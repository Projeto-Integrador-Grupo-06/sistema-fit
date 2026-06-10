package com.generation.projetointegradorfitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.projetointegradorfitness.model.Alimentacao;
import com.generation.projetointegradorfitness.repository.AlimentacaoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alimentacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlimentacaoController {

    @Autowired
    private AlimentacaoRepository alimentacaoRepository;

    @GetMapping
    public ResponseEntity<List<Alimentacao>> getAll() {
        return ResponseEntity.ok(alimentacaoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimentacao> getById(@PathVariable Long id) {
        return alimentacaoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Alimentacao>> getByNome(@PathVariable String nome) {

        return ResponseEntity.ok(
                alimentacaoRepository.findAllByNomeRefeicaoContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Alimentacao> post(@Valid @RequestBody Alimentacao alimentacao) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(alimentacaoRepository.save(alimentacao));
    }

    @PutMapping
    public ResponseEntity<Alimentacao> put(@Valid @RequestBody Alimentacao alimentacao) {

        return ResponseEntity.ok(alimentacaoRepository.save(alimentacao));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        alimentacaoRepository.deleteById(id);
    }
}