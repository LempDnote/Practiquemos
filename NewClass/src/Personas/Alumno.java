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
public class Alumno implements Serializable {
    private String nombre,carnet,genero;
    private int edad,grado;

    public Alumno(String nombre, String carnet, String genero, int edad, int grado) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.genero = genero;
        this.edad = edad;
        this.grado = grado;
    }
    
    public String Ver_Informacion(){
        String cadena = ("nombre:"+this.nombre+"\n"
                + "carnet:"+this.carnet+"\n"
                + "genero:"+this.genero+"\n"
                + "edad:"+this.edad+"\n"
                + "grado:"+this.grado);
        return cadena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }
    
    
    
}
