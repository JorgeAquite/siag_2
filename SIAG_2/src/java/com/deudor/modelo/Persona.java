/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deudor.modelo;


import java.util.Date;



/**
 *
 * @author User
 */
public class Persona {
    private int id;
    private String nombre;
    private String programa;
    private String insumo;
   
    private String forma;
   /* private String fechaD;
    private String fechaC;
   */
    private String fechaD;

    public String getFechaD() {
        return fechaD;
    }

    public void setFechaD(String fechaD) {
        this.fechaD = fechaD;
    }
    
        

    

   
    // Este atributo representa un estado, activado o desactivado.
    private boolean selected;
    
    public Persona() {
    
}

    public Persona(int id, String nombre, String programa, String insumo ,  String forma, String fechaD ){
        this.id = id;
        this.nombre = nombre;
        this.programa= programa;
        this.insumo = insumo;
        this.forma= forma;
        this.fechaD=fechaD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

   

   

   

   
 

    
}
