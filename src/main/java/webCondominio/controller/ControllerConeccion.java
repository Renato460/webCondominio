package webCondominio.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import webCondominio.model.ModelUsuario;

public class ControllerConeccion {
	
	private SessionFactory factory;
	private Session session;
	
	public ControllerConeccion() {
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();

		try {

			System.out.println("ENTRAMOOOOS!!");
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			session = factory.openSession();
			// Transaction transaction = session.beginTransaction();


		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<" + ex + "<<<<<<<<<<<<<<<<<<<<<<");
		}
	}
	
	
	public List<ModelUsuario> login(String user){
		
		List<ModelUsuario> usuario = session.createQuery("from ModelUsuario WHERE usuario="+"'"+user+"'").list();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+user);
		System.out.println(usuario.get(0).getUsuario());
		session.close();
		factory.close();
		return usuario;
	}
}
