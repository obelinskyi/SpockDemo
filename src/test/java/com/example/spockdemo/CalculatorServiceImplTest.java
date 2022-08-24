package com.example.spockdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorServiceImplTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    @Disabled("for demonstration purposes")
    void add() {
        assertEquals(calculatorService.add(1, 2), 3);
    }

    @Test
    @DisplayName("1 + 2 is not 4")
    void add2() {
        assertEquals(calculatorService.add(1, 2), 4, "Test error message");
    }

    @Test
    void testExc() {
        var arithmeticException = assertThrows(ArithmeticException.class, () -> calculatorService.divide(1, 0));
        assertEquals(arithmeticException.getMessage(), "/ by zero", "Wrong msg");
    }
}
