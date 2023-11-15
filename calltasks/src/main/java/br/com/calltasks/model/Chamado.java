package br.com.calltasks.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "chamado")
@SequenceGenerator(name = "seq_chamado", sequenceName = "seq_chamado", allocationSize = 1, initialValue = 1)
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_chamado")
	private int codigoChamado;

	@Column(name = "dataAbertura_chamado")
	private java.sql.Timestamp dataAberturaChamado;

	@Column(name = "status_chamado")
	private char statusChamado;

	@ManyToOne
	@JoinColumn(name = "cpf_usuario")
	private Usuario cpfUsuario;

	@ManyToOne
	@JoinColumn(name = "cnpj_empresa")
	private Empresa cnpjEmpresa;

	public int getCodigoChamado() {
		return codigoChamado;
	}

	public void setCodigoChamado(int codigoChamado) {
		this.codigoChamado = codigoChamado;
	}

	public java.sql.Timestamp getDataAberturaChamado() {
		return dataAberturaChamado;
	}

	public void setDataAberturaChamado(java.sql.Timestamp dataAberturaChamado) {
		this.dataAberturaChamado = dataAberturaChamado;
	}

	public char getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(char statusChamado) {
		this.statusChamado = statusChamado;
	}

	public Usuario getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(Usuario cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public Empresa getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(Empresa cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

}
