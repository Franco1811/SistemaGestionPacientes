package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.InterfazRegistrarEmergencia;

public class InterfazRecepcionista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFrame ventanaAnterior;

    public InterfazRecepcionista(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Panel Recepcionista");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(SystemColor.text);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Botón registrar ingresos por emergencia
        JButton btnRegistroEmergencia = new JButton("Registrar Ingreso por Emergencia");
        btnRegistroEmergencia.setBounds(100, 121, 300, 69);
        btnRegistroEmergencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(btnRegistroEmergencia);

        btnRegistroEmergencia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	InterfazRegistrarEmergencia ventanaEmergencia = new InterfazRegistrarEmergencia(InterfazRecepcionista.this);
                ventanaEmergencia.setVisible(true);
                setVisible(false);
            }
        });

        // Botón registrar nuevo paciente
        JButton btnRegistroPaciente = new JButton("Registrar Nuevo Paciente");
        btnRegistroPaciente.setBounds(100, 201, 300, 69);
        btnRegistroPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(btnRegistroPaciente);

        btnRegistroPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistroPaciente();
            }
        });

        // Botón cerrar sesión
        JButton btnCerrarSesiOn = new JButton("Cerrar Sesion");
        btnCerrarSesiOn.setBounds(347, 310, 127, 40);
        getContentPane().add(btnCerrarSesiOn);
        
        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.textHighlight);
        panel.setBounds(0, 0, 484, 58);
        contentPane.add(panel);
        panel.setLayout(null);
        
                JLabel lblTitulo = new JLabel("PANEL RECEPCIONISTA");
                lblTitulo.setBounds(100, 11, 300, 30);
                panel.add(lblTitulo);
                lblTitulo.setForeground(SystemColor.text);
                lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
                
                JLabel lblseleccionaaccion = new JLabel("Selecciona la acción a realizar: ");
                lblseleccionaaccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
                lblseleccionaaccion.setBounds(10, 69, 255, 14);
                contentPane.add(lblseleccionaaccion);
        btnCerrarSesiOn.addActionListener(e -> {
            InterfazLoginEmpleado login = new InterfazLoginEmpleado(null);
            login.limpiarCampos();
            login.setVisible(true);
            dispose();
        });
    }

    private void abrirVentanaRegistroEmergencia() {
        // Aquí puedes crear otra ventana específica para emergencias
        // Por ahora, solo un mensaje de prueba:
        JOptionPane.showMessageDialog(this,
                "Funcionalidad para registrar ingresos por emergencia.\n(Pendiente implementación)",
                "Registro Emergencia",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void abrirVentanaRegistroPaciente() {
        InterfazRegistroPaciente ventanaRegistro = new InterfazRegistroPaciente(this, true);
        ventanaRegistro.setVisible(true);
        setVisible(false);
    }
}
