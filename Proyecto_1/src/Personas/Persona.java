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
public class Persona {
    
    private String color_piel; //cadena
    private String color_ojos; //cadena
    private int edad; //edad en enteros
    private double estatura; //estatura en metros
    
    //------------Parametros
    public Persona(String c_p,String c_o,int Edad,double estatura) {
        this.color_ojos = c_o;
        this.color_piel = c_p;
        this.edad = Edad;
        this.estatura = estatura;
    }
    
    public void Ver_Persona(){
        System.out.println("Color_Ojos:"+this.color_ojos+"\n"
                + "Edad:"+this.edad+"\n"
                + "Color_Piel:"+this.color_piel+"\n");
    }

    
    

    
    
    
    
    
    
}
