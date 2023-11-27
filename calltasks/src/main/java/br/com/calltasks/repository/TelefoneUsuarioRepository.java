package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.TelefoneUsuario;

/**
 * Interface que representa um repositório para operações relacionadas à
 * entidade TelefoneUsuario.
 *
 * @Repository Indica que esta interface é um componente Spring que lida com
 *             acesso a dados.
 */
@Repository
public interface TelefoneUsuarioRepository extends JpaRepository<TelefoneUsuario, Long> {

	// Esta interface herda métodos CRUD básicos de JpaRepository para a entidade
	// TelefoneUsuario.
	// Além disso, você pode adicionar métodos personalizados se necessário.
}
