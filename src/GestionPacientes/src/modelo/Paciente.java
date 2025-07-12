package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends Persona {
    private Date FechaNacimiento;
    private int Telefono;
    private String Email;
    private String Direccion;
    private Date fechaRegistro;

    private static List<Paciente> Pacientes = new ArrayList<>();
    private static int count = 0;
    private static final SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public Paciente(
            String DNI,
            String Nombre,
            String ApellidoPaterno,
            String ApellidoMaterno,
            int Edad,
            String Sexo,
            Date FechaNacimiento,
            int Telefono,
            String Email,
            String Direccion,
            Usuario usuario,
            Date fechaRegistro
    ) {
        super(
                count++,
                DNI,
                Nombre,
                ApellidoPaterno,
                ApellidoMaterno,
                Edad,
                Sexo,
                usuario,
                new Rol(3, "PACIENTE")
        );

        this.FechaNacimiento = FechaNacimiento;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Direccion = Direccion;
        this.fechaRegistro = fechaRegistro;

        Paciente.Pacientes.add(this);
    }
    
    
 // Constructor alternativo que asigna automáticamente la fecha actual
    public Paciente(
            String DNI,
            String Nombre,
            String ApellidoPaterno,
            String ApellidoMaterno,
            int Edad,
            String Sexo,
            Date FechaNacimiento,
            int Telefono,
            String Email,
            String Direccion,
            Usuario usuario
    ) {
        this(
            DNI,
            Nombre,
            ApellidoPaterno,
            ApellidoMaterno,
            Edad,
            Sexo,
            FechaNacimiento,
            Telefono,
            Email,
            Direccion,
            usuario,
            new Date()  // ← Aquí se usa la fecha actual automáticamente
        );
    }


    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
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

    public static List<Paciente> getPacientes() {
        return Pacientes;
    }

    public static void setPacientes(List<Paciente> pacientes) {
        Pacientes = pacientes;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Paciente.count = count;
    }

    public static SimpleDateFormat getFormatofecha() {
        return FormatoFecha;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

    

	
	    
	    
	    

	    


