package com.example.demo.service;

import com.example.demo.dto.EsitoBaseDTO;
import com.example.demo.dto.EventoDTO;
import com.example.demo.dto.PersonaLoginDTO;
import com.example.demo.dto.PersonaDTO;

public interface PersonaService {

    String login(PersonaLoginDTO personaLoginDTO) throws Exception;

    EsitoBaseDTO singUp(PersonaDTO personaResponseDTO) throws Exception;

    EsitoBaseDTO creaEvento(EventoDTO eventoDTO);
}
