/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;

import com.bonarea.calculatorservlet.ICalculator;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carles
 */
public class CalculatorServlet extends HttpServlet {
    
    @Inject
    @Named("calculator")
    private ICalculator calculator;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenim l'operació i els paràmetres
        String operacio = request.getParameter("operacio");
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        int resultat = 0; 

        try {
            // Verifiquem que existeix l'operació
            Method method = calculator.getClass().getMethod(operacio, int.class, int.class);
            resultat = (int)method.invoke(calculator, (int)Integer.parseInt(num1), (int)Integer.parseInt(num2)); 
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CalculatorServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(400);
            return;
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculatorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculatorServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>La "+ operacio +"("+ num1 +","+ num2 +") = "+ resultat +"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
