package br.com.calltasks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Chamado {

	@Id
	@Column(name = "codigo_chamado", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoChamado;

	@Column(name = "dataAbertura_chamado", nullable = false)
	private java.sql.Timestamp dataAberturaChamado;

	@Column(name = "status_chamado", nullable = false)
	private char statusChamado;

	@ManyToOne
	@JoinColumn(name = "cpf_usuario")
	private Usuario cpfUsuario;

	@ManyToOne
	@JoinColumn(name = "cnpj_empresa")
	private Empresa cnpjEmpresa;
}