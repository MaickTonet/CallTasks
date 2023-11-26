package br.com.calltasks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tipo_chamado")
@Data
public class TipoChamado {

	@Id
	@Column(name = "cod_tipo_chamado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoTipoChamado;

	@Column(name = "grau_chamado", nullable = false)
	private char grauChamado;

	@Column(name = "classe_chamado", nullable = false)
	private char classeChamado;

	@OneToOne
	@JoinColumn(name = "codigo_chamado")
	private Chamado codigoChamado;

}
