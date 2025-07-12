package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public static void eliminarMedicamento(int id) {
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
    
    // ENFERMEROS
    private static List<Enfermero> listaEnfermeros = new ArrayList<>();

    public static void agregarEnfermero(Enfermero enfermero) {
    	 if (enfermero != null && !listaEnfermeros.contains(enfermero)) {
         	agregarUsuario(enfermero.getUsuario());
             listaEnfermeros.add(enfermero);
         }
    }

    public static Enfermero buscarEnfermeroPorDNI(String dni) {
        return listaEnfermeros.stream()
                .filter(e -> e.getDNI().equals(dni))
                .findFirst()
                .orElse(null);
    }

    public static List<Enfermero> getEnfermerosConPaciente(String dniPaciente) {
        return listaEnfermeros.stream()
                .filter(e -> e.tienePaciente(dniPaciente))
                .toList();
    }

    public static List<Enfermero> getListaEnfermeros() {
        return listaEnfermeros;
    }

    public static void setListaEnfermeros(List<Enfermero> listaEnfermeros) {
        BaseDatosSimulada.listaEnfermeros = listaEnfermeros;
    }
    
    // MÉDICOS
    private static List<Medico> ListaMedicos = new ArrayList<>();
    
    public static void agregarMedico(Medico medico) {
        if (medico != null && !ListaMedicos.contains(medico)) {
            agregarUsuario(medico.getUsuario());
            ListaMedicos.add(medico);
        }
    }
    
    public static List<Medico> getListaMedicos() {
        return ListaMedicos;
    }
    
    // CITAS MÉDICAS
    private static List<CitaMedica> listaCitas = new ArrayList<>();
    private static int contadorCitas = 1;

    public static void agregarCita(CitaMedica cita) {
        if (cita == null || cita.getMedico() == null) {
            System.err.println("Intento de agregar cita inválida");
            return;
        }
        cita.setID(contadorCitas++);
        listaCitas.add(cita);
    }

    public static List<CitaMedica> getCitasPorPaciente(String dniPaciente) {
        return listaCitas.stream()
                .filter(c -> c.getNombre().contains(dniPaciente))
                .toList();
    }

    public static List<CitaMedica> getCitasPorMedico(Medico medico) {
        return listaCitas.stream()
                .filter(c -> c.getMedico().equals(medico))
                .toList();
    }

    public static List<CitaMedica> getCitasPendientes() {
        return listaCitas.stream()
                .filter(c -> c.getEstado().equals("Pendiente"))
                .toList();
    }
    
    public static Optional<CitaMedica> getCitaPorId(int id) {
        return listaCitas.stream()
                .filter(c -> c.getID() == id)
                .findFirst();
    }
    
    // RECETAS MÉDICAS
    private static List<RecetaMedica> listaRecetas = new ArrayList<>();
    private static int contadorRecetas = 1;

    public static void agregarReceta(RecetaMedica receta) {
        receta.setID(contadorRecetas++);
        listaRecetas.add(receta);
    }

    public static int getProximoIdReceta() {
        return contadorRecetas;
    }
    
    // RECETAS PACIENTE
    private static List<RecetaPaciente> listaRecetasPaciente = new ArrayList<>();
    private static int contadorRecetasP = 1;

    public static void agregarRecetaPaciente(RecetaPaciente receta) {
        receta.setId(contadorRecetasP++);
        listaRecetasPaciente.add(receta);
    }
    
    public static List<RecetaPaciente> getRecetasPorPaciente(String dni) {
        List<RecetaPaciente> recetasDelPaciente = new ArrayList<>();
        for (RecetaPaciente receta : listaRecetasPaciente) {
            if (receta.getDniPaciente().equals(dni)) {
                recetasDelPaciente.add(receta);
            }
        }
        return recetasDelPaciente;
    }
    
    // VACUNACIONES
    private static List<Vacunacion> listaVacunaciones = new ArrayList<>();

    public static void agregarVacunacion(Vacunacion vacuna) {
        listaVacunaciones.add(vacuna);
    }

    public static List<Vacunacion> getVacunaciones() {
        return listaVacunaciones;
    }
    
    public static int getProximoIdVacunacion() {
        return listaVacunaciones.size() + 1;
    }

    // BLOQUE DE INICIALIZACIÓN CON DATOS DE PRUEBA (del segundo código)
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
            agregarUsuario(new Usuario("enfermero", "enf123", rolEnfermero, true));
            agregarUsuario(new Usuario("paciente1", "pac123", rolPaciente, true));
            agregarUsuario(new Usuario("farmaceutico1", "farm123", rolFarmaceutico, true));
            agregarUsuario(new Usuario("laboratorio1", "lab123", rolLaboratorio, true));
            agregarUsuario(new Usuario("recepcionista1", "rec123", rolRecepcionista, true));

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            // Medicos y Enfermeros
            Enfermero enfermero1 = new Enfermero(1001, "87654321A", "María", "García", "López", 32, "Femenino", 
                new Usuario("enfermero1", "enf123", rolEnfermero, true));
            BaseDatosSimulada.agregarEnfermero(enfermero1);

            Enfermero enfermero2 = new Enfermero(1002, "98765432B", "Juan", "Martínez", "Rodríguez", 28, "Masculino", 
                new Usuario("enfermero2", "enf456", rolEnfermero, true));
            BaseDatosSimulada.agregarEnfermero(enfermero2);
            // Creación de médicos (5)
            Medico medico1 = new Medico("Carlos", "Pérez", "Gómez", 35, "Masculino", "Cardiología", 
                new Usuario("cperez", "med123", rolMedico, true), "CMP12345");
            BaseDatosSimulada.agregarMedico(medico1);

            Medico medico2 = new Medico("Ana", "López", "Fernández", 40, "Femenino", "Pediatría", 
                new Usuario("alopez", "med456", rolMedico, true), "CMP54321");
            BaseDatosSimulada.agregarMedico(medico2);

            Medico medico3 = new Medico("Luis", "González", "Sánchez", 45, "Masculino", "Traumatología", 
                new Usuario("lgonzalez", "med789", rolMedico, true), "CMP67890");
            BaseDatosSimulada.agregarMedico(medico3);

            Medico medico4 = new Medico("Sofía", "Ramírez", "Díaz", 38, "Femenino", "Dermatología", 
                new Usuario("sramirez", "med012", rolMedico, true), "CMP09876");
            BaseDatosSimulada.agregarMedico(medico4);

            Medico medico5 = new Medico("Ricardo", "Torres", "Vargas", 50, "Masculino", "Neurología", 
                new Usuario("rtorres", "med345", rolMedico, true), "CMP56789");
            BaseDatosSimulada.agregarMedico(medico5);
            // PACIENTES          
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

            // ... (resto de pacientes del segundo código)

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