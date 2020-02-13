package com.example.demospringjpa.repositories;

import com.example.demospringjpa.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    Person save(Person entity);
}
