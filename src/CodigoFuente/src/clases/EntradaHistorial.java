package clases;

import java.util.Date;
import java.util.List;

public class EntradaHistorial {
    private int ID;
    private Date Fecha;
    private String Descripcion;
    private String ArchAdjunto;
    private List<String> Obs;

    // Constructor
    public EntradaHistorial(int ID, Date fecha, String descripcion, String archAdjunto, List<String> obs) {
        this.ID = ID;
        this.Fecha = fecha;
        this.Descripcion = descripcion;
        this.ArchAdjunto = archAdjunto;
        this.Obs = obs;
    }

    // Getters y Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        this.Fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public String getArchAdjunto() {
        return ArchAdjunto;
    }

    public void setArchAdjunto(String archAdjunto) {
        this.ArchAdjunto = archAdjunto;
    }

    public List<String> getObs() {
        return Obs;
    }

    public void setObs(List<String> obs) {
        this.Obs = obs;
    }
}