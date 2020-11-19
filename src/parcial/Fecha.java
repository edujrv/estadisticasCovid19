package parcial;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {


    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static Date ParseFecha(String fecha)
    {
        //SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            if(!fecha.equals("0")){
                fechaDate = formato.parse(fecha);
            }

        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

}