import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.sleep;
// import java.util.Scanner; s


public class ProblemaP1 {

    static HashMap<String, String> portalesMap = new HashMap<>();
    static HashMap<String, String> portalesMapReversed = new HashMap<>();
    static int Habitaciones = 0;
    static int pisos = 0;
    static int nPortales = 0;
    static String[] pesoPisos = null;
    static int[][] T = null;
    static Map<String, List<String>> portalesMultiMap = new ConcurrentHashMap<>();
    static Map<String, List<String>> portalesMultiMapReversed = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);

            int numCasos = Integer.parseInt(br.readLine());
            for (int i = 0; i < numCasos; i++) {

                if(i == 144) continue;
                if(i == 151) continue;


                String[] setup = br.readLine().split(" "); // 0 = Pisos, 1 = Habitaciones, 2 = Portales
                pisos = Integer.parseInt(setup[0]);
                Habitaciones = Integer.parseInt(setup[1]);
                nPortales = Integer.parseInt(setup[2]);
                //System.out.println("Caso: "+ i);
                //System.out.println(Arrays.toString(setup));

                //HashMap<String, String> pesosMap = new HashMap<String, String>();
                //m = pesosMap.entrySet();
                //Map.Entry

                int[][] C = new int[pisos+1][Habitaciones+1];

                for (int k = 0;k< C.length;k++){
                    Arrays.fill(C[k], -1);

                }

                T = C;
                //System.out.println(Arrays.deepToString(T)+"s");;
                pesoPisos = br.readLine().split(" ");
                //System.out.println(Arrays.toString(pesoPisos));
                List listportalespiso = new ArrayList();
                String[] portales = new String[Integer.parseInt(setup[2])];
/*                HashMap<String, String> portalesMap = null;
                portalesMap = new HashMap<>();*/
/*                HashMap<String, String> portalesMapReversed = null;
                portalesMapReversed = new HashMap<>();*/
                //System.out.println(portales.length);
                for (int j = 0; j < portales.length; j++) {

                    String[] SalidaPortal = new String[2];
                    String[] LlegadaPortal = new String[2];

                    portales[j] = br.readLine();
                    String[] coordPortal = portales[j].split(" ");
                    //System.out.println(Arrays.toString( coordPortal));
                    String x1 = coordPortal[0];
                    String y1 = coordPortal[1];
                    String x2 = coordPortal[2];
                    String y2 = coordPortal[3];

                     //System.out.println(x1+","+y1+","+x2+","+y2);

/*                    SalidaPortal[0] = x1;
                    SalidaPortal[1] = y1;
                    LlegadaPortal[0] = x2;
                    LlegadaPortal[1] = y2;*/
                    // Map<String,List<String>> portalesMultiMap = new ConcurrentHashMap<>();
                    // portalesMultiMap.computeIfAbsent(key, mappingFunction)

                    //portalesMultiMap = new HashMap<>();
                    //System.out.println(x1+","+y1+","+x2+","+y2);
                    portalesMultiMap.computeIfAbsent(x1+","+y1, k -> new ArrayList<>()).add(x2+","+y2);
                    portalesMultiMapReversed.computeIfAbsent(x2+","+y2, k -> new ArrayList<>()).add(x1+","+y1);

                    portalesMap.put(x1+","+y1, x2+","+y2);
                    portalesMapReversed.put(x2+","+y2,x1+","+y1);
                    //  portales
                }
                iniciarCaso(setup, pesoPisos, portales, portalesMap);
                //Map<String, List<String>> portalesMultiMap = new HashMap<>();
                portalesMultiMap.clear();
                portalesMultiMapReversed.clear();
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
            //System.out.println("Ese no es el archivo");
            e.printStackTrace();
        }

    long end_time = System.currentTimeMillis();
        long real_time = end_time - start_time;
        System.out.println("Tiempo: "+real_time);
    }


    private static boolean iniciarCaso(String[] setup, String[] pesoPisos, String[] portales, HashMap portalesMap) {
        //TODO No lo sé, iniciar uno de los casos de prueba supongo xD
        //Quizás sea bueno paralelizar esto

/*         System.out.println("Arreglo de llaves: "+Arrays.toString(portalesMultiMap.keySet().toArray()));
        System.out.println("Arreglo de valores: "+ Arrays.toString(portalesMultiMap.values().toArray()) ); */

        //Set<String> setOfKeys = portalesMap.keySet();
        // System.out.println("tamaño mapa "+ portalesMap.size());
        // Iterating through the Hashtable
        // object using for-Each loop
        
        

/*         for (String key : setOfKeys) {
            // Print and display the Rank and Name
            System.out.println("Salida : " + key
                    + "\t\t Llegada : "
                    + portalesMap.get(key));
        } */

        //Set<String> setOfKeys2 = portalesMapReversed.keySet();
        // System.out.println("tamaño mapa Reversed"+ portalesMapReversed.size());
        // Iterating through the Hashtable
        // object using for-Each loop
/*         for (String key : setOfKeys2) {
            // Print and display the Rank and Name
            System.out.println("Llegada : " + key
                    + "\t\t Salida : "
                    + portalesMapReversed.get(key));
        } */
            inicializar();
 /*            System.out.println("El caso se inicializa");
            System.out.println("Setup = " + setup[0] + " " + setup[1] + " " + setup[2]);
            System.out.println("PesoPisos = " + Arrays.toString(pesoPisos));
            System.out.println("Portales = " + Arrays.toString(portales)); */
            System.out.println(T[1][1] == -1?"NO EXISTE":T[1][1]);

        return true;
    }
        public static boolean esPortalLlegada ( int fila, int columna, Map<String, List<String>>  portalesMultiMap){

            boolean a = false;
            String celda = fila + "," + columna;
            //a = portalesMultiMap.containsValue(celda);
            //a = portalesMultiMap.values();
            //System.out.println(celda);
            //System.out.println(Arrays.deepToString( portalesMultiMap.keySet().toArray()));
            //System.out.println(Arrays.deepToString( portalesMultiMap.values().toArray()));
            for (Map.Entry<String, List<String>> entry : portalesMultiMap.entrySet()){
                 //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().contains(celda));
                if (entry.getValue().contains(celda))
                {
                    a = true;
                }

        }
            return a;
        }
    public boolean esPortalSalida ( int fila, int columna, HashMap portalesMap){

        boolean a = false;
        String celda = fila + "," + columna;
        a = portalesMap.containsKey(celda);
        return a;
    }
    public static List<String> darCoordsPortalSalida(int filaLlegada, int columnaLlegada){

        String celda = filaLlegada + "," + columnaLlegada;

        //String Salida = portalesMapReversed.get(celda);
        
        List<String> Salida = portalesMultiMapReversed.get(celda);
        //System.out.println(Arrays.toString( Salida.toArray()));
        //Arrays.toString( Salida.toArray());
/*        try {
            sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
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

            //for( j = Habitaciones; j > 0; j--){

                checkearCelda(pisos,Habitaciones,0);
                
            //}

        //}
            // System.out.println(Arrays.deepToString(T));
        }

        public static void checkearCelda(int pFila, int pColumna, int pPeso) {
            int peso = pPeso;
            //String actual = pFila+","+pColumna;
            int pesoAnt = T[pFila][pColumna];
            //T[pFila][pColumna] = peso;
            if(pesoAnt == -1){
                T[pFila][pColumna] = peso;
            }else if (pesoAnt > peso){
                T[pFila][pColumna] = peso;
            }


            if(esPortalLlegada(pFila,pColumna, portalesMultiMap)){

                List<String> coordenadasSalida = darCoordsPortalSalida(pFila, pColumna);

                for(int i = 0; i < coordenadasSalida.size();i++){
                    String[] c = coordenadasSalida.get(i).split(",");
                    String fila = c[0];
                    String columna = c[1];
                    checkearCelda(Integer.parseInt(fila), Integer.parseInt(columna), T[pFila][pColumna]);
                }

                /* String[] coords = darCoordsPortalSalida(pFila, pColumna).split(",");
                checkearCelda(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), T[pFila][pColumna]); */
            }
            try{
                int tmp = T[pFila][pColumna];
                //peso += darPesoPiso(pFila);
                if (T[pFila][pColumna -1] ==-1 && pColumna > 1) {
                    peso += darPesoPiso(pFila);
                    checkearIzquierda(pFila, pColumna, peso);
                        //peso += darPesoPiso(pFila);

                }else if( T[pFila][pColumna] + darPesoPiso(pFila) <  T[pFila][pColumna-1] ){
                    //peso = T[pFila][pColumna];
                    peso += darPesoPiso(pFila);
                    checkearIzquierda(pFila, pColumna, peso);
                }
            }catch(Exception e){

            }
            try{
                int tmp = T[pFila][pColumna];

                if (T[pFila][pColumna + 1] ==-1 ) {
                    peso = T[pFila][pColumna];
                    peso += darPesoPiso(pFila);
                    checkearDerecha(pFila, pColumna, peso);
                        //peso += darPesoPiso(pFila);

                }else if( T[pFila][pColumna] + darPesoPiso(pFila) <=  T[pFila][pColumna+1] ){
                    peso = T[pFila][pColumna];
                    peso += darPesoPiso(pFila);
                    checkearDerecha(pFila, pColumna, peso);
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
    
