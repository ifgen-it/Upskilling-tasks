package com.luxoft.RetirementCalculator2.rest;

import com.luxoft.RetirementCalculator2.domain.service.RetirementService;
import com.luxoft.RetirementCalculator2.domain.model.RequestDTO;
import com.luxoft.RetirementCalculator2.domain.model.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RetirementController {

    private RetirementService retirementService;

    @Autowired
    public RetirementController(RetirementService retirementService) {
        this.retirementService = retirementService;
    }

    @GetMapping("/retire1/{currentAge}/{retireAge}")
    public ResponseDTO getAnswer1(@PathVariable("currentAge") String currentAge,
                                  @PathVariable("retireAge") String retireAge){

        return retirementService.getAnswer(currentAge, retireAge);
    }

    // GET /retire2?currentAge=35&retireAge=65
    @GetMapping("/retire2")
    public ResponseDTO getAnswer2(@RequestParam("currentAge") String currentAge,
                                  @RequestParam("retireAge") String retireAge){

        return retirementService.getAnswer(currentAge, retireAge);
    }

    // GET /retire3?currentAge=35&retireAge=65
    @GetMapping("/retire3")
    public ResponseDTO getAnswer3(@RequestParam Map<String, String> params){

        String retireAge = params.get("retireAge");
        String currentAge = params.get("currentAge");

        return retirementService.getAnswer(currentAge, retireAge);
    }

    // GET /retire4?currentAge=35&retireAge=65
    @GetMapping("/retire4")
    public ResponseDTO getAnswer4(RequestDTO params){

        String retireAge = params.getRetireAge();
        String currentAge = params.getCurrentAge();

        return retirementService.getAnswer(currentAge, retireAge);
    }

}
