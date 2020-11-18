package parcial;

import java.io.*;
import java.net.StandardSocketOptions;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.zip.GZIPInputStream;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

class Main {

    public static void main(String[] args) throws Exception {

    //    List<Testeo> testeos = new ArrayList<>();
        HashTableOpen<String> testeos = new HashTableOpen<>(127, (a)->{
               int x = 0;
                x = (a.charAt(0) * a.charAt(a.length()- 4) + a.length() - a.charAt(a.length()-1))  % 127; 
                x = Math.abs(x);
            return x;
            });
       
        String file = "resources/Covid19Casos-1000.txt.gz";
        int numberOfSamples = 0, numberOfDeaths = 0, numberOfInfected = 0;
        int h = 0;
        float  infectedBySamples = 0, deceasedByInfected = 0;
        Integer[] ageRangeInfected = {0,0,0,0,0,0,0,0,0,0,0,0};
        Integer[] ageRangeDeath = {0,0,0,0,0,0,0,0,0,0,0,0};
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
                    if(values[i].length() < 1){
                        values[i] = "0";
                    }
                }
               
               
                if (bandera) {
                    Testeo t = new Testeo(Integer.parseInt(values[0]), values[1].charAt(0), Integer.parseInt(values[2]), values[3], values[4], values[5], values[6], values[7],
                            values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15],
                            values[16], Integer.parseInt(values[17]), values[18], values[19], values[20], Integer.parseInt(values[21]), values[22], Integer.parseInt(values[23]), values[24]);
                  
                 // hay algunos que no tienen edad, a esos no los tiene que tomar.
                   
                    if(values[3].equals("Años") && values[20].equals("Confirmado")){
                        if(!values[2].equals("0")){
                              h = (int) (Integer.parseInt(values[2])/10);
                             ageRangeInfected[h] = ageRangeInfected[h] + 1;
                        }
                    }
                    if(values[3].equals("Meses") && values[20].equals("Confirmado")){
                        ageRangeInfected[0]++;       // en el caso de que la edad se exprese en meses
                    }
                    if(values[14].equals("SI") && !values[2].equals("0")){
                        h = (int) (Integer.parseInt(values[2])/10);
                        ageRangeDeath[h] = ageRangeDeath[h] + 1;
                    }
                    if (values[20].equals("Confirmado")){
                        numberOfInfected++;
                        testeos.insert(values[7], t);
                    }

                    numberOfSamples++;
                    numberOfDeaths = (values[14].equals("SI")) ? ++numberOfDeaths : numberOfDeaths;
                        

