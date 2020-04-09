package com.qintess.cervejaria.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.cervejaria.model.Cerveja;
import com.qintess.cervejaria.model.Cidade;
import com.qintess.cervejaria.model.Cliente;
import com.qintess.cervejaria.model.Estado;
import com.qintess.cervejaria.model.Estilo;
import com.qintess.cervejaria.model.Grupo;
import com.qintess.cervejaria.model.ItenVenda;
import com.qintess.cervejaria.model.Permissao;
import com.qintess.cervejaria.model.Usuario;
import com.qintess.cervejaria.model.Venda;

//This class is just an Example
public class HibernateConfig {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			try {
				Configuration configuration = new Configuration();
				Properties prop = new Properties();

				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost/cervejaria");
				prop.put(Environment.USER, "postgres");
				prop.put(Environment.PASS, "admin");

				//Prestar atenção nisso em banco de dados de produção
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
				prop.put(Environment.SHOW_SQL, "true");
				//Principalmente nessa linha que pode F#der tudo.
				prop.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(prop);

				configuration.addAnnotatedClass(Cerveja.class);
				configuration.addAnnotatedClass(Cidade.class);
				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(Estado.class);
				configuration.addAnnotatedClass(Estilo.class);
				configuration.addAnnotatedClass(Grupo.class);
				configuration.addAnnotatedClass(ItenVenda.class);
				configuration.addAnnotatedClass(Permissao.class);
				configuration.addAnnotatedClass(Usuario.class);
				configuration.addAnnotatedClass(Venda.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}	

