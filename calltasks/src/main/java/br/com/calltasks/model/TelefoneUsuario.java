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
 * Entidade que representa os telefones associados a um usuário em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Table Especifica o nome da tabela no banco de dados associada a esta
 *        entidade.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Table(name = "telefone_usuario")
@Data
public class TelefoneUsuario {

	/**
	 * Identificador único para o telefone do usuário.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         codigoTelefoneUsuario.
	 * @GeneratedValue Especifica a estratégia de geração de valor automático para a
	 *                 chave primária.
	 */
	@Id
	@Column(name = "codigo_tel_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoTelefoneUsuario;

	/**
	 * Telefone pessoal associado ao usuário.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         telefonePessoalUsuario.
	 */
	@Column(name = "tel_pessoal_usuario", length = 20)
	private String telefonePessoalUsuario;

	/**
	 * Telefone residencial associado ao usuário.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         telefoneResidencialUsuario.
	 */
	@Column(name = "tel_residencial_usuario", length = 20, nullable = false)
	private String telefoneResidencialUsuario;

	/**
	 * Usuário associado aos telefones.
	 *
	 * @OneToOne Indica um relacionamento um-para-um.
	 * @JoinColumn Especifica a coluna na tabela de telefones de usuários que será
	 *             usada para manter a chave estrangeira referente ao usuário.
	 */
	@OneToOne
	@JoinColumn(name = "cpf_usuario")
	private Usuario cpfUsuario;
}
