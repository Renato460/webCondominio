package webCondominio.action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;
import javax.servlet.http.HttpServletRequest;
public class ActionSetGastoComun extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        this.idCondominio=Integer.parseInt(request.getParameter("idCondominio"));
        this.descripcion=request.getParameter("descripcion");
        this.valor=Integer.parseInt(request.getParameter("valor"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.setGastoComun(idCondominio,descripcion,valor);
        conexion.cerrarSession();
        return SUCCESS;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
    private HttpServletRequest request;
    private int idCondominio;
    private String descripcion;
    private int valor;
    private int resultado;

    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
