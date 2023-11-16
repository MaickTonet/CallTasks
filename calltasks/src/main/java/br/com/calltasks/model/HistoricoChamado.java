package br.com.calltasks.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "historico_chamado")
@SequenceGenerator(name = "seq_historico_chamado", sequenceName = "seq_historico_chamado", allocationSize = 1, initialValue = 1)
public class HistoricoChamado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_historico_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historico_chamado")
	private int codigoEnderecoEmpresa;

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

	public int getCodigoEnderecoEmpresa() {
		return codigoEnderecoEmpresa;
	}

	public void setCodigoEnderecoEmpresa(int codigoEnderecoEmpresa) {
		this.codigoEnderecoEmpresa = codigoEnderecoEmpresa;
	}

	public Date getDataRegistroChamado() {
		return dataRegistroChamado;
	}

	public void setDataRegistroChamado(Date dataRegistroChamado) {
		this.dataRegistroChamado = dataRegistroChamado;
	}

	public String getResponsavelChamado() {
		return responsavelChamado;
	}

	public void setResponsavelChamado(String responsavelChamado) {
		this.responsavelChamado = responsavelChamado;
	}

	public String getDescricaoChamado() {
		return descricaoChamado;
	}

	public void setDescricaoChamado(String descricaoChamado) {
		this.descricaoChamado = descricaoChamado;
	}

	public Chamado getCodigoChamado() {
		return codigoChamado;
	}

	public void setCodigoChamado(Chamado codigoChamado) {
		this.codigoChamado = codigoChamado;
	}

	public TipoChamado getCodigoTipoChamado() {
		return codigoTipoChamado;
	}

	public void setCodigoTipoChamado(TipoChamado codigoTipoChamado) {
		this.codigoTipoChamado = codigoTipoChamado;
	}

}
