package vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.BaseDatosSimulada;
import modelo.Paciente;
import modelo.Rol;
import modelo.Usuario;

import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import vista.InterfazFuncionesPaciente;


public class InterfazRegistroPaciente extends JFrame {

	private JFrame ventanaAnterior;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtdni;
	private JTextField txtnombres;
	private JTextField txtapellidopa;
	private JTextField txtapellidoma;
	private JTextField txtedad;
	private JTextField txtnumtelefonico;
	private JTextField txtemail;
	private JTextField txtdireccion;
	private JTextField txtddmmyyyy;
	private JTextField txtusuariocreado;
	private JPasswordField pfrepetircontraseña;
	private JPasswordField pfnuevacontraseña;
	private boolean esRecepcionista;

	
	//funcion para abrir Ventana de las funciones del paciente
	private void abrirVentanaPaciente(Paciente paciente) {
	    if (esRecepcionista) {
	        // Vuelve a la ventana del recepcionista
	        ventanaAnterior.setVisible(true);
	        dispose();
	    } else {
	        // Abre funciones del paciente si se auto-registró
	        InterfazFuncionesPaciente ventana = new InterfazFuncionesPaciente(paciente);
	        ventana.setVisible(true);
	        dispose();
	    }
	}

	//metodo para indicar si la fecha ingresada es valida
	private boolean esFechaValida(String fechaTexto) {
	    if (fechaTexto.equals("dd/mm/yyyy")) return false;
	    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    try {
	        sdf.parse(fechaTexto);
	        return true;
	    } catch (java.text.ParseException e) {
	        return false;
	    }
	}


	/**
	 * Create the frame.
	 */
	public InterfazRegistroPaciente(JFrame ventanaAnterior, boolean esRecepcionista) {
	    this(ventanaAnterior); // llama al constructor principal
	    if (esRecepcionista) {
	        setTitle("Registro de Paciente (Recepcionista)");
	        // puedes hacer más cambios visuales aquí si deseas
	    }
	}
	

