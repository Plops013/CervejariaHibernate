package com.qintess.cervejaria.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cerveja {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false)
	private String sku;
	@Column(columnDefinition="TEXT", nullable = false)
	private String nome;
	@Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
	private BigDecimal valor;
	@Column(columnDefinition = "DECIMAL(3,2)", nullable = false)
	private Float teorAlcolico;
	@Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
	private BigDecimal comissao;
	@Column(length = 50, nullable = false)
	private String sabor;
	@Column(length = 50, nullable = false)
	private String origem;
	@ManyToOne
	@JoinColumn(name = "estilo_id", nullable = false)
	private Estilo estilo;
	@Column(name = "quantidade_estoque")
	private int quantidadeEstoque;
	@Column(length = 100)
	private String foto;
	@Column(name="content_type" ,length = 100)
	private String contentType;
	
	public Cerveja() {}
	public Cerveja(String sku, String nome, BigDecimal valor, Float teorAlcolico, BigDecimal comissao, String sabor,
			String origem, int quantidadeEstoque, String foto, String contentType) {
		this.sku = sku;
		this.nome = nome;
		this.valor = valor;
		this.teorAlcolico = teorAlcolico;
		this.comissao = comissao;
		this.sabor = sabor;
		this.origem = origem;
		this.quantidadeEstoque = quantidadeEstoque;
		this.foto = foto;
		this.contentType = contentType;
	}
	
	public Cerveja(String sku, String nome, BigDecimal valor, Float teorAlcolico, BigDecimal comissao, String sabor,
			String origem, Estilo estilo, int quantidadeEstoque, String foto, String contentType) {
		super();
		this.sku = sku;
		this.nome = nome;
		this.valor = valor;
		this.teorAlcolico = teorAlcolico;
		this.comissao = comissao;
		this.sabor = sabor;
		this.origem = origem;
		this.estilo = estilo;
		this.quantidadeEstoque = quantidadeEstoque;
		this.foto = foto;
		this.contentType = contentType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Float getTeorAlcolico() {
		return teorAlcolico;
	}
	public void setTeorAlcolico(Float teorAlcolico) {
		this.teorAlcolico = teorAlcolico;
	}
	public BigDecimal getComissao() {
		return comissao;
	}
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Estilo getEstilo() {
		return estilo;
	}
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
