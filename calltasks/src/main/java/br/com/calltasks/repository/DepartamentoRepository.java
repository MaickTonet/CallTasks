package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.calltasks.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
