package webCondominio.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import webCondominio.model.ModelUsuario;

public class ControllerConeccion {

	public ControllerConeccion() {
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();

		try {

			System.out.println("ENTRAMOOOOS!!");
			SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			Session session = factory.openSession();
			// Transaction transaction = session.beginTransaction();
			System.out.println("<<<<<" + session + "<<<<<<<<");

			List<ModelUsuario> usuario = session.createQuery("from ModelUsuario").list();

			System.out.println("<<<<<" + usuario.get(0).getUsuario() + "<<<<<<<<");
			// transaction.commit();

			session.close();
			factory.close();

		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<" + ex + "<<<<<<<<<<<<<<<<<<<<<<");
		}
	}
}
