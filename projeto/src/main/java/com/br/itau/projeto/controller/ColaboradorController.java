package com.br.itau.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.itau.projeto.dao.ColaboradorDAO;
import com.br.itau.projeto.model.Colaborador;

@CrossOrigin("*")
@RestController
public class ColaboradorController {

	@Autowired
	private ColaboradorDAO dao;
	
	@PostMapping("/login")
	public ResponseEntity<Colaborador> login(@RequestBody Colaborador colaborador){
		
		Colaborador resposta;
		if (colaborador.getEmail() == null) {
			resposta = dao.findByRacfAndSenha(colaborador.getRacf(), colaborador.getSenha());
		} else {
			resposta = dao.findByEmailAndSenha(colaborador.getEmail(), colaborador.getSenha());
		}
		if (resposta == null) {
			return ResponseEntity.status(403).build();
		} else {
			return ResponseEntity.ok(resposta);
		}
	}
	
}
