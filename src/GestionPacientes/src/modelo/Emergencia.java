package modelo;
import java.util.Date;


public class Emergencia {
	private int ID;
	private Paciente Paciente;
	private String Motivo;
	private Date FechaIngreso;
	
	public Emergencia(int iD, modelo.Paciente paciente, String motivo, Date fechaIngreso) {
		super();
		ID = iD;
		Paciente = paciente;
		Motivo = motivo;
		FechaIngreso = fechaIngreso;
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
