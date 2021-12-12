/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

/**
 *
 * @author lgtjo
 */
public class Profesor {
    private int dpi,edad;
    private String nombre,correo,password;
    
    public Profesor(String nombre,String correo,String password,int dpi,int edad){
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.dpi = dpi;
        this.edad = edad;
    }
    
    public void Ver_Informacion(){
        System.out.println("nombre:"+this.nombre+"\n"
                + "correo:"+this.correo+"\n"
                + "password:"+this.password+"\n"
                + "dpi:"+this.dpi+"\n"
                + "edad:"+this.edad);
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
