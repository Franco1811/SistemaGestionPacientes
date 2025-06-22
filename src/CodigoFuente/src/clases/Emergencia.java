package clases;

import java.util.Date;

public class Emergencia {
	private int ID;
	private Paciente Paciente;
	private String Motivo;
	private Date FechaIngreso;

    public Emergencia(int ID, Paciente paciente, String motivo, Date fechaIngreso) {
        this.ID = ID;
        this.Paciente = paciente;
        this.Motivo = motivo;
        this.FechaIngreso = fechaIngreso;
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Paciente getPaciente() {
		return Paciente;
	}

	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}

	public String getMotivo() {
		return Motivo;
	}

	public void setMotivo(String motivo) {
		Motivo = motivo;
	}

	public Date getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}
	
}
