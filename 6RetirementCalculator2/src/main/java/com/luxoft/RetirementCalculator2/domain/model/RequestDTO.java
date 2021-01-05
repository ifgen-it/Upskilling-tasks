package com.luxoft.RetirementCalculator2.domain.model;

public class RequestDTO {

    private String currentAge;
    private String retireAge;

    public RequestDTO(String currentAge, String retireAge) {
        this.currentAge = currentAge;
        this.retireAge = retireAge;
    }

    public RequestDTO() {
    }

    public String getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(String currentAge) {
        this.currentAge = currentAge;
    }

    public String getRetireAge() {
        return retireAge;
    }

    public void setRetireAge(String retireAge) {
        this.retireAge = retireAge;
    }
}
