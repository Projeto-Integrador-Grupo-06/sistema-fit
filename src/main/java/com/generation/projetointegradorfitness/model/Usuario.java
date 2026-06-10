package com.generation.projetointegradorfitness.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String usuario; // ✅ adicionado
	private String senha;   // ✅ adicionado
	private String foto;    // ✅ adicionado
	private double peso;
	private double altura;
	private String imc;     // ✅ era double, mas setImc recebe String

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getUsuario() { return usuario; } // ✅
	public void setUsuario(String usuario) { this.usuario = usuario; }

	public String getSenha() { return senha; } // ✅
	public void setSenha(String senha) { this.senha = senha; }

	public String getFoto() { return foto; } // ✅
	public void setFoto(String foto) { this.foto = foto; }

	public double getPeso() { return peso; }
	public void setPeso(double peso) { this.peso = peso; }

	public double getAltura() { return altura; }
	public void setAltura(double altura) { this.altura = altura; }

	public String getImc() { return imc; } // ✅
	public void setImc(String imc) { this.imc = imc; }
}