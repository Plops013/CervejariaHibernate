package com.qintess.cervejaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_venda")
public class ItenVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false)
	private int quantidade;
	@Column(nullable = false)
	private double unitario;
	@ManyToOne
	@JoinColumn(name = "cerveja_id")
	private Cerveja cerveja;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venda_id")
	private Venda venda;
	
	public ItenVenda() {}
	
	public ItenVenda(int quantidade, double unitario, Cerveja cerveja, Venda venda) {
		super();
		this.quantidade = quantidade;
		this.unitario = unitario;
		this.cerveja = cerveja;
		this.venda = venda;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getUnitario() {
		return unitario;
	}
	public void setUnitario(double unitario) {
		this.unitario = unitario;
	}
	public Cerveja getCerveja() {
		return cerveja;
	}
	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}
