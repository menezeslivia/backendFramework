package com.example.universidade.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_pessoas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private int idade;
}