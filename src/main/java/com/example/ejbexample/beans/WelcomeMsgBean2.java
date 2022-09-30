package com.example.ejbexample.beans;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

@Stateless
@Remote(WelcomeMsgRemote.class)
public class WelcomeMsgBean2 implements WelcomeMsg {
    @Override
    public String getWelcomeMsg() {
        return "This is a message from welcome session bean 2 (remote)";
    }
}