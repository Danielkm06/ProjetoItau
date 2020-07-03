package com.br.itau.projeto.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.itau.projeto.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer>{
	
	@Query(value="SELECT COUNT(*) as TOTAL FROM mtb310_transaction WHERE STATUS = ?1 AND AG_FINANCEIRO = ?2", nativeQuery = true)
	double findByStatusAndAgfinanceiro(int status, int id);

}
