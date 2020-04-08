package com.qintess.cervejaria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false, length = 50)
	private String nome;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Permissao> permissoes = new ArrayList<Permissao>();
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "grupos")
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Grupo() {}
	public Grupo(String nome) {
		this.nome = nome;
	}	
	
	public void addPermissao(Permissao permissao) {
		permissoes.add(permissao);
	}
	
	public void removePermissao(Permissao permissao) {
		permissoes.remove(permissao);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
