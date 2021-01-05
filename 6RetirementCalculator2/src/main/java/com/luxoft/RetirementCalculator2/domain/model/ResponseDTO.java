package com.luxoft.RetirementCalculator2.domain.model;

public class ResponseDTO {

    private int workingYears;
    private int retireYear;

    public ResponseDTO(int workingYears, int retireYear) {
        this.workingYears = workingYears;
        this.retireYear = retireYear;
    }

    public ResponseDTO() {
    }

    public int getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(int workingYears) {
        this.workingYears = workingYears;
    }

    public int getRetireYear() {
        return retireYear;
    }

    public void setRetireYear(int retireYear) {
        this.retireYear = retireYear;
    }
}
