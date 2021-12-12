/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import org.jfree.JCommon;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import Personas.*;
/**
 *
 * @author lgtjo
 */
public class Herramientas {
    
    public Herramientas(){
        
    }
    
    public JFreeChart GraficarPie(Alumno[] alumno){
        DefaultPieDataset pie_value = new DefaultPieDataset();
        double contador_masculino = 0;
        double contador_femenino = 0;
        double contador = 0;
        double femenino;
        double masculino;
        
        for (int i = 0; i < alumno.length; i++) {
            if(alumno[i] != null){
                
                if(alumno[i].getGenero().equals("Femenino")){
                    contador_femenino++;
                    System.out.println(contador_femenino);
                }else{
                    contador_masculino++;
                }
                contador++;
            }
        }
        
        femenino = contador_femenino/contador;
        masculino = contador_masculino/contador;
        
        pie_value.setValue("Femenino",femenino*100);
        pie_value.setValue("Masculino", masculino*100);
        
        return ChartFactory.createPieChart("Genero de Alumnos", pie_value,true,true,false);
    }
    
    
    
    
}