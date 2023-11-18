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
@Table(name = "endereco_empresa")
@SequenceGenerator(name = "seq_endereco_empresa", sequenceName = "seq_endereco_empresa", allocationSize = 1, initialValue = 1)
public class EnderecoEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_endereco_empresa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco_empresa")
	private int codigoEnderecoEmpresa;

	@Column(name = "cep_endereco", length = 11, nullable = false)
	private String cepEndereco;

	@Column(name = "rua_endereco", length = 40, nullable = false)
	private String RuaEndereco;

	@Column(name = "bairro_endereco", length = 20, nullable = false)
	private String bairroEndereco;

	@Column(name = "cidade_endereco", length = 20, nullable = false)
	private String cidadeEndereco;

	@OneToOne
	@JoinColumn(name = "cpnj_empresa")
	private Empresa cnpjEmpresa;

	public EnderecoEmpresa() {
		super();
	}

	public EnderecoEmpresa(int codigoEnderecoEmpresa, String cepEndereco, String ruaEndereco, String bairroEndereco,
			String cidadeEndereco, Empresa cnpjEmpresa) {
		super();
		this.codigoEnderecoEmpresa = codigoEnderecoEmpresa;
		this.cepEndereco = cepEndereco;
		RuaEndereco = ruaEndereco;
		this.bairroEndereco = bairroEndereco;
		this.cidadeEndereco = cidadeEndereco;
		this.cnpjEmpresa = cnpjEmpresa;
	}

	public int getCodigoEnderecoEmpresa() {
		return codigoEnderecoEmpresa;
	}

	public void setCodigoEnderecoEmpresa(int codigoEnderecoEmpresa) {
		this.codigoEnderecoEmpresa = codigoEnderecoEmpresa;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public String getRuaEndereco() {
		return RuaEndereco;
	}

	public void setRuaEndereco(String ruaEndereco) {
		RuaEndereco = ruaEndereco;
	}

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}

	public String getCidadeEndereco() {
		return cidadeEndereco;
	}

	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}

	public Empresa getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(Empresa cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

}
