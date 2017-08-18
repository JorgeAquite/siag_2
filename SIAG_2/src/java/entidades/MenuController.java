/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
    private List<Menu> lista;
     private MenuModel model;
     private Collection<Rol> listarol;
     private Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    
    @PostConstruct
     public void init(){
         this.listarMenus();
         model= new DefaultMenuModel();
         this.establecerPermisos();
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
     
    ///lo que quiero hacer es comparar el tipo de usuario del usuario actual con el tipo de usuario del menu
    public void establecerPermisos(){
        //adquiero el usuario que esta logeado y capturo los roles que tiene asignado
//        listarol=us.getRolCollection();
                
        
        for (Menu m : lista){
              //   System.out.println("el rol del menu es "+m.getRolid().getRol());        
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

    private String rolactual() {
        listarol=us.getRolCollection();
        String rol=null;
        for (Rol r : listarol) {
            rol=r.getRol();
            //System.out.println("el rol del usuario es "+rol);
            
        }
        return rol;
    }
}
