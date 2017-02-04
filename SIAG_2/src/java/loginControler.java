
import entidades.Usuario;
import entidades.UsuarioFacade;
import java.io.Serializable;
import javax.ejb.EJB;
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
        try {
            EJBusuario.iniciarSesion(nombre, documento);
            redireccion="registrarDeudor";
        } catch (Exception e) {
        }
        return redireccion;
    }
     
    
    
}
