package com.luxoft.RetirementCalculator2.domain;

import com.luxoft.RetirementCalculator2.domain.model.ResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RetirementServiceImpl implements RetirementService{

    private final int currentYear = LocalDateTime.now().getYear();

    @Override
    public ResponseDTO getAnswer(int currentAge, int retireAge) {

        int workingYears = retireAge - currentAge;
        int retireYear = currentYear + workingYears;
        ResponseDTO response = new ResponseDTO(workingYears, retireYear);

        return response;
    }
}
