/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Personas.*;
import Principal.Carga_Informacion;
import Principal.Herramientas;
import java.io.File;
import java.io.FileNotFoundException;
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
    private Clase clase[] = new Clase[100];
    private Herramientas hr = new Herramientas();
    private Carga_Informacion ci;
    public Colegio colegio = new Colegio();
    public String usuario;
    private int asignacion = 0;
    
    public Controlador(){
        this.__init__();
        
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
        System.out.println(profesores);
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
                double ede = (double)edad;
                System.out.println(ede);
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
    
    public void Cargar_Profesores(String nombre,String correo, String password,int dpi,int edad){
        ci = new Carga_Informacion(this.profesor);
        ci.Cargar_Profesor(nombre, correo, password, dpi, edad);
    }
    
    public void Cargar_Clase(String seccion,int grado,String nombre_profesor,String nombre_alumnos,String asignacion,String informacion){
        ci = new Carga_Informacion(this.clase);
        ci.Cargar_Clase(seccion, grado, nombre_profesor, nombre_alumnos, asignacion,informacion);
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
    
    public String[][] matriz_Profesores(){
        String [][] matriz = new String[this.profesor.length][5];
        for (int i = 0; i < this.profesor.length; i++) {
            if(this.profesor[i] != null){
                matriz[i][0] = this.profesor[i].getNombre();
                matriz[i][1] = Integer.toString(this.profesor[i].getDpi());
                matriz[i][2] = this.profesor[i].getCorreo();
                matriz[i][3] = this.profesor[i].getPassword();
                matriz[i][4] = Integer.toString(this.profesor[i].getEdad());
            }
        }
        
        return matriz;
    }
    
    public String[][] matriz_Clase(){
        String matriz[][] = new String[this.clase.length][2];
        for (int i = 0; i < this.clase.length; i++) {
            if(this.clase[i] != null){
                if(this.clase[i].getNombre_profesor().equals(this.usuario)){
                    //leno la matriz de datos
                    for (int j = 0; j < matriz.length; j++) {
                        if(matriz[j][0] == null){
                            matriz[j][0] = this.clase[i].getInformacion();
                            matriz[j][1] = Integer.toString(this.clase[i].getNota());
                            break;
                        }
                    }
                }
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
                    this.usuario = usuario;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean Asignacion(int i){
        this.Cargar_Clase(null,this.alumnos[i].getGrado(),this.usuario,this.alumnos[i].getNombre(),Integer.toString(this.asignacion++),this.alumnos[i].Ver_Informacion());
        
        return true;
    }
//funcion retorna metodo no retorna
    public String[] ver_clase(){
        String estudiantes[] = new String[this.clase.length];
        for (int i = 0; i < this.clase.length; i++) {
            if(this.clase[i] != null){
                if(this.clase[i].getNombre_profesor().equals(this.usuario)){
                    //llenar vector de estudiantes
                    for (int j = 0; j < estudiantes.length; j++) {
                        if(estudiantes[j] == null){
                            estudiantes[j] = this.clase[i].getNombre_alumnos();
                            break;
                        }
                    }
                }
            }
        }
        /*Ejemplo
        String clientes[] = new String[this.alumnos.length];
        for (int i = 0; i < this.alumnos.length; i++) {
            if(this.alumnos[i] != null){
                clientes[i] = this.alumnos[i].getNombre();
            }
        }*/
        return estudiantes;
    }
    
    public boolean eliminar(int fila){
        this.alumnos[fila] = null;
        return true;
    }
    
    public boolean eliminar_profesor(int fila){
        this.profesor[fila] = null;
        return true;
    }
    
    public String clase_informacion(String Nombre){
        for (int i = 0; i < this.clase.length; i++) {
            if(this.clase[i].getNombre_alumnos().equals(Nombre)){
                return this.clase[i].getInformacion();
            }
        }
        return "";
    }
    
    public void Insertar_Notas(int nota,String Nombre){
        for (int i = 0; i < this.clase.length; i++) {
            if(this.clase[i] != null){
                if(this.clase[i].getNombre_alumnos().equals(Nombre)){
                this.clase[i].setNota(nota);
                break;
            }
            }
            
        }
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
    
    public boolean modificar_profesor(int i,String nombre,String correo,String password,int dpi,int edad){
        if(this.profesor[i] != null){
            this.profesor[i].setNombre(nombre);
            this.profesor[i].setCorreo(correo);
            this.profesor[i].setPassword(password);
            this.profesor[i].setEdad(edad);
            this.profesor[i].setDpi(dpi);
            return true;
        }
        return false;
    }
    
    public JFreeChart Barras_Profesores(){
        return this.hr.GraficaBarras(this.clase,this.profesor);
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
    
    
    
    
    
    
    //serializando
    public void serializarAlumnos(){
        //primero creamos el archivo a serealizar
        this.hr.escritura_abrir("alumnos.ser");
        //despues escribirmos el archivo
        this.hr.escritura_escribir(this.alumnos);
        //despues cerramos el archivo
        this.hr.escritura_cerrar();
    }
    
    public void serializarProfesores(){
        this.hr.escritura_abrir("profesores.ser");
        this.hr.escritura_escribir(this.profesor);
        this.hr.escritura_cerrar();
    }
    
    public void serializarClase(){
        this.hr.escritura_abrir("clase.ser");
        this.hr.escritura_escribir(this.clase);
        this.hr.escritura_cerrar();
    }
    
    public void serializarColegio(){
        this.hr.escritura_abrir_("colegio.animal");
        this.hr.escritura_escribir_colegio(this.colegio);
        this.hr.escritura_cerrar_();
    }
 
    //deserealizar
    
    public void deserializacion_alumnos(){
        
          this.hr.lectura_abrir("alumnos.ser");
          this.alumnos = (Alumno[])this.hr.lectura_leer();
          this.hr.lectura_cerrar();  
        
    }
    
    public void deserializacion_profesores(){
        
          this.hr.lectura_abrir("profesores.ser");
          this.profesor = (Profesor[])this.hr.lectura_leer();
          this.hr.lectura_cerrar();  
        
    }
    
    public void deserializacion_clase(){
          this.hr.lectura_abrir("clase.ser");
          this.clase = (Clase[])this.hr.lectura_leer();
          this.hr.lectura_cerrar();  
    }
    
    public void deserealizacion_colegio(){
        this.hr.Lectura_abrir("colegio.animal");
        this.colegio = (Colegio)this.hr.Lectura_leer();
        this.hr.Lectura_cerrar();
    }
    
    public void __init__(){
        File alumnos = new File("alumnos.ser");
        File profesores = new File("profesores.ser");
        File clase = new File("clase.ser");
        File colegio = new File("colegio.animal");
        if(alumnos.exists()){
            this.deserializacion_alumnos();
        }
        if(profesores.exists()){
            this.deserializacion_profesores();
        }
        if(clase.exists()){
            this.deserializacion_clase();
        }
        if(colegio.exists()){
            this.deserealizacion_colegio();
        }
    }
    
    public void Exportar_alumnos(){
        this.hr.Exportar_Pdf(this.alumnos);
    }
    
    public void Exportar_profesores(){
        this.hr.Exportar_Pdf(this.profesor);
    }
}
