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
@Table(name = "telefone_empresa")
@SequenceGenerator(name = "seq_telefone_empresa", sequenceName = "seq_telefone_empresa", allocationSize = 1, initialValue = 1)
public class TelefoneEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo_tel_empresa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_telefone_empresa")
	private int codigoTelefoneEmpresa;

	@Column(name = "tel_pessoal_empresa", length = 20)
	private String telefonePessoalEmpresa;

	@Column(name = "tel_residencial_empresa", length = 20)
	private String telefoneResidencialEmpresa;

	@OneToOne
	@JoinColumn(name = "cnpj_empresa")
	private Empresa cnpjEmpresa;

	public int getCodigoTelefoneEmpresa() {
		return codigoTelefoneEmpresa;
	}

	public void setCodigoTelefoneEmpresa(int codigoTelefoneEmpresa) {
		this.codigoTelefoneEmpresa = codigoTelefoneEmpresa;
	}

	public String getTelefonePessoalEmpresa() {
		return telefonePessoalEmpresa;
	}

	public void setTelefonePessoalEmpresa(String telefonePessoalEmpresa) {
		this.telefonePessoalEmpresa = telefonePessoalEmpresa;
	}

	public String getTelefoneResidencialEmpresa() {
		return telefoneResidencialEmpresa;
	}

	public void setTelefoneResidencialEmpresa(String telefoneResidencialEmpresa) {
		this.telefoneResidencialEmpresa = telefoneResidencialEmpresa;
	}

	public Empresa getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(Empresa cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

}
