package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Document("Persona")
public class Persona {

    @Id
    private String email;
    private String nome;
    private String cognome;
    private String password;
    private String numero;
    private Boolean attivo;
}
