package br.com.calltasks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 * Entidade que representa um departamento em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Data
public class Departamento {

	/**
	 * Identificador único para o departamento.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         codigoDepartamento.
	 */
	@Id
	@Column(name = "codigo_departamento", nullable = false)
	private long codigoDepartamento;

	/**
	 * Cargo associado ao departamento.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         cargoDepartamento.
	 */
	@Column(name = "cargo_departamento", length = 30, nullable = false)
	private String cargoDepartamento;

	/**
	 * Usuário associado ao departamento.
	 *
	 * @OneToOne Indica um relacionamento um-para-um.
	 * @JoinColumn Especifica a coluna na tabela de departamentos que será usada
	 *             para manter a chave estrangeira referente ao usuário.
	 */
	@OneToOne
	@JoinColumn(name = "cpf_usuario")
	private Usuario cpfUsuario;
}
