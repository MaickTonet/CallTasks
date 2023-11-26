package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
