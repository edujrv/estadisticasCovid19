package parcial;

import java.util.Arrays;
import java.util.Collection;


public  class Provincia{

    public static void nProvinciasConMasCasos(HashTableOpen<String> testeos, int n) throws Exception {
        n = n-1;
        Provincia2[] arrayProv = new Provincia2[24];

        arrayProv[0] = new Provincia2("Buenos Aires", testeos.getSize("Buenos Aires"));
        arrayProv[1] = new Provincia2("CABA", testeos.getSize("CABA"));
        arrayProv[2] = new Provincia2("Catamarca", testeos.getSize("Catamarca"));
        arrayProv[3] = new Provincia2("Chaco", testeos.getSize("Chaco"));
        arrayProv[4] = new Provincia2("Chubut", testeos.getSize("Chubut"));
        arrayProv[5] = new Provincia2("Córdoba", testeos.getSize("Córdoba"));
        arrayProv[6] = new Provincia2("Corrientes", testeos.getSize("Corrientes"));
        arrayProv[7] = new Provincia2("Entre Ríos", testeos.getSize("Entre Ríos"));
        arrayProv[8] = new Provincia2("Formosa", testeos.getSize("Formosa"));
        arrayProv[9] = new Provincia2("Jujuy", testeos.getSize("Jujuy"));
        arrayProv[10] = new Provincia2("La Pampa", testeos.getSize("La Pampa"));
        arrayProv[11] = new Provincia2("La Rioja", testeos.getSize("La Rioja"));
        arrayProv[12] = new Provincia2("Mendoza", testeos.getSize("Mendoza"));
        arrayProv[13] = new Provincia2("Misiones", testeos.getSize("Misiones"));
        arrayProv[14] = new Provincia2("Neuquén", testeos.getSize("Neuquén"));
        arrayProv[15] = new Provincia2("Río Negro", testeos.getSize("Río Negro"));
        arrayProv[16] = new Provincia2("Salta", testeos.getSize("Salta"));
        arrayProv[17] = new Provincia2("San Juan", testeos.getSize("San Juan"));
        arrayProv[18] = new Provincia2("San Luis", testeos.getSize("San Luis"));
        arrayProv[19] = new Provincia2("Santa Cruz", testeos.getSize("Santa Cruz"));
        arrayProv[20] = new Provincia2("Santa Fe", testeos.getSize("Santa Fe"));
        arrayProv[21] = new Provincia2("Santiago del Estero", testeos.getSize("Santiago del Estero"));
        arrayProv[22] = new Provincia2("Tierra del Fuego", testeos.getSize("Tierra del Fuego"));
        arrayProv[23] = new Provincia2("Tucumán", testeos.getSize("Tucumán"));


        Arrays.sort(arrayProv);
        System.out.println("\n\n*************************************** LAS "+ (n+1) +" PROVINCIAS CON MAYOR CANTIDAD DE CASOS **********************************\n\n");
        for (int i = arrayProv.length - 1;  i >= 0 && n >= 0; i--, n--) {
            System.out.println(arrayProv[i].nombre + ": " + arrayProv[i].cant);
            testeos.printList(arrayProv[i].nombre);
            System.out.println("");
        }
        System.out.println("\n\n*****************************************************************************************************************************\n\n");
    }

    public static void nProvinciasConMasCasos(HashTableOpen<String> testeos) throws Exception {
            nProvinciasConMasCasos(testeos, 24);
    }

    public static void nProvinciasConMasMuertes(HashTableOpen<String> testeos, int n) throws Exception {
        n = n-1;
        Provincia2[] arrayProv = new Provincia2[24];

        arrayProv[0] = new Provincia2("Buenos Aires", testeos.getCantMuerte("Buenos Aires"));
        arrayProv[1] = new Provincia2("CABA", testeos.getCantMuerte("CABA"));
        arrayProv[2] = new Provincia2("Catamarca", testeos.getCantMuerte("Catamarca"));
        arrayProv[3] = new Provincia2("Chaco", testeos.getCantMuerte("Chaco"));
        arrayProv[4] = new Provincia2("Chubut", testeos.getCantMuerte("Chubut"));
        arrayProv[5] = new Provincia2("Córdoba", testeos.getCantMuerte("Córdoba"));
        arrayProv[6] = new Provincia2("Corrientes", testeos.getCantMuerte("Corrientes"));
        arrayProv[7] = new Provincia2("Entre Ríos", testeos.getCantMuerte("Entre Ríos"));
        arrayProv[8] = new Provincia2("Formosa", testeos.getCantMuerte("Formosa"));
        arrayProv[9] = new Provincia2("Jujuy", testeos.getCantMuerte("Jujuy"));
        arrayProv[10] = new Provincia2("La Pampa", testeos.getCantMuerte("La Pampa"));
        arrayProv[11] = new Provincia2("La Rioja", testeos.getCantMuerte("La Rioja"));
        arrayProv[12] = new Provincia2("Mendoza", testeos.getCantMuerte("Mendoza"));
        arrayProv[13] = new Provincia2("Misiones", testeos.getCantMuerte("Misiones"));
        arrayProv[14] = new Provincia2("Neuquén", testeos.getCantMuerte("Neuquén"));
        arrayProv[15] = new Provincia2("Río Negro", testeos.getCantMuerte("Río Negro"));
        arrayProv[16] = new Provincia2("Salta", testeos.getCantMuerte("Salta"));
        arrayProv[17] = new Provincia2("San Juan", testeos.getCantMuerte("San Juan"));
        arrayProv[18] = new Provincia2("San Luis", testeos.getCantMuerte("San Luis"));
        arrayProv[19] = new Provincia2("Santa Cruz", testeos.getCantMuerte("Santa Cruz"));
        arrayProv[20] = new Provincia2("Santa Fe", testeos.getCantMuerte("Santa Fe"));
        arrayProv[21] = new Provincia2("Santiago del Estero", testeos.getCantMuerte("Santiago del Estero"));
        arrayProv[22] = new Provincia2("Tierra del Fuego", testeos.getCantMuerte("Tierra del Fuego"));
        arrayProv[23] = new Provincia2("Tucumán", testeos.getCantMuerte("Tucumán"));

        Arrays.sort(arrayProv);
        System.out.println("\n\n*************************************** LAS "+ (n+1) +" PROVINCIAS CON MAYOR CANTIDAD DE MUERTOS ******************************\n\n");
        for (int i = arrayProv.length - 1;  i >= 0 && n >= 0; i--, n--) {
            System.out.println(arrayProv[i].nombre + ": " + arrayProv[i].cant);
            testeos.printDeaths(arrayProv[i].nombre);
            System.out.println("");
        }
        System.out.println("\n\n*****************************************************************************************************************************\n\n");
    }

