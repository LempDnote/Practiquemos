/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import org.jsoup.Jsoup;

/**
 *
 * @author lgtjo
 */
public class Operaciones {
    
    private int [][] matriz_A;
    private int [][] matriz_B;
    
    public Operaciones(int [][] matriz_A, int [][] matriz_B){
        this.matriz_A = matriz_A;
        this.matriz_B = matriz_B;
    }
    
    public int [][] Suma(){
        int[][] matriz_Resultado = new int[this.matriz_A.length][this.matriz_A[0].length];
        for (int i = 0; i < this.matriz_A.length; i++) {
            for (int j = 0; j < this.matriz_A[i].length; j++) {
                matriz_Resultado[i][j] = this.matriz_A[i][j]+this.matriz_B[i][j];
            }
        }
        return matriz_Resultado;
    }
    
    public int [][] Resta(){
        return null;
    }
    
    public int [][] Multiplicacion(){
        int[][] resultado = new int[this.matriz_A.length][this.matriz_B[0].length];
        if (this.matriz_A[0].length == this.matriz_B.length) {
            for (int i = 0; i < this.matriz_A.length; i++) {
                for (int j = 0; j < this.matriz_B[0].length; j++) {
                    int suma = 0;
                    for (int k = 0; k < this.matriz_B.length; k++) {
                        suma += this.matriz_A[i][k]*this.matriz_B[k][j];
                    }
                    resultado[i][j] = suma;
                }
            }   
        }
        for (int i = 0; i < resultado.length; i++) {
            System.out.print("|");
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.printf("%5d",resultado[i][j]);
            }
            System.out.print("|");
            System.out.println("");
        }
        
        return null;
    }
    
    public int [][] Division(){
        return null;
    }
    
    public int [][] Transpuesta(){
        return null;
    }
    
    public int [][] Inversa(){
        int [][] matriz_temp = this.matriz_A;
        int [][] matriz_id = new int[matriz_temp.length][matriz_temp[0].length];
        int [][] matriz_completa = new int[matriz_temp.length][2*matriz_temp[0].length];
        
        for (int i = 0; i < matriz_id.length; i++) {
            matriz_id[i][i] = 1;
        }
        
        for (int i = 0; i < matriz_temp.length; i++) {
            for (int j = 0; j < matriz_temp[i].length; j++) {
                matriz_completa[i][j] = matriz_temp[i][j];
            }
        }
        
        for (int i = 0; i < matriz_completa.length; i++) {
            for (int j = matriz_temp.length; j < matriz_completa[i].length; j++) {
                matriz_completa[i][j] = matriz_id[i][j-matriz_temp.length];
            }
        }
        
        for (int i = 0; i < matriz_completa.length; i++) {
            for (int j = 0; j < matriz_completa[i].length; j++) {
                
            }
        }
        
        this.imprimir(matriz_completa);
        
        return null;
    }
    
    public int [][] Potencia(){
        return null;
    }
    
    
    public void imprimir(int[][] temp){
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.printf("%5d",temp[i][j]);
            }
            System.out.println("");
        }
    }
    
    
    public void Escribir(){
        org.jsoup.nodes.Document doc = Jsoup.parse("<html></html>");
        doc.body().appendElement("div").addClass("box");
        doc.getElementsByClass("box").append("<h1>");
        doc.getElementsByClass("box").append("<p>Hola Mundo");
        doc.getElementsByClass("box").append("<a>Hola Mundo");
        doc.body().appendElement("table").addClass("Table").addClass("Box_Table");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                doc.getElementsByClass("table").append("<tr>"+Integer.toString(j)+"<td>"+Integer.toString(i));
            }

        }
        
        
        try {
            FileWriter archivo = new FileWriter("Reportes.html");
            archivo.write(doc.toString());
            archivo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
    }
    
}
