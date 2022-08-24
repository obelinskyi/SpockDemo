package com.example.spockdemo;

import org.springframework.stereotype.Component;

@Component
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int subtract(int x, int y) {
        return x - y;
    }

    @Override
    public int multiply(int x, int y) {
        return x * y;
    }

    @Override
    public int divide(int x, int y) {
        return x / y;
    }

    @Override
    public String toString() {
        return "CalculatorServiceImpl{}";
    }
}
