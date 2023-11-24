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
@Table(name = "endereco_empresa")
@Data
public class EnderecoEmpresa {

	@Id
	@Column(name = "cod_endereco_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
