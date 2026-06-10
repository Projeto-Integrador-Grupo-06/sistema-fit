package com.generation.projetointegradorfitness.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório!")
	@Size(min = 3, max = 100, message = "O nome deve conter entre 3 e 100 caracteres!")
	private String nome;

	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O usuário é obrigatório!")
	@Email(message = "Digite um e-mail válido!")
	private String usuario; 
	
	@NotBlank(message = "A senha é obrigatória!")
    @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres!")
	private String senha;
	
	@NotBlank(message = "A foto é obrigatória!")
	private String foto; 
	
    @NotNull(message = "O peso é obrigatório!")
	private double peso;
    
    @NotNull(message = "A altura é obrigatória!")
	private double altura;
    
	private String imc; 

	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private List<Alimentacao> alimentos;

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

	public String getUsuario() {
		return usuario;
	} 

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	} 

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	} 

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getImc() {
		return imc;
	} 

	public void setImc(String imc) {
		this.imc = imc;
	}

	public List<Alimentacao> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimentacao> alimentos) {
		this.alimentos = alimentos;
	}
	
	
}