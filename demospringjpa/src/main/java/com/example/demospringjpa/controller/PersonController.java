package com.example.demospringjpa.controller;

import com.example.demospringjpa.entity.Person;
import com.example.demospringjpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/person/")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Transactional
    @GetMapping("/")
    public List<Person> getPersonList(){
        List<Person> people=new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return people;
    }
    @GetMapping("/{id}")
    public Person getByid(@PathVariable(name="id") long id){
       Optional<Person> allById = personRepository.findById(id);
       if(allById.isPresent()){
           return allById.get();
       }
       throw new ResponseStatusException(HttpStatus.NOT_FOUND," there is not this id");
    }
    @PostMapping("/")
    public Person addPerson(@RequestBody Person person){
       return personRepository.save(person);
    }
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable(name="id") long id,
                               @RequestBody Person person){
        if(personRepository.existsById(id)){
            System.out.println("person exist,update");
            return personRepository.save(person);
        }
        else{
            System.out.println("person does noto exist , insert");
            return personRepository.save(person);
        }

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable(name="id") long id){
        if(personRepository.existsById(id)){
            personRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," there is not this id");

        }

    }

}
