/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.bean;

import com.deudor.modelo.Persona;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;


/**
 *
 * @author User
 */
@ManagedBean (name = "Bean")
@RequestScoped
public class PersonaBean {
    // atributo ed arraylist de personas

   private ArrayList <Persona> lista= new ArrayList <>();
   
   //la lista no la ocupa la pagina, se trabaja internamente 
   private ArrayList <Persona> lista_eliminados = new ArrayList <>();
   //Atributo para almacenar lo que es editable, la nueva forma de pago
   private String forma;
   private String fechaD;

    public String getFechaD() {
        return fechaD;
    }

    public void setFechaD(String forma2) {
        this.fechaD = fechaD;
    }
   
   // otra lista para buscar 
   private ArrayList<Persona> filtroPersona = new ArrayList <>();
   
  //fechas
  
  
   
    // lista de deudores 
   public PersonaBean(){
        
       lista.add(new Persona(1,"juan","quimica","botella","--",""));
       lista.add(new Persona(2,"jorge","quimica","botella","--",""));
       lista.add(new Persona(3,"alexandra","quimica","botella","--",""));
       lista.add(new Persona(4,"pedro","quimica","botella","--",""));
       lista.add(new Persona(5,"javier","quimica","botella","--",""));
       lista.add(new Persona(6,"julian","quimica","botella","--",""));
       
   } 
   
   //Metodos
   
 
   
   //Metodos para Actualizar (actualizar y cancelar) con parametros, que pertenece a PrimFaces, que trabaja con ajax
   public void actualizar(RowEditEvent event){
       Persona p =(Persona) event.getObject();
       
       p.setForma(forma);
      
       FacesContext.getCurrentInstance().addMessage(null,new  FacesMessage ("Actualizado!"));
       
   }
   
   public void cancelar(RowEditEvent event){
       FacesContext.getCurrentInstance().addMessage(null,new  FacesMessage ("Cancelado"));
   }
   
    
   public String eliminar(){
       for (Persona p: lista){
           
           if(p.isSelected()){
               lista_eliminados.add(p);
           }
       }
       if (!lista_eliminados.isEmpty()){
           lista.removeAll(lista_eliminados);
           FacesContext.getCurrentInstance().addMessage(null,new  FacesMessage ("Eliminados"));
       }
       return "tablePrueba";
   }

    public ArrayList<Persona> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Persona> lista) {
        this.lista = lista;
    }

    public ArrayList<Persona> getLista_eliminados() {
        return lista_eliminados;
    }

    public void setLista_eliminados(ArrayList<Persona> lista_eliminados) {
        this.lista_eliminados = lista_eliminados;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public ArrayList<Persona> getFiltroPersona() {
        return filtroPersona;
    }

    public void setFiltroPersona(ArrayList<Persona> filtroPersona) {
        this.filtroPersona = filtroPersona;
    }

   

  
    
   
    
   
   
    
}
