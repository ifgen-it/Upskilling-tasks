package com.luxoft.RetirementCalculator2.domain.config;

import com.luxoft.RetirementCalculator2.domain.service.RetirementService;
import com.luxoft.RetirementCalculator2.domain.service.RetirementServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public RetirementService retirementService(){

        return new RetirementServiceImpl();
    }

}
