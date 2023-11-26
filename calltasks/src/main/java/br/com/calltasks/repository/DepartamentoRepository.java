package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.Departamento;
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
