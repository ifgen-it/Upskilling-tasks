package com.luxoft.RetirementCalculator2.domain.service;

import com.luxoft.RetirementCalculator2.domain.model.ResponseDTO;

public interface RetirementService {

    ResponseDTO getAnswer(String currentAge, String retireAge);
}
