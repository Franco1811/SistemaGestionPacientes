package clases;

import java.util.List;

public class RecetaMedica {
    private int ID;
    private Medico Medico;
    private Paciente Paciente;
    private List<Medicamentos> Medicamentos;
    private boolean Usada;
    
    public RecetaMedica(int ID, Medico medico, Paciente paciente, List<Medicamentos> medicamentos, boolean usada) {
        this.ID = ID;
        this.Medico = medico;
        this.Paciente = paciente;
        this.Medicamentos = medicamentos;
        this.Usada = usada;
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Medico getMedico() {
		return Medico;
	}

	public void setMedico(Medico medico) {
		Medico = medico;
	}

	public Paciente getPaciente() {
		return Paciente;
	}

	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}

	public List<Medicamentos> getMedicamentos() {
		return Medicamentos;
	}

	public void setMedicamentos(List<Medicamentos> medicamentos) {
		Medicamentos = medicamentos;
	}

	public boolean isUsada() {
		return Usada;
	}

	public void setUsada(boolean usada) {
		Usada = usada;
	}
    
}