package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calltasks.model.Empresa;

public interface EmpresaRepositoryRepository extends JpaRepository<Empresa, String>{

}
