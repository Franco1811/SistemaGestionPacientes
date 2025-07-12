package vista;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import herramientas.UtilidadesImagen;
import modelo.BaseDatosSimulada;
import modelo.Paciente;
import modelo.Usuario;
import modelo.Rol;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField passwordField;
	private JFrame ventanaAnterior;


	public InterfazPaciente(JFrame ventanaAnterior) {
		this.ventanaAnterior = ventanaAnterior;
		setTitle("Panel del Paciente");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bg1 = new JPanel();
		bg1.setBounds(0, 0, 384, 461);
		contentPane.add(bg1);
		bg1.setLayout(null);
		
		//imagen de la foto de usuario 
        JLabel lblfotousuario = new JLabel();
        lblfotousuario.setBounds(133, 57, 118, 103);
        lblfotousuario.setIcon(UtilidadesImagen.cargarImagenEscalada("/imagenes/fotousuario.png",118, 103));
        bg1.add(lblfotousuario, JLayeredPane.DEFAULT_LAYER); 
        
		//texto de inicio de sesion
        JLabel lbliniciarsesion = new JLabel("Iniciar sesión");
        lbliniciarsesion.setFont(new Font("Tahoma", Font.ITALIC, 20));
        lbliniciarsesion.setBounds(133, 32, 139, 14);
        bg1.add(lbliniciarsesion);
        
        
        // Botón de registrarse 
        JLabel lblRegistrarse = new JLabel("<HTML><U>Regístrate</U></HTML>");
        lblRegistrarse.setFont(new Font("Tahoma", Font.ITALIC, 13));
        // Apariencia de enlace
        lblRegistrarse.setForeground(SystemColor.textHighlight); // Azul
        lblRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Manito
        lblRegistrarse.setBounds(216, 171, 72, 14);
        bg1.add(lblRegistrarse);
        

        // Acción al hacer clic
        lblRegistrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfazRegistroPaciente ventanaRegistro = new InterfazRegistroPaciente(InterfazPaciente.this);
                ventanaRegistro.setVisible(true);
                setVisible(false);
            }
        });

        
        
        //texto de primera vez
        JLabel lblprimeravez = new JLabel("¿Es tu primera vez?");
        lblprimeravez.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblprimeravez.setBounds(94, 171, 129, 14);
        bg1.add(lblprimeravez);
        
        //texto usuario
        JLabel lblusuario = new JLabel("USUARIO");
        lblusuario.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblusuario.setBounds(38, 216, 86, 14);
        bg1.add(lblusuario);
        
        //textfield del nombre de usuario
        txtuser = new JTextField();
        txtuser.setFont(new Font("Tahoma", Font.ITALIC, 11));
        txtuser.setForeground(SystemColor.activeCaptionBorder);
        txtuser.setText("Ingrese su nombre de usuario");
        txtuser.setBounds(38, 243, 271, 20);
        bg1.add(txtuser);
        txtuser.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, SystemColor.activeCaptionBorder)); //para q solo mantenta la linea inferior
        txtuser.setColumns(10);
        
     // Placeholder del campo usuario
        txtuser.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtuser.getText().equals("Ingrese su nombre de usuario")) {
                    txtuser.setText("");
                    txtuser.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtuser.getText().isEmpty()) {
                    txtuser.setForeground(SystemColor.activeCaptionBorder);
                    txtuser.setText("Ingrese su nombre de usuario");
                }
            }
        });
        
        //texto contraseña
        JLabel lblContraseña = new JLabel("CONTRASEÑA");
        lblContraseña.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblContraseña.setBounds(38, 287, 86, 14);
        bg1.add(lblContraseña);
        
        //contraseña de usuario
        passwordField = new JPasswordField();
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setFont(new Font("Tahoma", Font.ITALIC, 11));
        passwordField.setText("******");
        passwordField.setBounds(38, 314, 271, 20);
        bg1.add(passwordField);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, SystemColor.activeCaptionBorder)); //para q solo mantenta la linea inferior

     // Placeholder para contraseña
        passwordField.setEchoChar((char) 0); // Mostrar texto temporalmente

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String pass = new String(passwordField.getPassword());
                if (pass.equals("******")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setEchoChar('●'); // O '*'
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String pass = new String(passwordField.getPassword());
                if (pass.isEmpty()) {
                    passwordField.setText("******");
                    passwordField.setForeground(SystemColor.activeCaptionBorder);
                    passwordField.setEchoChar((char) 0);
                }
            }
        });
        
        
        // Boton iniciar sesion
        JButton btnIniciarsesion = new JButton("Iniciar sesion");
        btnIniciarsesion.setFont(new Font("Tahoma", Font.ITALIC, 12));
        btnIniciarsesion.setBounds(94, 362, 178, 41);
        btnIniciarsesion.setBorder(new LineBorder(Color.GRAY, 1, true));
        bg1.add(btnIniciarsesion);
        
        btnIniciarsesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // manito al pasar el mouse
       
        
        //Validacion de campos 
        btnIniciarsesion.addActionListener(e -> {
            String usuario = txtuser.getText().trim();
            String contraseña = new String(passwordField.getPassword()).trim();

            // Validar si campos están vacíos o contienen el placeholder
            if (usuario.isEmpty() || usuario.equals("Ingrese su nombre de usuario") ||
                contraseña.isEmpty() || contraseña.equals("******")) {

                JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", 
                        "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Buscar si existe un paciente con ese usuario y contraseña
            Paciente pacienteEncontrado = null;

            for (Paciente p : BaseDatosSimulada.getListaPacientes()) {
                Usuario u = p.getUsuario();
                if (u.getUserName().equals(usuario) &&
                    u.getPassword().equals(contraseña)) {
                    pacienteEncontrado = p;
                    break;
                }
            }

            if (pacienteEncontrado != null) {
                JOptionPane.showMessageDialog(null, 
                    "Inicio de sesión exitoso", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                
                // Abrir ventana de funciones del paciente
                InterfazFuncionesPaciente ventana = new InterfazFuncionesPaciente(pacienteEncontrado);
                ventana.setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null,
                    "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        //Boton volver 
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Para abrir la ventna principal
                ventanaAnterior.setVisible(true);  // Muestra la ventana anterior
                dispose();   // Cierra esta
        	}
        });
        btnVolver.setFont(new Font("Tahoma", Font.ITALIC, 11));
        btnVolver.setBounds(10, 427, 72, 23);
        bg1.add(btnVolver);

	}
}
