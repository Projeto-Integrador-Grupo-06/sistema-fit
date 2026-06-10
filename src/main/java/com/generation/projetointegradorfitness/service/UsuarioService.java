package com.generation.projetointegradorfitness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projetointegradorfitness.model.Usuario;
import com.generation.projetointegradorfitness.model.UsuarioLogin;
import com.generation.projetointegradorfitness.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Usuario> gettAll(){
		return usuarioRepository.findAll();
	}
	
	public Optional <Usuario> getById(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Optional<Usuario> cadastrarUsuario(Usuario usuario){
		if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent()) {
			return Optional.empty();
		}
		
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuario.setId(null);
		
		return Optional.of(usuarioRepository.save(usuario));
	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario){
		if(!usuarioRepository.findById(usuario.getId()).isPresent()) {
			return Optional.empty();
		}
		
		Optional<Usuario> usuarioExistente = usuarioRepository.findByUsuario(usuario.getUsuario());
		
		if(usuarioExistente.isPresent() && !usuarioExistente.get().getId().equals(usuario.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
		}
		
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		return Optional.of(usuarioRepository.save(usuario));
	}
	
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin){
		if(!usuarioLogin.isPresent()) {
			return Optional.empty();
		}
		
		UsuarioLogin login = usuarioLogin.get();
		
		try {
			 
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(login.getUsuario(), login.getSenha()));

			return usuarioRepository.findByUsuario(login.getUsuario())
				.map(usuario -> construirRespostaLogin(login, usuario));

		} catch (Exception e) {

			return Optional.empty();
		}
	}

	private UsuarioLogin construirRespostaLogin(UsuarioLogin usuarioLogin, Usuario usuario) {
		
		usuarioLogin.setId(usuario.getId());
		usuarioLogin.setNome(usuario.getNome());
		usuarioLogin.setFoto(usuario.getFoto());
		usuarioLogin.setSenha("");
		usuarioLogin.setToken(gerarToken(usuario.getUsuario()));
		return usuarioLogin;
		
	}

	private String gerarToken(String usuario) {
		return "Bearer " + jwtService.generateToken(usuario);
	}
	
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

