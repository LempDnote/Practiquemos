/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;
import Menu.Tipo_Menu;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
/**
 *
 * @author lgtjo
 */
public class Practica {

    private int[][] matriz_A = null;
    private int[][] matriz_B = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        Practica practica = new Practica();
        practica.Abrir_Archivo();
        practica.imprimir();
        
    }
    
    public void Abrir_Archivo(){
        Scanner entrada = new Scanner(System.in);
        //File--ubica el fichero
        File archivo;
        //FileReader--lee el fichero
        FileReader fr;
        //BufferedReader--leer el contenido
        BufferedReader br;
        
        System.out.println("Ingrese la ruta:");
        String ruta = entrada.nextLine();
        
        try{
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String lineas,texto="";
            int contador=0;
            while((lineas = br.readLine())!= null){
                contador++;
                this.matriz_A = this.matriz(contador, lineas,this.matriz_A);
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void leer(){
        
    }
    
    public int[][] matriz(int no_filas,String lineas,int[][] matriz){
        System.out.println(no_filas);
        String[] valores = lineas.split(",");
        int[][] matriz_ = new int[no_filas][valores.length];
        if(matriz != null){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz_[i][j] = matriz[i][j];
                }
            }
        }
        for (int i = 0; i < valores.length; i++) {
            matriz_[no_filas-1][i] = Integer.parseInt(valores[i]);
        }
        return matriz_;
    } 
    
    
    public void imprimir(){
        for (int i = 0; i < this.matriz_A.length; i++) {
            System.out.print("|");
            for (int j = 0; j < this.matriz_A[i].length; j++) {
                System.out.printf("%5d",matriz_A[i][j]);
            }
            System.out.print("|");
            System.out.println("");
        }
    }
    
    //public--cualquier clase
    //private--metodo que pertenece a esta clase
    //protected--herencia
    
    //Funcion
    
    
    
    
    
   
    
}
