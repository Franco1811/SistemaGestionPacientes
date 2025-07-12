package modelo;

import java.util.Date;
import java.util.List;

public class Entrega {
    private int idEntrega;
    private String idReceta;
    private boolean recetaUtilizada;
    private Paciente paciente;
    private Date fecha;
    private List<MedicamentoEntregado> listaMedicamentos;

    public Entrega(int idEntrega, String idReceta,boolean recetaUtilizada,Paciente paciente, Date fecha, List<MedicamentoEntregado> listaMedicamentos) {
        this.idEntrega = idEntrega;
        this.idReceta = idReceta;
        this.recetaUtilizada = recetaUtilizada;
        this.paciente = paciente;
        this.fecha = fecha;
        this.listaMedicamentos = listaMedicamentos;
    }

    public int getIdEntrega() {
        return idEntrega;
    }
    
    public String getIdReceta() {
        return idReceta;
    }

    public boolean isRecetaUtilizada() {
        return recetaUtilizada;
    }

    public void setRecetaUtilizada(boolean recetaUtilizada) {
        this.recetaUtilizada = recetaUtilizada;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<MedicamentoEntregado> getListaMedicamentos() {
        return listaMedicamentos;
    }
}
