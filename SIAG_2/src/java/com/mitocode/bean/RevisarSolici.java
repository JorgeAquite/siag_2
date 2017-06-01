/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.bean;

import com.deudor.modelo.Persona;
import com.deudor.modelo.Solicitudes;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author User
 */
@ManagedBean(name = "soli")
@RequestScoped
public class RevisarSolici {
    
    // Boton de busqueda
    private String buscarID;
    
    public List<String> complete (String query){
        List<String> results =new ArrayList<String>();
        
        for( int i = 0; i < 100; i++)
            results.add(query+i);
        return results;
    }  

    public String getBuscarID() {
        return buscarID;
    }

    public void setBuscarID(String registroD) {
        this.buscarID = buscarID;
    }
    
    

    /**
     * Creates a new instance of RevisarSolici
     */
    
    // Crear lista de solicitudes
    
     private ArrayList<Solicitudes> lista = new ArrayList<>();

    public ArrayList<Solicitudes> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Solicitudes> lista) {
        this.lista = lista;
    }
    
    
    
   public RevisarSolici() {
       
       lista.add(new Solicitudes(1,144,"Jorge","01/01/0000","10:00am","11:30am","obando","lab. De Ceramica",5,"protecis fija","Mecanica Dental","estufa","RECIBIDO"));
        lista.add(new Solicitudes(2,0,"xx","01/01/0000","10:30am","12:30am","obando","lab. De Ceramica",4,"protecis fija","Mecanica Dental","xx","PENDIENTE"));
        lista.add(new Solicitudes(3,154,"Jorge","01/01/0000","10:00am","11:30am","obando","lab. De Ceramica",5,"protecis fija","Mecanica Dental","estufa","ENTREGADO"));
        
   }
        /*
        Solicitudes soli = new Solicitudes();
        soli.setNumSolicitud(1);
        soli.setDocumento(144);
        soli.setEstudiante("Jorge");
        soli.setFecha("01/01/0000");
        soli.setHoraInicial("10:00am");
        soli.setHoraFinal("11:30am");
        soli.setNombreDocente("obando");
        soli.setLaboratrio("lab. De Ceramica");
        soli.setNumEstudiantes(5);
        soli.setNombrePractica("protecis fija");
        soli.setPrograma("Mecanica Dental");
        soli.setInsumos("estufa");
        soli.setEstado("estufa");
        lista.add(soli);
        
        soli = new Solicitudes();
        soli.setNumSolicitud(2);
        soli.setDocumento(0);
        soli.setEstudiante("");
        soli.setFecha("01/01/0000");
        soli.setHoraInicial("10:00am");
        soli.setHoraFinal("11:30am");
        soli.setNombreDocente("obando");
        soli.setLaboratrio("lab. De Ceramica");
        soli.setNumEstudiantes(4);
        soli.setNombrePractica("protecis fija");
        soli.setPrograma("Mecanica Dental");
        soli.setInsumos("--");
        soli.setEstado("--");
        lista.add(soli);*/

   
   
    
}
