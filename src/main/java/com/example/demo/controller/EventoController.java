package com.example.demo.controller;

import com.example.demo.dto.EsitoBaseDTO;
import com.example.demo.dto.EventoDTO;
import com.example.demo.dto.PersonaDTO;
import com.example.demo.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/",exposedHeaders = "Authorization")
@RequestMapping(path = "/api/v1/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @RequestMapping(value = "/crea", method = RequestMethod.POST)
    public ResponseEntity<EsitoBaseDTO> singUp(@RequestBody EventoDTO eventoDTO) throws Exception {
        EsitoBaseDTO esitoBaseDTO=eventoService.inserisci(eventoDTO);
        return new ResponseEntity<>(esitoBaseDTO,  HttpStatus.OK);
    }

//    @RequestMapping(value = "/lista/{email}", method = RequestMethod.GET)
//    public ResponseEntity<List<EventoDTO>> ricercaLista(@PathVariable String email) throws Exception {
//        List<EventoDTO> lista=eventoService.getEventiByEmail(email);
//        return new ResponseEntity<>(lista,  HttpStatus.CREATED);
//    }


}
