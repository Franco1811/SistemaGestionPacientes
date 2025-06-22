package clases;

import java.util.Date;

public class ResultadoLaboratorio {
    private int ID;
    private Paciente Paciente;
    private String Examen;
    private String Resultado;
    private Date Fecha;
    
    public ResultadoLaboratorio(int ID, Paciente paciente, String examen, String resultado, Date fecha) {
        this.ID = ID;
        this.Paciente = paciente;
        this.Examen = examen;
        this.Resultado = resultado;
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

	public String getExamen() {
		return Examen;
	}

	public void setExamen(String examen) {
		Examen = examen;
	}

	public String getResultado() {
		return Resultado;
	}

	public void setResultado(String resultado) {
		Resultado = resultado;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
    
}