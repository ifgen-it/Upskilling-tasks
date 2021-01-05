package com.luxoft.RetirementCalculator2.domain.model;

public class ResponseDTO {

    private Integer workingYears;
    private Integer retireYear;
    private String result;

    public ResponseDTO(Integer workingYears, Integer retireYear, String result) {
        this.workingYears = workingYears;
        this.retireYear = retireYear;
        this.result = result;
    }

    public ResponseDTO() {
        result = "";
    }
    public void addResult(String result){
        if(this.result.equals("")){
            this.result = result;
        }
        else {
            this.result += "\n" + result;
        }
    }

    public Integer getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(Integer workingYears) {
        this.workingYears = workingYears;
    }

    public Integer getRetireYear() {
        return retireYear;
    }

    public void setRetireYear(Integer retireYear) {
        this.retireYear = retireYear;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
