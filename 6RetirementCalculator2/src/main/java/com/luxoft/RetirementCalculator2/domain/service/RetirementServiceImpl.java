package com.luxoft.RetirementCalculator2.domain.service;

import com.luxoft.RetirementCalculator2.domain.model.ResponseDTO;

import java.time.LocalDateTime;

public class RetirementServiceImpl implements RetirementService {

    private final int currentYear = LocalDateTime.now().getYear();
    static final int MIN_AGE = 18;
    static final int MAX_AGE = 100;

    @Override
    public ResponseDTO getAnswer(String currentAge, String retireAge) {

        ResponseDTO response = new ResponseDTO();

        // AGE
        Integer curAge = null;
        try{
            curAge = Integer.parseInt(currentAge);
            if(curAge < MIN_AGE || curAge > MAX_AGE){
                response.addResult("Age must be between " + MIN_AGE + " and " + MAX_AGE);
                curAge = null;
            }
        } catch (NumberFormatException e){
            response.addResult("Age must be a number");
        }

        // RETIRE AGE
        Integer retAge = null;
        if(curAge != null) {
            try {
                retAge = Integer.parseInt(retireAge);
                if (retAge < curAge || retAge > MAX_AGE) {
                    response.addResult("Retire age must be between your current age and " + MAX_AGE);
                    curAge = null;
                }
            } catch (NumberFormatException e) {
                response.addResult("Retire age must be a number");
            }
        }

        // CALCULATE
        if (curAge != null && retAge != null){
            Integer workingYears = retAge - curAge;
            Integer retireYear = currentYear + workingYears;

            response.setWorkingYears(workingYears);
            response.setRetireYear(retireYear);
            response.setResult("OK");
        }

        return response;
    }
}
