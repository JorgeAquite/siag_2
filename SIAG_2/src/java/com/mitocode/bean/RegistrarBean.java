/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.bean;

import com.deudor.modelo.Deudores;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;



/**
 *
 * @author User
 */
@ManagedBean (name = "regis")
@Dependent
public class RegistrarBean {
    /**
     * Creates a new instance of RegistrarBean
     */
    // Boton de busqueda 
    private String registroD;
    
    public List<String> complete (String query){
        List<String> results =new ArrayList<String>();
        
        for( int i = 0; i < 100; i++)
            results.add(query+i);
        return results;
    }  

    public String getRegistroD() {
        return registroD;
    }

    public void setRegistroD(String registroD) {
        this.registroD = registroD;
    }
      
    // Formulario de registro de los deudores 
    
    private String nombre;
    private String documento;
    private String programa;
    private String semestre;
    private String insumos;
    private String cantidadI;
    private String ciudad;
    
    private ArrayList <Deudores> listaI= new ArrayList <>();
    private ArrayList <Deudores> lista_eliminados = new ArrayList <>();
    
   public RegistrarBean(){
       listaI.add(new Deudores ("--","--"));
       listaI.add(new Deudores ("--","--"));
       listaI.add(new Deudores ("--","--"));
       listaI.add(new Deudores ("--","--"));
       
   }

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

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getInsumos() {
        return insumos;
    }

    public void setInsumos(String insumos) {
        this.insumos = insumos;
    }

    public String getCantidadI() {
        return cantidadI;
    }

    public void setCantidadI(String cantidad) {
        this.cantidadI = cantidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public ArrayList<String> getProgramas(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Enfermeria");
        lista.add("Fisioterapia");
        lista.add("Fonoaudiologia");
        lista.add("Quimica");
        lista.add("Mecanica");
        lista.add("Microbiologia");
        return lista;
    }
    
    
    
    public String registrar (){
        return "registrarOk.xhtml";
    }

    public ArrayList<Deudores> getListaI() {
        return listaI;
    }

    public void setListaI(ArrayList<Deudores> listaI) {
        this.listaI = listaI;
    }

    public ArrayList<Deudores> getLista_eliminados() {
        return lista_eliminados;
    }

    public void setLista_eliminados(ArrayList<Deudores> lista_eliminados) {
        this.lista_eliminados = lista_eliminados;
    }
      
    

       public void actualizar(RowEditEvent event){
       Deudores c =(Deudores) event.getObject();
       
       c.setCantidad(cantidadI);
       c.setInsumo(insumos);
     
       
      
       FacesContext.getCurrentInstance().addMessage(null,new  FacesMessage ("Actualizado!"));
       
   }
   
   public void cancelar(RowEditEvent event){
       FacesContext.getCurrentInstance().addMessage(null,new  FacesMessage ("Cancelado"));
   }
   
}
