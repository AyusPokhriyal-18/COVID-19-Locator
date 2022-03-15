package com.example.covid_19tracker.model;

public class StateModel {
    private String stateCase;

    public StateModel(String stateCase, String stateName) {
        this.stateCase = stateCase;
        this.stateName = stateName;
    }

    public String getStateCase() {
        return stateCase;
    }

    public void setStateCase(String stateCase) {
        this.stateCase = stateCase;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    private String stateName;


}
