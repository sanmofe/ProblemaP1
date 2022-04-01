import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// import java.util.Scanner;


public class ProblemaP1 {

    static HashMap<String, String> portalesMap = new HashMap<>();
    static HashMap<String, String> portalesMapReversed = new HashMap<>();
    static int Habitaciones = 0;
    static int pisos = 0;
    static int nPortales = 0;
    static String[] pesoPisos = null;
    static int[][] T = null;


    public static void main(String[] args) throws IOException {
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);

            int numCasos = Integer.parseInt(br.readLine());
            for (int i = 0; i < numCasos; i++) {
                String[] setup = br.readLine().split(" "); // 0 = Pisos, 1 = Habitaciones, 2 = Portales
                pisos = Integer.parseInt(setup[0]);
                Habitaciones = Integer.parseInt(setup[1]);
                nPortales = Integer.parseInt(setup[2]);

                //HashMap<String, String> pesosMap = new HashMap<String, String>();
                //m = pesosMap.entrySet();
                //Map.Entry

                int[][] C = new int[pisos+1][Habitaciones+1];
                
                for (int k = 0;k< C.length;k++){
                    Arrays.fill(C[k], -1);

                }

                T = C;
                System.out.println(Arrays.deepToString(T)+"s");;
                pesoPisos = br.readLine().split(" ");

                List listportalespiso = new ArrayList();
                String[] portales = new String[Integer.parseInt(setup[2])];
/*                HashMap<String, String> portalesMap = null;
                portalesMap = new HashMap<>();*/
/*                HashMap<String, String> portalesMapReversed = null;
                portalesMapReversed = new HashMap<>();*/
                for (int j = 0; j < portales.length; j++) {

                    String[] SalidaPortal = new String[2];
                    String[] LlegadaPortal = new String[2];

                    portales[j] = br.readLine();
                    String[] coordPortal = portales[j].split(" ");
                    System.out.println(coordPortal);
                    String x1 = coordPortal[0];
                    String y1 = coordPortal[1];
                    String x2 = coordPortal[2];
                    String y2 = coordPortal[3];

                    System.out.println(x1+","+y1+","+x2+","+y2);

/*                    SalidaPortal[0] = x1;
                    SalidaPortal[1] = y1;
                    LlegadaPortal[0] = x2;
                    LlegadaPortal[1] = y2;*/

                    portalesMap.put(x1+","+y1, x2+","+y2);
                    portalesMapReversed.put(x2+","+y2,x1+","+y1);
                    //  portales
                }
                iniciarCaso(setup, pesoPisos, portales, portalesMap);
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


    private static boolean iniciarCaso(String[] setup, String[] pesoPisos, String[] portales, HashMap portalesMap) {
        //TODO No lo sé, iniciar uno de los casos de prueba supongo xD
        //Quizás sea bueno paralelizar esto

        Set<String> setOfKeys = portalesMap.keySet();
        System.out.println("tamaño mapa "+ portalesMap.size());
        // Iterating through the Hashtable
        // object using for-Each loop
        
        

        for (String key : setOfKeys) {
            // Print and display the Rank and Name
            System.out.println("Salida : " + key
                    + "\t\t Llegada : "
                    + portalesMap.get(key));
        }

        Set<String> setOfKeys2 = portalesMapReversed.keySet();
        System.out.println("tamaño mapa Reversed"+ portalesMapReversed.size());
        // Iterating through the Hashtable
        // object using for-Each loop
        for (String key : setOfKeys2) {
            // Print and display the Rank and Name
            System.out.println("Llegada : " + key
                    + "\t\t Salida : "
                    + portalesMapReversed.get(key));
        }
            inicializar();
            System.out.println("El caso se inicializa");
            System.out.println("Setup = " + setup[0] + " " + setup[1] + " " + setup[2]);
            System.out.println("PesoPisos = " + Arrays.toString(pesoPisos));
            System.out.println("Portales = " + Arrays.toString(portales));

        return true;
    }
        public static boolean esPortalLlegada ( int fila, int columna, HashMap portalesMap){

            boolean a = false;
            String celda = fila + "," + columna;
            a = portalesMap.containsValue(celda);
            return a;
        }
    public boolean esPortalSalida ( int fila, int columna, HashMap portalesMap){

        boolean a = false;
        String celda = fila + "," + columna;
        a = portalesMap.containsKey(celda);
        return a;
    }
    public static String darCoordsPortalSalida(int filaLlegada, int columnaLlegada){

        String celda = filaLlegada + "," + columnaLlegada;

        String Salida = portalesMapReversed.get(celda);
        
        return Salida;




    }

    public String darCoordsPortalLlegada(int filaSalida, int columnaSalida){

        String celda = filaSalida + "," + columnaSalida;

        String Llegada = portalesMap.get(celda);

        return Llegada;



    }
    public static int darPesoPiso(int filaPiso){
        return Integer.parseInt( pesoPisos[filaPiso-1]);
    }

    public static void inicializar () {
            
        int i, j;

        //int T[][] = new int[pisos + 1][Habitaciones + 1];

        //for( i = pisos; i > 0; i--){

            for( j = Habitaciones; j > 0; j--){

                checkearCelda(pisos,j,0);
                
            }

        //}
            System.out.println(Arrays.deepToString(T));
        }

        public static void checkearCelda(int pFila, int pColumna, int pPeso) {
            int peso = pPeso;
            String actual = pFila+","+pColumna;
            int pesoAnt = T[pFila][pColumna];
            T[pFila][pColumna] = peso;
            if(pesoAnt != -1 && pesoAnt<peso){
                T[pFila][pColumna] = pesoAnt;
            }

            if(esPortalLlegada(pFila,pColumna, portalesMap)){
                String[] coords = darCoordsPortalSalida(pFila, pColumna).split(",");
                checkearCelda(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), peso);
            }
            try{
                int tmp = T[pFila][pColumna];
                //peso += darPesoPiso(pFila);
                if (T[pFila][pColumna -1] ==-1 && pColumna > 1) {
                    peso += darPesoPiso(pFila);
                    checkearIzquierda(pFila, pColumna, peso);
                        //peso += darPesoPiso(pFila);

                }
            }catch(Exception e){

            }
            try{
                int tmp = T[pFila][pColumna];
                //peso += darPesoPiso(pFila);
                if (T[pFila][pColumna + 1] ==-1 ) {
                    peso += darPesoPiso(pFila);
                    checkearDerecha(pFila, pColumna, peso);
                        //peso += darPesoPiso(pFila);

                }
            }catch(Exception e){

            }
            
            //T[pFila][pColumna] = peso;
            //return peso;
        }

        public static void checkearIzquierda(int pFila, int pColumna, int pPeso){
            checkearCelda(pFila, pColumna - 1,pPeso);
        }
        public static void checkearDerecha(int pFila, int pColumna, int pPeso){
            checkearCelda(pFila, pColumna + 1,pPeso);
        }
        // public int checkearDerecha(int pFila, int pColumna){
        //     if (pColumna+1 < 0){
        //         return -1;
        //     }
        //     return checkearCelda(pFila, pColumna + 1);
        // }
    }

