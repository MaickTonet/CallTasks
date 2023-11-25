package br.com.calltasks.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.calltasks.model.Chamado;
import br.com.calltasks.repository.ChamadoRepository;

@RestController
@RequestMapping("calltasks/chamado")
public class ChamadoController {

	private final ChamadoRepository chamadoRepository;

	public ChamadoController(ChamadoRepository chamadoRepository) {
		this.chamadoRepository = chamadoRepository;
	}

	@GetMapping(path = "/listar")
	public List<Chamado> listarTodosChamados() {
		return chamadoRepository.findAll();
	}

	@PostMapping(path = "/criar")
	public String criarChamado(Chamado chamado) {
		Chamado novoChamado = chamadoRepository.saveAndFlush(chamado);
		return "Chamado " + novoChamado.getCodigoChamado() + " registrado!";
	}

}
