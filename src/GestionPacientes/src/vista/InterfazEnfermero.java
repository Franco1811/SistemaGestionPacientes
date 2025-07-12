package vista;

import javax.swing.*;
import java.awt.*;
import modelo.*;
import herramientas.UtilidadesImagen; // Asumo que tienes esta clase para manejar imágenes

public class InterfazEnfermero extends JFrame {

    public InterfazEnfermero(JFrame ventanaAnterior) {
        setTitle("Panel Enfermero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500); // Aumenté el ancho para la imagen
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel superior (verde enfermería)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(76, 175, 80));
        headerPanel.setBounds(0, 0, 760, 80);
        contentPane.add(headerPanel);
        
        JLabel lblTitle = new JLabel("PANEL ENFERMERO");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        headerPanel.add(lblTitle);

        // --- Panel izquierdo para botones ---
        JPanel panelBotones = new JPanel(null);
        panelBotones.setBounds(20, 100, 350, 250);
        panelBotones.setOpaque(false);
        contentPane.add(panelBotones);

        // Botón Registrar Vacunación
        JButton btnVacunacion = new JButton("Registrar Vacunación");
        btnVacunacion.setBounds(0, 0, 350, 80);
        btnVacunacion.addActionListener(e -> {
            new InterfazRegistrarVacunacion(this).setVisible(true);
            setVisible(false);
        });

        // Botón Administrar Medicamentos
        JButton btnMedicamentos = new JButton("Administrar Medicamentos");
        btnMedicamentos.setBounds(0, 90, 350, 80);
        btnMedicamentos.addActionListener(e -> {
            new InterfazRegistrarEntrega(this).setVisible(true);
            setVisible(false);
        });

        // Botón Pacientes Asignados
        JButton btnPacientes = new JButton("Pacientes Asignados");
        btnPacientes.setBounds(0, 180, 350, 80);
        btnPacientes.addActionListener(e -> {
            Usuario userActual = InterfazMain.GetUsuarioActual();   
            Enfermero enfermeroActual = Enfermero.EnfermeroDeUsuario(userActual);
            
            if (enfermeroActual != null) {
                new InterfazPacientesEnfermero(this, enfermeroActual).setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No se encontró información del enfermero", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        // --- Panel derecho para imagen ---
        JLabel lblImagen = new JLabel();
        lblImagen.setBounds(400, 100, 340, 250);
        lblImagen.setIcon(UtilidadesImagen.cargarImagenEscalada(
            "/imagenes/rolenfermero.png", 340, 250)); // Asegúrate de tener esta imagen
        contentPane.add(lblImagen);
        
        // --- Botón Cerrar Sesión ---
        JButton btnLogout = new JButton("Cerrar Sesión");
        btnLogout.setBounds(600, 400, 150, 40);
        btnLogout.addActionListener(e -> {
            new InterfazLoginEmpleado(null).setVisible(true);
            dispose();
        });

        // Añadir componentes
        panelBotones.add(btnVacunacion);
        panelBotones.add(btnMedicamentos);
        panelBotones.add(btnPacientes);
        contentPane.add(btnLogout);
    }
}