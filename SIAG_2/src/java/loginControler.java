
import entidades.Usuario;
import entidades.UsuarioFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluca
 */
@Named
@ViewScoped
public class loginControler implements Serializable {
    
    @EJB
    private UsuarioFacade EJBusuario;
    private Usuario usuario;
    private String nombre;
    private String documento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public void init(){
        usuario=new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion(){
        
        String redireccion=null;
        Usuario us=null;
        try {
            usuario= new Usuario(BigDecimal.ZERO, nombre, "apellido", documento, "tipodocumento", BigInteger.ZERO);
            us=EJBusuario.iniciarSesion(usuario);
            
        } catch (Exception e) {
        }
        if (us!=null) {
            //Almacenar en la sesion de JSF
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
            redireccion="generarReportes?faces-redirect=true";      
        }
        else {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
             }
         return redireccion;
    }
    
    public void verificarSesion(){
        try {
            FacesContext sesion=FacesContext.getCurrentInstance();
            Usuario us=(Usuario) sesion.getExternalContext().getSessionMap().get("usuario");
            
            if (us==null) {
                sesion.getExternalContext().redirect("permisos.html");
            }
        } catch (Exception e) {
        }
    }
     
    
    
}
