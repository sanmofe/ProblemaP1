import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import java.util.Scanner;
import java.util.Arrays;

public class ProblemaP1 {
    
    public static void main(String[] args) throws IOException{
        try {
        	InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);

            int numCasos = Integer.parseInt(br.readLine());
            for (int i = 0; i < numCasos; i++) {
                String[] setup = br.readLine().split(" "); // 0 = Pisos, 1 = Habitaciones, 2 = Portales
                String[] pesos = br.readLine().split(" ");
                String[] portales = new String[Integer.parseInt(setup[2])];
                for (int j = 0; j < portales.length; j++) {
                    portales[j] = br.readLine();
                }                
               iniciarCaso(setup, pesos, portales);
            }
            

            //String linea  = br.readLine(); //Esto nos da los costos de los pisos del caso 1
            // while(br.ready()) { //Vamos a recorrer todito el texto
            //     String[] pesoPisos = linea.split(" "); //Ya dijimos que esto era el peso. salu2.
            //     System.out.println("lei");
            //     linea = br.readLine();//Vamos a mirar los portales ahora
            //     ArrayList<String[]> portales = new ArrayList<String[]>(); //Esto es lo más gracioso que he programado en mi vida xDDDD
            //     while(linea.length() == 7 && br.ready()){ //7 es el length de "W X Y Z", o sea, de un portal
            //         portales.add(linea.split(" ")); //Añadimos el portal a la lista de portales
            //         linea = br.readLine(); //Y seguimos alv
            //         System.out.println("Leí portal");
            //     }
            //     //No hay necesidad de otro nextline pq lo hicimos al final del while de antes
            //     iniciarCaso(pesoPisos, portales);
            // }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ese no es el archivo");
            e.printStackTrace();
        }

    }

    private static void iniciarCaso(String[] setup, String[] pesoPisos, String[] portales) {
        //TODO No lo sé, iniciar uno de los casos de prueba supongo xD
        //Quizás sea bueno paralelizar esto
        System.out.println("El caso se inicializa");
        System.out.println("Setup = " + setup[0] + " " + setup[1] + " " + setup[2]);
        System.out.println("PesoPisos = " + pesoPisos.toString());
        System.out.println("Portales = " + Arrays.toString(portales));

    }

    public void inicializar(){
    	
    }

}
