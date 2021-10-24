package com.example.function.service.function;

import com.example.function.model.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component(value = "person")
@Slf4j
@AllArgsConstructor
public class PersonFunction implements Function<String, Person> {

  @Override
  public Person apply(String s) {
    log.info("finding person {}", s);
    Optional<Person> person = findAllPersons()
            .stream()
            .filter(obj -> obj.getFirstName().equalsIgnoreCase(s))
            .findFirst();
    if(person.isEmpty()){
      throw new RuntimeException("Person not found");
    }
    return person.get();
  }

  private List<Person> findAllPersons() {
    Person sergio = new Person("Sergio", "Ruiz");
    Person andres = new Person("Andres", "Combariza");
    Person dario = new Person("Dario", "Vives");
    List<Person> personList = new ArrayList<>();
    personList.add(sergio);
    personList.add(andres);
    personList.add(dario);
    return  personList;
  }
}
