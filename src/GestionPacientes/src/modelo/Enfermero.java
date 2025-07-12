package modelo;

import java.util.ArrayList;
import java.util.List;

public class Enfermero extends Persona {
    private static final Enfermero[] Enfermero = null;
	private List<Paciente> pacientesAsignados;

    public Enfermero(int ID, String DNI, String Nombre, String ApellidoPaterno,
                    String ApellidoMaterno, int Edad, String Sexo,
                    Usuario usuario) {
        super(ID, DNI, Nombre, ApellidoPaterno, ApellidoMaterno, Edad, Sexo, usuario, new Rol(2, "ENFERMERO"));
        this.pacientesAsignados = new ArrayList<>();
    }
    // Métodos optimizados para gestión de pacientes
    public boolean asignarPaciente(Paciente paciente) {
        if (paciente == null || pacientesAsignados.contains(paciente)) {
            return false;
        }
        return pacientesAsignados.add(paciente);
    }

    public boolean eliminarPaciente(String dniPaciente) {
        return pacientesAsignados.removeIf(p -> p.getDNI().equals(dniPaciente));
    }

    public List<Paciente> getPacientesAsignados() {
        return new ArrayList<>(pacientesAsignados); // Retorna copia defensiva
    }

    public boolean tienePaciente(String dniPaciente) {
        return pacientesAsignados.stream().anyMatch(p -> p.getDNI().equals(dniPaciente));
    }

    @Override
    public String toString() {
        return String.format("%s %s (Enfermero - %d pacientes)", 
               getNombre(), getApellidoPaterno(), pacientesAsignados.size());
    }
    public static Enfermero EnfermeroDeUsuario(Usuario usuario) {
    	for (Enfermero e : BaseDatosSimulada.getListaEnfermeros()) {
    	    if (e.getUsuario().equals(usuario)) {
    	        return e;
    	    }
    	}
    	return null; 
    }
}