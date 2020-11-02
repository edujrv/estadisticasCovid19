import java.io.*;
import java.util.*;

class Main {

    public static void main (String[] args){
        List<Testeo> testeos = new ArrayList<>();
        try{
            try (BufferedReader br = new BufferedReader(new FileReader("resources/CasosCovid19.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    for(int i=0; i < values.length; i ++){
                        if(values[i].length() > 1){
                            values[i] = values[i].substring(1, values[i].length() - 1);
                        }


                        System.out.print(values[i] + "  ");
                    }
                    System.out.println("");

                    Testeo t = new Testeo();
                    // TODO: Hacer todos los sets

                    testeos.add(t);
                }

            }
        } catch(Exception e){
            e.printStackTrace();
        }




    }
}