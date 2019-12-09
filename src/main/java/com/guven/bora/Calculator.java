package com.guven.bora;

public class Calculator {

    private final CalculatorServive calculatorService;

    public Calculator(CalculatorServive calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int add(int first, int second) {
//        if (first < 0 || second < 0)
//            throw new RuntimeException("non negatibe number only please");
//        return first + second;
        return calculatorService.add(first ,second);
    }
}
