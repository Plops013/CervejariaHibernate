package com.qintess.cervejaria.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	@Column(precision = 10, scale = 2)
	private double valorFrete;
	@Column(precision = 10, scale = 2)
	private double valorDesconto;
	@Column(nullable = false, precision = 10, scale = 2)
	private double valorTotal;
	@Column(length = 30)
	private String status;
	@Column(length = 200)
	private String observacao;
	@Temporal(TemporalType.TIME)
	private Date dataHoraEntrega;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "venda")
	private List<ItenVenda> itensVenda = new ArrayList<>();
	
	public Venda() {}
	public Venda(Date dataCriacao, double valorFrete, double valorDesconto, double valorTotal, String status,
			String observacao, Date dataHoraEntrega) {
		this.dataCriacao = dataCriacao;
		this.valorFrete = valorFrete;
		this.valorDesconto = valorDesconto;
		this.valorTotal = valorTotal;
		this.status = status;
		this.observacao = observacao;
		this.dataHoraEntrega = dataHoraEntrega;
	}
	
	public void addItem(Cerveja cerveja, int quantidade) {
		ItenVenda iv = new ItenVenda(quantidade, cerveja.getValor().doubleValue(), cerveja, this);
		this.valorTotal += (iv.getUnitario() * iv.getQuantidade());
		itensVenda.add(iv);
	}
	
	public void removeItem(Cerveja cerveja) {
		for (ItenVenda itenVenda : itensVenda) {
			if(itenVenda.getCerveja().equals(cerveja)) {
				itensVenda.remove(itenVenda);
				break;
			}
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
