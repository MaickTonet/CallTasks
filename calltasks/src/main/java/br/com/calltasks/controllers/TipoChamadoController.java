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

@RestController
@RequestMapping("/calltasks/tipo-chamado")
public class TipoChamadoController {

	@Autowired
	private TipoChamadoRepository tipoChamadoRepository;

	@GetMapping(path = "/listar")
	public List<TipoChamado> listar() {
		return tipoChamadoRepository.findAll();
	}

	@PostMapping(path = "/criar")
	@ResponseBody
	public ResponseEntity<TipoChamado> criar(@RequestBody TipoChamado tipoChamado) {
		TipoChamado tc = tipoChamadoRepository.save(tipoChamado);
		return new ResponseEntity<TipoChamado>(tc, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long codigoTipoChamado) {
		tipoChamadoRepository.deleteById(codigoTipoChamado);
		return new ResponseEntity<String>("Tipo chamado removida com sucesso", HttpStatus.OK);
	}

	@GetMapping(path = "/buscar-id")
	@ResponseBody
	public ResponseEntity<TipoChamado> buscarId(@RequestParam Long codigoTipoChamado) {
		TipoChamado tipoChamado = tipoChamadoRepository.findById(codigoTipoChamado).get();
		return new ResponseEntity<TipoChamado>(tipoChamado, HttpStatus.OK);
	}

	@PutMapping(path = "/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody TipoChamado tipoChamado) {
		TipoChamado tc = tipoChamadoRepository.saveAndFlush(tipoChamado);
		return new ResponseEntity<TipoChamado>(tc, HttpStatus.OK);
	}

}
