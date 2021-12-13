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
    private Carga_Informacion ci;
    public Colegio colegio = new Colegio();
    
    
    public Controlador(){
        this.Cargar_Json_Profesor("profesores.json");
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
    
    public String info_profesor(){
        String profesores = "";
        for (int i = 0; i < this.profesor.length; i++) {
            if(this.profesor[i] != null){
                profesores += this.profesor[i].Ver_Informacion()+"\n";
            }
        }
        return profesores;
    }
    
    public String info_alumnos(){
        String alumnos = "";
        for (int i = 0; i < this.alumnos.length; i++) {
            if(this.alumnos[i] != null){
                alumnos += this.alumnos[i].Ver_Informacion()+"\n\n";
            }
        }
        return alumnos;
    }
    
    public void Cargar_Json_Profesor(String ruta){
        ci = new Carga_Informacion(this.profesor);        
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
        ci = new Carga_Informacion(this.alumnos); 
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
    
    public void Cargar_Alumnos(String nombre,String carnet,String genero,int edad, int grado){
        ci = new Carga_Informacion(this.alumnos);
        ci.Cargar_Alumnos(nombre, edad, carnet, grado, genero);
    }
    
    public void Cargar_Profesores(){
        
    }
    
    public String[][] matriz_Alumnos(){
        String [][] matriz = new String[this.alumnos.length][5];
        for (int i = 0; i < this.alumnos.length; i++) {
            if(this.alumnos[i] != null){
                matriz[i][0] = this.alumnos[i].getNombre();
                matriz[i][1] = this.alumnos[i].getCarnet();
                matriz[i][2] = this.alumnos[i].getGenero();
                matriz[i][3] = Integer.toString(this.alumnos[i].getEdad());
                matriz[i][4] = Integer.toString(this.alumnos[i].getGrado());
            }
        }
        return matriz;
    }
    
    public JFreeChart Graficar_Alumnos(){
        return this.hr.GraficarPie(this.alumnos);
    }
    
    public boolean Login(String usuario,String password){
        for (int i = 0; i < this.profesor.length; i++) {
            if(this.profesor[i] != null){
                if(this.profesor[i].getCorreo().equals(usuario) && this.profesor[i].getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public Profesor[] getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor[] profesor) {
        this.profesor = profesor;
    }
    
    public boolean eliminar(int fila){
        this.alumnos[fila] = null;
        return true;
    }
    
    public boolean modificar(int i,String nombre,String carnet,String genero,int edad,int grado){
        if(this.alumnos[i] != null){
                this.alumnos[i].setNombre(nombre);
                this.alumnos[i].setCarnet(carnet);
                this.alumnos[i].setGenero(genero);
                this.alumnos[i].setEdad(edad);
                this.alumnos[i].setGrado(grado);
                return true;
            }
        return false;
    }
    
    
}
