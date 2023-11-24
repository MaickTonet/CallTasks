package br.com.calltasks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Departamento {

	@Id
	@Column(name = "codigo_departamento", nullable = false)
	private int codigoDepartamento;

	@Column(name = "cargo_departamento", length = 30, nullable = false)
	private String cargoDepartamento;

	@OneToOne
	@JoinColumn(name = "cpf_usuario")
	private Usuario cpfUsuario;

}
