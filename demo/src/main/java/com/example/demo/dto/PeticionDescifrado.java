package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class PeticionDescifrado {
    private String textoCifrado;
    private String pista;


}
