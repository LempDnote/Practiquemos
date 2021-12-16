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
import org.jfree.data.category.DefaultCategoryDataset;
import Personas.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*------------------------------------*/
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
/*
 import org.apache.pdfbox.pdmodel.PDDocument;
 import org.apache.pdfbox.pdmodel.PDPage;
 import org.apache.pdfbox.pdmodel.PDPageContentStream;
 import org.apache.pdfbox.pdmodel.common.PDRectangle;
 import org.apache.pdfbox.pdmodel.font.PDType1Font;
 */

/*------------------------------------*/
/**
 *
 * @author lgtjo
 */
public class Herramientas {

    //Declarar el objeto para leer el archivo
    private FileOutputStream fileout;
    //Declarar el objeto para la salir
    private ObjectOutputStream output;

    //Declarar un objeto que me permita abrir el archivo
    private FileInputStream fileinput;
    //private FileInputStream fileinput;
    //Declarar un objeto que me permita leer;
    private ObjectInputStream input;
    //private ObjectInputStream input;

    public Herramientas() {

    }

    public JFreeChart GraficarPie(Alumno[] alumno) {
        DefaultPieDataset pie_value = new DefaultPieDataset();
        double contador_masculino = 0;
        double contador_femenino = 0;
        double contador = 0;
        double femenino;
        double masculino;

        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null) {

                if (alumno[i].getGenero().equals("Femenino")) {
                    contador_femenino++;
                    System.out.println(contador_femenino);
                } else {
                    contador_masculino++;
                }
                contador++;
            }
        }

        femenino = contador_femenino / contador;
        masculino = contador_masculino / contador;

        pie_value.setValue("Femenino", femenino * 100);
        pie_value.setValue("Masculino", masculino * 100);

        return ChartFactory.createPieChart("Genero de Alumnos", pie_value, true, true, false);
    }

    public JFreeChart GraficaBarras(Clase[] clase, Profesor[] profesor) {
        DefaultCategoryDataset barras = new DefaultCategoryDataset();//objeto que me permite agregar la informacion a graficar
        for (int i = 0; i < profesor.length; i++) {//reccorre a todos los profesores
            if (profesor[i] != null) {
                String nombre_profesor = profesor[i].getCorreo();
                int contador_alumnos = 0;
                for (int j = 0; j < clase.length; j++) {//recorremos la clase para encontrar a la cantidad de asignaciones que tienen el mismo profesor
                    if (clase[j] != null) {
                        String nombre_del_profesor_asignado = clase[j].getNombre_profesor();
                        if (nombre_profesor.equals(nombre_del_profesor_asignado)) {
                            contador_alumnos++;
                        }
                    }
                }
                barras.addValue(contador_alumnos, "Clase", nombre_profesor);
            }
        }
        return ChartFactory.createBarChart("Profesores", "Profesor", "Numero de estudiantes", barras, PlotOrientation.VERTICAL, true, true, true);
    }

    //Escribimos
    public void escritura_abrir_(String ruta) {
        try {
            fileout = new FileOutputStream(ruta);
            output = new ObjectOutputStream(fileout);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void escritura_cerrar_() {
        if (this.output != null) {
            try {
                this.output.close();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void escritura_escribir_(Object[] objeto) {
        if (this.output != null) {
            try {
                this.output.writeObject(objeto);
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void escritura_escribir_colegio(Object objeto) {
        try {
            this.output.writeObject(objeto);
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Leer

    public void Lectura_abrir(String url) {
        try {
            this.fileinput = new FileInputStream(url);
            this.input = new ObjectInputStream(fileinput);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Lectura_cerrar() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Object Lectura_leer() {
        Object objeto = null;
        if (this.input != null) {
            try {
                objeto = (Object) this.input.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return objeto;
    }

    public void escritura_abrir(String path) {
        try {
            fileout = new FileOutputStream(path);
            output = new ObjectOutputStream(fileout);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escritura_cerrar() {
        if (output != null) {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void escritura_escribir(Object[] objeto) {
        if (output != null) {
            try {
                output.writeObject(objeto);
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void lectura_abrir(String path) {
        try {
            fileinput = new FileInputStream(path);
            input = new ObjectInputStream(fileinput);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void lectura_cerrar() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Object lectura_leer() {
        Object objeto = null;
        if (input != null) {
            try {
                objeto = (Object) input.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return objeto;
    }

    public void Exportar_Pdf(Alumno[] alumnos) {
        try {
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A0);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);
            for (int i = 0; i < alumnos.length; i++) {
                if (alumnos[i] != null) {
                    contenido.beginText();//empiezo a escribir
                    contenido.setFont(PDType1Font.COURIER_BOLD, 8);//asigno letra
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (20 *(i+1)));//me posiciono en la linea
                    contenido.showText("Nombre:" + alumnos[i].getNombre() + "   "
                            + "Carnet:" + alumnos[i].getCarnet() + "    "
                            + "Genero:" + alumnos[i].getGenero());//escribo
                    contenido.endText();//termino de escribir
                }
            }

            contenido.close();//cierro el contenido
            documento.save("alumnos.pdf");//creo el documento
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     public void Exportar_Pdf(Alumno[] alumnos){
     try {
     PDDocument document = new PDDocument();
     PDPage page = new PDPage(PDRectangle.A0);
     document.addPage(page);
     PDPageContentStream contenido = new PDPageContentStream(document,page);
     for (int i = 0; i < alumnos.length; i++) {
     if(alumnos[i] != null){
     contenido.beginText();
     contenido.setFont(PDType1Font.COURIER_BOLD_OBLIQUE,5);
     contenido.newLineAtOffset(20,page.getMediaBox().getHeight()-(80*i));
     contenido.showText("Nombre:|"+alumnos[i].getNombre()+"|");
     contenido.endText();
     }
     }
     contenido.close();
     document.save("alumnos.pdf");
            
     } catch (IOException ex) {
     Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
     }
     }*/
    public void Exportar_Pdf(Profesor[] profesores) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A3);
            document.addPage(page);
            PDPageContentStream contenido = new PDPageContentStream(document, page);
            for (int i = 0; i < profesores.length; i++) {
                if (profesores[i] != null) {
                    contenido.beginText();
                    contenido.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 8);
                    contenido.newLineAtOffset(20, page.getMediaBox().getHeight() - (20*(i+1)));
                    contenido.showText("Nombre:"+profesores[i].getNombre());
                    contenido.endText();
                    
                }
            }
            contenido.close();
            document.save("profesores.pdf");

        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
