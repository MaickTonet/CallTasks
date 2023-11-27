package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.Usuario;

/**
 * Interface que representa um repositório para operações relacionadas à
 * entidade Usuario.
 *
 * @Repository Indica que esta interface é um componente Spring que lida com
 *             acesso a dados.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// Esta interface herda métodos CRUD básicos de JpaRepository para a entidade
	// Usuario.
	// Além disso, você pode adicionar métodos personalizados se necessário.
}
