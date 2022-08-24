package com.example.spockdemo;

import com.example.spockdemo.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDaoService personDaoService;

    @Override
    public Person getPerson(int id) {
        return personDaoService.findById(id);
    }
}
