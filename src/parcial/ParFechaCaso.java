package parcial;

import java.util.Date;

public class ParFechaCaso implements  Comparable <ParFechaCaso> {

    public Date fecha;
    public Testeo caso;


    public ParFechaCaso(Date fecha, Testeo caso) {
        this.fecha = fecha;
        this.caso = caso;
    }



    @Override
    public int compareTo(ParFechaCaso o) {
        if (fecha.compareTo(o.fecha) < 0) {
            return -1;
        }
        if (fecha.compareTo(o.fecha) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString(){

        return caso.getData();
    }


    public String toString(Date fecha){
        if (fecha.compareTo(this.fecha) < 0)
        return caso.getData();
        return null;
    }
}