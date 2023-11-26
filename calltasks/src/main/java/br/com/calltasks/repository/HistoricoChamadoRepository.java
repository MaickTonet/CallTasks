package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.HistoricoChamado;
@Repository
public interface HistoricoChamadoRepository extends JpaRepository<HistoricoChamado, Long>{

}
