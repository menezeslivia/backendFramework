package com.example.universidade.repository;


import com.example.universidade.domain.model.Pessoa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeStartingWithAndIdadeGreaterThan(String nome, int idade);
}
