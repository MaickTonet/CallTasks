package br.com.calltasks.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calltasks.model.Usuario;
import br.com.calltasks.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1")
public class GreetingsController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(path = "/list")
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = "/create")
	public String testeGravar() {
		Usuario usuario = new Usuario();
		usuario.setCpfUsuario("967.835.780-39");
		usuario.setNome("Lucas");
		usuario.setEmail("lesbia5182@uorak.com");
		usuario.setDataNascimento(new Date(0));
		usuarioRepository.save(usuario);
		return "Gravado";
		
		
	}
}