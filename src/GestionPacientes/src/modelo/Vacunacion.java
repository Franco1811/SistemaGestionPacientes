package modelo;
import java.util.Date;



public class Vacunacion {
    private int ID;
    private Paciente Paciente;
    private String Vacuna;
    private Date Fecha;
    
	public Vacunacion(int iD, modelo.Paciente paciente, String vacuna, Date fecha) {
		super();
		ID = iD;
		Paciente = paciente;
		Vacuna = vacuna;
		Fecha = fecha;
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
