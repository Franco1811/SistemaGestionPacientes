package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import modelo.*;

public class InterfazGestionCitas extends JFrame {

    private JTable tablaCitas;
    private DefaultTableModel modeloTabla;
    private Medico medicoActual;

    public InterfazGestionCitas(JFrame parent, Medico medico) {
        this.medicoActual = medico;
        
        setTitle("Gestión de Citas - Dr. " + medico.getApellidoPaterno());
        setSize(800, 500);
        setLocationRelativeTo(parent);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configurar tabla
        modeloTabla = new DefaultTableModel(
            new Object[]{"ID", "Paciente", "Fecha", "Hora", "Motivo", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabla no editable
            }
        };
        
        tablaCitas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaCitas);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton btnAprobar = new JButton("Aprobar Cita");
        btnAprobar.addActionListener(this::aprobarCita);
        
        JButton btnRechazar = new JButton("Rechazar Cita");
        btnRechazar.addActionListener(this::rechazarCita);
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> cargarCitas());
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            parent.setVisible(true);
            dispose();
        });

        panelBotones.add(btnAprobar);
        panelBotones.add(btnRechazar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnVolver);
        
        panel.add(panelBotones, BorderLayout.SOUTH);
        add(panel);
        
        cargarCitas();
    }

    private void cargarCitas() {
        modeloTabla.setRowCount(0); // Limpiar tabla
        SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        
        BaseDatosSimulada.getCitasPorMedico(medicoActual).forEach(cita -> {
            modeloTabla.addRow(new Object[]{
                cita.getID(),
                cita.getNombre(),
                sdfFecha.format(cita.getFechaHora()),
                sdfHora.format(cita.getFechaHora()),
                cita.getMotivo(),
                cita.getEstado()
            });
        });
    }

    private void aprobarCita(ActionEvent e) {
        int filaSeleccionada = tablaCitas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idCita = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        BaseDatosSimulada.getCitaPorId(idCita).ifPresent(cita -> {
            cita.setEstado("Aprobada");
            JOptionPane.showMessageDialog(this, "Cita aprobada exitosamente");
            cargarCitas();
        });
    }

    private void rechazarCita(ActionEvent e) {
        int filaSeleccionada = tablaCitas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idCita = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        BaseDatosSimulada.getCitaPorId(idCita).ifPresent(cita -> {
            cita.setEstado("Rechazada");
            JOptionPane.showMessageDialog(this, "Cita rechazada");
            cargarCitas();
        });
    }
}