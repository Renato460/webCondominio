package webCondominio.controller;

import java.sql.Date;
import java.util.*;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.loader.custom.sql.SQLCustomQuery;
import org.hibernate.procedure.ProcedureOutputs;

import webCondominio.model.*;

public class ControllerConexion {

	private SessionFactory factory;
	private Session session;

	//Controlador de conexión a base de datos
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
	//*******

	//Cerrar sesión
	public void cerrarSession() {
		session.close();
		factory.close();
	}
	//*******

	//Ingresa nuevos anuncios
	public ArrayList<ModelReservaLista> getReservas(String rut){

		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_RESERVAS.GETRESERVAUSUARIO")
				.registerStoredProcedureParameter("p_run", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_reserva", Class.class, ParameterMode.REF_CURSOR)
				.setParameter("p_run", rut);
		try {
			query.execute();
			List<Object[]> queryPlanilla = query.getResultList();
			ArrayList<ModelReservaLista> reservaListas = new ArrayList<>();
			queryPlanilla.forEach(objects -> {
				ModelReservaLista modelReservaLista = new ModelReservaLista();
				modelReservaLista.setId(Integer.parseInt(objects[0].toString()));
				modelReservaLista.setFecha(objects[1].toString());
				modelReservaLista.setHorario(objects[2].toString());
				modelReservaLista.setNombreServicio(objects[3].toString());
				modelReservaLista.setCosto(Double.parseDouble(objects[4].toString()));
				reservaListas.add(modelReservaLista);
			});


			return reservaListas;
		}catch (Exception e){
			return null;
		}
	}
	//*********


	//Generar Pago Respuesta
	public boolean setPagoResponse(String paymentId, double monto, Integer id_planilla, String tipo){
		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_PAGO_GC.SETPAGORESPUESTA")
				.registerStoredProcedureParameter("p_paymentid", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_monto", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_idplanilla",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_tipo",String.class,ParameterMode.IN)
				.setParameter("p_paymentid", paymentId)
				.setParameter("p_monto", monto)
				.setParameter("p_idplanilla", id_planilla)
				.setParameter("p_tipo", tipo);
		try {
			query.execute();
			return true;
		}catch (Exception e){
			return false;
		}
	}
	//********

	//Generar Pago Respuesta
	public Map<String,String> getPagoResponse(String paymentId){
		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_PAGO_GC.GETPAGORESPUESTA")
				.registerStoredProcedureParameter("p_paymentid", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_monto", Double.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("p_idplanilla",Integer.class,ParameterMode.OUT)
				.registerStoredProcedureParameter("p_tipo",String.class,ParameterMode.OUT)
				.setParameter("p_paymentid", paymentId);
		try {
			query.execute();
			String montoRespuesta = query.getOutputParameterValue("p_monto").toString();
			String idPlanillaRespuesta = query.getOutputParameterValue("p_idplanilla").toString();
			String tipoRespuesta = query.getOutputParameterValue("p_tipo").toString();
			Map<String,String> respuesta = new LinkedHashMap<>();
			respuesta.put("monto",montoRespuesta);
			respuesta.put("id_plantilla", idPlanillaRespuesta);
			respuesta.put("tipo",tipoRespuesta);
			return respuesta;
		}catch (Exception e){
			return null;
		}
	}
	//********

	public Integer getStatusPago(Integer pagoId){
		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_PAGO_GC.GETSTATUSPAGO")
				.registerStoredProcedureParameter("p_idpago", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_status", Integer.class, ParameterMode.OUT)
				.setParameter("p_idpago", pagoId);
		try {
			query.execute();
			return Integer.parseInt(query.getOutputParameterValue("p_status").toString());

		}catch (Exception e){
			return 0;
		}
	}
	//********
	//Setear Multas
	public int setMulta(String rut, String descripcion, Integer monto){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_multas.setmulta")
				.registerStoredProcedureParameter("p_rut", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_descripcion", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_monto", Integer.class, ParameterMode.IN)
				.setParameter("p_rut", rut)
				.setParameter("p_descripcion", descripcion)
				.setParameter("p_monto", monto);
		try {
			query.execute();
			return 1;
		}catch (Exception e){
			System.out.println("<<<<<<<"+e);
			return 0;
		}

	}
	//********

	//Update Multas
	public int updateMulta(int id_multa, String descripcion, Integer monto){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_multas.UPDATEMULTA")
				.registerStoredProcedureParameter("P_IDMULTA", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("P_DESCRIPCION", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("P_MONTO", Integer.class, ParameterMode.IN)
				.setParameter("P_IDMULTA", id_multa)
				.setParameter("P_DESCRIPCION", descripcion)
				.setParameter("P_MONTO", monto);
		try {

			query.execute();

			return 1;
		}catch (Exception e){
			System.out.println("<<<<<<<"+e);

			return 0;
		}

	}
	//********

	//Update Multas
	public int deleteMulta(int id_multa){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_multas.DELETEMULTA")
				.registerStoredProcedureParameter("P_IDMULTA", Integer.class, ParameterMode.IN)
				.setParameter("P_IDMULTA", id_multa);
		try {

			query.execute();

			return 1;
		}catch (Exception e){
			System.out.println("<<<<<<<"+e);

			return 0;
		}

	}
	//********

	//Historial de Pagos GC
	public ArrayList<ModelPlanillaGC> getPlanillaByRut(String rut){

		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_PAGO_GC.getplanillasusuario")
				.registerStoredProcedureParameter("p_rut",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("c_curplanillasusu",Class.class,ParameterMode.REF_CURSOR)
				.setParameter("p_rut",rut);

		try {
			query.execute();
			List<Object[]> queryPlanilla = query.getResultList();
			ArrayList<ModelPlanillaGC> planillaGCS = new ArrayList<>();
			queryPlanilla.forEach(objects -> {
				ModelPlanillaGC modelPlanillaGC = new ModelPlanillaGC();
				modelPlanillaGC.setIdPlanilla(Integer.parseInt(objects[0].toString()));
				modelPlanillaGC.setFecha(objects[1].toString());
				modelPlanillaGC.setMontoTotal(Integer.parseInt(objects[2].toString()));
				modelPlanillaGC.setFechavenc(objects[3].toString());
				String valido;
				if(objects[4].toString().equals("0")){
					valido = "Pagado";
				}else {
					valido = "Por Pagar";
				}
				modelPlanillaGC.setIsvalid(valido);
				modelPlanillaGC.setMontoReserva(Integer.parseInt(objects[5].toString()));
				if (objects[6]==null){
					modelPlanillaGC.setFechaPago("");
				}else{
					modelPlanillaGC.setFechaPago(objects[6].toString());
				}
				modelPlanillaGC.setMontoGastoComun(Integer.parseInt(objects[7].toString()));
				planillaGCS.add(modelPlanillaGC);
			});
			return planillaGCS;
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	//*******

	//Historial de Pagos GC
	public ArrayList<ModelPlanillaGC> getPlanillaPagada(String rut){

		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_PAGO_GC.GETPLANILLASUSUARIONOVALID")
				.registerStoredProcedureParameter("p_rut",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("c_curplanillasusu",Class.class,ParameterMode.REF_CURSOR)
				.setParameter("p_rut",rut);

		try {
			query.execute();
			List<Object[]> queryPlanilla = query.getResultList();
			ArrayList<ModelPlanillaGC> planillaGCS = new ArrayList<>();
			queryPlanilla.forEach(objects -> {
				ModelPlanillaGC modelPlanillaGC = new ModelPlanillaGC();
				modelPlanillaGC.setIdPlanilla(Integer.parseInt(objects[0].toString()));
				modelPlanillaGC.setFecha(objects[1].toString());
				modelPlanillaGC.setMontoTotal(Integer.parseInt(objects[2].toString()));
				modelPlanillaGC.setFechavenc(objects[3].toString());
				String valido;
				if(objects[4].toString().equals("0")){
					valido = "Pagado";
				}else {
					valido = "Por Pagar";
				}
				modelPlanillaGC.setIsvalid(valido);
				modelPlanillaGC.setMontoReserva(Integer.parseInt(objects[5].toString()));
				if (objects[6]==null){
					modelPlanillaGC.setFechaPago("");
				}else{
					modelPlanillaGC.setFechaPago(objects[6].toString());
				}
				modelPlanillaGC.setMontoGastoComun(Integer.parseInt(objects[7].toString()));
				planillaGCS.add(modelPlanillaGC);
			});
			return planillaGCS;
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	//*******

	//Listas de residentes y usuarios
	public ArrayList<ModelPerfilUsuario> getResidentes(Integer idRol){
		System.out.println(idRol);
		StoredProcedureQuery query = session.createStoredProcedureQuery("PKG_USUARIOS.GET_LISTA_USUARIOS")
				.registerStoredProcedureParameter("p_idrol", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("l_cursor", Class.class, ParameterMode.REF_CURSOR)
				.setParameter("p_idrol", idRol);

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
				String fechai = obj[7].toString();
				System.out.println(fechai);
				int cantMultas = Integer.parseInt(obj[8].toString());
				ModelPerfilUsuario residente = new ModelPerfilUsuario(nombre,aPaterno,aMaterno,run,nacionalidad,telefono,correo,cantMultas,fechai);
				listaResidentes.add(residente);
			}
			return listaResidentes;
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	//*******

	//Retorna la lista del total de pagos Gastos Comunes + Multas + Reservas
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
	//*******

	//genera una reserva de servicio del Usuario
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
	//*******

	//Retorna la disponibilidad de horario para una reserva
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
			ArrayList<ModelHorario> horarios = new ArrayList<>();
			cursorHorarios.forEach(objects -> {
				int idHorario = Integer.parseInt(objects[0].toString());
				String hora = objects[1].toString();
				ModelHorario horario = new ModelHorario(idHorario, hora);
				horarios.add(horario);
			});

			return horarios;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	//*******

	//Retorna la lista de multas de un usuario Residente
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
				String fecha = obj[3].toString();
				System.out.println(fecha);
				String descripcion = obj[1].toString();
				int monto = Integer.parseInt(obj[2].toString());

				ModelMulta multa = new ModelMulta(idMulta, fecha, descripcion, monto);
				multas.add(multa);

			}
			System.out.println(multas);
			return multas;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	//*******

	//Retorna la lista de multas de un usuario Residente
	public ArrayList<ModelReservaLista> getAllReservas() {

		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_reservas.getallreservas")
								.registerStoredProcedureParameter("p_reservas", Class.class, ParameterMode.REF_CURSOR);

		try {
			query.execute();

			List<Object[]> cursorReservas = query.getResultList();
			ArrayList<ModelReservaLista> reservas = new ArrayList<>();

			cursorReservas.forEach(objects -> {
				ModelReservaLista modelReservaLista = new ModelReservaLista();
				modelReservaLista.setId(Integer.parseInt(objects[0].toString()));
				modelReservaLista.setFecha(objects[1].toString());
				modelReservaLista.setNombre(objects[2].toString());
				modelReservaLista.setHorario(objects[3].toString());
				modelReservaLista.setNombreServicio(objects[4].toString());
				modelReservaLista.setCosto(Integer.parseInt(objects[5].toString()));
				reservas.add(modelReservaLista);
			});

			return reservas;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	//*******
	//Retorna los anuncios creados por el Administrador o Directiva
	public ArrayList<ModelAnuncios> anuncios() {

		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_anuncios.getanuncios")
				.registerStoredProcedureParameter("p_cursoranuncios", Class.class, ParameterMode.REF_CURSOR);

		try {
			query.execute();

			List<Object[]> anunciosQuery = query.getResultList();

			ArrayList<ModelAnuncios> anuncios = new ArrayList<ModelAnuncios>();
			for (Object[] obj : anunciosQuery) {

				int idAnuncio = Integer.parseInt(obj[0].toString());
				String descripcion = obj[1].toString();

				String url = "../assets/img/anuncios/"+obj[2].toString();

				ModelAnuncios anuncio = new ModelAnuncios(idAnuncio, descripcion, url);
				anuncios.add(anuncio);
			}
			return anuncios;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	};
	//*******

	//Ingresa nuevos anuncios
	public boolean setAnuncios(String descripcion, String urlImagen){
		System.out.println(">>>>>>>>>>>>>"+descripcion);
		System.out.println(">>>>>>>>>>>>>"+urlImagen);
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_anuncios.setanuncio")
				.registerStoredProcedureParameter("p_descripcion", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_url", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("return_message", String.class, ParameterMode.OUT)
				.setParameter("p_descripcion", descripcion)
				.setParameter("p_url", urlImagen);
		try {
			query.execute();
			String message = (String) query.getOutputParameterValue("return_message");
			System.out.println(message);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	//*********


	//Retorna Los datos de un usuario si se encuentra registrado
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
	//*******

	//TODO por hacer perfil
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
	//*******
	public int setCondominio(String nombre, int numero,String calle, int idComuna){
		StoredProcedureQuery query = session.createStoredProcedureQuery("paq_condominios.setcondominio")
				.registerStoredProcedureParameter("p_nombre", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_numero", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_calle", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_idcomuna", Integer.class,ParameterMode.IN )
				.setParameter("p_nombre",nombre)
				.setParameter("p_numero",numero)
				.setParameter("p_calle",calle)
				.setParameter("p_idcomuna",idComuna);
		try{
			query.execute();
			return 1;
		}
		catch(Exception ex){
			return 0;
		}
	}
	public int setGastoComun(int idCondominio,String descripcion,int valor){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_gastoscomunes.setgastocomun")
				.registerStoredProcedureParameter("p_idcondominio",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_descripcion",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_valor",Integer.class,ParameterMode.IN)
				.setParameter("p_idcondominio",idCondominio)
				.setParameter("p_descripcion",descripcion)
				.setParameter("p_valor",valor);
		try{
			query.execute();
			return 1;
		}
		catch (Exception ex){
			return 0;
		}
	}
	public int setVivienda(int nroVivienda,int idCondominio,String titular,String ruttitular){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_vivienda.setvivienda")
				.registerStoredProcedureParameter("p_numero", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_idcondominio", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_titular", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_ruttitular", String.class,ParameterMode.IN )
				.setParameter("p_numero",nroVivienda)
				.setParameter("p_idcondominio",idCondominio)
				.setParameter("p_titular",titular)
				.setParameter("p_ruttitular",ruttitular);
		try{
			query.execute();
			return 1;
		}
		catch(Exception ex){
			return 0;
		}
	}
	public int setPagoManual(int idPlanilla){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_pago_gc.setpagomanual")
				.registerStoredProcedureParameter("p_idplanilla",Integer.class,ParameterMode.IN)
				.setParameter("p_idplanilla",idPlanilla);
		try{
			query.execute();
			return 1;
		}
		catch(Exception ex){
			return 0;
		}
	}
	public int setPagoAuto(int idPlanilla){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_pago_gc.SETPAGOAUTO")
				.registerStoredProcedureParameter("p_idplanilla",Integer.class,ParameterMode.IN)
				.setParameter("p_idplanilla",idPlanilla);
		try{
			query.execute();
			return 1;
		}
		catch(Exception ex){
			return 0;
		}
	}
	public int updateUser(String Nombre,String Apaterno,String Amaterno,String Run,String Nacionalidad,int Telefono,String Correo){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_usuarios.updateperfiluser")
				.registerStoredProcedureParameter("p_Nombre", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_Apaterno", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_Amaterno", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_Run", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_Nacionalidad", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_Telefono", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_Correo", String.class,ParameterMode.IN)
				.setParameter("p_Nombre",Nombre)
				.setParameter("p_Apaterno",Apaterno)
				.setParameter("p_Amaterno",Amaterno)
				.setParameter("p_Run",Run)
				.setParameter("p_Nacionalidad",Nacionalidad)
				.setParameter("p_Telefono",Telefono)
				.setParameter("p_Correo",Correo);
		try{
			query.execute();
			return 1;
		}
		catch(Exception ex){
			return 0;
		}
	}
	public int updateGastoComun (int idGastocomun,String descripcion,int valor){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_gastoscomunes.updategastoscomun")
				.registerStoredProcedureParameter("p_idgastoc",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_descripcion",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_valor",Integer.class,ParameterMode.IN)
				.setParameter("p_idgastoc",idGastocomun)
				.setParameter("p_descripcion",descripcion)
				.setParameter("p_valor",valor);
		try{
			query.execute();
			return 1;
		} catch (Exception ex){
			return 0;
		}
	}
	public int updateVivienda(int idVivienda,int nroVivienda,String titular,String ruttitular){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_vivienda.updatevivienda")
				.registerStoredProcedureParameter("p_idVivienda",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_nroVivienda",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_titular",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_ruttitular",String.class,ParameterMode.IN)
				.setParameter("p_idVivienda",idVivienda)
				.setParameter("p_nroVivienda",nroVivienda)
				.setParameter("p_titular",titular)
				.setParameter("p_ruttitular",ruttitular);
		try{
			query.execute();
			return 1;
		}catch (Exception ex){
			return 0;
		}
	}
	public int updateEvento(int idEvento,String descripcion){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_eventosconserje.updateevento")
				.registerStoredProcedureParameter("p_idEvento",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_descripcion",String.class,ParameterMode.IN)
				.setParameter("p_idEvento",idEvento)
				.setParameter("p_descripcion",descripcion);
		try{
			query.execute();
			return 1;
		}catch(Exception ex){
			return 0;
		}
	}
	//Crea un perfil de usuario
	public int setPerfil(String usuario,String password,int idrol,String nombre, String apaterno,String amaterno, String run,String nacionalidad, int telefono,String correo, int nrovivienda, int idcondominio){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_usuarios.setusuario")
				.registerStoredProcedureParameter("p_usuario", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_password", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_idrol", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_nombre", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_apaterno", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_amaterno", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_run", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_nacionalidad", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_telefono", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_correo", String.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_nrovivienda", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("p_idcondominio", Integer.class,ParameterMode.IN )
				.setParameter("p_usuario",usuario)
				.setParameter("p_password",password)
				.setParameter("p_idrol",idrol)
				.setParameter("p_nombre",nombre)
				.setParameter("p_apaterno",apaterno)
				.setParameter("p_amaterno",amaterno)
				.setParameter("p_run",run)
				.setParameter("p_nacionalidad",nacionalidad)
				.setParameter("p_telefono",telefono)
				.setParameter("p_correo",correo)
				.setParameter("p_nrovivienda",nrovivienda)
				.setParameter("p_idcondominio",idcondominio);

		try{
			query.execute();
			return 1;
		}
		catch(Exception ex){
			System.out.println(ex);
			return 0;
		}
	}
	public int getcantMultas(){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_reportes.getcantmultas")
				.registerStoredProcedureParameter("p_multas", Integer.class, ParameterMode.OUT);
		try{
			query.execute();

			Integer cantMultas=Integer.parseInt(query.getOutputParameterValue("p_multas").toString());
			return cantMultas;
		}
		catch(Exception ex){
			return 0;
		}
	}
	public int getcantCondos(){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_reportes.GETCANTCONDOMINIOS")
				.registerStoredProcedureParameter("p_condominios", Integer.class, ParameterMode.OUT);
		try{
			query.execute();

			Integer cantCondominios=Integer.parseInt(query.getOutputParameterValue("p_condominios").toString());
			return cantCondominios;
		}
		catch(Exception ex){
			return 0;
		}
	}

	public int getcantMorosos(){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_reportes.GETMOROSOS")
				.registerStoredProcedureParameter("p_morosos", Integer.class, ParameterMode.OUT);
		try{
			query.execute();

			Integer cantMorosos=Integer.parseInt(query.getOutputParameterValue("p_morosos").toString());
			return cantMorosos;
		}
		catch(Exception ex){
			return 0;
		}
	}
	//*******

	//Retorna los servicios que ofrece el condominio
	public List<ModelServicio> getServicios() {

		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_reservas.GETSERVICIO")
				.registerStoredProcedureParameter("p_servicio", Class.class, ParameterMode.REF_CURSOR);
		try {
			query.execute();
			List<Object[]> reservas = query.getResultList();
			ArrayList<ModelServicio> reservaListas= new ArrayList<>();
			reservas.forEach(objects -> {
				ModelServicio reservaLista = new ModelServicio();

				reservaLista.setId_servicio(Integer.parseInt(objects[0].toString()));
				reservaLista.setNombre_servicio(objects[1].toString());
				reservaLista.setCosto(Double.parseDouble(objects[2].toString()));
				reservaListas.add(reservaLista);
			});
			return reservaListas;
		}catch (Exception e){
			return null;
		}
	}
	//*******

	//update los servicios que ofrece el condominio
	public int updateServicio(int id, String nombre, int costo) {

		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_reservas.updateservicio")
				.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
		.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
		.registerStoredProcedureParameter("p_monto", Integer.class, ParameterMode.IN)
		.setParameter("p_id",id)
				.setParameter("p_nombre",nombre)
				.setParameter("p_monto",costo);
		try {
			query.execute();
			return 1;
		}catch (Exception e){
			return 0;
		}
	}
	//*******

	//Retorna la lista de condominios
	public ArrayList <ModelCondominio> getCondominios(){
		StoredProcedureQuery query = session.createStoredProcedureQuery("paq_condominios.getcondominios")
				.registerStoredProcedureParameter("p_condocur",Class.class,ParameterMode.REF_CURSOR);
		try{
			query.execute();
			List <Object[]> condominios= query.getResultList();
			ArrayList <ModelCondominio> condos = new ArrayList<>();
			for (Object[] obj: condominios) {
				int idCondominio = Integer.parseInt(obj[0].toString());
				String Nombre = obj[1].toString();
				ModelCondominio condom = new ModelCondominio(idCondominio,Nombre);
				condos.add(condom);
			}
			return condos;
		}
		catch(Exception ex){
			return null;
		}

	}

	public ArrayList<ModelPlanillaGC> getPlanillas(){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_pago_gc.getplanillas")
				.registerStoredProcedureParameter("c_curplanillas",Class.class,ParameterMode.REF_CURSOR);
		try{
			query.execute();
			List <Object[]> planillax= query.getResultList();
			ArrayList <ModelPlanillaGC> planillas = new ArrayList<>();
			for (Object[] obj: planillax) {
				int nroVivienda = Integer.parseInt(obj[0].toString());
				int idPlanilla = Integer.parseInt(obj[1].toString());
				String rut = obj[2].toString();
				String nombre = obj[3].toString();
				String apaterno = obj[4].toString();
				String fecha = obj[5].toString();
				int montoTotal = Integer.parseInt(obj[6].toString());
				String fechavenc = obj[7].toString();
				String valido;
				if(obj[8].toString().equals("0")){
					valido = "Pagado";
				}else {
					valido = "Por Pagar";
				}
				//int isvalid =Integer.parseInt(obj[8].toString());
				ModelPlanillaGC planilla = new ModelPlanillaGC(nroVivienda, fecha, montoTotal, fechavenc, valido, rut,  nombre,  apaterno,idPlanilla);
				planillas.add(planilla);
			}
			return planillas;
		}
		catch(Exception ex){
			return null;
		}
	}

	public ArrayList <ModelRegiones> getRegiones(){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_regionescom.getregiones")
				.registerStoredProcedureParameter("c_curregion", Class.class,ParameterMode.REF_CURSOR);
		try{
			query.execute();
			List <Object[]> regionex= query.getResultList();
			ArrayList <ModelRegiones> regiones = new ArrayList<>();
			for (Object[] obj: regionex) {
				int idRegion = Integer.parseInt(obj[0].toString());
				String nombre = obj[1].toString();
				ModelRegiones region = new ModelRegiones(idRegion,nombre);
				regiones.add(region);
			}
			return regiones;
		}
		catch(Exception ex){
			return null;
		}
	}

	public ArrayList <ModelVivienda> getViviendas(int idcondo){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_vivienda.getviviendascondominio")
				.registerStoredProcedureParameter("p_idcondo", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("c_curvivienda",Class.class,ParameterMode.REF_CURSOR)
				.setParameter("p_idcondo",idcondo);
		try{
			query.execute();
			List <Object[]> viviends= query.getResultList();
			ArrayList <ModelVivienda> viviendas = new ArrayList<>();
			for (Object[] obj: viviends) {
				int idVivienda = Integer.parseInt(obj[0].toString());
				int Numero = Integer.parseInt(obj[1].toString());
				String tiTular = obj[2].toString();
				String rutTitular = obj[3].toString();
				ModelVivienda viviend = new ModelVivienda(idVivienda,Numero,tiTular,rutTitular);
				viviendas.add(viviend);
			}
			return viviendas;
		}
		catch(Exception ex){
			return null;
		}
	}
	public ArrayList <ModelMorosos> getMorosos(int idCondo){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_morosos.getmorosos")
				.registerStoredProcedureParameter("p_idCondominio",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("c_curmorosos",Class.class,ParameterMode.REF_CURSOR)
				.setParameter("p_idCondominio",idCondo);
		try{
			query.execute();
			List <Object []> moro = query.getResultList();
			ArrayList <ModelMorosos> morosos = new ArrayList<>();
			for(Object[] obj:moro){
				int idPlanilla = Integer.parseInt(obj[0].toString());
				String rut = obj[1].toString();
				String nombre = obj[2].toString();
				String fechainicial = obj[3].toString();
				String fechavenc = obj[4].toString();
				int montototal = Integer.parseInt(obj[5].toString());
				ModelMorosos moroso = new ModelMorosos(idPlanilla,rut,nombre,fechainicial,fechavenc,montototal);
				morosos.add(moroso);
			}
			return morosos;
		}catch (Exception ex){
			return null;
		}
	}
	public ArrayList <ModelGastosComunes> getGastosComunes(int idCondo){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_gastoscomunes.getgastoscomunes")
				.registerStoredProcedureParameter("p_idcondominio",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("c_gccursor",Class.class,ParameterMode.REF_CURSOR)
				.setParameter("p_idcondominio",idCondo);
		try{
			query.execute();
			List <Object[]> gastosgc = query.getResultList();
			ArrayList <ModelGastosComunes> gastoscomunes = new ArrayList <>();
			for(Object[] obj:gastosgc) {
				int idGastocomun = Integer.parseInt(obj[0].toString());
				String descripcion= obj[1].toString();
				int valor = Integer.parseInt(obj[2].toString());
				ModelGastosComunes gastocomun = new ModelGastosComunes(idGastocomun,descripcion,valor);
				gastoscomunes.add(gastocomun);
			}
			return gastoscomunes;

		} catch(Exception ex){
			return null;
		}
	}
	public ModelCondominio getCondoUsuario(String rut){
		StoredProcedureQuery query = session.createStoredProcedureQuery("paq_condominios.getcondominiousuario")
				.registerStoredProcedureParameter("p_rut",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_idCondominio",Integer.class,ParameterMode.OUT)
				.registerStoredProcedureParameter("p_nombre",String.class,ParameterMode.OUT)
				.setParameter("p_rut",rut);
		try{
			query.execute();
			int idCondominio=Integer.parseInt(query.getOutputParameterValue("p_idCondominio").toString());
			String nombre= query.getOutputParameterValue("p_nombre").toString();
			ModelCondominio condo = new ModelCondominio(idCondominio,nombre);
			return condo;
		}catch (Exception ex){
			return null;
		}
	}
	public ArrayList <ModelComunas> getComunas(int idRegion){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_regionescom.getcomunas")
				.registerStoredProcedureParameter("p_idregion", Integer.class,ParameterMode.IN )
				.registerStoredProcedureParameter("c_curcom",Class.class,ParameterMode.REF_CURSOR)
				.setParameter("p_idregion",idRegion);
		try{
			query.execute();
			List <Object[]> comuns= query.getResultList();
			ArrayList <ModelComunas> comunas = new ArrayList<>();
			for (Object[] obj: comuns) {
				int idComuna = Integer.parseInt(obj[0].toString());
				String nombreComuna = obj[1].toString();
				ModelComunas comuna = new ModelComunas(idComuna,nombreComuna);
				comunas.add(comuna);
			}
			return comunas;
		}
		catch(Exception ex){
			return null;
		}
	}

	//Envia informacion evento y la guarda en la BD
	public Integer setEventos(Date fecha, String descripcion, Integer idCondominio){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_eventosconserje.setevento")
				.registerStoredProcedureParameter("p_fecha",Date.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_descripcion",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("p_idcondominio",Integer.class,ParameterMode.IN)
				.setParameter("p_fecha", fecha)
				.setParameter("p_descripcion", descripcion)
				.setParameter("p_idcondominio", idCondominio);
		try{
			query.execute();

			return 1;
		}catch(Exception ex){
			return 0;
		}
	}
	public int DeleteUsuario(String rut){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_usuarios.deleteuser")
				.registerStoredProcedureParameter("p_run",String.class,ParameterMode.IN)
				.setParameter("p_run",rut);
		try{
			query.execute();
			return 1;
		}catch(Exception ex){
			return 0;
		}
	}
	public Integer DeleteGastoComun (Integer idGastocomun){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_gastoscomunes.deletegastocomun")
				.registerStoredProcedureParameter("p_idGastocomun",Integer.class,ParameterMode.IN)
				.setParameter("p_idGastocomun",idGastocomun);
		try{
			query.execute();
			return 1;
		}catch(Exception ex){
			return 0;
		}
	}
	public Integer DeleteEvento(int idEvento){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_eventosconserje.deleteevento")
				.registerStoredProcedureParameter("p_idEvento",Integer.class,ParameterMode.IN)
				.setParameter("p_idEvento",idEvento);
				try{
					query.execute();
					return 1;
				}catch(Exception ex){
					return 0;
				}
	}
	//Recibe informacion de evento
	public ArrayList<ModelEvento> getEventos(Integer idCondominio){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_eventosconserje.geteventos")
				.registerStoredProcedureParameter("p_idcondominio",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("c_cureventos",Class.class,ParameterMode.REF_CURSOR)
				.setParameter("p_idcondominio", idCondominio);
		try{
			query.execute();
			List <Object[]> eventos= query.getResultList();
			ArrayList <ModelEvento> evento = new ArrayList<>();
			for (Object[] obj: eventos) {
				Integer idEvento = Integer.parseInt(obj[0].toString());
				String fecha = obj[1].toString();
				String descripcion = obj[2].toString();
				ModelEvento evenCon = new ModelEvento(idEvento,fecha, descripcion);
				evento.add(evenCon);
			}
			return evento;

		}catch(Exception ex){
			System.out.println(ex);
			return null;
		}
	}

	//Pago de Multas
	public Integer setPagoMulta (Integer idMulta){
		StoredProcedureQuery query = session.createStoredProcedureQuery("pkg_pago_multa.pago_multa")
				.registerStoredProcedureParameter("p_id",Integer.class,ParameterMode.IN)
				.setParameter("p_id", idMulta);

		try {
			query.execute();
			return 1;
		}catch (Exception ex){
			return 0;
		}
	}
}
