/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import java.io.Serializable;

/**
 *
 * @author lgtjo
 */
public class Clase implements Serializable{
    private String seccion;
    private int grado;
    private String nombre_profesor;
    private String nombre_alumnos;
    private String no_asignacion;
    private int nota;
    private String informacion;

    

    

    public Clase(String seccion, int grado, String nombre_profesor, String nombre_alumnos, String no_asignacion,String informacion) {
        this.seccion = seccion;
        this.grado = grado;
        this.nombre_profesor = nombre_profesor;
        this.nombre_alumnos = nombre_alumnos;
        this.no_asignacion = no_asignacion;
        this.informacion = informacion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getNombre_alumnos() {
        return nombre_alumnos;
    }

    public void setNombre_alumnos(String nombre_alumnos) {
        this.nombre_alumnos = nombre_alumnos;
    }

    public String getNo_asignacion() {
        return no_asignacion;
    }

    public void setNo_asignacion(String no_asignacion) {
        this.no_asignacion = no_asignacion;
    }
    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    
   
}
