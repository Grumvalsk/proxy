package com.example.demo.config;
import com.example.demo.dto.EsitoBaseDTO;
import com.example.demo.dto.EventoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "name-of-service", url = "http://localhost:8081/api/v1/evento")
public interface MyFeignClient {

    @GetMapping("/crea")
    EsitoBaseDTO inserisci(@RequestBody EventoDTO eventoDTO);
}
