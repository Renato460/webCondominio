package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionUpdateUsuario extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        this.Nombre=request.getParameter("Nombre");
        this.Apaterno=request.getParameter("Apaterno");
        this.Amaterno=request.getParameter("Amaterno");
        this.Run=request.getParameter("Run");
        this.Nacionalidad=request.getParameter("Nacionalidad");
        this.Telefono=Integer.parseInt(request.getParameter("Telefono"));
        this.Correo=request.getParameter("Correo");
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.updateUser(Nombre,Apaterno,Amaterno,Run,Nacionalidad,Telefono,Correo);
        conexion.cerrarSession();
        return SUCCESS;
    }

    private int resultado;
    private String Nombre;
    private String Apaterno;
    private String Amaterno;
    private String Run;
    private String Nacionalidad;
    private int Telefono ;
    private String Correo ;
    private HttpServletRequest request;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApaterno() {
        return Apaterno;
    }

    public void setApaterno(String apaterno) {
        Apaterno = apaterno;
    }

    public String getAmaterno() {
        return Amaterno;
    }

    public void setAmaterno(String amaterno) {
        Amaterno = amaterno;
    }

    public String getRun() {
        return Run;
    }

    public void setRun(String run) {
        Run = run;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}
