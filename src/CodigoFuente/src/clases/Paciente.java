package clases;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
public class Paciente extends Persona{
    private Date FechaNac;
    private int Telefono;
    private String Email;
    private String Direccion;
    private static List<Paciente> Pacientes = new ArrayList<>();
 
	private static int count=0;
    private static final SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public Paciente(String nombre, String apellido, String DNI, Date fechaNac, int telefono, String email, String direccion, Usuario Usuario) {
        Paciente.FormatoFecha.setLenient(false);
    	this.ID = count++;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.DNI = DNI;
        this.FechaNac = fechaNac;
        this.Telefono = telefono;
        this.Email = email;
        this.Direccion = direccion;
        this.Usuario = Usuario;
        this.Rol = new Rol(1,"Paciente");
       
    }

    
    public static void registrarPaciente(String nombre, String apellido, String DNI, String fechaNac, 
            int telefono, String email, String direccion, 
            String userName, String password) throws ParseException {

    if (nombre != null && !nombre.isEmpty() &&
	apellido != null && !apellido.isEmpty() &&
	DNI != null && !DNI.isEmpty() &&
	fechaNac != null && !fechaNac.isEmpty() &&
	telefono > 900000000 && telefono < 999999999 &&
	direccion != null && !direccion.isEmpty() && fechaNac.matches("\\d{2}/\\d{2}/\\d{4}") &&
	userName != null && !userName.isEmpty() &&
	password != null && !password.isEmpty()) {


	Date fecha = FormatoFecha.parse(fechaNac);
	Usuario tempus = new Usuario(userName, password, new Rol(1, "Paciente"), true);
	Paciente temp = new Paciente(nombre, apellido, DNI, fecha, telefono, email, direccion, tempus);
	Pacientes.add((Paciente) temp);
	JOptionPane.showMessageDialog(null,"Registro completado");
	}else {
		JOptionPane.showMessageDialog(null,"Error: Verifique los datos ingresados.");
	}
	}
    
    
    public static List<Paciente> getPacientes() {
 		return Pacientes;
 	}

 	public static void setPacientes(List<Paciente> pacientes) {
 		Pacientes = pacientes;
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

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Date getFechaNac() {
		return FechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		FechaNac = fechaNac;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
    
}