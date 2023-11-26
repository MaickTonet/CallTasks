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

@RestController
@RequestMapping("/calltasks/chamado")
public class ChamadoController {

	@Autowired
	private ChamadoRepository chamadoRepository;

	@GetMapping(path = "/listar")
	public List<Chamado> listar() {
		return chamadoRepository.findAll();
	}

	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<Chamado> criar(@RequestBody Chamado chamado) {
		Chamado c = chamadoRepository.save(chamado);
		return new ResponseEntity<Chamado>(c, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long idChamado) {
		chamadoRepository.deleteById(idChamado);
		return new ResponseEntity<String>("Chamado excluido com sucesso", HttpStatus.OK);
	}

	@GetMapping(path = "/buscar-id")
	@ResponseBody
	public ResponseEntity<Chamado> buscarId(@RequestParam Long idChamado) {
		Chamado chamado = chamadoRepository.findById(idChamado).get();
		return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
	}

	@PutMapping(path = "/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Chamado chamado) {
		Chamado c = chamadoRepository.saveAndFlush(chamado);
		return new ResponseEntity<Chamado>(c, HttpStatus.OK);
	}
}
