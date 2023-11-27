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
import br.com.calltasks.model.Chamado;
import br.com.calltasks.repository.ChamadoRepository;

/**
 * Controlador REST para manipulação de Chamados. Gerencia operações CRUD
 * (Criar, Ler, Atualizar, Deletar) relacionadas a Chamados. As operações são
 * acessíveis através de endpoints definidos em "/calltasks/chamado".
 *
 * @RestController Indica que esta classe é um controlador REST. 
 * @RequestMapping Define o mapeamento de URL base para todos os métodos desta
 *                 classe.
 */
@RestController
@RequestMapping("/calltasks/chamado")
public class ChamadoController {

	/**
	 * Repositório para manipulação de dados relacionados a Chamados.
	 */
	@Autowired
	private ChamadoRepository chamadoRepository;

	/**
	 * Retorna uma lista de todos os chamados.
	 *
	 * @return Lista de chamados.
	 */
	@GetMapping(path = "/listar")
	public List<Chamado> listar() {
		return chamadoRepository.findAll();
	}

	/**
	 * Cria um novo chamado.
	 *
	 * @param chamado Objeto Chamado enviado no corpo da requisição.
	 * @return Resposta HTTP com o Chamado recém-criado e status 201 (CREATED).
	 */
	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<Chamado> criar(@RequestBody Chamado chamado) {
		Chamado c = chamadoRepository.save(chamado);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}

	/**
	 * Deleta um chamado com base no ID fornecido.
	 *
	 * @param idChamado ID do Chamado a ser excluído.
	 * @return Resposta HTTP com mensagem e status 200 (OK).
	 */
	@DeleteMapping(path = "/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long idChamado) {
		chamadoRepository.deleteById(idChamado);
		return new ResponseEntity<>("Chamado excluído com sucesso", HttpStatus.OK);
	}

	/**
	 * Busca um chamado pelo ID fornecido.
	 *
	 * @param idChamado ID do Chamado a ser buscado.
	 * @return Resposta HTTP com o Chamado encontrado e status 200 (OK).
	 */
	@GetMapping(path = "/buscar-id")
	@ResponseBody
	public ResponseEntity<Chamado> buscarId(@RequestParam Long idChamado) {
		Chamado chamado = chamadoRepository.findById(idChamado).orElse(null);
		return new ResponseEntity<>(chamado, HttpStatus.OK);
	}

	/**
	 * Atualiza um chamado existente.
	 *
	 * @param chamado Objeto Chamado enviado no corpo da requisição.
	 * @return Resposta HTTP com o Chamado atualizado e status 200 (OK).
	 */
	@PutMapping(path = "/atualizar")
	@ResponseBody
	public ResponseEntity<Chamado> atualizar(@RequestBody Chamado chamado) {
		Chamado c = chamadoRepository.saveAndFlush(chamado);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
}
