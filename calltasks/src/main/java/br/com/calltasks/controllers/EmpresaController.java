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

import br.com.calltasks.model.Empresa;
import br.com.calltasks.repository.EmpresaRepository;

/**
 * Controlador REST para manipulação de Empresas. Gerencia operações CRUD
 * (Criar, Ler, Atualizar, Deletar) relacionadas a Empresas. As operações são
 * acessíveis através de endpoints definidos em "/calltasks/empresa".
 *
 * @RestController Indica que esta classe é um controlador REST.
 * @RequestMapping Define o mapeamento de URL base para todos os métodos desta
 *                 classe.
 */
@RestController
@RequestMapping("/calltasks/empresa")
public class EmpresaController {

	/**
	 * Repositório para manipulação de dados relacionados a Empresas.
	 */
	@Autowired
	private EmpresaRepository empresaRepository;

	/**
	 * Retorna uma lista de todas as empresas.
	 *
	 * @return Lista de empresas.
	 */
	@GetMapping(path = "/listar")
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}

	/**
	 * Cria uma nova empresa.
	 *
	 * @param empresa Objeto Empresa enviado no corpo da requisição.
	 * @return Resposta HTTP com a Empresa recém-criada e status 201 (CREATED).
	 */
	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa) {
		Empresa e = empresaRepository.save(empresa);
		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}

	/**
	 * Deleta uma empresa com base no CNPJ fornecido.
	 *
	 * @param cnpjEmpresa CNPJ da Empresa a ser removida.
	 * @return Resposta HTTP com mensagem e status 200 (OK).
	 */
	@DeleteMapping(path = "/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam String cnpjEmpresa) {
		empresaRepository.deleteById(cnpjEmpresa);
		return new ResponseEntity<>("Empresa removida com sucesso", HttpStatus.OK);
	}

	/**
	 * Busca uma empresa pelo CNPJ fornecido.
	 *
	 * @param cnpjEmpresa CNPJ da Empresa a ser buscada.
	 * @return Resposta HTTP com a Empresa encontrada e status 200 (OK).
	 */
	@GetMapping(path = "/buscar-id")
	@ResponseBody
	public ResponseEntity<Empresa> buscarId(@RequestParam String cnpjEmpresa) {
		Empresa empresa = empresaRepository.findById(cnpjEmpresa).orElse(null);
		return new ResponseEntity<>(empresa, HttpStatus.OK);
	}

	/**
	 * Atualiza uma empresa existente.
	 *
	 * @param empresa Objeto Empresa enviado no corpo da requisição.
	 * @return Resposta HTTP com a Empresa atualizada e status 200 (OK).
	 */
	@PutMapping(path = "/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Empresa empresa) {
		if (empresa.getCnpjEmpresa() == null) {
			return new ResponseEntity<>("CNPJ não informado para atualizar", HttpStatus.OK);
		}
		Empresa e = empresaRepository.saveAndFlush(empresa);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
}
