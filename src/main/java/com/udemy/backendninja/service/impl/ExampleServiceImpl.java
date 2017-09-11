package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);
    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Pepe", 25));
        people.add(new Person("Tony", 20));
        people.add(new Person("Nia", 3));
        people.add(new Person("Bob", 21));

        LOGGER.info("HELLO FROM SERVICE");
        return people;
    }
}
