package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelo.BaseDatosSimulada;
import modelo.CitaMedica;
import modelo.Paciente;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class InterfazHistorialClinico extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JTextField txtDni;

    public InterfazHistorialClinico(JFrame parent) {
        setTitle("Historial Clínico");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(parent);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        // Panel superior (búsqueda)
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setBackground(SystemColor.textHighlight);
        panelBusqueda.setPreferredSize(new Dimension(0, 80));
        contentPane.add(panelBusqueda, BorderLayout.NORTH);
        panelBusqueda.setLayout(null);
        
        JLabel lblDniPaciente = new JLabel("DNI del Paciente:");
        lblDniPaciente.setForeground(Color.WHITE);
        lblDniPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDniPaciente.setBounds(30, 30, 150, 20);
        panelBusqueda.add(lblDniPaciente);
        
        txtDni = new JTextField();
        txtDni.setBounds(180, 30, 200, 25);
        panelBusqueda.add(txtDni);
        txtDni.setColumns(10);
        
        JButton btnBuscar = new JButton("Buscar Historial");
        btnBuscar.setBounds(400, 30, 150, 25);
        btnBuscar.addActionListener(e -> buscarHistorial());
        panelBusqueda.add(btnBuscar);
        
        // Panel central (tabla de citas)
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout(0, 0));
        contentPane.add(panelCentral, BorderLayout.CENTER);
        
        String[] columnas = {
            "ID Cita", "Fecha", "Hora", "Médico", "Especialidad", "Motivo", "Estado"
        };
        
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabla no editable
            }
        };
        
        tabla = new JTable(modeloTabla);
        tabla.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelCentral.add(scrollPane, BorderLayout.CENTER);
    }

    private void buscarHistorial() {
        String dni = txtDni.getText().trim();
        
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el DNI del paciente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Paciente paciente = BaseDatosSimulada.buscarPacientePorDNI(dni);
        
        if (paciente == null) {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        cargarCitasPaciente(paciente);
    }

    private void cargarCitasPaciente(Paciente paciente) {
        modeloTabla.setRowCount(0); // Limpiar tabla
        
        SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        
        List<CitaMedica> citas = BaseDatosSimulada.getCitasPorPaciente(paciente.getDNI());
        
        if (citas == null || citas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El paciente no tiene citas registradas", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        for (CitaMedica cita : citas) {
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
            
            modeloTabla.addRow(new Object[]{
                cita.getID(),
                fechaStr,
                horaStr,
                nombreMedico,
                cita.getEspecialidad(),
                cita.getMotivo() != null ? cita.getMotivo() : "",
                cita.getEstado() != null ? cita.getEstado() : ""
            });
        }
    }
}