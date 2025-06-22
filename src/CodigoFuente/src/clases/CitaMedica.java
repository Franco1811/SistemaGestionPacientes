package clases;
import java.util.Date;
public class CitaMedica {
	private int ID;
	private String Nombre;
	private String Especialidad;
	private Medico Medico;
	private Date fechaHora;
	private int durMinutos;
	private String Motivo;
	private String Estado;
	
	public CitaMedica(int ID, String Nombre, String especialidad,Medico medico, Date fecha, int durminutos,String Motivo, String estado) {
		this.ID = ID;
		this.Nombre = Nombre;
		this.Especialidad = especialidad;
		this.Medico = medico;
		this.fechaHora = fecha;
		this.durMinutos= durminutos;
		this.Motivo = Motivo;
		this.Estado = estado;
	}
	
	
	
	
	//Getters and setters
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
	public Medico getMedico() {
		return Medico;
	}
	public void setMedico(Medico medico) {
		Medico = medico;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public int getDurMinutos() {
		return durMinutos;
	}
	public void setDurMinutos(int durMinutos) {
		this.durMinutos = durMinutos;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
}
