import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ProblemaP1 {

    public static void main(String[] args) throws IOException{
        try {
        	
        	InputStreamReader in = new InputStreamReader(System.in);
			//FileReader read = new FileReader("./data/prueba");
			BufferedReader br = new BufferedReader(in);
            String linea  = br.readLine(); //Esto nos da los costos de los pisos del caso 1
            while(!linea.isEmpty()) { //Vamos a recorrer todito el texto
                String[] pesoPisos = linea.split(" "); //Ya dijimos que esto era el peso. salu2.
                linea = br.readLine();//Vamos a mirar los portales ahora
                ArrayList<String[]> portales = new ArrayList<String[]>(); //Esto es lo más gracioso que he programado en mi vida xDDDD
                while(linea.length() == 7){ //7 es el length de "W X Y Z", o sea, de un portal
                    portales.add(linea.split(" ")); //Añadimos el portal a la lista de portales
                    linea = br.readLine(); //Y seguimos alv
                }
                //No hay necesidad de otro nextline pq lo hicimos al final del while de antes
                iniciarCaso(pesoPisos, portales);
            }
            br.close();
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
