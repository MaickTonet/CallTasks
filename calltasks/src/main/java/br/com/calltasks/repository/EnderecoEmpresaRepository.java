package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.EnderecoEmpresa;
@Repository
public interface EnderecoEmpresaRepository extends JpaRepository<EnderecoEmpresa, Long>{

}
