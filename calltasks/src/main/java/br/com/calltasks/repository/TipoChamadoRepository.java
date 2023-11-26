package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.TipoChamado;

@Repository
public interface TipoChamadoRepository extends JpaRepository<TipoChamado, Long> {

}
