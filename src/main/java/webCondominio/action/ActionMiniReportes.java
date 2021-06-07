package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import webCondominio.controller.ControllerConexion;

public class ActionMiniReportes extends ActionSupport {
    private int cantMultas;
    private int cantCondos;
    private int cantMorosos;

    public int getCantMultas() {
        return cantMultas;
    }

    public void setCantMultas(int cantMultas) {
        this.cantMultas = cantMultas;
    }

    public int getCantCondos() {
        return cantCondos;
    }

    public void setCantCondos(int cantCondos) {
        this.cantCondos = cantCondos;
    }

    public int getCantMorosos() {
        return cantMorosos;
    }

    public void setCantMorosos(int cantMorosos) {
        this.cantMorosos = cantMorosos;
    }

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        this.cantMultas=conexion.getcantMultas();
        this.cantCondos=conexion.getcantCondos();
        this.cantMorosos=conexion.getcantMorosos();
        conexion.cerrarSession();
        return SUCCESS;
    }
}
