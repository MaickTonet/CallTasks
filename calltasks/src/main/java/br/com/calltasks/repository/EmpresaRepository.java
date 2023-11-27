package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.Empresa;

/**
 * Interface que representa um repositório para operações relacionadas à
 * entidade Empresa.
 *
 * @Repository Indica que esta interface é um componente Spring que lida com
 *             acesso a dados.
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {

	// Esta interface herda métodos CRUD básicos de JpaRepository para a entidade
	// Empresa.
	// Além disso, você pode adicionar métodos personalizados se necessário.
}
