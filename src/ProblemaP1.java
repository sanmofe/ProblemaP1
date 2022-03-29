import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProblemaP1 {

    public static void main(String[] args){
        try {
            File archivo = new File("ESTO ES UN PLACEHOLDER");
            Scanner escaner = new Scanner(archivo);
            escaner.nextLine(); //El número de casos nos vale vrg
            String linea  = escaner.nextLine(); //Esto nos da los costos de los pisos del caso 1
            while(!linea.isEmpty()) { //Vamos a recorrer todito el texto
                String[] pesoPisos = linea.split(" "); //Ya dijimos que esto era el peso. salu2.
                linea = escaner.nextLine();//Vamos a mirar los portales ahora
                ArrayList<String[]> portales = new ArrayList<String[]>(); //Esto es lo más gracioso que he programado en mi vida xDDDD
                while(linea.length() == 7){ //7 es el length de "W X Y Z", o sea, de un portal
                    portales.add(linea.split(" ")); //Añadimos el portal a la lista de portales
                    linea = escaner.nextLine(); //Y seguimos alv
                }
                //No hay necesidad de otro nextline pq lo hicimos al final del while de antes
                iniciarCaso(pesoPisos, portales);
            }
            escaner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ese no es el archivo");
            e.printStackTrace();
        }

    }

    private static void iniciarCaso(String[] pesoPisos, ArrayList<String[]> portales) {
        //TODO No lo sé, iniciar uno de los casos de prueba supongo xD
        //Quizás sea bueno paralelizar esto
    }

    public void inicializar(){

    }

}
