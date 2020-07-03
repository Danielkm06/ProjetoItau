package com.br.itau.projeto.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mtb310_transaction")
public class Transacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_transacao")	
	private int idTransacao;
	
	@Column(name="data_hora")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dataHora;
	
	@Column(name="dispositivo")
	private int dispositivo;
	
	@Column(name="valor_solic")
	private float valorSolic;
	
	@Column(name="valor_aut")
	private float valorAut;
	
	@Column(name="status")
	private int status;
	
	@JsonIgnoreProperties("transacoes")
	@ManyToOne
	private AgFinanceiro agFinanceiro;

	
	
	public Transacao() {
		super();
	}

	public Transacao(int idTransacao, Date dataHora, int dispositivo, float valorSolic, float valorAut, int status,
			AgFinanceiro agFinanceiro) {
		super();
		this.idTransacao = idTransacao;
		this.dataHora = dataHora;
		this.dispositivo = dispositivo;
		this.valorSolic = valorSolic;
		this.valorAut = valorAut;
		this.status = status;
		this.agFinanceiro = agFinanceiro;
	}

	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public int getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(int dispositivo) {
		this.dispositivo = dispositivo;
	}

	public float getValorSolic() {
		return valorSolic;
	}

	public void setValorSolic(float valorSolic) {
		this.valorSolic = valorSolic;
	}

	public float getValorAut() {
		return valorAut;
	}

	public void setValorAut(float valorAut) {
		this.valorAut = valorAut;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public AgFinanceiro getAgFinanceiro() {
		return agFinanceiro;
	}

	public void setAgFinanceiro(AgFinanceiro agFinanceiro) {
		this.agFinanceiro = agFinanceiro;
	}
	
	


}