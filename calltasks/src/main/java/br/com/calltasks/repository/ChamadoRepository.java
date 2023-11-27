package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.Chamado;

/**
 * Interface que representa um repositório para operações relacionadas à
 * entidade Chamado.
 *
 * @Repository Indica que esta interface é um componente Spring que lida com
 *             acesso a dados.
 */
@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

	// Esta interface herda métodos CRUD básicos de JpaRepository para a entidade
	// Chamado.
	// Além disso, você pode adicionar métodos personalizados se necessário.
}
