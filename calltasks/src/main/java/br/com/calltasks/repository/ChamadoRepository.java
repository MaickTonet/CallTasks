package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.calltasks.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

}
