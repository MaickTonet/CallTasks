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
@Table(name = "telefone_usuario")
@SequenceGenerator(name = "seq_telefone_usuario", sequenceName = "seq_telefone_usuario", allocationSize = 1, initialValue = 1)
public class TelefoneUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo_tel_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_telefone_usuario")
	private int codigoTelefoneUsuario;

	@Column(name = "tel_pessoal_usuario", length = 20)
	private String telefonePessoalUsuario;

	@Column(name = "tel_residencial_usuario", length = 20, nullable = false)
	private String telefoneResidencialUsuario;

	@OneToOne
	@JoinColumn(name = "cpf_usuario")
	private Usuario cpfUsuario;

	public int getCodigoTelefoneUsuario() {
		return codigoTelefoneUsuario;
	}

	public void setCodigoTelefoneUsuario(int codigoTelefoneUsuario) {
		this.codigoTelefoneUsuario = codigoTelefoneUsuario;
	}

	public String getTelefonePessoalUsuario() {
		return telefonePessoalUsuario;
	}

	public void setTelefonePessoalUsuario(String telefonePessoalUsuario) {
		this.telefonePessoalUsuario = telefonePessoalUsuario;
	}

	public String getTelefoneResidencialUsuario() {
		return telefoneResidencialUsuario;
	}

	public void setTelefoneResidencialUsuario(String telefoneResidencialUsuario) {
		this.telefoneResidencialUsuario = telefoneResidencialUsuario;
	}

	public Usuario getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(Usuario cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

}
