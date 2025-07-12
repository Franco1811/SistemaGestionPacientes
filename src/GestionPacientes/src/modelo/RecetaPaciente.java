package modelo;

import java.util.Date;

public class RecetaPaciente {
    private int id;
    private String dniPaciente;
    private String nombreMedico;
    private String textoReceta;
    private Date fechaEmision;

    public RecetaPaciente(String dniPaciente, String nombreMedico, String textoReceta) {
        this.dniPaciente = dniPaciente;
        this.nombreMedico = nombreMedico;
        this.textoReceta = textoReceta;
        this.fechaEmision = new Date();
    }

    // Getters
    public int getId() { return id; }
    public String getDniPaciente() { return dniPaciente; }
    public String getNombreMedico() { return nombreMedico; }
    public String getTextoReceta() { return textoReceta; }
    public Date getFechaEmision() { return fechaEmision; }
    
    // Setter para ID (usado al guardar en la base de datos)
    public void setId(int id) { this.id = id; }
}