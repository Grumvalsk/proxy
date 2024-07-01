package com.example.demo.service;

import com.example.demo.dto.EsitoBaseDTO;
import com.example.demo.dto.EventoDTO;

import java.util.List;

public interface EventoService {


    EsitoBaseDTO inserisci(EventoDTO eventoDTO);

//    List<EventoDTO> getEventiByEmail(String email);
}
