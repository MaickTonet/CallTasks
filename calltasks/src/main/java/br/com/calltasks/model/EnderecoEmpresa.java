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

/**
 * Entidade que representa o endereço de uma empresa em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Table Especifica o nome da tabela no banco de dados associada a esta
 *        entidade.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Table(name = "endereco_empresa")
@Data
public class EnderecoEmpresa {

	/**
	 * Identificador único para o endereço da empresa.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         codigoEnderecoEmpresa.
	 * @GeneratedValue Especifica a estratégia de geração de valor automático para a
	 *                 chave primária.
	 */
	@Id
	@Column(name = "cod_endereco_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoEnderecoEmpresa;

	/**
	 * CEP (Código de Endereçamento Postal) do endereço.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         cepEndereco.
	 */
	@Column(name = "cep_endereco", length = 11, nullable = false)
	private String cepEndereco;

	/**
	 * Rua do endereço.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         RuaEndereco.
	 */
	@Column(name = "rua_endereco", length = 40, nullable = false)
	private String RuaEndereco;

	/**
	 * Bairro do endereço.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         bairroEndereco.
	 */
	@Column(name = "bairro_endereco", length = 20, nullable = false)
	private String bairroEndereco;

	/**
	 * Cidade do endereço.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         cidadeEndereco.
	 */
	@Column(name = "cidade_endereco", length = 20, nullable = false)
	private String cidadeEndereco;

	/**
	 * Empresa associada ao endereço.
	 *
	 * @OneToOne Indica um relacionamento um-para-um.
	 * @JoinColumn Especifica a coluna na tabela de endereços de empresas que será
	 *             usada para manter a chave estrangeira referente à empresa.
	 */
	@OneToOne
	@JoinColumn(name = "cpnj_empresa")
	private Empresa cnpjEmpresa;
}