                 //  testeos.get(values[7]).printData();
                }
                bandera = true;
            }
            br.close();    
        } catch (Exception e) {
           e.printStackTrace();
        }
      
        System.out.println("Cantidad de muestras: " + numberOfSamples);
        System.out.println("Cantidad de fallecidos: " + numberOfDeaths);
        System.out.println("Cantidad de Infectados: " + numberOfInfected);
        infectedBySamples = numberOfInfected * 100 / numberOfSamples;
        System.out.println("Infectados por muestras: % " + infectedBySamples);
        deceasedByInfected = numberOfDeaths * 100 / numberOfInfected;
        System.out.println("Fallecidos por infectados: % " + deceasedByInfected );
        System.out.println("Cantidad de infectados por rango etario: ");
        for (int i = 0; i < ageRangeInfected.length; i++){
            System.out.println(" Entre " + (i*10) + " y " + (((i + 1) * 10) - 1) + ": " + ageRangeInfected[i]);
        }
        System.out.println("Cantidad de fallecidos por rango etario: ");
        for (int i = 0; i < ageRangeDeath.length; i++){
            System.out.println(" Entre " + (i*10) + " y " + (((i + 1) * 10) - 1) + ": " + ageRangeDeath[i]);
        }
        




      /*  String[] arr = { "Salta", "Jujuy", "Formosa", "Catamarca", "Chaco", "Tucumán", "Córdoba", "Buenos Aires",
                "CABA", "Mendoza", "San Juan", "San Luis", "Corrientes", "La Rioja", "La Pampa", "Santa Cruz", "Chubut",
                "Tierra del Fuego", "Santiago del Estero", "Neuquén", "Río Negro", "Misiones", "Santa Fe",
                "Entre Ríos" };
        int[] hashes = new int[arr.length];
        int y = 0;

        for (int i = 0; i < arr.length; i++) {
            y = arr[i].length() - 1;
    
        
            hashes[i] = (arr[i].charAt(0) * arr[i].charAt(arr[i].length()- 4) + arr[i].length() - arr[i].charAt(arr[i].length()-1))  % 127; 
            hashes[i] = Math.abs(hashes[i]);
           
            System.out.println(arr[i] + ": " + hashes[i]);
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < hashes.length && i != j; j++) {
                if (hashes[i] == hashes[j])
                    System.out.println(arr[i] + " colisiono con " + arr[j]);
            }
        
        }*/
        try{
        //     testeos.get("CABA").printData();
          //   testeos.printTree("CABA");
            //testeos.get("CABA")

            System.out.println("Cantidad de casos: " + testeos.getSize("CABA"));
             
        } catch(Exception e){
            System.out.println("***********************************************");
            System.out.println(e);
            System.out.println("***********************************************");
        }

        Provincia[] arrayProv = new Provincia[24];

        arrayProv[0] = new Provincia("CABA", testeos.getSize("CABA"));
        arrayProv[1] = new Provincia("Buenos Aires", testeos.getSize("Buenos Aires"));
        arrayProv[2] = new Provincia("Mendoza", testeos.getSize("Mendoza"));
        arrayProv[3] = new Provincia("San Juan", testeos.getSize("San Juan"));
        arrayProv[4] = new Provincia("Formosa", testeos.getSize("Formosa"));
        arrayProv[5] = new Provincia("Santa Fe", testeos.getSize("Santa Fe"));
        arrayProv[6] = new Provincia("San Luis", testeos.getSize("San Luis"));
        arrayProv[7] = new Provincia("Entre Ríos", testeos.getSize("Entre Ríos"));
        arrayProv[8] = new Provincia("Tucumán", testeos.getSize("Tucumán"));
        arrayProv[9] = new Provincia("Chaco", testeos.getSize("Chaco"));
        arrayProv[10] = new Provincia("Corrientes", testeos.getSize("Corrientes"));
        arrayProv[11] = new Provincia("Río Negro", testeos.getSize("Río Negro"));
        arrayProv[12] = new Provincia("Santa Cruz", testeos.getSize("Santa Cruz"));
        arrayProv[13] = new Provincia("Salta", testeos.getSize("Salta"));
        arrayProv[14] = new Provincia("Jujuy", testeos.getSize("Jujuy"));
        arrayProv[15] = new Provincia("Neuquén", testeos.getSize("Neuquén"));
        arrayProv[16] = new Provincia("La Pampa", testeos.getSize("La Pampa"));
        arrayProv[17] = new Provincia("La Rioja", testeos.getSize("La Rioja"));
        arrayProv[18] = new Provincia("Misiones", testeos.getSize("Misiones"));
        arrayProv[19] = new Provincia("Santiago del Estero", testeos.getSize("Santiago del Estero"));
        arrayProv[20] = new Provincia("Tierra del Fuego", testeos.getSize("Tierra del Fuego"));
        arrayProv[21] = new Provincia("Chubut", testeos.getSize("Chubut"));
        arrayProv[22] = new Provincia("Catamarca", testeos.getSize("Catamarca"));
        arrayProv[23] = new Provincia("Córdoba", testeos.getSize("Córdoba"));

        Arrays.sort(arrayProv);

        //imprimeArrayPersonas(arrayProv);
        //System.out.println(arrayProv[23].nombre + ": " + arrayProv[23].cantCasos);

        //IMPRIMIR LAS N PRIMERAS PROVINCIAS CON MAS CASOS
        imprimeArrayProvincias(arrayProv, testeos,5);

        }

    static class Provincia implements  Comparable <Provincia> {

        public String nombre;
        public int cantCasos = 0;

        public Provincia(String nombre, int cantCasos){
            this.nombre = nombre;
            this.cantCasos = cantCasos;
        }
        @Override
        public int compareTo(Provincia o) {
            if (cantCasos < o.cantCasos) {
                return -1;
            }
            if (cantCasos > o.cantCasos) {
                return 1;
            }
            return 0;
        }

    }
    //IMPRIMIR LAS N PRIMERAS PROVINCIAS CON MAS CASOS
    static void imprimeArrayProvincias(Provincia[] array, HashTableOpen<String> testeos, int n) throws Exception {
        for (int i = array.length - 1;  i >= 0 && n >= 0; i--, n--) {
            System.out.println(array[i].nombre + ": " + array[i].cantCasos);
            testeos.get(array[i].nombre);
        }
    }
}


