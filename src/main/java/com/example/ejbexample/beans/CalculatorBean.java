package com.example.ejbexample.beans;

import jakarta.ejb.Stateless;

@Stateless
public class CalculatorBean implements Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiple(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}
