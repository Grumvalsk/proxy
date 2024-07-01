package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@AllArgsConstructor
@SuperBuilder
public class PersonaSingUpDTO {

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String numero;
}
