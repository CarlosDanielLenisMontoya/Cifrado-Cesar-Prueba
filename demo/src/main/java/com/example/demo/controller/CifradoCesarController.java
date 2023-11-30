package com.example.demo.controller;

import com.example.demo.bussines.CifradoCesarService;
import com.example.demo.dto.CodificarResponse;
import com.example.demo.dto.DescodificadoResponse;
import com.example.demo.dto.PistaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cifrado-service")
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class CifradoCesarController {

    private final CifradoCesarService cifradoCesarService;
    @CrossOrigin(value = "*")
    @PostMapping("/codificar")
    public CodificarResponse codificar(@RequestParam(name = "texto") String texto, @RequestParam(name = "desplazamiento") int desplazamiento) {
        return cifradoCesarService.codificar(texto, desplazamiento);
    }
    @CrossOrigin(value = "*")
    @PostMapping("/descodificar")
    public DescodificadoResponse descodificar(@RequestParam(name = "desplazamiento") int desplazamiento, @RequestParam(name = "texto") String texto) {
        return cifradoCesarService.descodificar(desplazamiento, texto);
    }
    @CrossOrigin(value = "*")
    @PostMapping("/pista")
    public PistaResponse pista(@RequestParam(name = "textoOriginal") String textoOriginal, @RequestParam(name = "pista") String pista) {
        return cifradoCesarService.pista(textoOriginal, pista);
    }



}
