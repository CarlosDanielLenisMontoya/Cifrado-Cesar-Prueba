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
            //Este if sirve para cuando el caracter no es una letra  (por ejemplo, es un número, símbolo o espacio en blanco)
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
    public DescodificadoResponse descodificar(int desplazamiento, String texto) {
        StringBuilder textoDescodificado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            //Este if sirve para cuando el caracter no es una letra  (por ejemplo, es un número, símbolo o espacio en blanco)
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
    public PistaResponse pistaTexto(String textoCifrado, String pista) {
        int desplazamiento = 0;
        boolean encontrado = false;

        do {
            String textoDescifrado = descifrarCesar(textoCifrado, desplazamiento);

            if (textoDescifrado.contains(pista)) {
                encontrado = true;
                return new PistaResponse(textoDescifrado, desplazamiento);
            } else {
                desplazamiento++;
            }
        } while (!encontrado);

        // Este código nunca se ejecutará si se encuentra la pista
        return null;



    }
    private String descifrarCesar(String textoCifrado, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < textoCifrado.length(); i++) {
            char caracter = textoCifrado.charAt(i);

            if (Character.isLetter(caracter)) {
                char descifrado = (char) ((caracter - desplazamiento - 'A' + 26) % 26 + 'A');
                resultado.append(descifrado);
            } else {
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }
}







