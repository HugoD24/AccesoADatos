package EJ07;

import java.time.LocalDate;
import java.util.Date;

public class Alumno {
    private String NRE;
    private String NOMBRE;
    private String APELLIDOS;
    private String TELEFONO;
    private LocalDate FECHANAC;
    private boolean BECA;

    public Alumno(String NRE, String NOMBRE, String APELLIDOS, String TELEFONO, LocalDate FECHANAC, boolean BECA) {
        this.NRE = NRE;
        this.NOMBRE = NOMBRE;
        this.APELLIDOS = APELLIDOS;
        this.TELEFONO = TELEFONO;
        this.FECHANAC = FECHANAC;
        this.BECA = BECA;
    }

    public String getNRE() {
        return NRE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public LocalDate getFECHANAC() {
        return FECHANAC;
    }

    public boolean isBECA() {
        return BECA;
    }

    public void setNRE(String NRE) {
        this.NRE = NRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public void setFECHANAC(LocalDate FECHANAC) {
        this.FECHANAC = FECHANAC;
    }

    public void setBECA(boolean BECA) {
        this.BECA = BECA;
    }
}
