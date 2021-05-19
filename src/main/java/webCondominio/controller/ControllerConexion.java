package webCondominio.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

import webCondominio.model.*;

public class ControllerConexion {

	private SessionFactory factory;
	private Session session;

	public ControllerConexion() {

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

	public ArrayList<ModelPerfilUsuario> getResidentes(){

		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_USUARIOS.GET_LISTA_USUARIOS")
				.registerStoredProcedureParameter("l_cursor", Class.class, ParameterMode.REF_CURSOR);

		try {
			query.execute();
			List<Object[]> queryResidentes = query.getResultList();
			System.out.println(queryResidentes.toString());
			ArrayList<ModelPerfilUsuario> listaResidentes = new ArrayList<>();
			for (Object[] obj: queryResidentes) {
				String nombre = obj[0].toString();
				String aPaterno = obj[1].toString();
				String aMaterno = obj[2].toString();
				String run = obj[3].toString();
				String nacionalidad = obj[4].toString();
				String telefono = obj[5].toString();
				String correo = obj[6].toString();
				int cantMultas = Integer.parseInt(obj[7].toString());
				ModelPerfilUsuario residente = new ModelPerfilUsuario(nombre,aPaterno,aMaterno,run,nacionalidad,telefono,correo,cantMultas);
				listaResidentes.add(residente);
			}
			return listaResidentes;
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	public ArrayList<ModelPago> getPagos(Date fecha, String rut) {

		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_PAGO_GC.getpagomensual")
				.registerStoredProcedureParameter("p_fecha", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_run", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_totalgastoscomunes", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("p_totalmultas", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("p_totalreservas", Integer.class, ParameterMode.OUT)
				.setParameter("p_fecha", fecha).setParameter("p_run", rut);

		Integer gastComun = (Integer) query.getOutputParameterValue("p_totalgastoscomunes");
		Integer multa = (Integer) query.getOutputParameterValue("p_totalmultas");
		Integer reserva = (Integer) query.getOutputParameterValue("p_totalreservas");

		ModelPago pagosModel = new ModelPago(gastComun, multa, reserva);
		try {
			query.execute();

			ArrayList<ModelPago> pagos = new ArrayList<ModelPago>();
			pagos.add(pagosModel);
			return pagos;

		} catch (Exception ex) {
			return null;
		}
	}

	public boolean setReservaUsuario(Date fecha, String runUsuario, Integer idServicio, Integer idHorario) {

		System.out.println("-------------------->Seteando reserva");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<ID HORARIO: " + fecha);
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_reservas.setreserva")
				.registerStoredProcedureParameter("p_fecha", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_runusuario", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_idservicio", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_idhorario", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_confirm", Integer.class, ParameterMode.OUT)
				.setParameter("p_fecha", fecha).setParameter("p_runusuario", runUsuario)
				.setParameter("p_idservicio", idServicio).setParameter("p_idhorario", idHorario);

		try {
			query.execute();

			Integer exito = (Integer) query.getOutputParameterValue("p_confirm");
			System.out.println(exito);
			if (exito == 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public ArrayList<ModelHorario> getDisponibilidad(Date fecha, Integer idServicio) {

		System.out.println("-------------------->get dispo");
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_reservas.getdisponibilidad")
				.registerStoredProcedureParameter("p_fecha", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_idservicio", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_horariosdisp", Class.class, ParameterMode.REF_CURSOR)
				.setParameter("p_fecha", fecha).setParameter("p_idservicio", idServicio);
		try {
			query.execute();
			List<Object[]> cursorHorarios = query.getResultList();
			ArrayList<ModelHorario> horarios = new ArrayList<ModelHorario>();
			for (Object[] obj : cursorHorarios) {
				Integer idHorario = Integer.parseInt(obj[0].toString());
				System.out.println(idHorario);
				String hora = obj[1].toString();
				System.out.println(hora);
				ModelHorario horario = new ModelHorario(idHorario, hora);

				horarios.add(horario);
			}
			return horarios;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public ArrayList<ModelMulta> multas(String rut) {
		System.out.println("-------------------->Entroooooo");
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_multas.getmultas")
				.registerStoredProcedureParameter("p_rut", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_cursormultas", Class.class, ParameterMode.REF_CURSOR)
				.setParameter("p_rut", rut);

		try {
			query.execute();

			List<Object[]> cursorMultas = query.getResultList();
			ArrayList<ModelMulta> multas = new ArrayList<ModelMulta>();
			for (Object[] obj : cursorMultas) {

				int idMulta = Integer.parseInt(obj[0].toString());
				SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd hh:mm:ss");
				java.util.Date date = sdf.parse(obj[3].toString());
				Date fecha = new Date(date.getTime());

				String descripcion = obj[1].toString();

				int monto = Integer.parseInt(obj[2].toString());

				ModelMulta multa = new ModelMulta(idMulta, fecha, descripcion, monto);
				multas.add(multa);

			}

			return multas;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public ArrayList<ModelAnuncios> anuncios() {

		System.out.println("-------------------->Anuncios");
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_anuncios.getanuncios")
				.registerStoredProcedureParameter("p_cursoranuncios", Class.class, ParameterMode.REF_CURSOR);

		try {
			query.execute();

			List<Object[]> anunciosQuery = query.getResultList();

			ArrayList<ModelAnuncios> anuncios = new ArrayList<ModelAnuncios>();
			for (Object[] obj : anunciosQuery) {

				int idAnuncio = Integer.parseInt(obj[0].toString());
				String descripcion = obj[1].toString();
				System.out.println(descripcion);
				String url = obj[2].toString();
				System.out.println(url);
				ModelAnuncios anuncio = new ModelAnuncios(idAnuncio, descripcion, url);
				anuncios.add(anuncio);
			}
			return anuncios;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	};

	public List<String> login(String user, String pass) {

		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_usuarios.getusuario")
				.registerStoredProcedureParameter("p_usuario", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_run", String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("p_rol", String.class, ParameterMode.OUT)
				.setParameter("p_usuario", user).setParameter("p_password", pass);

		try {
			query.execute();

			String run = (String) query.getOutputParameterValue("p_run");
			String nombre = (String) query.getOutputParameterValue("p_nombre");
			String rol = (String) query.getOutputParameterValue("p_rol");
			List<String> usuario = new ArrayList<String>();
			usuario.add(run);
			usuario.add(nombre);
			usuario.add(rol);
			System.out.println(run);
			System.out.println(nombre);
			System.out.println(rol);
			return (usuario);

		} catch (Exception ex) {
			System.out.println(ex);
			return (null);
		} finally {
			query.unwrap(ProcedureOutputs.class).release();

		}
	}

	public String perfil() {
		System.out.println("ENTRAMOS al PERFIL<<<<<<<<<<<<<<<<<<<<<<<");

		StoredProcedureQuery query = session.createStoredProcedureQuery("paq_pago_externo.getperfil")
				.registerStoredProcedureParameter("p_runusuario", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_nombrecompleto", String.class, ParameterMode.OUT)
				.setParameter("p_runusuario", "19286743-6");

		try {
			query.execute();

			String nombre = (String) query.getOutputParameterValue("p_nombrecompleto");
			System.out.println(nombre);
			return (nombre);

		} catch (Exception ex) {
			System.out.println(ex);
			return ("PROBLEMASSS");
		} finally {
			query.unwrap(ProcedureOutputs.class).release();

		}
	}

	public List<ModelServicio> getServicios() {
		List<ModelServicio> reserva = session.createQuery("from ModelServicio").list();

		System.out.println(reserva.get(0));
		return reserva;
	}
}
