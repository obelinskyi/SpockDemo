package com.example.spockdemo;

import com.example.spockdemo.dto.Person;
import org.springframework.stereotype.Repository;

@Repository
public class DummyPersonDaoService implements PersonDaoService {

    public static final Person SKOVORODA = new Person("Hryhorii", "Skovoroda", 72, "Philosopher");

    @Override
    public Person findById(int id) {
        return SKOVORODA;
    }
}
