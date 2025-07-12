package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelo.Paciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

public class InterfazReportesDiarios extends JFrame {

    private JTable tablaPacientes;
    private DefaultTableModel modeloTabla;
    private JTextField txtFechaFiltro;
    private JLabel lblTotalPacientes;

    public InterfazReportesDiarios() {
        setTitle("Reportes Diarios de Pacientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // Panel superior (filtros)
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(SystemColor.textHighlight);
        panelSuperior.setLayout(new FlowLayout());

        panelSuperior.add(new JLabel("Fecha (dd/MM/yyyy):"));
        txtFechaFiltro = new JTextField(10);
        panelSuperior.add(txtFechaFiltro);

        JButton btnFiltrar = new JButton("Filtrar por Fecha");
        panelSuperior.add(btnFiltrar);

        JButton btnMostrarTodo = new JButton("Mostrar Todos");
        panelSuperior.add(btnMostrarTodo);

        JButton btnVolver = new JButton("Volver");
        panelSuperior.add(btnVolver);

        getContentPane().add(panelSuperior, BorderLayout.NORTH);

        // Tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[] { "DNI", "Nombre Completo", "Fecha Registro" });

        tablaPacientes = new JTable(modeloTabla);
        getContentPane().add(new JScrollPane(tablaPacientes), BorderLayout.CENTER);

        // Panel inferior (resumen)
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.setBackground(SystemColor.textHighlight);
        lblTotalPacientes = new JLabel("Total pacientes: 0");
        panelInferior.add(lblTotalPacientes);
        getContentPane().add(panelInferior, BorderLayout.SOUTH);

        // Eventos
        btnFiltrar.addActionListener(e -> filtrarPorFecha());
        btnMostrarTodo.addActionListener(e -> mostrarTodos());
        btnVolver.addActionListener(e -> dispose());

        mostrarTodos(); // mostrar al iniciar
    }
    
    private void mostrarTodos() {
        modeloTabla.setRowCount(0); // limpiar tabla

        List<Paciente> pacientes = Paciente.getPacientes();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Paciente p : pacientes) {
            modeloTabla.addRow(new Object[] {
                p.getDNI(),
                p.getNombre() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno(),
                sdf.format(p.getFechaRegistro())
            });
        }

        lblTotalPacientes.setText("Total pacientes: " + pacientes.size());
    }

    private void filtrarPorFecha() {
        String fechaTexto = txtFechaFiltro.getText().trim();

        if (fechaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha para filtrar.");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date fechaFiltro = sdf.parse(fechaTexto);

            List<Paciente> filtrados = Paciente.getPacientes().stream()
                .filter(p -> sdf.format(p.getFechaRegistro()).equals(sdf.format(fechaFiltro)))
                .collect(Collectors.toList());

            modeloTabla.setRowCount(0); // limpiar tabla

            for (Paciente p : filtrados) {
                modeloTabla.addRow(new Object[] {
                    p.getDNI(),
                    p.getNombre() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno(),
                    sdf.format(p.getFechaRegistro())
                });
            }

            lblTotalPacientes.setText("Pacientes ese día: " + filtrados.size());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fecha inválida. Use el formato dd/MM/yyyy.");
        }
    }
}


