package com.br.itau.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import com.br.itau.projeto.model.Colaborador;

public interface ColaboradorDAO extends CrudRepository<Colaborador, Integer>{

	public Colaborador findByEmailAndSenha(String email, String senha);
	
	public Colaborador findByRacfAndSenha(String racf, String senha);
	
}
