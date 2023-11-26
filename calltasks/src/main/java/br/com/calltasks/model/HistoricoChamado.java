package br.com.calltasks.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "historico_chamado")
@Data
public class HistoricoChamado {

	@Id
	@Column(name = "cod_historico_chamado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoEnderecoEmpresa;

	@Column(name = "data_reg_chamado", nullable = false)
	private Date dataRegistroChamado;

	@Column(name = "responsavel_reg_chamado", length = 30, nullable = false)
	private String responsavelChamado;

	@Column(name = "descricao_chamado", nullable = false)
	private String descricaoChamado;

	@OneToOne
	@JoinColumn(name = "codigo_chamado")
	private Chamado codigoChamado;

	@OneToOne
	@JoinColumn(name = "cod_tipo_chamado")
	private TipoChamado codigoTipoChamado;

}
