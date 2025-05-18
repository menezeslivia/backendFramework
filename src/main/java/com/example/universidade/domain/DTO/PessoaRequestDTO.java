package com.example.universidade.domain.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaRequestDTO {
    private String nome;
    private String cpf;
    private int idade;
}
