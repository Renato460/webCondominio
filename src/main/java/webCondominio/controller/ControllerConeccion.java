package webCondominio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.procedure.ProcedureOutputs;

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
	
	public void cerrarSession() {
		session.close();
		factory.close();
	}
	
	public List<ModelUsuario> login(String user){
		try {
			List<ModelUsuario> usuario = session.createQuery("from ModelUsuario WHERE usuario="+"'"+user+"'").list();
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+user);
			System.out.println(usuario.get(0).getUsuario());

		return usuario;
		}catch(Exception ex) {
		return null;
		}
	}
	
	public String perfil() {
		System.out.println("ENTRAMOS al PERFIL<<<<<<<<<<<<<<<<<<<<<<<");

		StoredProcedureQuery query = session
				.createStoredProcedureQuery("paq_pago_externo.getperfil")
				.registerStoredProcedureParameter(
					"p_runusuario",
				    String.class,
				    ParameterMode.IN
				)
				.registerStoredProcedureParameter(
				    "p_nombrecompleto",
				    String.class,
				    ParameterMode.OUT
				)
				.setParameter("p_runusuario", "19286743-6");
				 
				try {
				    query.execute();
				     
				    String commentCount = (String) query
				    .getOutputParameterValue("p_nombrecompleto");
				    
				 
				    System.out.println(commentCount);
				    return (commentCount);
				 
				}catch(Exception ex){
					System.out.println(ex);
					return ("PROBLEMASSS");
				} finally {
				    query.unwrap(ProcedureOutputs.class)
				    .release();
				    
				}
				
				
				
	}
}
