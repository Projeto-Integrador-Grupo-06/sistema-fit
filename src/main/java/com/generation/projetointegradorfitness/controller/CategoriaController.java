package com.generation.projetointegradorfitness.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projetointegradorfitness.model.Categoria;
import com.generation.projetointegradorfitness.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*") //
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	// Lista por ID
	@GetMapping("/{id}") //
	public ResponseEntity<Categoria> getById(@PathVariable Long id) {
		return categoriaRepository.findById(id)

				// .map metodo lambda
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

	}
	

	// CRUD
   // INSERT - Cadastrar 	

	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {

		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	//Atualizar
	@PutMapping

	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {

		if (categoriaRepository.existsById(categoria.getId())) {

			return ResponseEntity.ok(categoriaRepository.save(categoria));
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercício não encontrada!");
	}
	
	//Deletar
	// Representa o DELETE do SQL (remover dados)
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			Optional<Categoria> categoria = categoriaRepository.findById(id);
			// Se o id não existir, retorna erro 404
			if(categoria.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
			categoriaRepository.deleteById(id);
			
		}
	
}
