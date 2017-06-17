/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
     
    
    public void establecerPermisos(){
        Usuario us=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        for (Menu m : lista){
//            if(m.getTipo().equals("S") && m.g ){
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                for(Menu i: lista){
                    Menu subMenu= i.getCodsubmenu();
                    if (subMenu != null){
                        if(subMenu.getCodigo()==m.getCodigo()){
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            }
            else{
                if (m.getCodsubmenu()==null) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                    model.addElement(item);
                }  
            }
        }
    }
}
