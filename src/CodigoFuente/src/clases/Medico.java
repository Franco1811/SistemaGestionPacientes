package clases;

import java.util.ArrayList;
import java.util.List;
public class Medico extends Persona {
    private String Especialidad;
    private static List<Medico> Medicos = new ArrayList<>();
    private static int count=0;
    public Medico(String nombre, String Apellido,String especialidad, Usuario usuario, String DNI) {
    	this.ID = count++;
        this.Nombre = nombre;
        this.Apellido = Apellido;
        this.Especialidad = especialidad;
        this.Usuario = usuario;
        this.DNI = DNI;
        registrarUsuario();
    }
    private void registrarUsuario() {
        synchronized (Medicos) {
        	Medicos.add(this);
        }
    }
    
	public static List<Medico> getMedicos() {
		return Medicos;
	}
	public static void setMedicos(List<Medico> medicos) {
		Medicos = medicos;
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEspecialidad() {
		return Especialidad;
	}

	public void setEspecialidad(String especialidad) {
		Especialidad = especialidad;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
    
}