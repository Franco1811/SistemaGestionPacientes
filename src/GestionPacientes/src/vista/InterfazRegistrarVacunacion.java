package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import modelo.Vacunacion;
import modelo.Paciente;
import modelo.BaseDatosSimulada;

public class InterfazRegistrarVacunacion extends JFrame {

    private JTextField txtDniPaciente;
    private JComboBox<String> comboVacunas;
    private JButton btnBuscarPaciente, btnRegistrar;
    private JLabel lblInfoPaciente;

    public InterfazRegistrarVacunacion(JFrame ventanaAnterior) {
        setTitle("Registro de Vacunación");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        setLocationRelativeTo(ventanaAnterior);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(6, 2, 10, 10));

        // Componentes
        contentPane.add(new JLabel("DNI del Paciente:"));
        txtDniPaciente = new JTextField();
        contentPane.add(txtDniPaciente);

        btnBuscarPaciente = new JButton("Buscar Paciente");
        btnBuscarPaciente.addActionListener(e -> buscarPaciente());
        contentPane.add(btnBuscarPaciente);

        lblInfoPaciente = new JLabel("", SwingConstants.CENTER);
        lblInfoPaciente.setForeground(new Color(0, 100, 0)); // Verde oscuro
        contentPane.add(lblInfoPaciente);

        contentPane.add(new JLabel("Vacuna:"));
        comboVacunas = new JComboBox<>(new String[]{
            "COVID-19 (Pfizer)", 
            "COVID-19 (AstraZeneca)", 
            "Influenza", 
            "Hepatitis B", 
            "Tétanos",
            "Sarampión/Rubéola",
            "Neumococo",
            "Rotavirus"
        });
        contentPane.add(comboVacunas);

        contentPane.add(new JLabel("Fecha:"));
        JSpinner spinnerFecha = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editorFecha = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
        spinnerFecha.setEditor(editorFecha);
        spinnerFecha.setValue(new Date());
        contentPane.add(spinnerFecha);

        btnRegistrar = new JButton("Registrar Vacuna");
        btnRegistrar.setEnabled(false); // Se activa tras buscar paciente
        btnRegistrar.addActionListener(e -> registrarVacuna((Date) spinnerFecha.getValue()));
        contentPane.add(btnRegistrar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);
    }

    private void buscarPaciente() {
        String dni = txtDniPaciente.getText().trim();
        if (dni.isEmpty()) {
            mostrarError("Ingrese un DNI válido");
            return;
        }

        Paciente paciente = BaseDatosSimulada.buscarPacientePorDNI(dni);
        if (paciente != null) {
            lblInfoPaciente.setText("<html>Paciente: <b>" + paciente.getNombre() + "</b><br>Edad: " + paciente.getEdad() + "</html>");
            btnRegistrar.setEnabled(true);
        } else {
            mostrarError("Paciente no registrado");
            lblInfoPaciente.setText("");
            btnRegistrar.setEnabled(false);
        }
    }

    private void registrarVacuna(Date fecha) {
        String dni = txtDniPaciente.getText().trim();
        String vacuna = (String) comboVacunas.getSelectedItem();
        Paciente paciente = BaseDatosSimulada.buscarPacientePorDNI(dni);

        // Generar ID único (simulado)
        int nuevoId = BaseDatosSimulada.getListaPacientes().size() + 1000;

        // Crear y guardar la vacunación
        Vacunacion nuevaVacuna = new Vacunacion(nuevoId, paciente, vacuna, fecha);
        
        // En un sistema real, aquí se llamaría a BaseDatosSimulada.agregarVacunacion(nuevaVacuna);
        // Como no existe aún, mostramos un simulacro:
        JOptionPane.showMessageDialog(this, 
            "¡Vacuna registrada con éxito!\n" +
            "ID: " + nuevoId + "\n" +
            "Paciente: " + paciente.getNombre() + "\n" +
            "Vacuna: " + vacuna + "\n" +
            "Fecha: " + String.format("%td/%<tm/%<tY", fecha),
            "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        // Reiniciar formulario
        txtDniPaciente.setText("");
        lblInfoPaciente.setText("");
        btnRegistrar.setEnabled(false);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}