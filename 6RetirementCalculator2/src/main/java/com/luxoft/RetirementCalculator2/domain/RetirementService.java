package com.luxoft.RetirementCalculator2.domain;

import com.luxoft.RetirementCalculator2.domain.model.ResponseDTO;

public interface RetirementService {

    ResponseDTO getAnswer(int currentAge, int retireAge);
}
