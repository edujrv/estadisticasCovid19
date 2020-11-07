import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.zip.GZIPInputStream;

class Main {

    public static void main(String[] args) {

    //    List<Testeo> testeos = new ArrayList<>();
        HashTableOpen<String, Testeo> testeos = new HashTableOpen<>(50);
       
        String file = "resources/Covid19Casos-10.txt.gz";
        int numberOfSamples = 0, numberOfDeaths = 0, numberOfInfected = 0;
        try {
            GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(gzip));

            String line;
            boolean bandera = false;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[i].length() > 1) {    // evito los datos con comas dobles -> ,,
                        values[i] = values[i].substring(1, values[i].length() - 1);     // acorto el string para que salga sin ""
                    }
                }

                if (bandera) {
                    Testeo t = new Testeo(Integer.parseInt(values[0]), values[1].charAt(0), Integer.parseInt(values[2]), values[3], values[4], values[5], values[6], values[7],
                            values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15],
                            values[16], Integer.parseInt(values[17]), values[18], values[19], values[20], Integer.parseInt(values[21]), values[22], Integer.parseInt(values[23]), values[24]);

               
                    numberOfSamples ++;
                    numberOfDeaths = (values[14].equals("SI")) ? ++numberOfDeaths : numberOfDeaths;
                    numberOfInfected = (values[20].equals("Confirmado")) ? ++numberOfInfected : numberOfInfected;
                        
                    
                    // ****************TIRA EXCEPCION*********************
                    /*
                        la idea es una tabla que tenga como clave las provincias y como
                        valor la informacion del testeo
                    */
                    //testeos.insert(values[7], t);
                    //System.out.println(testeos.get(values[7]));
                    
                }
                bandera = true;
            }
            br.close();    
        } catch (Exception e) {
            System.out.println("El archivo no se pudo abrir correctamente! ");
        }
        
        System.out.println("Cantidad de muestras: " + ++numberOfSamples);
        System.out.println("Cantidad de muertes: " + numberOfDeaths);
        System.out.println("Cantidad de Infectados: " + numberOfInfected);
        
    }
}