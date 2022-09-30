package com.example.ejbexample.beans;

import jakarta.ejb.Local;

@Local
public interface WelcomeMsg {
    String getWelcomeMsg();
}
