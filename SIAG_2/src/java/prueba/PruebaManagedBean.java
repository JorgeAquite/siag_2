/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Aluca
 */
@ManagedBean(name = "pruebaMB")
@RequestScoped
public class PruebaManagedBean {

    /**
     * Creates a new instance of PruebaManagedBean
     */
    
    private String usuario;
    private String clave;
    public PruebaManagedBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
