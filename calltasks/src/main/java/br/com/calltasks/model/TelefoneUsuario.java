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
@Table(name = "telefone_usuario")
@Data
public class TelefoneUsuario {

	@Id
	@Column(name = "codigo_tel_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoTelefoneUsuario;

	@Column(name = "tel_pessoal_usuario", length = 20)
	private String telefonePessoalUsuario;

	@Column(name = "tel_residencial_usuario", length = 20, nullable = false)
	private String telefoneResidencialUsuario;

	@OneToOne
	@JoinColumn(name = "cpf_usuario")
	private Usuario cpfUsuario;

}
