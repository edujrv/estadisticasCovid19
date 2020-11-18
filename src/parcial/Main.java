package parcial;

import java.util.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
        Integer[] ageRangeInfected = new Integer[15];
        Arrays.fill(ageRangeInfected,0);
        Integer[] ageRangeDeath = new Integer[15];
        Arrays.fill(ageRangeDeath,0);
        AvlTree<ParFechaCaso> arbol = new AvlTree<ParFechaCaso>();
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

               boolean dead = false;
                if (bandera) {

                    Testeo t = new Testeo(Integer.parseInt(values[0]), values[1].charAt(0), Integer.parseInt(values[2]), values[3], values[4], values[5], values[6], values[7],
                            values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15],
                            values[16], Integer.parseInt(values[17]), values[18], values[19], values[20], Integer.parseInt(values[21]), values[22], Integer.parseInt(values[23]), values[24]);

                 // hay algunos que no tienen edad, a esos no los tiene que tomar.

                    if(values[20].equals("Confirmado")){
                        numberOfInfected++;
                        testeos.insert(values[7], t);

                        if (values[14].equals("SI")) {
                            numberOfDeaths++;
                            testeos.sumarMuerte(values[7]);
                            h = (int) (Integer.parseInt(values[2]) / 10);
                            ageRangeDeath[h] = ageRangeDeath[h] + 1;
                        }
                        if(values[3].equals("Meses")){
                            ageRangeInfected[0]++;       // en el caso de que la edad se exprese en meses
                        }else{
                            h = (int) (Integer.parseInt(values[2]) / 10);
                            if(h > 14){
                                ageRangeInfected[14] = ageRangeInfected[14] + 1;
                            }else {
                                ageRangeInfected[h] = ageRangeInfected[h] + 1;
                            }
                        }
                    }
                    if (args[0].equals("casos_cui") && args.length == 2){
                        Date fechaAComparar = Testeo.ParseFecha(args[1]);

                        if(!values[13].equals("0") && fechaAComparar.before(t.getFechaCuidadoDate())){
                            ParFechaCaso x = new ParFechaCaso(t.ParseFecha(values[13]), t);
                            arbol.insert(x);
                        }
                    }else if (args[0].equals("casos_cui")&& args.length < 2){

                        if(!values[13].equals("0")){
                            ParFechaCaso x = new ParFechaCaso(t.ParseFecha(values[13]), t);
                            arbol.insert(x);
                        }
                    }



                    numberOfSamples++;
                }
                bandera = true;
            }
            br.close();
        } catch (Exception e) {
           e.printStackTrace();
        }

        switch (args[0]){
            case "estad": {
                mostrarEstadisticas(numberOfSamples, numberOfDeaths, numberOfInfected, infectedBySamples,
                deceasedByInfected, ageRangeInfected, ageRangeDeath);
                break;
            }
            case "p_casos": {
                if (args.length < 2){
                    Provincia.nProvinciasConMasCasos(testeos);
                }
                else if (Integer.parseInt(args[1]) > 0 && Integer.parseInt(args[1]) < 25){
                    Provincia.nProvinciasConMasCasos(testeos, Integer.parseInt(args[1]));
                }
                else {
                    System.out.println("****************** N ERRONEO *********************");
                }
                break;
            }

            case "p_muertes": {
                if (args.length < 2){
                    Provincia.nProvinciasConMasMuertes(testeos);
                }
                else if (Integer.parseInt(args[1]) > 0 && Integer.parseInt(args[1]) < 25){
                    Provincia.nProvinciasConMasMuertes(testeos, Integer.parseInt(args[1]));
                }
                else {
                    System.out.println("****************** N ERRONEO *********************");
                }
                break;
            }
            case "casos_edad": {
                if (args.length < 2){
                    System.out.println("****************** N ERRONEO *********************");
                    break;
                }
                if (Integer.parseInt(args[1]) > 0 && Integer.parseInt(args[1]) < 125){
                    Provincia.casosEdadAnios(testeos, Integer.parseInt(args[1]));
                }
                else {
                    System.out.println("****************** N ERRONEO *********************");
                }
                break;
            }

            case "casos_cui": {
                   arbol.printTree();
                   break;
            }

            default:{
                System.out.println("*************** ARGUMENTO NO VALIDO *******************");
                break;
            }
        }


    }

    public static void mostrarEstadisticas(int numberOfSamples, int numberOfDeaths, int numberOfInfected , float infectedBySamples,
                             float deceasedByInfected, Integer[] ageRangeInfected, Integer[] ageRangeDeath){
        System.out.println("\n\n ************************* ESTADISTICAS ******************************\n\n");
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
    }


}




