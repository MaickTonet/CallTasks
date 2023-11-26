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

@RestController
@RequestMapping("/calltasks/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping(path = "/listar")
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}

	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa) {
		Empresa e = empresaRepository.save(empresa);
		return new ResponseEntity<Empresa>(e, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam String cnpjEmpresa) {
		empresaRepository.deleteById(cnpjEmpresa);
		return new ResponseEntity<String>("Empresa removida com sucesso", HttpStatus.OK);
	}

	@GetMapping(path = "/buscar-id")
	@ResponseBody
	public ResponseEntity<Empresa> buscarId(@RequestParam String cnpjEmpresa) {
		Empresa empresa = empresaRepository.findById(cnpjEmpresa).get();
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
	}

	@PutMapping(path = "/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Empresa empresa) {
		if (empresa.getCnpjEmpresa() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Empresa e = empresaRepository.saveAndFlush(empresa);
		return new ResponseEntity<Empresa>(e, HttpStatus.OK);
	}

}
