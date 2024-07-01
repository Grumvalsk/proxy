package com.example.demo.mapper;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.PersonaSingUpDTO;
import com.example.demo.entity.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {

    public Persona toEntity(PersonaDTO personaDTO){
        return Persona.builder()
                .nome(personaDTO.getNome())
                .cognome(personaDTO.getCognome())
                .email(personaDTO.getEmail())
                .password(personaDTO.getPassword())
                .numero(personaDTO.getNumero())
                .build();
    }
}
