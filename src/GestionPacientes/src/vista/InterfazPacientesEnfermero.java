package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import modelo.*;

public class InterfazPacientesEnfermero extends JFrame {
	private JFrame ventanaAnterior;
    private final Enfermero enfermero;
    private final DefaultListModel<Paciente> modeloLista = new DefaultListModel<>();
    private final JList<Paciente> listaPacientes = new JList<>(modeloLista);

    public InterfazPacientesEnfermero(JFrame ventanaAnterior, Enfermero enfermero) {
        this.ventanaAnterior = ventanaAnterior;
        this.enfermero = enfermero;
        configurarVentana(ventanaAnterior);
        initUI();
        cargarPacientes();
    }


    private void configurarVentana(JFrame parent) {
        setTitle("Gestión de Pacientes - " + enfermero.getNombre());
        setSize(600, 450);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initUI() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Configuración de la lista
        listaPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPacientes.setCellRenderer(new PacienteListCellRenderer());
        panel.add(new JScrollPane(listaPacientes), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 10, 0));
        
        JButton btnAsignar = new JButton("Asignar Paciente");
        btnAsignar.addActionListener(this::asignarPaciente);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this::eliminarPaciente);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> volver());

        panelBotones.add(btnAsignar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVolver);
        
        panel.add(panelBotones, BorderLayout.SOUTH);
        add(panel);
    }

    private void cargarPacientes() {
        modeloLista.clear();
        enfermero.getPacientesAsignados().forEach(modeloLista::addElement);
    }

    private void asignarPaciente(ActionEvent e) {
        String dni = JOptionPane.showInputDialog(this, "Ingrese DNI del paciente:");
        if (dni != null && !dni.isBlank()) {
            Paciente paciente = BaseDatosSimulada.buscarPacientePorDNI(dni.trim());
            if (paciente != null) {
                if (enfermero.asignarPaciente(paciente)) {
                    modeloLista.addElement(paciente);
                    JOptionPane.showMessageDialog(this, "Paciente asignado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(this, "El paciente ya está asignado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarPaciente(ActionEvent e) {
        Paciente seleccionado = listaPacientes.getSelectedValue();
        if (seleccionado != null) {
            if (enfermero.eliminarPaciente(seleccionado.getDNI())) {
                modeloLista.removeElement(seleccionado);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un paciente primero", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void volver() {
        this.dispose();
        
        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true); 
        }
    }
    // Renderer personalizado para mostrar mejor la información
    private static class PacienteListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, 
                                                    boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Paciente p) {
                setText(String.format("%s %s (%s) - Tel: %d", 
                       p.getNombre(), p.getApellidoPaterno(), p.getDNI(), p.getTelefono()));
            }
            return this;
        }
    }
}