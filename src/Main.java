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
        String file = "resources/Covid19Casos-10.txt.gz";
        try {
            GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(gzip));

                String line;
                boolean bandera = false;

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    for(int i=0; i < values.length; i ++){
                        if(values[i].length() > 1){    // evito los datos con comas dobles -> ,,
                            values[i] = values[i].substring(1, values[i].length() - 1);     // acorto el string para que salga sin ""
                        }


                     //   System.out.print(values[i] + "  ");
                    }
                  //  System.out.println("");

                  if (bandera) {
                      Testeo t = new Testeo(Integer.parseInt(values[0]), values[1].charAt(0), Integer.parseInt(values[2]), values[3], values[4], values[5], values[6], values[7],
                              values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15],
                              values[16], Integer.parseInt(values[17]), values[18], values[19], values[20], Integer.parseInt(values[21]), values[22], Integer.parseInt(values[23]), values[24]);


                      testeos.add(t);
                  }
                  bandera=true;
                   //  System.out.println(values[0]);
                }

            for ( int i = 0; i < testeos.size(); i++){
                testeos.get(i).printData();
            }

            }
     catch (Exception e) {
        System.out.println("El archivo no se pudo abrir correctamente! ");
    }


    }
}