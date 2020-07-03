package com.br.itau.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.br.itau.projeto.dao.TransacaoDAO;

@CrossOrigin("*")
@RestController
public class TransacaoController {
	
	@Autowired
	private TransacaoDAO dao;
	
	@GetMapping("/dashboard/{agFinanceiro}")
	public ArrayList<Double> exibirDashboard(@PathVariable int agFinanceiro) {	
		ArrayList status = new ArrayList();
		status.add(somarStatus0(agFinanceiro));
		status.add(somarStatus1(agFinanceiro));
		status.add(somarStatus2(agFinanceiro));
		return status;		
	}
	
	public double somarStatus0(int id) {
		return dao.findByStatusAndAgfinanceiro(0, id);
	}
	
	public double somarStatus1(int id) {
		return dao.findByStatusAndAgfinanceiro(1, id);
	}
	
	public double somarStatus2(int id) {
		return dao.findByStatusAndAgfinanceiro(2, id);
	}
	
}
