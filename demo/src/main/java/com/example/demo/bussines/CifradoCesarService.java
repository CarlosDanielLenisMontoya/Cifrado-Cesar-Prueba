// Esta declaración de paquete indica el paquete del archivo Java actual.
package com.example.demo.bussines;

import com.example.demo.dto.CodificarResponse;
import com.example.demo.dto.DescodificadoResponse;
import com.example.demo.dto.PistaResponse;


public interface CifradoCesarService {

    // Este método se encarga de codificar un texto dado con un desplazamiento especificado.
    CodificarResponse codificar(String texto, int desplazamiento);

    // Este método se encarga de descodificar un texto dado con un desplazamiento especificado.
    DescodificadoResponse descodificar(int desplazamiento, String texto);

    // Este método genera un PistaResponse basado en el texto codificado y una pista dada.
    PistaResponse pistaTexto(String textoCodificado, String pista);
}
