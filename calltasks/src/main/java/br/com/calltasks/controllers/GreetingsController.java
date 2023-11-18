package br.com.calltasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.calltasks.model.Usuario;
import br.com.calltasks.repository.UsuarioRepository;

@RestController
public class GreetingsController {
	@GetMapping("/")
	public String index() {
		return "Hello, World!";
	}

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "testeGravar/{nome}", method = RequestMethod.GET) // Não está funcionando
	@ResponseStatus(HttpStatus.OK)
	public String testeGravar(@PathVariable String nome) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuarioRepository.save(usuario);
		return "Gravado";
	}

}