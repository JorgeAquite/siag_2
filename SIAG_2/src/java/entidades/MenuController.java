/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Aluca
 */
@Named
@SessionScoped
public class MenuController implements Serializable{
    
    @EJB    
    private MenuFacadeLocal EJBMenu;
    private RolFacade EJBRol;
    private List<Menu> lista;
    private String rol;
    private HashMap<String,String> roles;
    private MenuModel model;
    private Collection<Rol> listarol;
    private Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    
    @PostConstruct
     public void init(){
         this.listarMenus();
         model= new DefaultMenuModel();
         this.establecerPermisos();
         this.listarRoles();
    }
    
    public void listarMenus(){
        try {
            lista=EJBMenu.findAll();
        } catch (Exception e) {
            
        }
        
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public HashMap<String, String> getRoles() {
        return roles;
    }

    public void setRoles(HashMap<String, String> roles) {
        this.roles = roles;
    }

    public Collection<Rol> getListarol() {
        return listarol;
    }

    public void setListarol(Collection<Rol> listarol) {
        this.listarol = listarol;
    }
    
    
     
    ///lo que quiero hacer es comparar el tipo de usuario del usuario actual con el tipo de usuario del menu
    public void establecerPermisos(){
        //adquiero el usuario que esta logeado y capturo los roles que tiene asignado
//        listarol=us.getRolCollection();
                
        
        for (Menu m : lista){
                 System.out.println("el rol del menu es "+m.getRolid().getRol());        
            if(m.getTipo().equals("S") && m.getRolid().getRol().equals(rolactual()) ){
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                for(Menu i: lista){
                    Menu subMenu= i.getCodsubmenu();
                    if (subMenu != null){
                        if(subMenu.getCodigo()==m.getCodigo()){
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
//                            System.out.println(i.getRuta());
//                            item.setUrl("../vistas/conogramaAlmacen.xhtml");
                            item.setUrl(i.getRuta());                            
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            }
            else{
                if (m.getCodsubmenu()==null && m.getRolid().getRol().equals(rolactual())) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                    model.addElement(item);
                }  
            }
        }
    }
     //rol inicial con el que se cargan los menus
    public String rolactual() {
        listarol=us.getRolCollection();
        String rol=null;
        for (Rol r : listarol) {
            rol=r.getRol();
            System.out.println("el rol del usuario es "+rol);
            
        }
        return rol;
    }
    //muestra los roles desplegados en el combo de seleccion de roles
    public void listarRoles() {
        try {
            listarol=us.getRolCollection();
            roles= new HashMap<String,String>();
                        
            for (Rol r : listarol) {
                String rol=r.getRol();
                roles.put(rol,rol);
            }
        } catch (Exception e) {
             System.out.println("excepcion "+e);
        }
        
         }
    public void loMismo(AjaxBehaviorEvent a) throws Exception
    {
        System.out.println("lo Mismo pero con ");
    }
       
}
