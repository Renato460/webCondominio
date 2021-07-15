package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelReservaLista;

import java.util.ArrayList;

public class ActionGetAllReservas extends ActionSupport {


    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        this.reservas = conexion.getAllReservas();
        conexion.cerrarSession();
        return SUCCESS;
    }

    private ArrayList<ModelReservaLista> reservas;

    public ArrayList<ModelReservaLista> getReservas() {
        return reservas;
    }
}
