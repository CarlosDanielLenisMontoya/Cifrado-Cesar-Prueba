package com.example.demo.bussines.Impl;

import com.example.demo.bussines.CifradoCesarService;
import com.example.demo.dto.CodificarResponse;
import com.example.demo.dto.DescodificadoResponse;
import com.example.demo.dto.PistaResponse;
import org.springframework.stereotype.Service;

@Service
public class CifradoCesarServiceImpl implements CifradoCesarService {



    // Método para codificar un texto utilizando el cifrado César.
    @Override
    public CodificarResponse codificar(String texto, int desplazamiento) {

        // StringBuilder para construir el texto codificado.
        StringBuilder textoCodificado = new StringBuilder();

        // Iterar a través de cada caracter del texto original.
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            // Comprobar si el caracter es una letra.
            if (Character.isLetter(caracter)) {
                char inicio = Character.isUpperCase(caracter) ? 'A' : 'a';
                // Aplicar la fórmula de cifrado César y agregar el caracter codificado al resultado.
                textoCodificado.append((char) ((caracter - inicio + desplazamiento) % 26 + inicio));
            } else {
                // Si no es una letra, agregar el caracter original al resultado.
                textoCodificado.append(caracter);
            }
        }

        // Construir y devolver la respuesta de codificación.
        return CodificarResponse.builder()
                .textoCodificado(textoCodificado.toString())
                .build();
    }

    // Método para descodificar un texto utilizando el cifrado César.
    @Override
    public DescodificadoResponse descodificar(int desplazamiento, String texto) {
        // StringBuilder para construir el texto descodificado.
        StringBuilder textoDescodificado = new StringBuilder();

        // Iterar a través de cada caracter del texto cifrado.
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            // Comprobar si el caracter es una letra.
            if (Character.isLetter(caracter)) {
                char inicio = Character.isUpperCase(caracter) ? 'A' : 'a';
                // Aplicar la fórmula de descifrado César y agregar el caracter descodificado al resultado.
                textoDescodificado.append((char) ((caracter - inicio + 26 - desplazamiento) % 26 + inicio));
            } else {
                // Si no es una letra, agregar el caracter original al resultado.
                textoDescodificado.append(caracter);
            }
        }

        // Construir y devolver la respuesta de descodificación.
        return DescodificadoResponse.builder()
                .textoDescodificado(textoDescodificado.toString())
                .build();
    }

    // Método para encontrar un desplazamiento que revele una pista en el texto cifrado.
    @Override
    public PistaResponse pistaTexto(String textoCifrado, String pista) {
        int desplazamiento = 0;
        boolean encontrado = false;

        // Bucle para probar diferentes desplazamientos hasta que se encuentre la pista.
        do {
                // Descifrar el texto cifrado con el desplazamiento actual.
            String textoDescifrado = descifrarCesar(textoCifrado, desplazamiento);

            // Verificar si el texto descifrado contiene la pista.
            if (textoDescifrado.contains(pista)) {
                encontrado = true;
                // Construir y devolver la respuesta de pista.
                return new PistaResponse(textoDescifrado, desplazamiento);
            } else {
                // Incrementar el desplazamiento si la pista no se encuentra.
                desplazamiento++;
            }
        } while (!encontrado);

        // Este código nunca se ejecutará si se encuentra la pista.
        return null;
    }

    // Método privado para descifrar un texto cifrado con un desplazamiento dado.
    private String descifrarCesar(String textoCifrado, int desplazamiento) {
        // StringBuilder para construir el resultado del descifrado.
        StringBuilder resultado = new StringBuilder();

        // Iterar a través de cada caracter del texto cifrado.
        for (int i = 0; i < textoCifrado.length(); i++) {
            char caracter = textoCifrado.charAt(i);

            // Comprobar si el caracter es una letra.
            if (Character.isLetter(caracter)) {
                // Aplicar la fórmula de descifrado César y agregar el caracter descifrado al resultado.
                char descifrado = (char) ((caracter - desplazamiento - 'A' + 26) % 26 + 'A');
                resultado.append(descifrado);
            } else {
                // Si no es una letra, agregar el caracter original al resultado.
                resultado.append(caracter);
            }
        }

        // Devolver el resultado del descifrado.
        return resultado.toString();
    }
}


