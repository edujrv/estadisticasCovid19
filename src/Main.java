import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.zip.GZIPInputStream;

class Main {

    public static void main (String[] args){

        List<Testeo> testeos = new ArrayList<>();
        String file = "resources/Covid19Casos-1000.txt.gz";
        try {
            GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(gzip));

                String line;

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    for(int i=0; i < values.length; i ++){
                        if(values[i].length() > 1){    // evito los datos con comas dobles -> ,,
                            values[i] = values[i].substring(1, values[i].length() - 1);     // acorto el string para que salga sin ""
                        }


                        System.out.print(values[i] + "  ");
                    }
                    System.out.println("");

                    Testeo t = new Testeo();
                    // TODO: Hacer todos los sets

                    testeos.add(t);
                }
            }
     catch (Exception e) {
        System.out.println("El archivo no se pudo abrir correctamente! ");
    }


    }
}