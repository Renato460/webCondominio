package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ActionSetAnuncio extends ActionSupport {

    @Override
    public String execute() throws Exception {

        String file_dirs_path = "C:\\Users\\rerey\\eclipse-workspace\\webCondominio\\img\\anuncios"+File.separator;
        System.out.println(File.separator);
        File dirs = new File(file_dirs_path);
        if (!dirs.exists()) {
            dirs.mkdirs();
        }
        String file_url = file_dirs_path +File.separator+fileFileName;
        System.out.println("file_url: " + file_url);

        FileInputStream io = new FileInputStream(file);
        FileOutputStream op = new FileOutputStream(file_url);
        IOUtils.copy(io, op);
        io.close();
        op.close();

        return SUCCESS;
    }


    private File file;
    private String fileFileName;
    private String fileContentType;

    // return value


    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
