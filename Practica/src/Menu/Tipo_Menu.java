/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author lgtjo
 */
public class Tipo_Menu {
    
    public Tipo_Menu(){
        
    }
    
    public String Mostrar_Principal(){
        String cadena = "Bienvenido a la practica no_1\n"
                + "Luis Eduardo Monroy Pérez\n";
        cadena += "1.Cargar Matrices\n";
        cadena += "Precione cualquier tecla para salir\n"
                + "Opcion:: ";
        return cadena;
    }
    
    public String Menu_Rutas(String tipo){
        String cadena = "Ingrese la ruta para cargar la matriz_"+tipo+": ";
        return cadena;
    }
    
    public String Menu_Operaciones(int tipo){
        String cadena = "";
        switch(tipo){
            //Resta
            case 1:
                cadena += "Ingrese el orden de la resta";
                break;
            //Multiplicacion
            case 2:
                cadena += "Ingrese el orden de la multiplicacion\n"
                        + "1.A*B\n"
                        + "2.B*A\n"
                        + "Opcion::";
                break;
            
            case 3:
                cadena += "Ingrese el orden de la divicion\n"
                        + "1.A/B\n"
                        + "2.B/A\n"
                        + "Opciones::";
        }
        return cadena;
    }
    
}
