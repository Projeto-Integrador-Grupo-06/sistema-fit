package com.generation.projetointegradorfitness.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.projetointegradorfitness.model.Usuario;
import com.generation.projetointegradorfitness.repository.UsuarioRepository;

@Service
public class AvaliacaoService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public String calcularImc (double peso, double altura, Long id) {
		double imc = peso / (altura*altura);
		
		if (imc <= 18.5) {
			return "Baixo Peso";
					
		} else if (imc > 18.5 && imc <= 24.9) {
			return "Peso normal";
		
		} else if (imc >= 25 && imc <= 29.9) {
			return "Sobrepeso";
		} else if (imc >= 30 && imc <= 39.9) {
			return "Obesidade";
		} else {
			return "Obesidade grave";
		}	
	}
	
	public Optional<Usuario> imcUsuario (Usuario usuario){
		if (!usuarioRepository.findById(usuario.getId()).isPresent()) {
			return Optional.empty();
		}
		
		String resultado = calcularImc(usuario.getPeso(), usuario.getAltura(), usuario.getId());
		usuario.setImc(resultado);
	
		
		return Optional.of(usuarioRepository.save(usuario));
	}
}