    public static void nProvinciasConMasMuertes(HashTableOpen<String> testeos) throws Exception {
        nProvinciasConMasMuertes(testeos, 24);
    }


    public static void casosEdadAnios(HashTableOpen<String> testeos, int n) throws Exception {

        Provincia2[] arrayProv = new Provincia2[24];

        arrayProv[0] = new Provincia2("Buenos Aires", testeos.getSize("Buenos Aires"));
        arrayProv[1] = new Provincia2("CABA", testeos.getSize("CABA"));
        arrayProv[2] = new Provincia2("Catamarca", testeos.getSize("Catamarca"));
        arrayProv[3] = new Provincia2("Chaco", testeos.getSize("Chaco"));
        arrayProv[4] = new Provincia2("Chubut", testeos.getSize("Chubut"));
        arrayProv[5] = new Provincia2("Córdoba", testeos.getSize("Córdoba"));
        arrayProv[6] = new Provincia2("Corrientes", testeos.getSize("Corrientes"));
        arrayProv[7] = new Provincia2("Entre Ríos", testeos.getSize("Entre Ríos"));
        arrayProv[8] = new Provincia2("Formosa", testeos.getSize("Formosa"));
        arrayProv[9] = new Provincia2("Jujuy", testeos.getSize("Jujuy"));
        arrayProv[10] = new Provincia2("La Pampa", testeos.getSize("La Pampa"));
        arrayProv[11] = new Provincia2("La Rioja", testeos.getSize("La Rioja"));
        arrayProv[12] = new Provincia2("Mendoza", testeos.getSize("Mendoza"));
        arrayProv[13] = new Provincia2("Misiones", testeos.getSize("Misiones"));
        arrayProv[14] = new Provincia2("Neuquén", testeos.getSize("Neuquén"));
        arrayProv[15] = new Provincia2("Río Negro", testeos.getSize("Río Negro"));
        arrayProv[16] = new Provincia2("Salta", testeos.getSize("Salta"));
        arrayProv[17] = new Provincia2("San Juan", testeos.getSize("San Juan"));
        arrayProv[18] = new Provincia2("San Luis", testeos.getSize("San Luis"));
        arrayProv[19] = new Provincia2("Santa Cruz", testeos.getSize("Santa Cruz"));
        arrayProv[20] = new Provincia2("Santa Fe", testeos.getSize("Santa Fe"));
        arrayProv[21] = new Provincia2("Santiago del Estero", testeos.getSize("Santiago del Estero"));
        arrayProv[22] = new Provincia2("Tierra del Fuego", testeos.getSize("Tierra del Fuego"));
        arrayProv[23] = new Provincia2("Tucumán", testeos.getSize("Tucumán"));



        System.out.println("\n\n*************************************** CASOS DE PROVINCIAS CON "+ n +" ANIOS **********************************\n\n");

        for (int i =0; i < arrayProv.length; i++) {
            System.out.println(arrayProv[i].nombre);
                for(int j= 0; j < testeos.getSize(arrayProv[i].nombre)-1; j++){
                    testeos.printAnios(arrayProv[i].nombre, n);

                }
            System.out.println("Total: " + testeos.getCantAnios(arrayProv[i].nombre));
                System.out.println("");

        }
        System.out.println("\n\n*****************************************************************************************************************************\n\n");
    }


     static class Provincia2 implements  Comparable <Provincia2> {

        public String nombre;
        public int cant = 0;


        public Provincia2(String nombre, int cant) {
            this.nombre = nombre;
            this.cant = cant;
        }

        @Override
        public int compareTo(Provincia2 o) {
            if (cant < o.cant) {
                return -1;
            }
            if (cant > o.cant) {
                return 1;
            }
            return 0;
        }
    }







}


