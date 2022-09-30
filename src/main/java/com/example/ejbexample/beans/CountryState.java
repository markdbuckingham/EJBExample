package com.example.ejbexample.beans;

import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface CountryState {
    List<String> getStates(String country);
    void setStates(String country, List<String> states);
}
