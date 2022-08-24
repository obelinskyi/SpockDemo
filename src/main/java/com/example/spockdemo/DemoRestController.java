package com.example.spockdemo;

import com.example.spockdemo.dto.AddRequest;
import com.example.spockdemo.dto.AddResponse;
import com.example.spockdemo.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DemoRestController {

    private final CalculatorService calculatorService;

    private final PersonService personService;

    @PostMapping("/add")
    public AddResponse add(@RequestBody AddRequest addRequest) {
        return new AddResponse(calculatorService.add(addRequest.x(), addRequest.y()), "Message");
    }

    @GetMapping("/person")
    public Person person(@RequestParam int id) {
        return personService.getPerson(id);
    }
}
