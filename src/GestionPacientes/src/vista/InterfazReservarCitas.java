package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Paciente;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.BaseDatosSimulada;
import modelo.CitaMedica;
import modelo.Medico;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterfazReservarCitas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtdnipaciente;
    private JTextField txtnombrecompleto;
    private JComboBox<String> comboBoxareas;
    private JComboBox<String> comboBoxdoctor;
    private Map<String, List<String>> mapaAreasDoctores;
    private Paciente pacienteActual;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private int contadorCitas = 1;


    
    
    public InterfazReservarCitas(Paciente paciente) {
        this(); 
        this.pacienteActual = paciente;
        txtdnipaciente.setText(paciente.getDNI());
        txtnombrecompleto.setText(
            paciente.getNombre() + " " +
            paciente.getApellidoPaterno() + " " +
            paciente.getApellidoMaterno()
        );
    }
    
    public InterfazReservarCitas() {
    	
        setTitle("Citas Médicas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel bg8 = new JPanel();
        bg8.setLayout(null);
        bg8.setBackground(SystemColor.textHighlight);
        bg8.setBounds(0, 0, 984, 88);
        contentPane.add(bg8);

        JLabel lblCitasMdicas = new JLabel("CITAS MÉDICAS");
        lblCitasMdicas.setForeground(SystemColor.window);
        lblCitasMdicas.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblCitasMdicas.setBounds(332, 11, 324, 49);
        bg8.add(lblCitasMdicas);

        JPanel bg9 = new JPanel();
        bg9.setBounds(0, 84, 984, 477);
        contentPane.add(bg9);
        bg9.setLayout(null);

        JLabel lbldni = new JLabel("DNI Paciente:");
        lbldni.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbldni.setBounds(23, 26, 103, 14);
        bg9.add(lbldni);

        JLabel lblrea = new JLabel("Área:");
        lblrea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblrea.setBounds(23, 72, 103, 14);
        bg9.add(lblrea);

        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDoctor.setBounds(467, 72, 103, 14);
        bg9.add(lblDoctor);

        JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
        lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNombreCompleto.setBounds(467, 26, 120, 14);
        bg9.add(lblNombreCompleto);

        txtdnipaciente = new JTextField();
        txtdnipaciente.setColumns(10);
        txtdnipaciente.setBounds(115, 26, 175, 20);
        txtdnipaciente.setEditable(false);
        txtdnipaciente.setBorder(null);
        txtdnipaciente.setOpaque(false);
        bg9.add(txtdnipaciente);

        txtnombrecompleto = new JTextField();
        txtnombrecompleto.setColumns(10);
        txtnombrecompleto.setBounds(583, 26, 175, 20);
        txtnombrecompleto.setEditable(false);
        txtnombrecompleto.setBorder(null);
        txtnombrecompleto.setOpaque(false);
        bg9.add(txtnombrecompleto);

        comboBoxareas = new JComboBox<>();
        comboBoxareas.setModel(new DefaultComboBoxModel<>(new String[]{
                "Seleccione área...", "Cardiología", "Dermatología", "Endocrinología",
                "Gastroenterología", "Ginecología", "Medicina General", "Neurología",
                "Oftalmología", "Otorrinolaringología", "Pediatría", "Psicología",
                "Psiquiatría", "Traumatología", "Urología"
        }));
        comboBoxareas.setBounds(115, 69, 175, 22);
        bg9.add(comboBoxareas);

        comboBoxdoctor = new JComboBox<>();
        comboBoxdoctor.setBounds(583, 69, 175, 22);
        comboBoxdoctor.addItem("Seleccione doctor...");
        bg9.add(comboBoxdoctor);
        
        

        String[] columnas = {
            "ID_CITA", "ID_PACIENTE", "IDUMEDICO", 
            "FECHA_CITA", "HORA_CITA", 
            "AREA", "MOTIVO"
        };

        // Datos vacíos 
        Object[][] datos = new Object[0][8];

        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(20, 120, 940, 229);
        bg9.add(scrollPane);
        
        
        //Boton nueva cita
        JButton btnnuevacita = new JButton("NUEVA CITA");
        btnnuevacita.setBounds(76, 379, 120, 54);
        btnnuevacita.addActionListener(e -> {
            String areaSeleccionada = (String) comboBoxareas.getSelectedItem();
            String doctorSeleccionado = (String) comboBoxdoctor.getSelectedItem();
            
            if ("Seleccione área...".equals(areaSeleccionada)) {
                JOptionPane.showMessageDialog(this, "Seleccione un área médica", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if ("Seleccione doctor...".equals(doctorSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Seleccione un médico", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            InterfazNuevaCita ventanaNuevaCita = new InterfazNuevaCita(
                this,
                txtdnipaciente.getText(),
                txtnombrecompleto.getText(),
                areaSeleccionada,
                doctorSeleccionado,
                modeloTabla
            );
            ventanaNuevaCita.setVisible(true);
            this.setVisible(false);
        });



        bg9.add(btnnuevacita);
        
        
        //Boton atras
        JButton btnatras = new JButton("ATRAS");
        btnatras.addActionListener(e -> {
            InterfazFuncionesPaciente ventanaFunciones = new InterfazFuncionesPaciente(pacienteActual);
            ventanaFunciones.setVisible(true);
            dispose();
        });
        btnatras.setBounds(228, 379, 120, 54);
        bg9.add(btnatras);

        inicializarMapaAreasDoctores();
        inicializarListeners();

        setLocationRelativeTo(null);
    }

    private void inicializarMapaAreasDoctores() {
        mapaAreasDoctores = new HashMap<>();
        
        // Usa los médicos reales de la base de datos
        BaseDatosSimulada.getListaMedicos().forEach(medico -> {
            String area = medico.getEspecialidad();
            String nombreCompleto = medico.getNombre() + " " + medico.getApellidoPaterno();
            
            if (!mapaAreasDoctores.containsKey(area)) {
                mapaAreasDoctores.put(area, new ArrayList<>());
            }
            mapaAreasDoctores.get(area).add(nombreCompleto);
        });
        
        // Ordena las áreas alfabéticamente
        String[] areasOrdenadas = mapaAreasDoctores.keySet().stream()
                .sorted()
                .toArray(String[]::new);
        
        comboBoxareas.setModel(new DefaultComboBoxModel<>(areasOrdenadas));
        comboBoxareas.insertItemAt("Seleccione área...", 0);
        comboBoxareas.setSelectedIndex(0);
    }

    private void inicializarListeners() {
        comboBoxareas.addActionListener(e -> {
            String areaSeleccionada = (String) comboBoxareas.getSelectedItem();

            comboBoxdoctor.removeAllItems();
            comboBoxdoctor.addItem("Seleccione doctor...");

            if (mapaAreasDoctores.containsKey(areaSeleccionada)) {
                for (String doctor : mapaAreasDoctores.get(areaSeleccionada)) {
                    comboBoxdoctor.addItem(doctor);
                }
            }
        });
    }
    public void agregarCita(
            String dni,
            String fecha,
            String hora,
            String area,
            String nombreMedico,
            String motivo
    ) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date fechaHora = sdf.parse(fecha + " " + hora);
            
            // Buscar el médico real por su nombre
            Medico medico = BaseDatosSimulada.getListaMedicos().stream()
                    .filter(m -> (m.getNombre() + " " + m.getApellidoPaterno()).equals(nombreMedico))
                    .findFirst()
                    .orElse(null);
            
            if (medico == null) {
                JOptionPane.showMessageDialog(this, "Error: Médico no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Buscar paciente por DNI
            Paciente paciente = BaseDatosSimulada.buscarPacientePorDNI(dni);
            
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "Error: Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear y guardar la cita real
            CitaMedica nuevaCita = new CitaMedica(
                    0, // ID se asignará automáticamente
                    paciente.getNombre() + " " + paciente.getApellidoPaterno(),
                    area,
                    medico,
                    fechaHora,
                    30, // Duración por defecto
                    motivo,
                    "Pendiente" // Estado inicial
            );
            
            BaseDatosSimulada.agregarCita(nuevaCita);
            
            // Actualizar tabla local (opcional)
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            
            model.addRow(new Object[]{
                nuevaCita.getID(),
                dni,
                nombreMedico,
                sdfFecha.format(fechaHora),
                sdfHora.format(fechaHora),
                area,
                motivo
            });
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al procesar la cita: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void cargarCitasPaciente() {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0); // Limpiar tabla
        
        if (pacienteActual != null && pacienteActual.getDNI() != null) {
            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            
            List<CitaMedica> citas = BaseDatosSimulada.getCitasPorPaciente(pacienteActual.getDNI());
            
            if (citas != null) {
                for (CitaMedica cita : citas) {
                    if (cita == null) {
                        System.err.println("Advertencia: Cita nula encontrada");
                        continue;
                    }
                    
                    // Manejar médico nulo
                    String nombreMedico = "Médico no asignado";
                    if (cita.getMedico() != null) {
                        nombreMedico = cita.getMedico().getNombre() + " " + cita.getMedico().getApellidoPaterno();
                    }
                    
                    // Manejar fecha nula
                    String fechaStr = "";
                    String horaStr = "";
                    if (cita.getFechaHora() != null) {
                        fechaStr = sdfFecha.format(cita.getFechaHora());
                        horaStr = sdfHora.format(cita.getFechaHora());
                    }
                    
                    model.addRow(new Object[]{
                        cita.getID(),
                        pacienteActual.getDNI(),
                        nombreMedico,
                        fechaStr,
                        horaStr,
                        cita.getEspecialidad(),
                        cita.getMotivo() != null ? cita.getMotivo() : ""
                    });
                }
            }
        }
    }
    


}


