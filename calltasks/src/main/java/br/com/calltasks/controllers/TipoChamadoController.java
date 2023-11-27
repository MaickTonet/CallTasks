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

import br.com.calltasks.model.TipoChamado;
import br.com.calltasks.repository.TipoChamadoRepository;

/**
 * Controlador REST para manipulação de Tipos de Chamados. Gerencia operações
 * CRUD (Criar, Ler, Atualizar, Deletar) relacionadas a Tipos de Chamados. As
 * operações são acessíveis através de endpoints definidos em
 * "/calltasks/tipo-chamado".
 *
 * @RestController Indica que esta classe é um controlador REST.
 * @RequestMapping Define o mapeamento de URL base para todos os métodos desta
 *                 classe.
 */
@RestController
@RequestMapping("/calltasks/tipo-chamado")
public class TipoChamadoController {

	/**
	 * Repositório para manipulação de dados relacionados a Tipos de Chamados.
	 */
	@Autowired
	private TipoChamadoRepository tipoChamadoRepository;

	/**
	 * Retorna uma lista de todos os tipos de chamados.
	 *
	 * @return Lista de tipos de chamados.
	 */
	@GetMapping(path = "/listar")
	public List<TipoChamado> listar() {
		return tipoChamadoRepository.findAll();
	}

	/**
	 * Cria um novo tipo de chamado.
	 *
	 * @param tipoChamado Objeto TipoChamado enviado no corpo da requisição.
	 * @return Resposta HTTP com o TipoChamado recém-criado e status 201 (CREATED).
	 */
	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<TipoChamado> criar(@RequestBody TipoChamado tipoChamado) {
		TipoChamado tc = tipoChamadoRepository.save(tipoChamado);
		return new ResponseEntity<>(tc, HttpStatus.CREATED);
	}

	/**
	 * Deleta um tipo de chamado com base no código fornecido.
	 *
	 * @param codigoTipoChamado Código do TipoChamado a ser removido.
	 * @return Resposta HTTP com mensagem e status 200 (OK).
	 */
	@DeleteMapping(path = "/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long codigoTipoChamado) {
		tipoChamadoRepository.deleteById(codigoTipoChamado);
		return new ResponseEntity<>("Tipo de chamado removido com sucesso", HttpStatus.OK);
	}

	/**
	 * Busca um tipo de chamado pelo código fornecido.
	 *
	 * @param codigoTipoChamado Código do TipoChamado a ser buscado.
	 * @return Resposta HTTP com o TipoChamado encontrado e status 200 (OK).
	 */
	@GetMapping(path = "/buscar-id")
	@ResponseBody
	public ResponseEntity<TipoChamado> buscarId(@RequestParam Long codigoTipoChamado) {
		TipoChamado tipoChamado = tipoChamadoRepository.findById(codigoTipoChamado).orElse(null);
		return new ResponseEntity<>(tipoChamado, HttpStatus.OK);
	}

	/**
	 * Atualiza um tipo de chamado existente.
	 *
	 * @param tipoChamado Objeto TipoChamado enviado no corpo da requisição.
	 * @return Resposta HTTP com o TipoChamado atualizado e status 200 (OK).
	 */
	@PutMapping(path = "/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody TipoChamado tipoChamado) {
		TipoChamado tc = tipoChamadoRepository.saveAndFlush(tipoChamado);
		return new ResponseEntity<>(tc, HttpStatus.OK);
	}
}
