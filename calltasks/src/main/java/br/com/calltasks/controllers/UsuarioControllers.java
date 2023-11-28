package br.com.calltasks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

/**
 * Controlador REST para manipulação de Usuários. Gerencia operações CRUD
 * (Criar, Ler, Atualizar, Deletar) relacionadas a Usuários. As operações são
 * acessíveis através de endpoints definidos em "/calltasks/usuario".
 *
 * @RestController Indica que esta classe é um controlador REST.
 * @RequestMapping Define o mapeamento de URL base para todos os métodos desta
 *                 classe.
 */
@RestController
@RequestMapping("/calltasks/usuario")
public class UsuarioControllers {

	/**
	 * Repositório para manipulação de dados relacionados a Usuários.
	 */
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Retorna uma lista de todos os usuários.
	 *
	 * @return Lista de usuários.
	 */
	@GetMapping(path = "/listar")
	public List<Usuario> listar() {
		try {
			return usuarioRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException("Não foi possível listar os usuários");
		}
	}

	/**
	 * Cria um novo usuário.
	 *
	 * @param usuario Objeto Usuario enviado no corpo da requisição.
	 * @return Resposta HTTP com o Usuario recém-criado e status 201 (CREATED).
	 */
	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		try {
			Usuario user = usuarioRepository.save(usuario);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Deleta um usuário com base no ID fornecido.
	 *
	 * @param idUsuario ID do Usuario a ser excluído.
	 * @return Resposta HTTP com mensagem e status 200 (OK).
	 */
	@DeleteMapping(path = "/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long idUsuario) {
		try {
			usuarioRepository.deleteById(idUsuario);
			return new ResponseEntity<>("Usuário excluído com sucesso", HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível excluir o usuário");
		}
	}

	/**
	 * Busca um usuário pelo ID fornecido.
	 *
	 * @param idUsuario ID do Usuario a ser buscado.
	 * @return Resposta HTTP com o Usuario encontrado e status 200 (OK).
	 */
	@GetMapping(path = "/buscar-id")
	@ResponseBody
	public ResponseEntity<Usuario> buscarID(@RequestParam Long idUsuario) {
		try {
			Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);

			if (usuario != null) {
				return new ResponseEntity<>(usuario, HttpStatus.OK);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (Exception e) {
			// Aqui você pode logar a exceção se necessário
			e.printStackTrace(); // Isso imprime a exceção no console, substitua por um log apropriado

			// Retorne a mensagem desejada em caso de exceção
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Atualiza um usuário existente.
	 *
	 * @param usuario Objeto Usuario enviado no corpo da requisição.
	 * @return Resposta HTTP com o Usuario atualizado e status 200 (OK).
	 */
	@PutMapping(path = "/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) {
		try {
			if (usuario.getCpfUsuario() == null) {
				return new ResponseEntity<>("ID não informado para atualizar", HttpStatus.BAD_REQUEST);
			}
			Usuario user = usuarioRepository.saveAndFlush(usuario);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			// Aqui você pode logar a exceção se necessário
			e.printStackTrace(); // Isso imprime a exceção no console, substitua por um log apropriado

			// Retorne a mensagem desejada em caso de exceção
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível atualizar o usuário");
		}
	}

}
