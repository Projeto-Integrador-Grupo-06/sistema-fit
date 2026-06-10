package com.generation.projetointegradorfitness.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projetointegradorfitness.model.Alimentacao;
import com.generation.projetointegradorfitness.repository.AlimentacaoRepository;
import com.generation.projetointegradorfitness.repository.CategoriaRepository;
import com.generation.projetointegradorfitness.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alimentacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlimentacaoController {

    @Autowired
    private AlimentacaoRepository alimentacaoRepository;

    @Autowired 
    private CategoriaRepository categoriaRepository;
    
    @Autowired 
    private UsuarioRepository usuarioRepository;
    
    //==============================================================================================
    
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

    //==============================================================================================
    
    @PostMapping
    public ResponseEntity<Alimentacao> post(@Valid @RequestBody Alimentacao alimentacao) {

        if (!categoriaRepository.existsById(alimentacao.getCategoria().getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Categoria não existe!");
        }

        if (!usuarioRepository.existsById(alimentacao.getUsuario().getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Usuário não existe!");
        }

        alimentacao.setId(null);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(alimentacaoRepository.save(alimentacao));
    }

    //==============================================================================================
    
    // Trata tentativas de atualização com categoria, usuário
    // ou alimentação inexistentes, retornando mensagens apropriadas
    @PutMapping
    public ResponseEntity<Alimentacao> put(@Valid @RequestBody Alimentacao alimentacao) {

        if (!categoriaRepository.existsById(alimentacao.getCategoria().getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Categoria não existe!");
        }

        if (!usuarioRepository.existsById(alimentacao.getUsuario().getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Usuário não existe!");
        }

        return alimentacaoRepository.findById(alimentacao.getId())
                .map(resposta -> ResponseEntity.ok(alimentacaoRepository.save(alimentacao)))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Alimentação não encontrada!"));
    }
    
    //==============================================================================================
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Alimentacao> alimentacao = alimentacaoRepository.findById(id);

		if (alimentacao.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		alimentacaoRepository.deleteById(id);
	}
    
}