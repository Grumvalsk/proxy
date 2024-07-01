package com.example.demo.controller;

import com.example.demo.dto.EsitoBaseDTO;
import com.example.demo.dto.EventoDTO;
import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.PersonaLoginDTO;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/",exposedHeaders = "Authorization")
@RequestMapping(path = "/api/v1/user")
public class PersonaController {

    @Autowired
    private PersonaService personaService;



    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<EsitoBaseDTO> singUp(@RequestBody PersonaDTO personaResponseDTO) throws Exception {
        EsitoBaseDTO result=personaService.singUp(personaResponseDTO);
        return new ResponseEntity<>(new EsitoBaseDTO(),  HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<EsitoBaseDTO> login(@RequestBody PersonaLoginDTO personaLoginDTO) throws Exception {
       String jwt=personaService.login(personaLoginDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwt);
        return new ResponseEntity<>(new EsitoBaseDTO(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/crea", method = RequestMethod.POST)
    public ResponseEntity<EsitoBaseDTO> inserisciEvento(@RequestBody EventoDTO eventoDTO) throws Exception {

        return new ResponseEntity<>(new EsitoBaseDTO(),  HttpStatus.OK);
    }

    @RequestMapping(value = "/cerca", method = RequestMethod.GET)
    public ResponseEntity<EsitoBaseDTO> trovaEventi(@RequestBody PersonaLoginDTO personaLoginDTO) throws Exception {

        return new ResponseEntity<>(new EsitoBaseDTO(),  HttpStatus.OK);
    }
}
