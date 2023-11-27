package br.com.calltasks.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entidade que representa um usuário em um sistema.
 *
 * @Entity Indica que esta classe é uma entidade JPA, mapeada para uma tabela no
 *         banco de dados.
 * @Data Anotação do projeto Lombok que gera automaticamente métodos como
 *       toString(), equals(), hashCode(), entre outros.
 */
@Entity
@Data
public class Usuario {

	/**
	 * Identificador único para o usuário.
	 *
	 * @Id Indica que este campo é a chave primária da entidade.
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         codigoUsuario.
	 * @GeneratedValue Especifica a estratégia de geração de valor automático para a
	 *                 chave primária.
	 */
	@Id
	@Column(name = "codigo_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoUsuario;

	/**
	 * CPF (Cadastro de Pessoas Físicas) único para o usuário.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         cpfUsuario.
	 */
	@Column(name = "cpf_usuario", nullable = false)
	private String cpfUsuario;

	/**
	 * Nome do usuário.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         nome.
	 */
	@Column(name = "nome_usuario", length = 40, nullable = false)
	private String nome;

	/**
	 * Endereço de e-mail do usuário.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         email.
	 */
	@Column(name = "email_usuario", length = 40, nullable = false)
	private String email;

	/**
	 * Data de abertura do chamado associado ao usuário.
	 *
	 * @Column Especifica detalhes da coluna no banco de dados associada ao campo
	 *         dataAberturaChamado.
	 */
	@Column(name = "dataAbertura_chamado", nullable = false)
	private LocalDate dataAberturaChamado;
}
