package clases;

import java.util.Date;

public class Vacunacion {
    private int ID;
    private Paciente Paciente;
    private String Vacuna;
    private Date Fecha;
    
    public Vacunacion(int ID, Paciente paciente, String vacuna, Date fecha) {
        this.ID = ID;
        this.Paciente = paciente;
        this.Vacuna = vacuna;
        this.Fecha = fecha;
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

	public String getVacuna() {
		return Vacuna;
	}

	public void setVacuna(String vacuna) {
		Vacuna = vacuna;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
    
}