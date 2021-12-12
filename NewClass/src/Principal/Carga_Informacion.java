/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Personas.*;
/**
 *
 * @author lgtjo
 */
public class Carga_Informacion {
    
    private Alumno alumnos[];
    private Profesor profesores[];
    
    public Carga_Informacion(Alumno[] alumnos){
        this.alumnos = alumnos;
        
    }
    
    public Carga_Informacion(Profesor[] profesores){
        this.profesores = profesores;
    }
    
    public void Cargar_Alumnos(String nombre,int edad,String carnet,int grado,String genero){
        for (int i = 0; i < this.alumnos.length; i++) {
            if(this.alumnos[i] == null){
                this.alumnos[i] = new Alumno(nombre,carnet,genero,edad,grado);
                break;
            }
        }
    }
    
    public void Cargar_Profesor(String nombre,String correo, String password,int dpi,int edad){
        for (int i = 0; i < this.profesores.length; i++) {
            if(this.profesores[i] == null){
                this.profesores[i] = new Profesor(nombre,correo,password,dpi,edad);
                break;
            }
        }
    }
    
    public void Ver_Informacion_Alumnos(){
        for (int i = 0; i < this.alumnos.length; i++) {
            if(this.alumnos[i] != null){
                this.alumnos[i].Ver_Info();
            }
        }
    }
    

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public Profesor[] getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesor[] profesores) {
        this.profesores = profesores;
    }
    
    
    
    
}
