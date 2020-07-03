package com.br.itau.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.br.itau.projeto.dao.AgFinanceiroDAO;
import com.br.itau.projeto.model.AgFinanceiro;


@CrossOrigin("*")
@RestController
public class AgFinanceiroController {

	
	@Autowired
	private AgFinanceiroDAO dao;

	
	@GetMapping("/agentefinanceiros")
	public ResponseEntity<ArrayList<AgFinanceiro>> exibirAgFinanceiro(){
		ArrayList<AgFinanceiro> resposta = (ArrayList<AgFinanceiro>) dao.findAll();
		if (resposta.size()==0) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(resposta);
		}
	}
	@GetMapping("/top10")
		public ResponseEntity<List<AgFinanceiro>> exibirTop10() {
		ArrayList<AgFinanceiro> resposta = (ArrayList<AgFinanceiro>) dao.findTop10ByOrderByVolumetransacionalDesc();
		if (resposta ==null) {
			return ResponseEntity.status(404).build();
		}else {
			return ResponseEntity.ok(resposta);
		}
	
		}
	@GetMapping("/agentefinanceiro/{id}")
	public ResponseEntity<AgFinanceiro> exibirAgFinanceiroPorId(@PathVariable int id){
		AgFinanceiro resposta = dao.findById(id).orElse(null);
		if (resposta == null) {
			return ResponseEntity.status(404).build();
		} else {
			return ResponseEntity.ok(resposta);
		}
		
	}
	
	}	

