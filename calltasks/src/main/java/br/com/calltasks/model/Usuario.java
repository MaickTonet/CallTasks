package br.com.calltasks.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {

	@Id
	@Column(name = "codigo_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoUsuario;

	@Column(name = "cpf_usuario", nullable = false)
	private String cpfUsuario;

	@Column(name = "nome_usuario", length = 40, nullable = false)
	private String nome;

	@Column(name = "email_usuario", length = 40, nullable = false)
	private String email;
	
	@Column(name = "dataAbertura_chamado", nullable = false)
	private LocalDate dataAberturaChamado;
}