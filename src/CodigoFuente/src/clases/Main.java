package clases;
import java.util.Date;
import java.util.List;
import interfaz.InterfazMain;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		presentarInterfaz();
		 try {
	            // 1. Datos de prueba
	            String nombre = "María";
	            String apellido = "González";
	            String dni = "87654321";
	            String fechaNac = "15/05/1990";
	            int telefono = 987654321;
	            String email = "maria.gonzalez@example.com";
	            String direccion = "Av. Principal 123";
	            String usuario = "mgonzalez";
	            String password = "ClaveSegura123";
	            // 1. datos medicos de prueba
	            Usuario usuarioMedico = new Usuario("drhouse", "password123", new Rol(2,"Medico"),true);

	            // Crear un médico de prueba
	            Medico medicoPrueba = new Medico(
	                "Gregory",              // Nombre
	                "House",                // Apellido
	                "Diagnóstico Médico",   // Especialidad
	                usuarioMedico,         // Usuario
	                "12345678A"            // DNI
	            );
	            // 2. Registrar paciente
	            System.out.println("Intentando registrar paciente...");
	            Paciente.registrarPaciente(nombre, apellido, dni, fechaNac, telefono, 
	                                     email, direccion, usuario, password);

	            // 3. Mostrar resultados
	           

	        } catch (ParseException e) {
	            System.err.println("\nError: Formato de fecha inválido. Use dd/MM/yyyy");
	            e.printStackTrace();
	        } catch (IllegalArgumentException e) {
	            System.err.println("\nError: " + e.getMessage());
	        } catch (Exception e) {
	            System.err.println("\nError inesperado:");
	            e.printStackTrace();
	        }
		
	}

	private static void presentarInterfaz() {
		InterfazMain Interfaz = new InterfazMain();
		Interfaz.setVisible(true);
	}
	

}
