package vista;

import javax.swing.*;

import modelo.BaseDatosSimulada;
import modelo.Medico;
import modelo.Usuario;

import java.awt.*;

public class InterfazMedico extends JFrame {

    public InterfazMedico(JFrame ventanaAnterior) {
        setTitle("Panel Médico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel superior (azul médico)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 120, 215));
        headerPanel.setBounds(0, 0, 600, 80);
        contentPane.add(headerPanel);
        
        JLabel lblTitle = new JLabel("PANEL MÉDICO");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        headerPanel.add(lblTitle);

        // Botones principales (reutilizando interfaces existentes)
        JButton btnHistorial = new JButton("Historial Clínico");
        btnHistorial.setBounds(50, 120, 200, 80);
        btnHistorial.addActionListener(e -> {
            new InterfazHistorialClinico(InterfazMedico.this).setVisible(true);
        });

        JButton btnReceta = new JButton("Generar Receta");
        btnReceta.setBounds(320, 120, 200, 80);
        btnReceta.addActionListener(e -> {
            // Obtener el médico actual
            Usuario usuarioActual = InterfazMain.GetUsuarioActual();
            Medico medicoActual = Medico.MedicoDeUsuario(usuarioActual);
            
            if (medicoActual == null) {
                JOptionPane.showMessageDialog(this, "No se encontró información médica", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            new InterfazGenerarReceta(InterfazMedico.this, medicoActual).setVisible(true);
        });

     // Agrega este botón en el constructor de InterfazMedico:
        JButton btnGestionCitas = new JButton("Gestionar Citas");
        btnGestionCitas.setBounds(320, 240, 200, 80);
        btnGestionCitas.addActionListener(e -> {
            Usuario usuarioActual = InterfazMain.GetUsuarioActual();
            Medico medicoActual = Medico.MedicoDeUsuario(usuarioActual);
            
            if (medicoActual != null) {
                new InterfazGestionCitas(this, medicoActual).setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No se encontró información médica asociada", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(btnGestionCitas);

        JButton btnEmergencia = new JButton("Registrar Emergencia");
        btnEmergencia.setBounds(320, 240, 200, 80);
        btnEmergencia.addActionListener(e -> {
            new InterfazRegistrarEmergencia(this).setVisible(true);
            setVisible(false);
        });

        // Cerrar sesión (consistente con tu estilo)
        JButton btnLogout = new JButton("Cerrar Sesión");
        btnLogout.setBounds(400, 400, 150, 40);
        btnLogout.addActionListener(e -> {
            new InterfazLoginEmpleado(null).setVisible(true);
            dispose();
        });

        // Añadir componentes
        contentPane.add(btnHistorial);
        contentPane.add(btnReceta);
        contentPane.add(btnEmergencia);
        contentPane.add(btnLogout);
    }
}