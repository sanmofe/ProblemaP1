import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemaP1 {

    public static void main(String[] args){
        try {
            File archivo = new File("ESTO ES UN PLACEHOLDER");
            Scanner escaner = new Scanner(archivo);
            int numCasos = escaner.nextInt();



            while (escaner.hasNextLine()) {
                String linea = escaner.nextLine();
                System.out.println(linea);
            }
            escaner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ese no es el archivo");
            e.printStackTrace();
        }

    }

    public void inicializar(){

    }

}
