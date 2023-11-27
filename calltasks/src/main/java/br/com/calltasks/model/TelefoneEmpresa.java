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
 * Entidade que representa os telefones associados a uma empresa em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Table Especifica o nome da tabela no banco de dados associada a esta
 *        entidade.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Table(name = "telefone_empresa")
@Data
public class TelefoneEmpresa {

	/**
	 * Identificador único para o telefone da empresa.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         codigoTelefoneEmpresa.
	 * @GeneratedValue Especifica a estratégia de geração de valor automático para a
	 *                 chave primária.
	 */
	@Id
	@Column(name = "codigo_tel_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoTelefoneEmpresa;

	/**
	 * Telefone pessoal associado à empresa.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         telefonePessoalEmpresa.
	 */
	@Column(name = "tel_pessoal_empresa", length = 20)
	private String telefonePessoalEmpresa;

	/**
	 * Telefone residencial associado à empresa.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         telefoneResidencialEmpresa.
	 */
	@Column(name = "tel_residencial_empresa", length = 20, nullable = false)
	private String telefoneResidencialEmpresa;

	/**
	 * Empresa associada aos telefones.
	 *
	 * @OneToOne Indica um relacionamento um-para-um.
	 * @JoinColumn Especifica a coluna na tabela de telefones de empresas que será
	 *             usada para manter a chave estrangeira referente à empresa.
	 */
	@OneToOne
	@JoinColumn(name = "cnpj_empresa")
	private Empresa cnpjEmpresa;
}
