package com.example.ejbexample.beans;

import jakarta.ejb.Remote;

@Remote
public interface Calculator {
    public int add(int a, int b);
    public int subtract(int a, int b);
    public int multiple(int a, int b);
    public int divide(int a, int b);
}
