package com.example.demo.bussines.Impl;

import com.example.demo.bussines.CifradoCesarService;
import com.example.demo.dto.CodificarResponse;
import com.example.demo.dto.DescodificadoResponse;
import com.example.demo.dto.PistaResponse;
import org.springframework.stereotype.Service;

@Service
public class CifradoCesarServiceImpl implements CifradoCesarService {


    @Override
    public CodificarResponse codificar(String texto, int desplazamiento) {

        StringBuilder textoCodificado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isLetter(caracter)) {
                char inicio = Character.isUpperCase(caracter) ? 'A' : 'a';
                textoCodificado.append((char) ((caracter - inicio + desplazamiento) % 26 + inicio));
            } else {
                textoCodificado.append(caracter);
            }
        }

        return CodificarResponse.builder()
                .textoCodificado(textoCodificado.toString())
                .build();
    }

    @Override
    public DescodificadoResponse descodificar(int desplazamiento ,String texto ) {
        StringBuilder textoDescodificado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isLetter(caracter)) {
                char inicio = Character.isUpperCase(caracter) ? 'A' : 'a';
                textoDescodificado.append((char) ((caracter - inicio + 26 - desplazamiento) % 26 + inicio));
            } else {
                textoDescodificado.append(caracter);
            }
        }

        return DescodificadoResponse.builder()
                .textoDescodificado(textoDescodificado.toString())
                .build();
    }

    @Override
    public PistaResponse pista(String texto, String pista) {
        int desplazamiento = 0;
        pista = pista.toUpperCase();

        for (int i = 0; i < pista.length(); i++) {
            char caracter = pista.charAt(i);

            if (Character.isLetter(caracter)) {
                char inicio = 'A';
                desplazamiento = (caracter - inicio + 3) % 26; // Puedes ajustar el desplazamiento según la pista
                break;
            }
        }

        return PistaResponse.builder()
                .desplazamiento(desplazamiento)
                .texto(texto)
                .pista(pista)
                .build();
    }
    }


