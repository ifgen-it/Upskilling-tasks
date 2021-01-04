package com.luxoft;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    static final int MIN_AGE = 18;
    static final int MAX_AGE = 100;

    public static void main(String[] args) {

        int currentYear = LocalDate.now().getYear();

        // AGE
        System.out.println("What is your current age?");
        int currentAge = 0;
        while (currentAge == 0) {
            Scanner scanner = new Scanner(System.in);
            String currentAgeStr = scanner.next();
            try {
                currentAge = Integer.parseInt(currentAgeStr);
                if(currentAge < MIN_AGE || currentAge > MAX_AGE){
                    System.out.println("Age must be between " + MIN_AGE + " and " + MAX_AGE + "! Try more");
                    currentAge = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Age must be a number! Try more");
            }
        }

        // RETIRE AGE
        System.out.println("At what age would you like to retire?");
        int retireAge = 0;
        while (retireAge == 0) {
            Scanner scanner = new Scanner(System.in);
            String retireAgeStr = scanner.next();
            try {
                retireAge = Integer.parseInt(retireAgeStr);
                if (retireAge < currentAge || retireAge > MAX_AGE){
                    System.out.println("Retire age must be between your current age and " + MAX_AGE + "! Try more");
                    retireAge = 0;
                }
            } catch (NumberFormatException e){
                System.out.println("Retire age must be a number! Try more");
            }
        }

        // CALCULATE
        int workingYears = retireAge - currentAge;
        int retireYear = currentYear + workingYears;

        // OUTPUT
        System.out.println("You have " + workingYears + " years left until you can retire");
        System.out.println("It's " + currentYear + ", so you can retire in " + retireYear);

    }
}
