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
public class Solicitudes {

    private int numSolicitud;
    private int documento;
    private String estudiante;
    private String fecha;
    private String horaInicial;
    private String horaFinal;
    private String nombreDocente;
    private String laboratrio;
    private int numEstudiantes;
    private String nombrePractica;
    private String programa;
    private String insumos;
    private String Estado;

    public Solicitudes(int numSolicitud, int documento, String estudiante, String fecha, String horaInicial, String horaFinal, String nombreDocente, String laboratrio, int numEstudiantes, String nombrePractica, String programa, String insumos, String Estado) {
        this.numSolicitud = numSolicitud;
        this.documento = documento;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.nombreDocente = nombreDocente;
        this.laboratrio = laboratrio;
        this.numEstudiantes = numEstudiantes;
        this.nombrePractica = nombrePractica;
        this.programa = programa;
        this.insumos = insumos;
        this.Estado = Estado;
    }
    
    
    
    

    public int getNumSolicitud() {
        return numSolicitud;
    }

    public void setNumSolicitud(int numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documenteo) {
        this.documento = documenteo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getLaboratrio() {
        return laboratrio;
    }

    public void setLaboratrio(String laboratrio) {
        this.laboratrio = laboratrio;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }

    public String getNombrePractica() {
        return nombrePractica;
    }

    public void setNombrePractica(String nombrePractica) {
        this.nombrePractica = nombrePractica;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getInsumos() {
        return insumos;
    }

    public void setInsumos(String insumos) {
        this.insumos = insumos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

}
