package com.example.controller.automovel.controller;

import com.example.controller.automovel.model.Automovel;
import com.example.controller.automovel.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class AutomovelController {

    @Autowired
    private AutomovelRepository automovelRepository;

    @PostMapping("/cadastroAutomoveis")
    public ResponseEntity<Automovel> cadastroAutomovel(@RequestBody Automovel automovelDTO) {
        Automovel automovel = new Automovel();
        automovel.setMarca(automovelDTO.getMarca());
        automovel.setModelo(automovelDTO.getModelo());
        automovel.setValor(automovelDTO.getValor());
        automovel.setDataCadastro(Date.from(Instant.now(
                        Clock.system(ZoneId.of("America/Sao_Paulo")))
                )
        );
        automovelRepository.save(automovel);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/automoveis")
    public ResponseEntity<List<Automovel>> obterAutomoveis() {
        List<Automovel> automoveis = automovelRepository.findAll();
        return new ResponseEntity<>(automoveis, HttpStatus.OK);
    }
}
