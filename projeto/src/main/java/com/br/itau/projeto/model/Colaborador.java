package com.br.itau.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COLABORADOR")
public class Colaborador {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="RACF", length=7)
	private String racf;
	@Column(name="EMAIL", length=40)
	private String email;
	@Column(name="NOME", length=50)
	private String nome;
	@Column(name="SENHA", length=40)
	private String senha;
	@Column(name="FOTO", length=40)
	private String foto;

	public Colaborador() {
		super();
	}

	public Colaborador(int id, String racf, String email, String nome, String senha, String foto) {
		super();
		
		this.id = id;
		this.racf = racf;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
