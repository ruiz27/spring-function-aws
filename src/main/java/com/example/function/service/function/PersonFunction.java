package com.example.function.service.function;

import com.example.function.model.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component(value = "person")
@Slf4j
@AllArgsConstructor
public class PersonFunction implements Function<String, Person> {

    @Override
    public Person apply(String s) {
        log.info("finding person {}", s);
        return new Person("Sergio", "Ruiz");
    }
}
