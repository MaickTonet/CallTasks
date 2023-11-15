package br.com.calltasks.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
@SequenceGenerator(name = "seq_departamento", sequenceName = "seq_departamento", allocationSize = 1, initialValue = 1)
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo_departamento")
	private int codigoDepartamento;

	@Column(name = "cargo_departamento", length = 30)
	private String cargoDepartamento;

	@OneToOne
	@JoinColumn(name = "cpf_usuario")
	private Usuario cpfUsuario;

	public int getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(int codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getCargoDepartamento() {
		return cargoDepartamento;
	}

	public void setCargoDepartamento(String cargoDepartamento) {
		this.cargoDepartamento = cargoDepartamento;
	}

	public Usuario getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(Usuario cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

}
