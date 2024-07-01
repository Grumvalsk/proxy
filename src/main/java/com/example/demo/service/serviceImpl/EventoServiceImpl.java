package com.example.demo.service.serviceImpl;

import com.example.demo.config.MyFeignClient;
import com.example.demo.dto.EsitoBaseDTO;
import com.example.demo.dto.EventoDTO;
import com.example.demo.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private MyFeignClient myFeignClient;

    @Value("${url.evento.controller}")
    private  String urlEvento;

    public EventoServiceImpl() {
    }

//    @Override
//    public EsitoBaseDTO inserisci(EventoDTO eventoDTO) {
//        EsitoBaseDTO risposta = restTemplate.postForObject(urlEvento+"/crea", eventoDTO, EsitoBaseDTO.class);
//        return risposta;
//    }

    @Override
    public EsitoBaseDTO inserisci(EventoDTO eventoDTO) {
        EsitoBaseDTO risposta = myFeignClient.inserisci(eventoDTO);
        return risposta;
    }

    public List<EventoDTO> getEventiByEmail(String email) {
        // Effettua la chiamata GET
        Flux<EventoDTO> result = webClientBuilder.build()
                .get()
                .uri(urlEvento + "/lista/{email}", email) // Assicurati di utilizzare {email} come variabile di percorso
                .retrieve()
                .bodyToFlux(EventoDTO.class);
        return result.collectList().block();
    }


}
