package com.generation.projetointegradorfitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.projetointegradorfitness.model.Categoria;


public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

}
