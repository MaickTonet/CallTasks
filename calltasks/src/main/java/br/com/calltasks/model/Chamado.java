package br.com.calltasks.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Entidade que representa um chamado em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Data
public class Chamado {

	/**
	 * Identificador único para o chamado.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         codigoChamado.
	 * @GeneratedValue Especifica a estratégia de geração de valor automático para a
	 *                 chave primária.
	 */
	@Id
	@Column(name = "codigo_chamado", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoChamado;

	/**
	 * Data de abertura do chamado.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         dataAberturaChamado.
	 */
	@Column(name = "dataAbertura_chamado", nullable = false)
	private LocalDate dataAberturaChamado;

	/**
	 * Status do chamado representado por um caractere.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         statusChamado.
	 */
	@Column(name = "status_chamado", nullable = false)
	private char statusChamado;

	/**
	 * Usuário associado ao chamado.
	 *
	 * @ManyToOne Indica um relacionamento muitos-para-um.
	 * @JoinColumn Especifica a coluna na tabela de chamados que será usada para
	 *             manter a chave estrangeira referente ao usuário.
	 */
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario codigoUsuario;

	/**
	 * Empresa associada ao chamado.
	 *
	 * @ManyToOne Indica um relacionamento muitos-para-um.
	 * @JoinColumn Especifica a coluna na tabela de chamados que será usada para
	 *             manter a chave estrangeira referente à empresa.
	 */
	@ManyToOne
	@JoinColumn(name = "cnpj_empresa")
	private Empresa cnpjEmpresa;
}
