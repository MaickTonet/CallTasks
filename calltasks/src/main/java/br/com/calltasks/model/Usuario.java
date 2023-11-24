package br.com.calltasks.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {

	@Id
	@Column(name = "cpf_usuario", length = 14, nullable = false)
	private String cpfUsuario;

	@Column(name = "nome_usuario", length = 40, nullable = false)
	private String nome;

	@Column(name = "email_usuario", length = 40, nullable = false)
	private String email;

	@Column(name = "dataNascimento_usuario", nullable = false)
	private Date dataNascimento;

}