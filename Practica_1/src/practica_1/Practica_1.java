/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_1;

import practica_1.Operaciones;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author lgtjo
 */
public class Practica_1 {
    
    private Scanner entrada = new Scanner(System.in);
    private int [][] Matriz_A;
    private int [][] Matriz_B;
    private int [][] Matriz_Resultado;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Practica_1 practica = new Practica_1();
        practica.Pruebas();
    }

    private void Menu_Inicial(){
        Scanner entrada = new Scanner(System.in);
        String opcion = "";
        
        while(true){
            System.out.println(">>Bienvenido a practica 1\nSeleccione la opcion a realizar:"
                + "\n1.Cargar Matrices"
                + "\n2.Salir"
                + "\nOpcion::");
            opcion = entrada.next();
            switch(opcion){
                case "1":
                    System.out.println(">Ingrese la ruta de la Matriz A");
                    String file_A = this.entrada.next();
                    this.Matriz_A = this.Cargar_Matriz(file_A);
                    System.out.println(">Inrese la ruta de la Matriz B");
                    String file_B = this.entrada.next();
                    this.Matriz_B = this.Cargar_Matriz(file_B);
                    this.Menu_Operaciones();
                    
                    break;
                case "2":
                    return;
            } 
        }
    }
    
    private int[][] Cargar_Matriz(String file){
        int [][] matriz = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader bf = null;
        try{
            archivo = new File(file);
            fr = new FileReader(archivo);
            bf = new BufferedReader(fr); 
            String lector;
            int[] valores;
            int contador = 0;
            while((lector = bf.readLine()) != null){
                valores = this.Split(lector);
                contador++;
                matriz = this.Matriz(contador, valores, matriz);
            }
            this.Imprimir(matriz);
        }catch(Exception ex){
            System.out.println("Archivo no abierto");
            ex.printStackTrace();
        }finally{
            try{
                if(null != fr){
                    fr.close();
                }
            }catch(Exception ez){
                ez.printStackTrace();
            }
        }
        return matriz;
    }
    
    private int[] Split(String linea){
        String[] valores = linea.split(",");
        int[] datos = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            datos[i] = Integer.parseInt(valores[i]);
        }
        return datos;
    }
    
    private int[][] Matriz(int T_fila,int[] Columnas,int[][] matriz_){
        int [][] temp;
        temp = new int[T_fila][Columnas.length];
        if (matriz_ != null) {    
            for (int i = 0; i < matriz_.length; i++) {
                for (int j = 0; j < matriz_[i].length; j++) {
                    temp[i][j] = matriz_[i][j];
                }
            }
        }
        for (int i = 0; i < Columnas.length; i++) {
                temp[T_fila-1][i] = Columnas[i];
            }
        return temp;
    }
    
    private void Imprimir(int [][] matriz_){
        for (int i = 0; i < matriz_.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz_[i].length; j++) {
                System.out.printf("%5d",matriz_[i][j]);
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    private void Menu_Operaciones(){
        Operaciones operaciones = new Operaciones(this.Matriz_A,this.Matriz_B);
        while(true){
            System.out.println(">>Ingrese la operacion que desea Realizar\n"
                    + "1.Suma de matrices\n"
                    + "2.Resta de matrices\n"
                    + "3.Multiplicacion entre matrices\n"
                    + "4.Division entre matrices\n"
                    + "5.Matriz Transpuesta\n"
                    + "6.Matriz Inversa\n"
                    + "7.Potencia\n"
                    + "Cualquier numero para salir\n"
                    + "Operacion::");
            int opcion = this.entrada.nextInt();
            switch(opcion){
                case 1:
                    this.entrada.reset();
                    
                    break;
                //Resta
                case 2:
                    this.entrada.reset();
                    System.out.println("Orden de resta:\n"
                            + "1.A-B\n"
                            + "2.B-A\n"
                            + "Opcion::");
                    int tipo = this.entrada.nextInt();
                    switch(tipo){
                        case 1:
                            operaciones.Resta();
                            break;
                        case 2:
                            break;
                    }
                    break;
                //Multiplicacion
                case 3:
                    this.entrada.reset();
                    System.out.println("Orden de Mutiplicacion:\n"
                            + "1.A*B\n"
                            + "2.B*A\n"
                            + "Opcion::");
                    break;
                    
                //Division
                case 4:
                    this.entrada.reset();
                    System.out.println("Orden de Division:\n"
                            + "A/B\n"
                            + "B/A\n"
                            + "Opcion::");
                    break;
                    
                //Transpuesta
                case 5:
                    this.entrada.reset();
                    System.out.println("Matriz para realizar la transpuesta");
                    break;
                    
                //Inversa
                case 6:
                    this.entrada.reset();
                    System.out.println("Matriz para realizar la inversa");
                    break;
                    
                //Potencia
                case 7:
                    this.entrada.reset();
                    System.out.println("Matriz para realizar potencia\n"
                            + "1.A\n"
                            + "2.B\n"
                            + "Opcion::");
                    
                    System.out.println("Ingrese la potencia:");
                    break;
                default:
                    return;
            }
        }
    }
    
    private String Imprimir_Matriz_html(int [][] matriz,String nombre){
        String cadena = "<div class=\"matriz\">\n";
        cadena += "<h2>"+nombre+"</h2>\n";
        cadena += "<table>\n";
        for (int i = 0; i < matriz.length; i++) {
            cadena += "<tr>";
            for (int j = 0; j < matriz[i].length; j++) {
                cadena += "<td>"+Integer.toString(matriz[i][j]);
                cadena += "</td>";
            }
            cadena += "\n</tr>\n";
        }
        cadena += "</table>\n</div>\n";
        System.out.println(cadena);
        return cadena;
    }
    
    private void Pruebas(){
        
        int[][] matriz_A = new int[3][2];
        matriz_A[0][0] = 1;
        matriz_A[0][1] = 2;
        
        matriz_A[1][0] = 4;
        matriz_A[1][1] = 5;
        
        matriz_A[2][0] = 7;
        matriz_A[2][1] = 8;
        
        
        int[][] matriz_B = new int[3][2];
        matriz_B[0][0] = 1;
        matriz_B[0][1] = 2;
        matriz_B[1][0] = 13;
        matriz_B[1][1] = 4;
        matriz_B[2][0] = 5;
        matriz_B[2][1] = 6;

        Operaciones operaciones = new Operaciones(matriz_A,matriz_B);
        this.Imprimir_Matriz_html(matriz_A,"matriz_A");
        this.Imprimir_Matriz_html(matriz_B,"matriz_B");
        this.Imprimir_Matriz_html(operaciones.Suma(),"resultado");
        
    }
    
    
    
}