	/**
	 * @wbp.parser.constructor
	 */
	public InterfazRegistroPaciente(JFrame ventanaAnterior) {
		this.ventanaAnterior = ventanaAnterior;
		setTitle("Registro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//panel superior
		JPanel bg3 = new JPanel();
		bg3.setBackground(SystemColor.textHighlight);
		bg3.setBounds(0, 0, 734, 85);
		contentPane.add(bg3);
		bg3.setLayout(null);
		
		//panel inferior
		JPanel bg2 = new JPanel();
		bg2.setBounds(0, 80, 734, 431);
		contentPane.add(bg2);
		bg2.setLayout(null);
		
		
		//texto Registro paciente
		JLabel lblregistropaciente = new JLabel("DATOS PERSONALES");
		lblregistropaciente.setForeground(SystemColor.text);
		lblregistropaciente.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblregistropaciente.setBounds(209, 25, 345, 35);
		bg3.add(lblregistropaciente);
		
		if (esRecepcionista) {
		    lblregistropaciente.setText("REGISTRO DE PACIENTE (Recepcionista)");
		}
		
		
		//apartado dni
		JLabel lbldni = new JLabel("DNI Paciente:");
		lbldni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbldni.setBounds(78, 23, 103, 14);
		bg2.add(lbldni);
		
		txtdni = new JTextField();
		txtdni.setBounds(232, 23, 175, 20);
		bg2.add(txtdni);
		txtdni.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setColumns(10);
		txtnombres.setBounds(232, 50, 175, 20);
		bg2.add(txtnombres);
		
		//apartado nombres
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombres.setBounds(78, 50, 103, 14);
		bg2.add(lblNombres);
		
		txtapellidopa = new JTextField();
		txtapellidopa.setColumns(10);
		txtapellidopa.setBounds(232, 81, 175, 20);
		bg2.add(txtapellidopa);
		
		//apartado apellidos
		JLabel lblApellidos = new JLabel("Apellidos Paterno:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setBounds(78, 81, 103, 14);
		bg2.add(lblApellidos);
		
		txtapellidoma = new JTextField();
		txtapellidoma.setColumns(10);
		txtapellidoma.setBounds(232, 110, 175, 20);
		bg2.add(txtapellidoma);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidoMaterno.setBounds(78, 110, 103, 14);
		bg2.add(lblApellidoMaterno);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(78, 153, 103, 14);
		bg2.add(lblEdad);
		
		txtedad = new JTextField();
		txtedad.setColumns(10);
		txtedad.setBounds(127, 151, 103, 20);
		bg2.add(txtedad);
		
		
		//apartado sexo
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(253, 153, 103, 14);
		bg2.add(lblSexo);
		
		
		JComboBox<String> comboBoxSexo = new JComboBox<>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<>(
			    new String[] {"Seleccione...", "Masculino", "Femenino"}
			));
		comboBoxSexo.setBounds(304, 150, 103, 22);
		bg2.add(comboBoxSexo);
		
		//apartado telefono
		JLabel lblNmeroTelefnico = new JLabel("Número telefónico:");
		lblNmeroTelefnico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNmeroTelefnico.setBounds(78, 203, 115, 14);
		bg2.add(lblNmeroTelefnico);
		
		txtnumtelefonico = new JTextField();
		txtnumtelefonico.setColumns(10);
		txtnumtelefonico.setBounds(232, 203, 175, 20);
		bg2.add(txtnumtelefonico);

        //apartado email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(78, 230, 103, 14);
		bg2.add(lblEmail);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(232, 230, 175, 20);
		bg2.add(txtemail);
		
		//apartado direccion
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(78, 259, 103, 14);
		bg2.add(lblDireccion);
		
		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(232, 259, 175, 20);
		bg2.add(txtdireccion);
		
		
		//fecha nacimiento
		JLabel lblFechaNacimientoddmmyyyy = new JLabel("Fecha nacimiento:");
		lblFechaNacimientoddmmyyyy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaNacimientoddmmyyyy.setBounds(78, 286, 228, 14);
		bg2.add(lblFechaNacimientoddmmyyyy);
		
		txtddmmyyyy = new JTextField();
		txtddmmyyyy.setForeground(Color.LIGHT_GRAY);
		txtddmmyyyy.setText("dd/mm/yyyy");
		txtddmmyyyy.setColumns(10);
		txtddmmyyyy.setBounds(232, 286, 175, 20);
		bg2.add(txtddmmyyyy);
		
		// Placeholder que se borra al hacer clic
        txtddmmyyyy.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtddmmyyyy.getText().equals("dd/mm/yyyy")) {
                    txtddmmyyyy.setText("");
                    txtddmmyyyy.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtddmmyyyy.getText().isEmpty()) {
                    txtddmmyyyy.setText("dd/mm/yyyy");
                    txtddmmyyyy.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
		
		
		//nuevo usuario
		JLabel lblIngreseSuNuevousuario = new JLabel("Ingrese su nuevo usuario:");
		lblIngreseSuNuevousuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseSuNuevousuario.setBounds(78, 336, 191, 14);
		bg2.add(lblIngreseSuNuevousuario);
		
		txtusuariocreado = new JTextField();
		txtusuariocreado.setColumns(10);
		txtusuariocreado.setBounds(242, 334, 165, 20);
		bg2.add(txtusuariocreado);
		
		//nueva contraseña
		JLabel lblIngresocontraseñanueva = new JLabel("Ingrese su nuevo contraseña:");
		lblIngresocontraseñanueva.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngresocontraseñanueva.setBounds(78, 363, 191, 14);
		bg2.add(lblIngresocontraseñanueva);
		
		//repetir contraseña
		JLabel lblRepitaSuContraseña = new JLabel("Repita su contraseña:");
		lblRepitaSuContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRepitaSuContraseña.setBounds(78, 390, 191, 14);
		bg2.add(lblRepitaSuContraseña);
		
		JLabel lbloprimaqui = new JLabel("Luego de completar los datos oprima aqui:");
		lbloprimaqui.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbloprimaqui.setBounds(452, 23, 242, 14);
		bg2.add(lbloprimaqui);
		
		
		//boton de REGISTRAR PACIENTE
		JButton btnregistrarpaciente = new JButton("");
		btnregistrarpaciente.setBounds(505, 63, 132, 132);
		bg2.add(btnregistrarpaciente);

		
		// Escalar la imagen para que encaje bien en el botón
		ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagenes/btnregistrar.png"));
		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(132, 132, Image.SCALE_SMOOTH);
		btnregistrarpaciente.setIcon(new ImageIcon(imagenEscalada));

		btnregistrarpaciente.setContentAreaFilled(false);  // quita fondo
		btnregistrarpaciente.setBorderPainted(false);      // quita borde
		btnregistrarpaciente.setFocusPainted(false);       // quita borde al seleccionar
		btnregistrarpaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		
		
		pfrepetircontraseña = new JPasswordField();
		pfrepetircontraseña.setBounds(242, 388, 165, 20);
		bg2.add(pfrepetircontraseña);
		
		pfnuevacontraseña = new JPasswordField();
		pfnuevacontraseña.setBounds(242, 361, 165, 20);
		bg2.add(pfnuevacontraseña);
		
		JLabel lbletrocederclickaqui = new JLabel("Para retroceder click aqui:");
		lbletrocederclickaqui.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbletrocederclickaqui.setBounds(462, 265, 242, 14);
		bg2.add(lbletrocederclickaqui);
		
		
		//BOTON PARA INICIAR SESION AHORA SI 
		JButton btnatras = new JButton("Atrás");
		btnatras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnatras.setBounds(522, 303, 115, 47);
		bg2.add(btnatras);
		
		btnatras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
		        dispose(); // Cierra la ventana actual
			}
		});
		
		
		//accion al hacer click sobre el boton para registrar paciente
		btnregistrarpaciente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        String dni = txtdni.getText().trim();
		        String nombres = txtnombres.getText().trim();
		        String apellidoPa = txtapellidopa.getText().trim();
		        String apellidoMa = txtapellidoma.getText().trim();
		        String edad = txtedad.getText().trim();
		        String sexo = comboBoxSexo.getSelectedItem().toString();
		        String telefono = txtnumtelefonico.getText().trim();
		        String email = txtemail.getText().trim();
		        String direccion = txtdireccion.getText().trim();
		        String fechaNacimiento = txtddmmyyyy.getText().trim();
		        String usuario = txtusuariocreado.getText().trim();
		        char[] contrasenaChars = pfnuevacontraseña.getPassword();
		        char[] repetirContrasenaChars = pfrepetircontraseña.getPassword();

		        String contrasena = new String(contrasenaChars).trim();
		        String repetirContrasena = new String(repetirContrasenaChars).trim();
		        

		        // Opcional: limpiar arrays
		        Arrays.fill(contrasenaChars, ' ');
		        Arrays.fill(repetirContrasenaChars, ' ');


		        // Validaciones una a una:
		        
		        if (dni.isEmpty() || !dni.matches("\\d{8}")) {
		            JOptionPane.showMessageDialog(null, " El DNI debe tener exactamente 8 dígitos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (nombres.isEmpty()) {
		            JOptionPane.showMessageDialog(null, " Ingrese los nombres.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (apellidoPa.isEmpty()) {
		            JOptionPane.showMessageDialog(null, " Ingrese el apellido paterno.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (apellidoMa.isEmpty()) {
		            JOptionPane.showMessageDialog(null, " Ingrese el apellido materno.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (edad.isEmpty() || !edad.matches("\\d+")) {
		            JOptionPane.showMessageDialog(null, " Ingrese una edad válida.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (sexo.equals("Seleccione...")) {
		            JOptionPane.showMessageDialog(null,
		                "Por favor seleccione el sexo del paciente.",
		                "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (telefono.isEmpty() || !telefono.matches("\\d{9}")) {
		            JOptionPane.showMessageDialog(null, " Ingrese un número telefónico válido.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (email.isEmpty() || !email.matches("^(.+)@(.+)$")) {
		            JOptionPane.showMessageDialog(null, " Ingrese un email válido.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (direccion.isEmpty()) {
		            JOptionPane.showMessageDialog(null, " Ingrese la dirección.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (fechaNacimiento.isEmpty() || fechaNacimiento.equals("dd/mm/yyyy")) {
		            JOptionPane.showMessageDialog(null, " Ingrese la fecha de nacimiento.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (!esFechaValida(fechaNacimiento)) {
		            JOptionPane.showMessageDialog(null, " La fecha debe tener el formato dd/mm/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (usuario.isEmpty()) {
		            JOptionPane.showMessageDialog(null, " Ingrese un nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (contrasena.isEmpty()) {
		            JOptionPane.showMessageDialog(null, " Ingrese una contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if (!contrasena.equals(repetirContrasena)) {
		            JOptionPane.showMessageDialog(null, " Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        // Si pasa todas las validaciones:
		     // → Verificar si el paciente ya existe
		        Paciente pacienteExistente = null;

		        for (Paciente p : Paciente.getPacientes()) {
		            if (p.getDNI().equals(dni) ||
		                p.getUsuario().getUserName().equals(usuario)) {
		                pacienteExistente = p;
		                break;
		            }
		        }

		        if (pacienteExistente != null) {
		            JOptionPane.showMessageDialog(null,
		                "Ya estás registrado. Iniciando sesión...");

		            abrirVentanaPaciente(pacienteExistente);

		        } else {
		            try {
		                Usuario nuevoUsuario = new Usuario(
		                    usuario,
		                    contrasena,
		                    new Rol(3, Rol.PACIENTE),
		                    true
		                );

		                Paciente nuevo = new Paciente(
		                	    dni,
		                	    nombres,
		                	    apellidoPa,
		                	    apellidoMa,
		                	    Integer.parseInt(edad),
		                	    sexo,
		                	    Paciente.getFormatofecha().parse(fechaNacimiento),
		                	    Integer.parseInt(telefono),
		                	    email,
		                	    direccion,
		                	    nuevoUsuario
		                	);
		                Paciente.getPacientes().add(nuevo);
		                BaseDatosSimulada.getUsuarios().add(nuevoUsuario);


		                JOptionPane.showMessageDialog(null,
		                    "Registro exitoso. Bienvenido.");

		                abrirVentanaPaciente(nuevo);

		            } catch (Exception ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null,
		                    "Error al registrar paciente.",
		                    "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }

		        

		        
		        // Limpiar campos
		        limpiarCampos();
		    }
		});
		

		
		

	}
	
	
	//metodo para limpiar campos al terminar el registro
	private void limpiarCampos() {
	    txtdni.setText("");
	    txtnombres.setText("");
	    txtapellidopa.setText("");
	    txtapellidoma.setText("");
	    txtedad.setText("");
	    txtnumtelefonico.setText("");
	    txtemail.setText("");
	    txtdireccion.setText("");
	    txtddmmyyyy.setText("dd/mm/yyyy");
	    txtddmmyyyy.setForeground(Color.LIGHT_GRAY);
	    txtusuariocreado.setText("");
	    pfnuevacontraseña.setText("");
	    pfrepetircontraseña.setText("");
	}
}
