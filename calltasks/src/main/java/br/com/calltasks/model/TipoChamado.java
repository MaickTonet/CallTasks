package br.com.calltasks.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_chamado")
@SequenceGenerator(name = "seq_tipo_chamado", sequenceName = "seq_utipo_chamado", allocationSize = 1, initialValue = 1)
public class TipoChamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_tipo_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_chamado")
	private int codigoTipoChamado;

	@Column(name = "grau_chamado", nullable = false)
	private char grauChamado;

	@Column(name = "classe_chamado", nullable = false)
	private char classeChamado;

	@OneToOne
	@JoinColumn(name = "codigo_chamado")
	private Chamado codigoChamado;

	public int getCodigoTipoChamado() {
		return codigoTipoChamado;
	}

	public void setCodigoTipoChamado(int codigoTipoChamado) {
		this.codigoTipoChamado = codigoTipoChamado;
	}

	public char getGrauChamado() {
		return grauChamado;
	}

	public void setGrauChamado(char grauChamado) {
		this.grauChamado = grauChamado;
	}

	public char getClasseChamado() {
		return classeChamado;
	}

	public void setClasseChamado(char classeChamado) {
		this.classeChamado = classeChamado;
	}

	public Chamado getCodigoChamado() {
		return codigoChamado;
	}

	public void setCodigoChamado(Chamado codigoChamado) {
		this.codigoChamado = codigoChamado;
	}

}
