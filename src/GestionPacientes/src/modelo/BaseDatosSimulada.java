package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaseDatosSimulada {

    // USUARIOS
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public static List<Usuario> getUsuarios() {
        return listaUsuarios;
    }

    public static Usuario buscarUsuario(String username) {
        for (Usuario u : listaUsuarios) {
            if (u.getUserName().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public static void eliminarUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    public static Usuario buscarUsuarioPorUsuarioYContrasena(String usuario, String contrasena) {
        for (Usuario u : listaUsuarios) {
            if (u.getUserName().equals(usuario) && u.getPassword().equals(contrasena) && u.isActivo()) {
                return u;
            }
        }
        return null;
    }

    // MEDICAMENTOS
    public static List<Medicamentos> listaMedicamentos = new ArrayList<>();

    static {
        listaMedicamentos.add(new Medicamentos(1, "Paracetamol", 50, false, 2.5));
        listaMedicamentos.add(new Medicamentos(2, "Ibuprofeno", 10, true, 3.2));
        listaMedicamentos.add(new Medicamentos(3, "Amoxicilina", 100, false, 5.0));
        listaMedicamentos.add(new Medicamentos(4, "Omeprazol", 30, false, 4.0));
        listaMedicamentos.add(new Medicamentos(5, "Loratadina", 5, true, 3.8));
        listaMedicamentos.add(new Medicamentos(6, "Metformina", 80, false, 2.0));
        listaMedicamentos.add(new Medicamentos(7, "Salbutamol", 15, true, 6.5));
        listaMedicamentos.add(new Medicamentos(8, "Vitamina C", 120, false, 1.5));
        listaMedicamentos.add(new Medicamentos(9, "Prednisona", 8, true, 4.2));
        listaMedicamentos.add(new Medicamentos(10, "Diclofenaco", 40, false, 2.8));
    }

    public static void agregarMedicamento(Medicamentos medicamento) {
        listaMedicamentos.add(medicamento);
    }

    public static List<Medicamentos> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void eliminarMedicamento(int id) {
        listaMedicamentos.removeIf(m -> m.getID() == id);
    }

    // ENTREGA DE MEDICAMENTOS
    private static List<Entrega> listaEntregas = new ArrayList<>();

    public static void agregarEntrega(Entrega entrega) {
        listaEntregas.add(entrega);
    }

    public static List<Entrega> getListaEntregas() {
        return listaEntregas;
    }

    // PACIENTES
    private static List<Paciente> listaPacientes = new ArrayList<>();

    public static void agregarPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    public static List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public static Paciente buscarPacientePorDNI(String dni) {
        for (Paciente p : listaPacientes) {
            if (p.getDNI().equals(dni)) {
                return p;
            }
        }
        return null;
    }
    
    static {
        try {
        	
            // CREAR ROLES
            Rol rolAdmin = new Rol(1, Rol.ADMINISTRADOR);
            Rol rolMedico = new Rol(2, Rol.MEDICO);
            Rol rolEnfermero = new Rol(3, Rol.ENFERMERO);
            Rol rolPaciente = new Rol(4, Rol.PACIENTE);
            Rol rolFarmaceutico = new Rol(5, Rol.FARMACEUTICO);
            Rol rolLaboratorio = new Rol(6, Rol.LABORATORIO);
            Rol rolRecepcionista = new Rol(7, Rol.RECEPCIONISTA);

            // CREAR USUARIOS DE PRUEBA
            agregarUsuario(new Usuario("admin", "1234", rolAdmin, true));
            agregarUsuario(new Usuario("medico1", "med123", rolMedico, true));
            agregarUsuario(new Usuario("enfermero1", "enf123", rolEnfermero, true));
            agregarUsuario(new Usuario("paciente1", "pac123", rolPaciente, true));
            agregarUsuario(new Usuario("farmaceutico1", "farm123", rolFarmaceutico, true));
            agregarUsuario(new Usuario("laboratorio1", "lab123", rolLaboratorio, true));
            agregarUsuario(new Usuario("recepcionista1", "rec123", rolRecepcionista, true));

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	
        	
        	//PACIENTES          
            Usuario usuario1 = new Usuario("pepito", "123456", rolPaciente, true);
            agregarUsuario(usuario1);
            Paciente paciente1 = new Paciente(
                    "12345678", "Pepito", "Pérez", "García", 30,
                    "Masculino", sdf.parse("01/01/1995"), 987654321,
                    "pepito@email.com", "Calle Falsa 123",
                    usuario1, sdf.parse("01/06/2025"));
            agregarPaciente(paciente1);

            Usuario usuario2 = new Usuario("juanita", "juana123", rolPaciente, true);
            agregarUsuario(usuario2);
            Paciente paciente2 = new Paciente(
                    "87654321", "Juanita", "Ramírez", "Lopez", 28,
                    "Femenino", sdf.parse("15/02/1997"), 912345678,
                    "juanita@email.com", "Av. Principal 456",
                    usuario2, sdf.parse("20/06/2025"));
            agregarPaciente(paciente2);

            Usuario usuario3 = new Usuario("carlitos", "carlitos123", rolPaciente, true);
            agregarUsuario(usuario3);
            Paciente paciente3 = new Paciente(
                    "11223344", "Carlitos", "Suarez", "Quispe", 35,
                    "Masculino", sdf.parse("10/10/1989"), 998877665,
                    "carlitos@email.com", "Jr. Las Flores 789",
                    usuario3, sdf.parse("25/06/2025"));
            agregarPaciente(paciente3);


            Usuario usuario4 = new Usuario("maria", "maria123", rolPaciente, true);
            agregarUsuario(usuario4);
            Paciente paciente4 = new Paciente(
                    "44556677", "Maria", "Lopez", "Sanchez", 40,
                    "Femenino", sdf.parse("02/03/1984"), 999999999,
                    "maria@email.com", "Av. Lima 789",
                    usuario4, sdf.parse("10/06/2025"));
            agregarPaciente(paciente4);


            Usuario usuario5 = new Usuario("jose", "jose123", rolPaciente, true);
            agregarUsuario(usuario5);
            Paciente paciente5 = new Paciente(
                    "55667788", "Jose", "Fernandez", "Rojas", 45,
                    "Masculino", sdf.parse("12/05/1979"), 988888888,
                    "jose@email.com", "Calle Central 456",
                    usuario5, sdf.parse("12/06/2025"));
            agregarPaciente(paciente5);


            Usuario usuario6 = new Usuario("luisa", "luisa123", rolPaciente, true);
            agregarUsuario(usuario6);
            Paciente paciente6 = new Paciente(
                    "66778899", "Luisa", "Gomez", "Torres", 32,
                    "Femenino", sdf.parse("08/07/1992"), 977777777,
                    "luisa@email.com", "Av. Libertad 234",
                    usuario6, sdf.parse("15/06/2025"));
            agregarPaciente(paciente6);


            Usuario usuario7 = new Usuario("andres", "andres123", rolPaciente, true);
            agregarUsuario(usuario7);
            Paciente paciente7 = new Paciente(
                    "77889900", "Andres", "Ruiz", "Chavez", 38,
                    "Masculino", sdf.parse("25/09/1986"), 966666666,
                    "andres@email.com", "Jr. Amazonas 567",
                    usuario7, sdf.parse("18/06/2025"));
            agregarPaciente(paciente7);


            Usuario usuario8 = new Usuario("rosa", "rosa123", rolPaciente, true);
            agregarUsuario(usuario8);
            Paciente paciente8 = new Paciente(
                    "88990011", "Rosa", "Mendoza", "Silva", 50,
                    "Femenino", sdf.parse("30/11/1974"), 955555555,
                    "rosa@email.com", "Calle Perú 890",
                    usuario8, sdf.parse("20/06/2025"));
            agregarPaciente(paciente8);


            Usuario usuario9 = new Usuario("ricardo", "ricardo123", rolPaciente, true);
            agregarUsuario(usuario9);
            Paciente paciente9 = new Paciente(
                    "99001122", "Ricardo", "Campos", "Vargas", 28,
                    "Masculino", sdf.parse("12/12/1996"), 944444444,
                    "ricardo@email.com", "Av. Arequipa 321",
                    usuario9, sdf.parse("22/06/2025"));
            agregarPaciente(paciente9);


            Usuario usuario10 = new Usuario("veronica", "veronica123", rolPaciente, true);
            agregarUsuario(usuario10);
            Paciente paciente10 = new Paciente(
                    "10111213", "Veronica", "Salazar", "Huaman", 34,
                    "Femenino", sdf.parse("05/01/1990"), 933333333,
                    "veronica@email.com", "Jr. Ayacucho 654",
                    usuario10, sdf.parse("25/06/2025"));
            agregarPaciente(paciente10);
            
            
            
            // ENTREGAS DE PRUEBA
               
            paciente1 = buscarPacientePorDNI("11223344"); // Carlitos
            paciente2 = buscarPacientePorDNI("12345678"); // Pepito

            if (paciente1 != null) {
                List<MedicamentoEntregado> listaMeds1 = new ArrayList<>();
                listaMeds1.add(new MedicamentoEntregado(1, "Paracetamol", 5));
                listaMeds1.add(new MedicamentoEntregado(3, "Amoxicilina", 10));

                Entrega entrega1 = new Entrega(
                        1,
                        "REC-0001",
                        true,
                        paciente1,
                        new java.util.Date(),
                        listaMeds1
                );
                agregarEntrega(entrega1);
                System.out.println("Entrega de prueba registrada para paciente " + paciente1.getDNI());
            }

            if (paciente2 != null) {
                List<MedicamentoEntregado> listaMeds2 = new ArrayList<>();
                listaMeds2.add(new MedicamentoEntregado(2, "Ibuprofeno", 3));
                listaMeds2.add(new MedicamentoEntregado(4, "Omeprazol", 4));

                Entrega entrega2 = new Entrega(
                        2,
                        "REC-0002",
                        true,
                        paciente2,
                        new java.util.Date(),
                        listaMeds2
                );
                agregarEntrega(entrega2);
                System.out.println("Entrega de prueba registrada para paciente " + paciente2.getDNI());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}