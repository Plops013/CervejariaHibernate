package com.qintess.cervejaria.teste;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import com.qintess.cervejaria.dao.GenericDao;
import com.qintess.cervejaria.model.Cerveja;
import com.qintess.cervejaria.model.Cidade;
import com.qintess.cervejaria.model.Cliente;
import com.qintess.cervejaria.model.Estado;
import com.qintess.cervejaria.model.Estilo;
import com.qintess.cervejaria.model.Grupo;
import com.qintess.cervejaria.model.Permissao;
import com.qintess.cervejaria.model.Usuario;
import com.qintess.cervejaria.model.Venda;

public class ExecutaTeste {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
	
	GenericDao dao;
		
	//PERMISSÃO
	Permissao permissao = new Permissao("Administrador");
	
	//GRUPO da Cascade nas permissões
	Grupo grupo = new Grupo("Estagiarios");
	grupo.addPermissao(permissao);
	dao = new GenericDao<Grupo, Integer>();
	dao.persistir(grupo);
	
	//USUARIO
	Usuario user = new Usuario("Fabio Lopes", "fabio.lopes@qintess.com", "KsmRD9bWE@MVSyq", (short) 1, Date.valueOf(LocalDate.now()));
	dao = new GenericDao<Usuario, Integer>();
	user.addGrupo(grupo);
	dao.persistir(user);
	
	//Estilo
	Estilo estilo = new Estilo("Pilsen");
	dao = new GenericDao<Estilo, Integer>();
	dao.persistir(estilo);
	
	//Cerveja
	Cerveja cerveja = new Cerveja(
			"breja",
			"skol",
			BigDecimal.valueOf(3.50), 
			7.5F, 
			BigDecimal.valueOf(5), 
			"Lupus", 
			"Brasileira",
			estilo,
			350, 
			"", 
			"contentTipo");
	
	dao = new GenericDao<Cerveja, Integer>();
	dao.persistir(cerveja);
	
	//Estado
	Estado estado = new Estado("São Paulo", "SP");
	dao = new GenericDao<Estado, Integer>();
	dao.persistir(estado);
	
	//Cidade
	Cidade cidade = new Cidade("Santo André", estado);
	dao = new GenericDao<Cidade, Integer>();
	dao.persistir(cidade);
	
	
	//Cliente
	Cliente cliente = new Cliente("Joaoziho", "Pessoa Fisica", "490.646.298-70", "13 981725946", "fabio.lopes@qintess.com", "Rua Catarina Maria", "33", "Apto 4", "11707090", cidade);
	dao = new GenericDao<Cliente, Integer>();
	dao.persistir(cliente);
	
	//Venda
	Venda venda = new Venda(Date.valueOf(LocalDate.now()), 0, 0, 0, "Em aberto", "Entregar Gelada", null);
	dao = new GenericDao<Venda, Integer>();
	venda.addItem(cerveja, 12);
	venda.setCliente(cliente);
	venda.setUsuario(user);
	dao.persistir(venda);
	}
}
