package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionSetUsuario extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        this.usuario=request.getParameter("usuario");
        this.password=request.getParameter("password");
        this.idrol=Integer.parseInt(request.getParameter("idrol"));
        this.nombre=request.getParameter("nombre");
        this.apaterno=request.getParameter("apaterno");
        this.amaterno=request.getParameter("amaterno");
        this.run=request.getParameter("run");
        this.nacionalidad=request.getParameter("nacionalidad");
        this.telefono=Integer.parseInt(request.getParameter("telefono"));
        this.correo=request.getParameter("correo");
        this.nrovivienda=Integer.parseInt(request.getParameter("idvivienda"));
        this.idcondominio=Integer.parseInt(request.getParameter("idcondominio"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.setPerfil(usuario,password,idrol,nombre,apaterno,amaterno,run,nacionalidad,telefono,correo,nrovivienda,idcondominio);
        conexion.cerrarSession();
        return SUCCESS;
    }
    private String usuario;
    private String password;
    private int idrol;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String run;
    private String nacionalidad;
    private int telefono;
    private String correo;
    private int nrovivienda;
    private int idcondominio;
    private HttpServletRequest request;
    private int resultado;
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNrovivienda() {
        return nrovivienda;
    }

    public void setNrovivienda(int idvivienda) {
        this.nrovivienda = idvivienda;
    }

    public int getIdcondominio() {
        return idcondominio;
    }

    public void setIdcondominio(int idcondominio) {
        this.idcondominio = idcondominio;
    }


    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
