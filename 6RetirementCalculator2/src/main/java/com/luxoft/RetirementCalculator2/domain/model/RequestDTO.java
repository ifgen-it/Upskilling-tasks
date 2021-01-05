package com.luxoft.RetirementCalculator2.domain.model;

public class RequestDTO {

    private int currentAge;
    private int retireAge;

    public RequestDTO(int currentAge, int retireAge) {
        this.currentAge = currentAge;
        this.retireAge = retireAge;
    }

    public RequestDTO() {
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    public int getRetireAge() {
        return retireAge;
    }

    public void setRetireAge(int retireAge) {
        this.retireAge = retireAge;
    }
}
