package com.example.universidade.service;


import com.example.universidade.domain.dto.PessoaRequestDTO;
import com.example.universidade.domain.dto.PessoaResponseDTO;
import com.example.universidade.domain.model.Pessoa;

public class PessoaMapperDTOService {
    
 public static Pessoa toEntity(PessoaRequestDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setIdade(dto.getIdade());
        return pessoa;
    }

    public static PessoaResponseDTO toDTO(Pessoa pessoa) {
        PessoaResponseDTO dto = new PessoaResponseDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        dto.setIdade(pessoa.getIdade());
        return dto;
    }

}
