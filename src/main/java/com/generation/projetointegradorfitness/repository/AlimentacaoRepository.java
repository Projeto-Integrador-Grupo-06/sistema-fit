package com.generation.projetointegradorfitness.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projetointegradorfitness.model.Alimentacao;

@Repository
public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long> {

    List<Alimentacao> findAllByNomeRefeicaoContainingIgnoreCase(String nomeRefeicao);

}