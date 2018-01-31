/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.calculatorservlet;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.runner.RunWith;


/**
 *
 * @author Carles
 */
@RunWith(JUnitParamsRunner.class)
public class TestCalculatorIT {
    
    public TestCalculatorIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    @Parameters({"0, 0, 0",
                 "1, 1, 2",
                 "-1, -1, -2",
                 "1, -1, 0"})
    public void testSuma(int num1, int num2, int expResult) {
        ICalculator instance = new Calculator();
        int result = instance.suma(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of substract method, of class Calculator.
     */
    @Test
    @Parameters({"1, 1, 0",
                 "2, 1, 1",
                 "1, 2, -1"})
    public void testResta(int num1, int num2, int expResult) {
        ICalculator instance = new Calculator();

        int result = instance.resta(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiply method, of class Calculator.
     */
    @Test
    @Parameters({"1, 0, 0",
                 "1, 1, 1",
                 "2, -2, -4",
                 "-2, -3, +6"})
    public void testMultiplica(int num1, int num2, int expResult) {
        ICalculator instance = new Calculator();

        int result = instance.multiplica(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    @Parameters({"1, 1, 1",
                 "10, 5, 2"})
    public void testDivideix(int num1, int num2, int expResult) {
        ICalculator instance = new Calculator();
        int result = instance.divideix(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDivideixZero() {
        ICalculator instance = new Calculator();
        try {
            instance.divideix(1, 0);
            fail("Hauria d'executar execpció");
        }
        catch( ArithmeticException e) {
        }
    }

    
}
