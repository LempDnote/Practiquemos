/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Personas.*;
import Principal.Carga_Informacion;
import Principal.Herramientas;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.jfree.JCommon;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author lgtjo
 */
public class Controlador {
    private Alumno alumnos [] = new Alumno[200] ;
    private Profesor profesor[] = new Profesor[10];
    private Herramientas hr = new Herramientas();
    
    public Controlador(){
        this.Cargar_Json_Alumnos("alumnos.json");
    }
    
    public void recorrer(){
        String nombre = "Miguel";
        String correo = "miguel@gmail.com";
        String password = "m123";
        int dpi = 123;
        int edad = 25;
        
        Carga_Informacion ci = new Carga_Informacion(this.profesor);        
        ci.Cargar_Profesor(nombre, correo, password, dpi, edad);
    }
    
    public void info(){
        for (int i = 0; i < this.profesor.length; i++) {
            if(this.profesor[i] != null){
                this.profesor[i].Ver_Informacion();
                System.out.println("");
            }
        }
    }
    
    public void Cargar_Json_Profesor(String ruta){
        Carga_Informacion ci = new Carga_Informacion(this.profesor);        
        try{
            Object objeto = new JSONParser().parse(new FileReader(ruta));
            JSONArray ajs = (JSONArray)objeto;
            for (int i = 0; i < ajs.size(); i++) {
                JSONObject ojs = (JSONObject)ajs.get(i);
                String nombre = (String)ojs.get("nombre");
                String correo = (String)ojs.get("correo");
                String password = (String)ojs.get("password");
                int dpi = Integer.parseInt((String)ojs.get("dpi"));
                int edad = Integer.parseInt((String)ojs.get("edad"));
                ci.Cargar_Profesor(nombre, correo, password, dpi, edad);
            }
        }catch(Exception e){
            
        }
    }
    
    public void Cargar_Json_Alumnos(String ruta){
        Carga_Informacion ci = new Carga_Informacion(this.alumnos); 
        try{
            Object objeto = new JSONParser().parse(new FileReader(ruta));
            JSONArray ajs = (JSONArray)objeto;
            for (int i = 0; i < ajs.size(); i++) {
                JSONObject ojs = (JSONObject)ajs.get(i);
                String nombre = (String)ojs.get("nombre");
                String carnet = (String)ojs.get("carnet");
                String genero = (String)ojs.get("genero");
                long grado = (long)ojs.get("grado");
                long edad = (long)ojs.get("edad");
                int grado_ = (int)grado;
                int edad_ = (int)edad;
                ci.Cargar_Alumnos(nombre,edad_, carnet,grado_, genero);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    
    public JFreeChart Graficar_Alumnos(){
        return this.hr.GraficarPie(this.alumnos);
    }
    
    
    
    
}
