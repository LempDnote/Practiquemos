/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;
import Personas.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
/**
 *
 * @author lgtjo
 */
public class Proyecto_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*
        Persona persona = new Persona("Azul","Negros",45,0.5);
        Persona vector_personas[] = new Persona[50];
        
        
        for (int i = 0; i < vector_personas.length; i++) {
            vector_personas[i] = new Persona("Amarillo","Azul",25,1.70);
        }
        
        for (int i = 0; i < vector_personas.length; i++) {
            vector_personas[i].Ver_Persona();
        }
        
        Persona persona1 = new Persona("Morena","Claros",45,0.5);
        Persona persona2 = new Persona("Blanca","Negros",45,0.5);
        Persona persona3 = new Persona("Amarilla","Cafes",45,0.5);
        */
        Proyecto_1 proyecto = new Proyecto_1();
        proyecto.leer();
    }
    
    private void leer() throws Exception{
       
        Object objeto = new JSONParser().parse(new FileReader("profesores.json"));
        JSONArray js = (JSONArray) objeto;
        for (int i = 0; i < js.size(); i++) {
            JSONObject objs = (JSONObject) js.get(i);
            System.out.println(objs.get("nombre"));
        }
    }
    
    
    
}
