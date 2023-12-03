package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PistaResponse {
    private String textoDescifrado;
    private int desplazamiento;

}