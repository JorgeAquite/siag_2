/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deudor.modelo;

/**
 *
 * @author User
 */
public class Deudores {
    
    private String cantidad;
    private String insumo;

    public Deudores(String cantidad, String insumo) {
        this.cantidad = cantidad;
        this.insumo = insumo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    
    
    
    
}
