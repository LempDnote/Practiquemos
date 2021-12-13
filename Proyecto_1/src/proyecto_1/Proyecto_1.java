/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;
import java.io.*;
import Personas.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
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

    private FileOutputStream file;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private FileInputStream file_;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Persona[] persona;
        Proyecto_1 py = new Proyecto_1();
        py.abrir_();
        persona = py.lectura();
        for (int i = 0; i < persona.length; i++) {
            persona[i].Ver_Persona();
        }
        
        /*
        Persona vector_personas[] = new Persona[50];
        
        
        for (int i = 0; i < vector_personas.length; i++) {
            vector_personas[i] = new Persona("Amarillo","Azul",25,1.70);
        }
        */
        
        /*
        Persona persona1 = new Persona("Morena","Claros",45,0.5);
        Persona persona2 = new Persona("Blanca","Negros",45,0.5);
        Persona persona3 = new Persona("Amarilla","Cafes",45,0.5);
        */
        /*
        Proyecto_1 py = new Proyecto_1();
        py.abrir();
        py.escribir(vector_personas);
        py.cerar();
        */
        
    }
    
    private void abrir()throws IOException{
        file = new FileOutputStream("persona.ser");
        output = new ObjectOutputStream(file);
    }
    
    public void cerar() throws IOException{
        if(output != null){
            output.close();
        }
    }
    
    public void escribir(Persona[] persona) throws IOException{
        if(output != null){
            output.writeObject(persona);
        }
    }
    
    private void leer() throws Exception{
       
        Object objeto = new JSONParser().parse(new FileReader("profesores.json"));
        JSONArray js = (JSONArray) objeto;
        for (int i = 0; i < js.size(); i++) {
            JSONObject objs = (JSONObject) js.get(i);
            System.out.println(objs.get("nombre"));
        }
    }
    
    private void abrir_() throws IOException{
        file_ = new FileInputStream("persona.ser");
        input = new ObjectInputStream(file_);
    }
    
    private void cerrar_() throws IOException{
        if(input != null){
            input.close();
        }
    }
    
    private Persona[] lectura() throws IOException,ClassNotFoundException{
        Persona[] persona = null;
        if(input != null){
            try{
                persona = (Persona[])input.readObject();
            }catch(EOFException e){
                
            }
        }
        return persona;
    }
    
    
    
}
