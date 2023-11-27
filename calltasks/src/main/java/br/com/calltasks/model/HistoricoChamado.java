package br.com.calltasks.model;

import java.sql.Date;

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
 * Entidade que representa o histórico de um chamado em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Table Especifica o nome da tabela no banco de dados associada a esta
 *        entidade.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Table(name = "historico_chamado")
@Data
public class HistoricoChamado {

	/**
	 * Identificador único para o histórico do chamado.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         codigoEnderecoEmpresa.
	 * @GeneratedValue Especifica a estratégia de geração de valor automático para a
	 *                 chave primária.
	 */
	@Id
	@Column(name = "cod_historico_chamado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoEnderecoEmpresa;

	/**
	 * Data de registro do chamado no histórico.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         dataRegistroChamado.
	 */
	@Column(name = "data_reg_chamado", nullable = false)
	private Date dataRegistroChamado;

	/**
	 * Responsável pelo registro do chamado no histórico.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         responsavelChamado.
	 */
	@Column(name = "responsavel_reg_chamado", length = 30, nullable = false)
	private String responsavelChamado;

	/**
	 * Descrição do chamado no histórico.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         descricaoChamado.
	 */
	@Column(name = "descricao_chamado", nullable = false)
	private String descricaoChamado;

	/**
	 * Chamado associado ao histórico.
	 *
	 * @OneToOne Indica um relacionamento um-para-um.
	 * @JoinColumn Especifica a coluna na tabela de histórico de chamados que será
	 *             usada para manter a chave estrangeira referente ao chamado.
	 */
	@OneToOne
	@JoinColumn(name = "codigo_chamado")
	private Chamado codigoChamado;

	/**
	 * Tipo de chamado associado ao histórico.
	 *
	 * @OneToOne Indica um relacionamento um-para-um.
	 * @JoinColumn Especifica a coluna na tabela de histórico de chamados que será
	 *             usada para manter a chave estrangeira referente ao tipo de
	 *             chamado.
	 */
	@OneToOne
	@JoinColumn(name = "cod_tipo_chamado")
	private TipoChamado codigoTipoChamado;
}
