package modelo;

public class Rol {
	public static final String PACIENTE = "PACIENTE";
    public static final String MEDICO = "MEDICO";
    public static final String ADMINISTRADOR = "ADMINISTRADOR";
    public static final String ENFERMERO = "ENFERMERO";
    public static final String FARMACEUTICO = "FARMACEUTICO";
    public static final String LABORATORIO = "LABORATORIO";
    public static final String RECEPCIONISTA = "RECEPCIONISTA";

    private int ID;
    private String Nombre;
	public Rol(int iD, String nombre) {
		super();
		ID = iD;
		Nombre = nombre;
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
	public static String getPaciente() {
		return PACIENTE;
	}
	public static String getMedico() {
		return MEDICO;
	}
	public static String getAdministrador() {
		return ADMINISTRADOR;
	}
	public static String getenefermero() {
		return ENFERMERO;
	}
	
    
    
    
	
    

}
