package br.com.calltasks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entidade que representa uma empresa em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Data
public class Empresa {

	/**
	 * CNPJ (Cadastro Nacional da Pessoa Jurídica) único para a empresa.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         cnpjEmpresa.
	 */
	@Id
	@Column(name = "cnpj_empresa", length = 18, nullable = false)
	private String cnpjEmpresa;

	/**
	 * Nome da empresa.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         nomeEmpresa.
	 */
	@Column(name = "nome_empresa", length = 40, nullable = false)
	private String nomeEmpresa;

	/**
	 * Endereço de e-mail da empresa.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         emailEmpresa.
	 */
	@Column(name = "email_empresa", length = 40, nullable = false)
	private String emailEmpresa;
}
