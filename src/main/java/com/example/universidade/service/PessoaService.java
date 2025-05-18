package com.example.universidade.service;

import com.example.universidade.domain.dto.PessoaRequestDTO;
import com.example.universidade.domain.dto.PessoaResponseDTO;
import com.example.universidade.domain.model.Pessoa;
import com.example.universidade.exceptions.PessoaNotFoundException;
import com.example.universidade.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada com ID: ";

    public PessoaResponseDTO criarPessoa(PessoaRequestDTO dto) {
        Pessoa pessoa = PessoaMapperDTOService.toEntity(dto);
        Pessoa salva = pessoaRepository.save(pessoa);
        log.info("Pessoa criada: {}", salva.getId());
        return PessoaMapperDTOService.toDTO(salva);
    }

    public PessoaResponseDTO buscarPorId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(PESSOA_NAO_ENCONTRADA + id));
        return PessoaMapperDTOService.toDTO(pessoa);
    }

    public PessoaResponseDTO atualizarPessoa(Long id, PessoaRequestDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(PESSOA_NAO_ENCONTRADA + id));

        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setIdade(dto.getIdade());

        Pessoa atualizada = pessoaRepository.save(pessoa);
        log.info("Pessoa atualizada: {}", atualizada.getId());
        return PessoaMapperDTOService.toDTO(atualizada);
    }

    public void deletarPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(PESSOA_NAO_ENCONTRADA + id));

        pessoaRepository.delete(pessoa);
        log.info("Pessoa deletada: {}", id);
    }

    public List<PessoaResponseDTO> buscarPorNomeEIdade(String nome, int idade) {
        List<Pessoa> pessoas = pessoaRepository.findByNomeStartingWithAndIdadeGreaterThan(nome, idade);
        log.info("Consulta personalizada - nome: {}, idade > {}", nome, idade);
        return pessoas.stream().map(PessoaMapperDTOService::toDTO).toList();
    }
}
