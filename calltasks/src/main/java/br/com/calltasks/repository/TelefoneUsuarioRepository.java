package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.TelefoneUsuario;
@Repository
public interface TelefoneUsuarioRepository extends JpaRepository<TelefoneUsuario, Long>{

}
