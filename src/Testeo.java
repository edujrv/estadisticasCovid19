public class Testeo{

    private int idEventoCaso;
    private char sexo;
    private int edad;
    private boolean edadTipo; // 1 -> meses //// 0 -> anios
    private String residenciaPais;
    private String residenciaProvincia;
    private String residenciaDepartamento;
    private String cargaProvincia;
    private String fechaInicioSintomas;
    private String fechaApertura;
    private String sepiApertura;
    private String fechaInternacion;
    private boolean cuidadoIntensivo; //Verdadero -> Estuvo en cuidado
    private String fechaCuidadoIntensivo;
    private boolean fallecido; //Verdadero->Muerto //hatch en cs = verdadero
    private String fechaFallecimiento;
    private boolean asistenciaRespiratoriaMecanica; //Verdadero-> Tuvo asistencia
    private int cargaProvinciaId;
    private boolean origenFinanciamiento; //Verdadero-> Tenia obra social
    private String clasificacion;
    private String clasificacionResumen;
    private int residenciaProvinciaId;
    private String fechaDiagnostico;
    private int residenciaDepartamentoId;
    private String ultimaActualizacion; //Fecha

    //****************************** BUILDER *****************************************
    Testeo() {

    }
    public Testeo(int idEventoCaso, char sexo, int edad, boolean edadTipo, String residenciaPais, String residenciaProvincia, String residenciaDepartamento, String cargaProvincia, String fechaInicioSintomas, String fechaApertura, String sepiApertura, String fechaInternacion, boolean cuidadoIntensivo, boolean fallecido, String fechaCuidadoIntensivo,String fechaFallecimiento, boolean asistenciaRespiratoriaMecanica, int cargaProvinciaId, boolean origenFinanciamiento,  String clasificacion, String clasificacionResumen, int residenciaProvinciaId, String fechaDiagnostico, int residenciaDepartamentoId, String ultimaActualizacion){


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

    public boolean isEdadTipo() {
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

    public boolean isCuidadoIntensivo() {
        return cuidadoIntensivo;
    }

    public String getFechaCuidadoIntensivo() {
        return fechaCuidadoIntensivo;
    }

    public boolean isFallecido() {
        return fallecido;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public boolean isAsistenciaRespiratoriaMecanica() {
        return asistenciaRespiratoriaMecanica;
    }

    public int getCargaProvinciaId() {
        return cargaProvinciaId;
    }

    public boolean isOrigenFinanciamiento() {
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
//**************************FIN GETTERS **************************************





}