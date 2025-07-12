package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import herramientas.UtilidadesImagen;
import modelo.BaseDatosSimulada;
import modelo.Usuario;
import modelo.Rol;

public class InterfazLoginEmpleado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JFrame ventanaAnterior;

    public InterfazLoginEmpleado() {
        this(null);
    }

    public InterfazLoginEmpleado(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Panel de login empleado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel bg1 = new JPanel();
        bg1.setLayout(null);
        bg1.setBounds(0, 0, 384, 461);
        contentPane.add(bg1);

        JLabel lbliniciarsesion = new JLabel("Iniciar sesión");
        lbliniciarsesion.setFont(new Font("Tahoma", Font.ITALIC, 20));
        lbliniciarsesion.setBounds(120, 32, 200, 25);
        bg1.add(lbliniciarsesion);

        JLabel lblfotousuario = new JLabel();
        lblfotousuario.setBounds(133, 70, 118, 103);
        lblfotousuario.setIcon(UtilidadesImagen.cargarImagenEscalada("/imagenes/fotousuario.png", 118, 103));
        bg1.add(lblfotousuario, JLayeredPane.DEFAULT_LAYER);

        JLabel lblusuario = new JLabel("USUARIO");
        lblusuario.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblusuario.setBounds(38, 200, 86, 20);
        bg1.add(lblusuario);

        textField = new JTextField("Ingrese su nombre de usuario");
        textField.setForeground(SystemColor.activeCaptionBorder);
        textField.setFont(new Font("Tahoma", Font.ITALIC, 11));
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, SystemColor.activeCaptionBorder));
        textField.setBounds(38, 225, 271, 25);
        bg1.add(textField);
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (textField.getText().equals("Ingrese su nombre de usuario")) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                    textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
                }
            }
        });

        JLabel lblContraseña = new JLabel("CONTRASEÑA");
        lblContraseña.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblContraseña.setBounds(38, 270, 110, 20);
        bg1.add(lblContraseña);

        passwordField = new JPasswordField("******");
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setFont(new Font("Tahoma", Font.ITALIC, 11));
        passwordField.setEchoChar('*');
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, SystemColor.activeCaptionBorder));
        passwordField.setBounds(38, 295, 271, 25);
        bg1.add(passwordField);
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("******")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
                }
            }
        });

        // BOTON INICIAR SESION
        JButton btnIniciarsesion = new JButton("Iniciar sesion");
        btnIniciarsesion.setFont(new Font("Tahoma", Font.ITALIC, 12));
        btnIniciarsesion.setBounds(94, 362, 178, 41);
        btnIniciarsesion.setBorder(new LineBorder(Color.GRAY, 1, true));
        bg1.add(btnIniciarsesion);
        btnIniciarsesion.addActionListener(e -> login());
        btnIniciarsesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // BOTON VOLVER
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            dispose();
            if (ventanaAnterior != null) {
                ventanaAnterior.setVisible(true);
            } else {
                new InterfazMain().setVisible(true);
            }
        });
        btnVolver.setFont(new Font("Tahoma", Font.ITALIC, 11));
        btnVolver.setBounds(10, 427, 72, 23);
        bg1.add(btnVolver);

        limpiarCampos();
    }

    private void login() {
        String usuario = textField.getText();
        String contrasena = new String(passwordField.getPassword());

        Usuario user = BaseDatosSimulada.buscarUsuarioPorUsuarioYContrasena(usuario, contrasena);

        if (user != null) {
            JOptionPane.showMessageDialog(this, 
                "Bienvenido " + user.getUserName() + "\nRol: " + user.getRol().getNombre());
            InterfazMain.UsuarioActual(user);
            switch (user.getRol().getNombre()) {
                case Rol.ADMINISTRADOR:
                    new InterfazAdmin(this).setVisible(true);
                    break;
                case Rol.RECEPCIONISTA:
                    new InterfazRecepcionista(this).setVisible(true);
                    break;
                case Rol.FARMACEUTICO:
                    new InterfazFarmaceutico(this).setVisible(true);
                    break;
                case Rol.LABORATORIO:
                    new InterfazLaboratorio(this).setVisible(true);
                    break;
                case Rol.MEDICO:
                    new InterfazMedico(this).setVisible(true);  
                    break;
                case Rol.ENFERMERO:
                    new InterfazEnfermero(this).setVisible(true); 
                    break;
                default:
                    JOptionPane.showMessageDialog(this, 
                        "No hay interfaz implementada para el rol: " + user.getRol().getNombre());
                    if (ventanaAnterior != null) {
                        ventanaAnterior.setVisible(true);
                    }
                    break;
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas o usuario inactivo.");
        }
    }

    public void limpiarCampos() {
        textField.setText("Ingrese su nombre de usuario");
        textField.setForeground(SystemColor.activeCaptionBorder);
        textField.setFont(new Font("Tahoma", Font.ITALIC, 11));

        passwordField.setText("******");
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setFont(new Font("Tahoma", Font.ITALIC, 11));
    }
}