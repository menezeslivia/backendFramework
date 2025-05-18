package com.example.universidade.controllers;

import com.example.universidade.domain.dto.PessoaRequestDTO;
import com.example.universidade.domain.dto.PessoaResponseDTO;
import com.example.universidade.service.PessoaService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> criarPessoa(@RequestBody PessoaRequestDTO dto) {
        return ResponseEntity.ok(pessoaService.criarPessoa(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaRequestDTO dto) {
        return ResponseEntity.ok(pessoaService.atualizarPessoa(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PessoaResponseDTO>> buscarPorNomeEIdade(@RequestParam String nome, @RequestParam int idade) {
        return ResponseEntity.ok(pessoaService.buscarPorNomeEIdade(nome, idade));
    }
}
