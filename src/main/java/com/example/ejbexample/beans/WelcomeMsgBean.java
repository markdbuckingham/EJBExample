package com.example.ejbexample.beans;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

@Stateless
@Local(WelcomeMsg.class)
public class WelcomeMsgBean implements WelcomeMsg {
    @Override
    public String getWelcomeMsg() {
        return "This is a message from welcome session bean (local)";
    }
}
