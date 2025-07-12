package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IngresoEmergencia {
    private Paciente paciente;
    private String motivo;
    private Date fechaHora;

    private static List<IngresoEmergencia> ingresos = new ArrayList<>();

    public IngresoEmergencia(Paciente paciente, String motivo, Date fechaHora) {
        this.paciente = paciente;
        this.motivo = motivo;
        this.fechaHora = fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public static List<IngresoEmergencia> getIngresos() {
        return ingresos;
    }

    public static void setIngresos(List<IngresoEmergencia> ingresos) {
        IngresoEmergencia.ingresos = ingresos;
    }
}
