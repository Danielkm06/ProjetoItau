package com.br.itau.projeto.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.br.itau.projeto.model.AgFinanceiro;


public interface AgFinanceiroDAO extends CrudRepository<AgFinanceiro, Integer>{
		//AgFinanceiro findByIdagente(int idAgente);
		
		public List <AgFinanceiro> findTop10ByOrderByVolumetransacionalDesc();
}