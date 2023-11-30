package com.example.demo.bussines;

import com.example.demo.dto.CodificarResponse;
import com.example.demo.dto.DescodificadoResponse;
import com.example.demo.dto.PistaResponse;

public interface CifradoCesarService {

    CodificarResponse codificar(String texto, int desplazamiento);
    DescodificadoResponse descodificar(int desplazamiento,String texto );

    PistaResponse pista (String texto , String pista);

}
