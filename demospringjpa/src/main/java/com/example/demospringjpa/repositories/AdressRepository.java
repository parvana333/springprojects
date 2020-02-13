package com.example.demospringjpa.repositories;

import com.example.demospringjpa.entity.Adress;
import org.springframework.data.repository.CrudRepository;

public interface AdressRepository extends CrudRepository<Adress, Long> {
}
