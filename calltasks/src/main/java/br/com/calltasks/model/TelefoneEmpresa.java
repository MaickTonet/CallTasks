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
@Table(name = "telefone_empresa")
@Data
public class TelefoneEmpresa {

	@Id
	@Column(name = "codigo_tel_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoTelefoneEmpresa;

	@Column(name = "tel_pessoal_empresa", length = 20)
	private String telefonePessoalEmpresa;

	@Column(name = "tel_residencial_empresa", length = 20, nullable = false)
	private String telefoneResidencialEmpresa;

	@OneToOne
	@JoinColumn(name = "cnpj_empresa")
	private Empresa cnpjEmpresa;

}
