package com.example.universidade.domain.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
    private String nome;
    private String cpf;
    private int idade;
}