package br.com.calltasks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.calltasks.model.Usuario;
import br.com.calltasks.repository.UsuarioRepository;

@RestController
@RequestMapping("/calltasks/usuario")
public class UsuarioControllers {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping(path = "/listar")
	public List<Usuario> listarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@PostMapping(value = "/salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}

}
