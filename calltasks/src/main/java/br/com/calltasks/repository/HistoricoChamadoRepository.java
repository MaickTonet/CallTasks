package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.HistoricoChamado;

/**
 * Interface que representa um repositório para operações relacionadas à
 * entidade HistoricoChamado.
 *
 * @Repository Indica que esta interface é um componente Spring que lida com
 *             acesso a dados.
 */
@Repository
public interface HistoricoChamadoRepository extends JpaRepository<HistoricoChamado, Long> {

	// Esta interface herda métodos CRUD básicos de JpaRepository para a entidade
	// HistoricoChamado.
	// Além disso, você pode adicionar métodos personalizados se necessário.
}
