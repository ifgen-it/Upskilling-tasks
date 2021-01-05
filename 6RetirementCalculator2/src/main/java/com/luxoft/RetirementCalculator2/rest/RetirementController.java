package com.luxoft.RetirementCalculator2.rest;

import com.luxoft.RetirementCalculator2.domain.RetirementService;
import com.luxoft.RetirementCalculator2.domain.model.RequestDTO;
import com.luxoft.RetirementCalculator2.domain.model.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseDTO getAnswer1(@PathVariable("currentAge") int currentAge,
                                  @PathVariable("retireAge") int retireAge){

        ResponseDTO response = retirementService.getAnswer(currentAge, retireAge);
        return response;
    }

    // GET /retire2?currentAge=35&retireAge=65
    @GetMapping("/retire2")
    public ResponseDTO getAnswer2(@RequestParam("currentAge") int currentAge,
                                  @RequestParam("retireAge") int retireAge){

        ResponseDTO response = retirementService.getAnswer(currentAge, retireAge);
        return response;
    }

    // GET /retire3?currentAge=35&retireAge=65
    @GetMapping("/retire3")
    public ResponseDTO getAnswer3(@RequestParam Map<String, String> params){

        int retireAge = Integer.parseInt(params.get("retireAge"));
        int currentAge = Integer.parseInt(params.get("currentAge"));

        ResponseDTO response = retirementService.getAnswer(currentAge, retireAge);
        return response;
    }

    // GET /retire4?currentAge=35&retireAge=65
    @GetMapping("/retire4")
    public ResponseDTO getAnswer4(RequestDTO params){

        int retireAge = params.getRetireAge();
        int currentAge = params.getCurrentAge();

        ResponseDTO response = retirementService.getAnswer(currentAge, retireAge);
        return response;
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handleE1(NumberFormatException e){
        System.out.println("Exception: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }
}
