package com.qintess.cervejaria.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 50)
	private String email;
	@Column(nullable = false, length = 120)
	private String senha;
	@Column(nullable = false, precision = 1)
	private short ativo;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_grupo",
    joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	List<Grupo> grupos = new ArrayList<Grupo>();
	
	public Usuario() {}
	public Usuario(String nome, String email, String senha, short ativo, Date dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
		this.dataNascimento = dataNascimento;
	}
	public void addGrupo(Grupo grupo) {
		this.grupos.add(grupo);
	}
	
	public void removeGrupo(Grupo grupo) {
		this.grupos.remove(grupo);
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public short getAtivo() {
		return ativo;
	}
	public void setAtivo(short ativo) {
		this.ativo = ativo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
