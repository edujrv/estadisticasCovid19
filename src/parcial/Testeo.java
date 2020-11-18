package parcial;
import java.util.Date;
import java.text.*;

public class Testeo implements Comparable<Testeo> {

    private int idEventoCaso;
    private char sexo;
    private int edad;
    private String edadTipo;
    private String residenciaPais;
    private String residenciaProvincia;
    private String residenciaDepartamento;
    private String cargaProvincia;
    private String fechaInicioSintomas;
    private String fechaApertura;
    private String sepiApertura;
    private String fechaInternacion;
    private String cuidadoIntensivo; //Verdadero -> Estuvo en cuidado
    private String fechaCuidadoIntensivo;
    private String fallecido; //Verdadero->Muerto //hatch en cs = verdadero
    private String fechaFallecimiento;
    private String asistenciaRespiratoriaMecanica; //Verdadero-> Tuvo asistencia
    private int cargaProvinciaId;
    private String origenFinanciamiento; //Verdadero-> Tenia obra social

    private String clasificacion;
    private String clasificacionResumen;
    private int residenciaProvinciaId;
    private String fechaDiagnostico;
    private int residenciaDepartamentoId;
    private String ultimaActualizacion; //Fecha

    private Date fechaCuidadoDate;
    //****************************** BUILDER *****************************************
    Testeo() {

    }
    public Testeo(int idEventoCaso, char sexo, int edad, String edadTipo, String residenciaPais, String residenciaProvincia, String residenciaDepartamento, String cargaProvincia,
                  String fechaInicioSintomas, String fechaApertura, String sepiApertura, String fechaInternacion, String cuidadoIntensivo,String fechaCuidadoIntensivo,
                  String fallecido, String fechaFallecimiento, String asistenciaRespiratoriaMecanica,
                  int cargaProvinciaId, String origenFinanciamiento,  String clasificacion, String clasificacionResumen, int residenciaProvinciaId,
                  String fechaDiagnostico, int residenciaDepartamentoId, String ultimaActualizacion){


        this.idEventoCaso = idEventoCaso;
        this.sexo = sexo;
        this.edad = edad;
        this.edadTipo = edadTipo;
        this.residenciaPais = residenciaPais;
        this.residenciaProvincia = residenciaProvincia;
        this.residenciaDepartamento = residenciaDepartamento;
        this.cargaProvincia = cargaProvincia;
        this.fechaInicioSintomas = fechaInicioSintomas;
        this.fechaApertura = fechaApertura;
        this.sepiApertura = sepiApertura;
        this.fechaInternacion = fechaInternacion;
        this.cuidadoIntensivo = cuidadoIntensivo;

        this.fechaCuidadoIntensivo = fechaCuidadoIntensivo;
        this.fallecido = fallecido;
        this.fechaFallecimiento = fechaFallecimiento;
        this.asistenciaRespiratoriaMecanica = asistenciaRespiratoriaMecanica;
        this.cargaProvinciaId = cargaProvinciaId;
        this.origenFinanciamiento = origenFinanciamiento;
        this.clasificacion = clasificacion;
        this.clasificacionResumen = clasificacionResumen;
        this.residenciaProvinciaId = residenciaProvinciaId;
        this.fechaDiagnostico = fechaDiagnostico;
        this.residenciaDepartamentoId = residenciaDepartamentoId;
        this.ultimaActualizacion = ultimaActualizacion;

        this.fechaCuidadoDate = ParseFecha(fechaCuidadoIntensivo);

    }
//************************** FIN BUILDER ****************************************


//************************** INICIO GETTERS **************************************

    public int getIdEventoCaso() {
        return idEventoCaso;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String isEdadTipo() {
        return edadTipo;
    }

    public String getResidenciaPais() {
        return residenciaPais;
    }

    public String getResidenciaProvincia() {
        return residenciaProvincia;
    }

    public String getResidenciaDepartamento() {
        return residenciaDepartamento;
    }

    public String getCargaProvincia() {
        return cargaProvincia;
    }

    public String getFechaInicioSintomas() {
        return fechaInicioSintomas;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public String getSepiApertura() {
        return sepiApertura;
    }

    public String getFechaInternacion() {
        return fechaInternacion;
    }

    public String isCuidadoIntensivo() {
        return cuidadoIntensivo;
    }

    public String getFechaCuidadoIntensivo() {
        return fechaCuidadoIntensivo;
    }

    public boolean isFallecido() {
        return fallecido.equalsIgnoreCase("SI");
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public String isAsistenciaRespiratoriaMecanica() {
        return asistenciaRespiratoriaMecanica;
    }

    public int getCargaProvinciaId() {
        return cargaProvinciaId;
    }

    public String isOrigenFinanciamiento() {
        return origenFinanciamiento;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getClasificacionResumen() {
        return clasificacionResumen;
    }

    public int getResidenciaProvinciaId() {
        return residenciaProvinciaId;
    }

    public String getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public int getResidenciaDepartamentoId() {
        return residenciaDepartamentoId;
    }

    public String getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public Date getFechaCuidadoDate(){ return fechaCuidadoDate;}

    public void printData() {
        System.out.println(idEventoCaso + " - " + sexo + " - " + edad + " - " + edadTipo + " - " + residenciaPais + " - " + residenciaProvincia + " - " + residenciaDepartamento + " - " + cargaProvincia + " - " +
                fechaInicioSintomas + " - " + fechaApertura + " - " + sepiApertura + " - " + fechaInternacion + " - " + cuidadoIntensivo + " - " + fechaCuidadoIntensivo + " - " + fallecido + " - " + fechaFallecimiento + " - " +
                asistenciaRespiratoriaMecanica + " - " + cargaProvinciaId + " - " + origenFinanciamiento + " - " + clasificacion + " - " + clasificacionResumen + " - " + residenciaProvinciaId + " - " +
                fechaDiagnostico + " - " + residenciaDepartamentoId + " - " + ultimaActualizacion);
    }

    public String getData() {
        String aux;
        aux = idEventoCaso + " - " + sexo + " - " + edad + " - " + edadTipo + " - " + residenciaPais + " - " + residenciaProvincia + " - " + residenciaDepartamento + " - " + cargaProvincia + " - " +
                fechaInicioSintomas + " - " + fechaApertura + " - " + sepiApertura + " - " + fechaInternacion + " - " + cuidadoIntensivo + " - " + fechaCuidadoIntensivo + " - " + fallecido + " - " + fechaFallecimiento + " - " +
                asistenciaRespiratoriaMecanica + " - " + cargaProvinciaId + " - " + origenFinanciamiento + " - " + clasificacion + " - " + clasificacionResumen + " - " + residenciaProvinciaId + " - " +
                fechaDiagnostico + " - " + residenciaDepartamentoId + " - " + ultimaActualizacion;
        return aux;
    }

    @Override
    public int compareTo(Testeo testeo) {
        if (fechaCuidadoDate.compareTo(testeo.fechaCuidadoDate)== -1) {
            return -1;
        }
        if (fechaCuidadoDate.compareTo(testeo.fechaCuidadoDate)== 1) {
            return 1;
        }
        return 0;
    }

//**************************FIN GETTERS **************************************

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