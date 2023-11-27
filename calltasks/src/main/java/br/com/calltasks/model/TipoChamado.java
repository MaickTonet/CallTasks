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
 * Entidade que representa o tipo de um chamado em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Table Especifica o nome da tabela no banco de dados associada a esta
 *        entidade.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Table(name = "tipo_chamado")
@Data
public class TipoChamado {

	/**
	 * Identificador único para o tipo de chamado.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         codigoTipoChamado.
	 * @GeneratedValue Especifica a estratégia de geração de valor automático para a
	 *                 chave primária.
	 */
	@Id
	@Column(name = "cod_tipo_chamado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoTipoChamado;

	/**
	 * Grau do chamado.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         grauChamado.
	 */
	@Column(name = "grau_chamado", nullable = false)
	private char grauChamado;

	/**
	 * Classe do chamado.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         classeChamado.
	 */
	@Column(name = "classe_chamado", nullable = false)
	private char classeChamado;

	/**
	 * Chamado associado ao tipo.
	 *
	 * @OneToOne Indica um relacionamento um-para-um.
	 * @JoinColumn Especifica a coluna na tabela de tipos de chamados que será usada
	 *             para manter a chave estrangeira referente ao chamado.
	 */
	@OneToOne
	@JoinColumn(name = "codigo_chamado")
	private Chamado codigoChamado;
}
