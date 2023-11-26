package br.com.calltasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calltasks.model.TelefoneEmpresa;
@Repository
public interface TelefoneEmpresaRepository extends JpaRepository<TelefoneEmpresa, Long>{

}
