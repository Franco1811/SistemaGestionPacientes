package modelo;
import java.util.List;



public class HistorialClinico {
    private int ID;
    private Paciente Paciente;
    private List<EntradaHistorial> Entradas;
    
	public HistorialClinico(int iD, modelo.Paciente paciente, List<EntradaHistorial> entradas) {
		super();
		ID = iD;
		Paciente = paciente;
		Entradas = entradas;
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

	public List<EntradaHistorial> getEntradas() {
		return Entradas;
	}

	public void setEntradas(List<EntradaHistorial> entradas) {
		Entradas = entradas;
	}
	
	

    
}
