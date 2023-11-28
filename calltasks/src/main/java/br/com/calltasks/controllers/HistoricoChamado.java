package br.com.calltasks.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calltasks.repository.HistoricoChamadoRepository;

@RestController
@RequestMapping("/calltasks/historico")
public class HistoricoChamado {

	@Autowired
	private HistoricoChamadoRepository historicoChamadoRepository;

}

