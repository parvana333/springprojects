package com.example.demospringjpa.service.impl;

import com.example.demospringjpa.entity.Adress;
import com.example.demospringjpa.entity.Person;
import com.example.demospringjpa.repositories.AdressRepository;
import com.example.demospringjpa.repositories.PersonRepository;
import com.example.demospringjpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Override
    public Person addPerson(Person person) {
        Adress address = adressRepository.save(person.getAdress());
        person.setAdress(address);
       return personRepository.save(person);

    }
}
