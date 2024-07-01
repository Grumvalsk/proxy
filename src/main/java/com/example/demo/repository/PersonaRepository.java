package com.example.demo.repository;

import com.example.demo.entity.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PersonaRepository extends MongoRepository<Persona, String> {

    boolean existsByEmail(String email);

    Optional<Persona> getByEmail(String email);
}
