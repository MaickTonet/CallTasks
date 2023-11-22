package br.com.calltasks.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cpf_usuario", length = 14, nullable = false)
	private String cpfUsuario;

	@Column(name = "nome_usuario", length = 40, nullable = false)
	private String nome;

	@Column(name = "email_usuario", length = 40, nullable = false)
	private String email;

	@Column(name = "dataNascimento_usuario", nullable = false)
	private Date dataNascimento;

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public Usuario() {
		super();
	}

	public Usuario(String cpfUsuario, String nome, String email, Date dataNascimento) {
		super();
		this.cpfUsuario = cpfUsuario;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}