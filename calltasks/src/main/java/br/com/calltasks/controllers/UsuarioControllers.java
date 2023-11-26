package br.com.calltasks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
		return new ResponseEntity<String>("Usuario excluido com sucesso", HttpStatus.OK);
	}

	@GetMapping(path = "/buscar-id")
	@ResponseBody
	public ResponseEntity<Usuario> buscarID(@RequestParam Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@PutMapping(path = "/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) {
		if (usuario.getCpfUsuario() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Usuario user = usuarioRepository.saveAndFlush(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}

}