package com.example.demo.controller;

import com.example.demo.bussines.CifradoCesarService;
import com.example.demo.dto.CodificarResponse;
import com.example.demo.dto.DescodificadoResponse;
import com.example.demo.dto.PeticionDescifrado;
import com.example.demo.dto.PistaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cifrado-service")
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class CifradoCesarController {


    // Inyección de dependencia del servicio CifradoCesarService.
    private final CifradoCesarService cifradoCesarService;

    // Método para manejar solicitudes POST que codifican un texto.
    @CrossOrigin(value = "*")
    @PostMapping("/codificar")
    public CodificarResponse codificar(@RequestParam(name = "texto") String texto, @RequestParam(name = "desplazamiento") int desplazamiento) {
        // Llamar al método correspondiente en el servicio y devolver la respuesta.
        return cifradoCesarService.codificar(texto, desplazamiento);
    }

    // Método para manejar solicitudes POST que descodifican un texto.
    @CrossOrigin(value = "*")
    @PostMapping("/descodificar")
    public DescodificadoResponse descodificar(@RequestParam(name = "desplazamiento") int desplazamiento, @RequestParam(name = "texto") String texto) {
        // Llamar al método correspondiente en el servicio y devolver la respuesta.
        return cifradoCesarService.descodificar(desplazamiento, texto);
    }

    // Método para manejar solicitudes POST que buscan una pista en un texto cifrado.
    @CrossOrigin(value = "*")
    @PostMapping("/pista")
    public PistaResponse pistaTexto(@RequestParam(name = "textoCifrado") String textoCifrado,
                                    @RequestParam(name = "pista") String pista) {
        // Convertir texto cifrado y pista a mayúsculas para evitar problemas de caso.
        textoCifrado = textoCifrado.toUpperCase();
        pista = pista.toUpperCase();

        // Llamar al método correspondiente en el servicio y devolver la respuesta.
        return cifradoCesarService.pistaTexto(textoCifrado, pista);
    } 

}

