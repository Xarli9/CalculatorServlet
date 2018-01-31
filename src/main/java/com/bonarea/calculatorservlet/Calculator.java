/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.calculatorservlet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Carles
 */
@RequestScoped
@Named("calculator")
public class Calculator implements ICalculator {

    @Override
    public int suma(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int resta(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiplica(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divideix(int num1, int num2) {
        return num1 / num2;
    }
    
}
