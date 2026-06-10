package com.generation.projetointegradorfitness.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // erá utilizada para gerar uma tabela no Banco de dados da aplicação
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // gera IDs automaticamente
	private Long id;

	@NotBlank(message = "O atributo Nome é obrigatório!")
	@Size(max = 100, message = "O nome deve conter até 100 caracteres!")
	private String nome;
	
	@NotBlank(message = "O atributo Descrição é obrigatório!")
	@Size(min = 10, max = 500, message = "A Descrição deve conter entre 10 e 500 caracteres!")
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
    @JsonIgnoreProperties("categoria")
    private List<Alimentacao>alimentos;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
