package com.example.demo.service.serviceImpl;

import com.example.demo.dto.EventoDTO;
import com.example.demo.dto.EsitoBaseDTO;
import com.example.demo.dto.PersonaLoginDTO;
import com.example.demo.dto.PersonaDTO;
import com.example.demo.entity.Persona;
import com.example.demo.exception.AuthException;
import com.example.demo.mapper.PersonaMapper;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;
import com.example.demo.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;



    @Override
    public String login(PersonaLoginDTO personaLoginDTO) throws Exception {
        Optional<Persona> pers=personaRepository.getByEmail(personaLoginDTO.getEmail());
        if(pers.isPresent()){
            Persona persona=pers.get();
            if(persona.getPassword().equals(personaLoginDTO.getPassword())){
                String jwt= JwtUtil.generateJwt(persona.getNome(),persona.getCognome(),persona.getEmail());
                return jwt;
            }else {
                throw new AuthException("Password errata!");
            }
        }else {
            throw new AuthException("Email inesistente!");
        }
    }

    @Override
    public EsitoBaseDTO singUp(PersonaDTO personaDTO) throws Exception {

        Persona persona= personaMapper.toEntity(personaDTO);
        boolean flag=personaRepository.existsByEmail(persona.getEmail());
        if(!flag){
            personaRepository.save(persona);
            return new EsitoBaseDTO();
        }else {
            throw new Exception("Email già utilizzata!!");
        }

    }

    @Override
    public EsitoBaseDTO creaEvento(EventoDTO eventoDTO) {
        return null;
    }
}
