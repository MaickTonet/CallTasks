package br.com.calltasks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Empresa {

	@Id
	@Column(name = "cnpj_empresa", length = 18, nullable = false)
	private String cnpjEmpresa;

	@Column(name = "nome_empresa", length = 40, nullable = false)
	private String nomeEmpresa;

	@Column(name = "email_empresa", length = 40, nullable = false)
	private String emailEmpresa;

}
 