package com.br.itau.projeto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="MTB310_ag_financeiro")
public class AgFinanceiro {
		
		@Column(name="id_agente")
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idAgente;
		
		@Column(name="nome_agente", length=100)
		private String nomeAgente;
		
		@Column(name="volume_transacional")
		private float volumetransacional;
		
		@JsonIgnoreProperties("agFinanceiro")
		@OneToMany(cascade=CascadeType.ALL, mappedBy="agFinanceiro")
		private List<Transacao> transacoes;
		
		public AgFinanceiro(int idAgente, String nomeAgente, float volumeTransacional) {
			super();
			this.idAgente = idAgente;
			this.nomeAgente = nomeAgente;
			this.volumetransacional = volumeTransacional;
		}
		
		
		public AgFinanceiro() {
			super();
			
			
		}
		public int getIdAgente() {
			return idAgente;
		}
		public void setIdAgente(int idAgente) {
			this.idAgente = idAgente;
		}
		public String getNomeAgente() {
			return nomeAgente;
		}
		public void setNomeAgente(String nomeAgente) {
			this.nomeAgente = nomeAgente;
		}
		public float getVolumeTransacional() {
			return volumetransacional;
		}
		public void setVolumeTransacional(float volumeTransacional) {
			this.volumetransacional = volumeTransacional;
		}
		
		
		
		
}
