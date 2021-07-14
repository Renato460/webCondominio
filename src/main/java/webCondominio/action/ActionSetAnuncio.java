package webCondominio.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.IOUtils;
import webCondominio.controller.ControllerConexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ActionSetAnuncio extends ActionSupport {

    @Override
    public String execute() throws Exception {

        if((!this.descripcion.equals("")) && (this.fileFileName != null)){
            String file_dirs_path = "C:\\Users\\rerey\\eclipse-workspace\\webCondominio\\src\\main\\webapp\\assets\\img\\anuncios"+File.separator;

            File dirs = new File(file_dirs_path);
            if (!dirs.exists()) {
                dirs.mkdirs();
            }
            String file_url = file_dirs_path +File.separator+fileFileName;

            FileInputStream io = new FileInputStream(file);
            FileOutputStream op = new FileOutputStream(file_url);
            IOUtils.copy(io, op);
            io.close();
            op.close();

            ControllerConexion conexion = new ControllerConexion();
            if(conexion.setAnuncios(this.descripcion,this.fileFileName)){
                conexion.cerrarSession();
                this.resultado = 1;
            }else {
                conexion.cerrarSession();
                this.resultado = 0;
            }
        }
        else {
            this.resultado =0;
        }
        return SUCCESS;
    }

    private int resultado;
    private File file;
    private String fileFileName;
    private String descripcion;


    public int getResultado(){
        return resultado;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }


    public void setFile(File file) {
        this.file = file;
    }

}
