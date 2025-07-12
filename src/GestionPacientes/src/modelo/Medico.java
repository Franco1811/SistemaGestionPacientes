package modelo;
import java.util.ArrayList;
import java.util.List;
public class Medico extends Persona {
	private String Especialidad;
	private static List<Medico> Medicos = new ArrayList<>();
	private static int count=0;
	
	public Medico(
		    String nombre,
		    String apellidoPaterno,
		    String apellidoMaterno,
		    int edad,
		    String sexo,
		    String especialidad,
		    Usuario usuario,
		    String DNI
		) {
		    super(
		        count++,           // ID
		        DNI,
		        nombre,
		        apellidoPaterno,
		        apellidoMaterno,
		        edad,
		        sexo,
		        usuario
		    );
		    this.Especialidad = especialidad;
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
	public static Medico MedicoDeUsuario(Usuario usuario) {
    	for (Medico e : BaseDatosSimulada.getListaMedicos()) {
    	    if (e.getUsuario().equals(usuario)) {
    	        return e;
    	    }
    	}
    	return null; 
    }
}
