package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {

}
