package com.example.ejbexample.beans;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Remote(CountryState.class)
public class CountryStateBean implements CountryState {

    @PostConstruct
    public void initialize() {

        List<String> states = new ArrayList<>();
        states.add("Texas");
        states.add("Alabama");
        states.add("Alaska");
        states.add("Arizona");
        states.add("Arkansas");
        countryStatesMap.put("UnitedStates", states);
    }

    private final Map<String, List<String>> countryStatesMap = new HashMap<>();

    @Lock(LockType.READ)
    public List<String> getStates(String country) {
        return countryStatesMap.get(country);
    }

    @Lock(LockType.WRITE)
    public void setStates(String country, List<String> states) {
        countryStatesMap.put(country, states);
    }
}
