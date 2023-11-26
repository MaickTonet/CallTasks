package br.com.calltasks.controllers;

import java.time.LocalDate;
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

	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}

	@GetMapping(path = "/gerar")
	public String gerarUsuario() {
		LocalDate localDate = LocalDate.now();
		Usuario usuario = new Usuario();
		usuario.setCpfUsuario("000.000.000-00");
		usuario.setNome("Usuario");
		usuario.setEmail("usuario@email.com");
		usuario.setDataAberturaChamado(localDate);
		usuarioRepository.save(usuario);
		return "Usuario criado com sucesso!";
	}	

}
