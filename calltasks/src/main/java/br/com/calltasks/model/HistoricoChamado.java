package br.com.calltasks.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "historico_chamado")
@SequenceGenerator(name = "seq_historico_chamado", sequenceName = "seq_historico_chamado", allocationSize = 1, initialValue = 1)
public class HistoricoChamado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_historico_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historico_chamado")
	private int codigoEnderecoEmpresa;
	
	

}
