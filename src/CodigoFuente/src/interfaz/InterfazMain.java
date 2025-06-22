package interfaz;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Paciente;
import clases.Usuario;
import clases.Medico;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;


public class InterfazMain extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static final SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	private JPanel contentPane;
	private JPanel panelLogIn;
	private JPanel panelLoginPaciente;
	private JButton btnPaciente, btnPersonal;
	private JLabel lblNewLabel_1;
	private JButton btnIniciarSesionPaciente;
	private JTextField txtUsuarioInicioSesion;
	private JLabel label;
	private JLabel label_1;
	private JButton btnRedireccionRegistrarPaciente;
	private JPasswordField passwordPaciente;
	private JLabel lblnoTieneCuenta;
	private JPanel panelRegistroPaciente;
	private JLabel lblNewLabel_2;
	private JButton btnRedireccionIniciarSesionPaciente;
	private JTextField txtUsuarioPaciente;
	private JLabel label_2;
	private JLabel label_1_1;
	private JButton btnRegistrarPaciente;
	private JLabel lblnoTieneCuenta_1;
	private JLabel lblIngreseSuNombre;
	private JTextField txtNombrePaciente;
	private JLabel lblIngreseSuApellido;
	private JTextField txtApellidoPaciente;
	private JLabel label_1_2;
	private JTextField txtDniPaciente;
	private JLabel label_1_2_1;
	private JTextField txtFechaPaciente;
	private JLabel label_1_2_3;
	private JTextField txtNumeroPaciente;
	private JLabel lblIngreseSuEmail;
	private JTextField txtEmaiPaciente;
	private JPasswordField passwordRegistroPaciente;
	private JLabel label_1_1_1;
	private JPasswordField passwordRegistroVerificacion;
	private JPanel panelLoginPersonal;
	private JLabel lblNewLabel_3;
	private JButton btnIniciarSesionPersonal;
	private JTextField txtUsuarioPersonal;
	private JLabel label_3;
	private JLabel label_4;
	private JPasswordField passwordPersonal;
	private JButton btnVolver1;
	private JButton btnVolver2;
	private JLabel label_1_2_2;
	private JTextField txtDireccion;
	private JPanel panelMainPaciente;
	private JLabel labelSaludo;
	private JButton btnModificarPaciente;
	private JButton btnInformesPaciente;
	private JButton btnSolicitarCitaPaciente;
	private JButton btnDispoMedicamentos;
	private JButton btnCitasPaciente;
	private JButton btnRecetasPaciente;
	private JButton btnCerrarSesionPaciente;
	private JPanel panelModificarDatosPaciente;
	private JTextField txtModApellidoPaciente;
	private JLabel lblIngreseSuApellido_1;
	private JTextField txtModNombrePaciente;
	private JLabel lblIngreseSuNombre_1;
	private JLabel lblNewLabel_5;
	private JTextField txtModDniPaciente;
	private JLabel label_1_3;
	private JTextField txtModFechaPaciente;
	private JLabel label_1_2_4;
	private JLabel txtModNumeroPaciente;
	private JTextField txtModNumero;
	private JTextField txtModDireccionPaciente;
	private JLabel label_1_2_6;
	private JButton btnModificarDatosPaciente;
	private JPasswordField passwordModVerificacion;
	private JLabel label_1_1_2;
	private JPasswordField passwordModPaciente;
	private JLabel label_1_4;
	private JTextField txtModUsuarioPaciente;
	private JLabel label_5;
	private JTextField txtModEmailPaciente;
	private JLabel lblIngreseSuEmail_1;
	private JButton btnVolverMain;
	private Usuario ActualUsuario;
	private Paciente ActualPaciente;
	private Medico ActualMedico;
	private JLabel lblHospitalsanJos;
	private JLabel lblNewLabel_4;
	private JButton btnRevisarPerfilPaciente;
	private JPanel panelPerfilPaciente;
	private JButton btnVolverPerfilPaciente;
	private JLabel lblNewLabel_6;
	private JLabel label_6;
	private JLabel lblIngreseSuNombre_2;
	private JLabel lblIngreseSuApellido_2;
	private JLabel label_1_5;
	private JLabel label_1_2_5;
	private JLabel label_1_2_7;
	private JLabel lblIngreseSuEmail_2;
	private JLabel label_1_2_8;
	private JTextArea txtNombreSalida;
	private JTextArea txtApellidoSalida;
	private JTextArea txtDniSalida;
	private JTextArea txtFechaSalida;
	private JTextArea txtNumeroSalida;
	private JTextArea txtDireccionSalida;
	private JTextArea txtEmailSalida;
	private JTextArea txtNomUsarioSalida;

	/**
	/**
	 * Create the frame.
	 */
	public InterfazMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Programa de hospital");
		setLocationRelativeTo(null);
		setResizable(false);
		
		iniciarComponentes();
		

	}

	private void iniciarComponentes() {
		setBounds(100, 100, 702, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelLogIn = new JPanel();
		panelLogIn.setLayout(null);
		panelLogIn.setBounds(10, 10, 668, 381);
		contentPane.add(panelLogIn);
		panelLogIn.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a la interfaz gráfica de nuestro hospital");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 56, 358, 42);
		panelLogIn.add(lblNewLabel);
		
		btnPaciente = new JButton("Paciente");
		btnPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPaciente.setBounds(0, 173, 224, 54);
		panelLogIn.add(btnPaciente);
		btnPaciente.addActionListener(this);
		
		btnPersonal = new JButton("Personal");
		btnPersonal.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPersonal.setBounds(0, 261, 224, 54);
		panelLogIn.add(btnPersonal);
		
		lblHospitalsanJos = new JLabel("Hospital \"San José\"");
		lblHospitalsanJos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalsanJos.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
		lblHospitalsanJos.setBounds(0, 0, 668, 42);
		panelLogIn.add(lblHospitalsanJos);
		
		lblNewLabel_4 = new JLabel("Opciones de inicio de sesión:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(0, 112, 358, 42);
		panelLogIn.add(lblNewLabel_4);
		btnPersonal.addActionListener(this);
		
		
		panelPerfilPaciente = new JPanel();
		panelPerfilPaciente.setBounds(10, 10, 668, 381);
		contentPane.add(panelPerfilPaciente);
		panelPerfilPaciente.setLayout(null);
		
		btnVolverPerfilPaciente = new JButton("Volver");
		btnVolverPerfilPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolverPerfilPaciente.setBounds(567, 0, 91, 33);
		panelPerfilPaciente.add(btnVolverPerfilPaciente);
		btnVolverPerfilPaciente.addActionListener(this);
		
		lblNewLabel_6 = new JLabel("Su perfil:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 29));
		lblNewLabel_6.setBounds(10, 0, 263, 54);
		panelPerfilPaciente.add(lblNewLabel_6);
		
		label_6 = new JLabel("Su nombre de Usuario:");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(10, 282, 180, 34);
		panelPerfilPaciente.add(label_6);
		
		lblIngreseSuNombre_2 = new JLabel("Su nombre:");
		lblIngreseSuNombre_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuNombre_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuNombre_2.setBounds(10, 64, 118, 34);
		panelPerfilPaciente.add(lblIngreseSuNombre_2);
		
		lblIngreseSuApellido_2 = new JLabel("Su apellido:");
		lblIngreseSuApellido_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuApellido_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuApellido_2.setBounds(10, 97, 180, 34);
		panelPerfilPaciente.add(lblIngreseSuApellido_2);
		
		label_1_5 = new JLabel("Su nombre de DNI:");
		label_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_5.setBounds(10, 128, 180, 34);
		panelPerfilPaciente.add(label_1_5);
		
		label_1_2_5 = new JLabel("Su fecha de nacimiento (dd/mm/yyyy):");
		label_1_2_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_5.setBounds(10, 160, 252, 34);
		panelPerfilPaciente.add(label_1_2_5);
		
		label_1_2_7 = new JLabel("Su numero de telefono:");
		label_1_2_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_7.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_7.setBounds(10, 191, 252, 34);
		panelPerfilPaciente.add(label_1_2_7);
		
		lblIngreseSuEmail_2 = new JLabel("Su email:");
		lblIngreseSuEmail_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuEmail_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuEmail_2.setBounds(10, 251, 180, 34);
		panelPerfilPaciente.add(lblIngreseSuEmail_2);
		
		label_1_2_8 = new JLabel("Su direccion:");
		label_1_2_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_8.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_8.setBounds(10, 222, 252, 34);
		panelPerfilPaciente.add(label_1_2_8);
		
		txtNombreSalida = new JTextArea();
		txtNombreSalida.setEditable(false);
		txtNombreSalida.setBounds(238, 69, 214, 22);
		panelPerfilPaciente.add(txtNombreSalida);
		
		txtApellidoSalida = new JTextArea();
		txtApellidoSalida.setEditable(false);
		txtApellidoSalida.setBounds(238, 102, 214, 22);
		panelPerfilPaciente.add(txtApellidoSalida);
		
		txtDniSalida = new JTextArea();
		txtDniSalida.setEditable(false);
		txtDniSalida.setBounds(238, 133, 214, 22);
		panelPerfilPaciente.add(txtDniSalida);
		
		txtFechaSalida = new JTextArea();
		txtFechaSalida.setEditable(false);
		txtFechaSalida.setBounds(238, 165, 214, 22);
		panelPerfilPaciente.add(txtFechaSalida);
		
		txtNumeroSalida = new JTextArea();
		txtNumeroSalida.setEditable(false);
		txtNumeroSalida.setBounds(238, 196, 214, 22);
		panelPerfilPaciente.add(txtNumeroSalida);
		
		txtDireccionSalida = new JTextArea();
		txtDireccionSalida.setEditable(false);
		txtDireccionSalida.setBounds(238, 227, 214, 22);
		panelPerfilPaciente.add(txtDireccionSalida);
		
		txtEmailSalida = new JTextArea();
		txtEmailSalida.setEditable(false);
		txtEmailSalida.setBounds(238, 256, 214, 22);
		panelPerfilPaciente.add(txtEmailSalida);
		
		txtNomUsarioSalida = new JTextArea();
		txtNomUsarioSalida.setEditable(false);
		txtNomUsarioSalida.setBounds(238, 287, 214, 22);
		panelPerfilPaciente.add(txtNomUsarioSalida);
		panelPerfilPaciente.setVisible(false);
		
		panelMainPaciente = new JPanel();
		panelMainPaciente.setBounds(10, 10, 668, 381);
		contentPane.add(panelMainPaciente);
		panelMainPaciente.setLayout(null);
		
		labelSaludo = new JLabel("Hola, ");
		labelSaludo.setHorizontalAlignment(SwingConstants.CENTER);
		labelSaludo.setFont(new Font("Arial", Font.PLAIN, 29));
		labelSaludo.setBounds(395, 14, 263, 54);
		panelMainPaciente.add(labelSaludo);
		
		btnModificarPaciente = new JButton("Modifica tus datos");
		btnModificarPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnModificarPaciente.setBounds(0, 10, 169, 72);
		panelMainPaciente.add(btnModificarPaciente);
		btnModificarPaciente.addActionListener(this);
		
		btnInformesPaciente = new JButton("Informes medicos");
		btnInformesPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInformesPaciente.setBounds(0, 86, 169, 72);
		panelMainPaciente.add(btnInformesPaciente);
		
		btnSolicitarCitaPaciente = new JButton("Solicitar cita");
		btnSolicitarCitaPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSolicitarCitaPaciente.setBounds(0, 168, 169, 72);
		panelMainPaciente.add(btnSolicitarCitaPaciente);
		
		btnDispoMedicamentos = new JButton("Disponibilidad de medicamentos");
		btnDispoMedicamentos.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDispoMedicamentos.setBounds(0, 250, 169, 72);
		panelMainPaciente.add(btnDispoMedicamentos);
		
		btnCitasPaciente = new JButton("Ver citas");
		btnCitasPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCitasPaciente.setBounds(179, 10, 169, 72);
		panelMainPaciente.add(btnCitasPaciente);
		
		btnRecetasPaciente = new JButton("Ver recetas");
		btnRecetasPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRecetasPaciente.setBounds(179, 86, 169, 72);
		panelMainPaciente.add(btnRecetasPaciente);
		
		btnCerrarSesionPaciente = new JButton("Cerrar sesion");
		btnCerrarSesionPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCerrarSesionPaciente.setBounds(550, 311, 118, 64);
		panelMainPaciente.add(btnCerrarSesionPaciente);
		
		btnRevisarPerfilPaciente = new JButton("Ver Perfil");
		btnRevisarPerfilPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRevisarPerfilPaciente.setBounds(475, 61, 183, 45);
		panelMainPaciente.add(btnRevisarPerfilPaciente);
		panelMainPaciente.setVisible(false);
		btnRevisarPerfilPaciente.addActionListener(this);
		
		panelModificarDatosPaciente = new JPanel();
		panelModificarDatosPaciente.setBounds(10, 10, 668, 381);
		contentPane.add(panelModificarDatosPaciente);
		panelModificarDatosPaciente.setLayout(null);
		
		txtModApellidoPaciente = new JTextField();
		txtModApellidoPaciente.setToolTipText("");
		txtModApellidoPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModApellidoPaciente.setColumns(10);
		txtModApellidoPaciente.setBounds(148, 135, 113, 19);
		panelModificarDatosPaciente.add(txtModApellidoPaciente);
		
		lblIngreseSuApellido_1 = new JLabel("Ingrese su apellido:");
		lblIngreseSuApellido_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuApellido_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuApellido_1.setBounds(145, 91, 180, 34);
		panelModificarDatosPaciente.add(lblIngreseSuApellido_1);
		
		txtModNombrePaciente = new JTextField();
		txtModNombrePaciente.setToolTipText("");
		txtModNombrePaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModNombrePaciente.setColumns(10);
		txtModNombrePaciente.setBounds(20, 135, 101, 19);
		panelModificarDatosPaciente.add(txtModNombrePaciente);
		
		lblIngreseSuNombre_1 = new JLabel("Ingrese su nombre:");
		lblIngreseSuNombre_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuNombre_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuNombre_1.setBounds(20, 91, 118, 34);
		panelModificarDatosPaciente.add(lblIngreseSuNombre_1);
		
		lblNewLabel_5 = new JLabel("Modifique sus datos ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 29));
		lblNewLabel_5.setBounds(20, 0, 263, 54);
		panelModificarDatosPaciente.add(lblNewLabel_5);
		
		txtModDniPaciente = new JTextField();
		txtModDniPaciente.setToolTipText("");
		txtModDniPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModDniPaciente.setColumns(10);
		txtModDniPaciente.setBounds(20, 192, 150, 19);
		panelModificarDatosPaciente.add(txtModDniPaciente);
		
		label_1_3 = new JLabel("Ingrese su nombre de DNI:");
		label_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_3.setBounds(20, 156, 180, 34);
		panelModificarDatosPaciente.add(label_1_3);
		
		txtModFechaPaciente = new JTextField();
		txtModFechaPaciente.setToolTipText("");
		txtModFechaPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModFechaPaciente.setColumns(10);
		txtModFechaPaciente.setBounds(20, 251, 150, 19);
		panelModificarDatosPaciente.add(txtModFechaPaciente);
		
		label_1_2_4 = new JLabel("Ingrese su fecha de nacimiento (dd/mm/yyyy):");
		label_1_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_4.setBounds(20, 221, 252, 34);
		panelModificarDatosPaciente.add(label_1_2_4);
		
		txtModNumeroPaciente = new JLabel("Ingrese su numero de telefono:");
		txtModNumeroPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		txtModNumeroPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModNumeroPaciente.setBounds(20, 272, 252, 34);
		panelModificarDatosPaciente.add(txtModNumeroPaciente);
		
		txtModNumero = new JTextField();
		txtModNumero.setToolTipText("");
		txtModNumero.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModNumero.setColumns(10);
		txtModNumero.setBounds(20, 309, 150, 19);
		panelModificarDatosPaciente.add(txtModNumero);
		
		txtModDireccionPaciente = new JTextField();
		txtModDireccionPaciente.setToolTipText("");
		txtModDireccionPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModDireccionPaciente.setColumns(10);
		txtModDireccionPaciente.setBounds(20, 352, 150, 19);
		panelModificarDatosPaciente.add(txtModDireccionPaciente);
		
		label_1_2_6 = new JLabel("Ingrese su direccion:");
		label_1_2_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_6.setBounds(20, 319, 252, 34);
		panelModificarDatosPaciente.add(label_1_2_6);
		
		btnModificarDatosPaciente = new JButton("Modifica tus datos");
		btnModificarDatosPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnModificarDatosPaciente.setBounds(452, 299, 169, 72);
		panelModificarDatosPaciente.add(btnModificarDatosPaciente);
		btnModificarDatosPaciente.addActionListener(this);
		
		passwordModVerificacion = new JPasswordField();
		passwordModVerificacion.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordModVerificacion.setBounds(452, 272, 180, 19);
		panelModificarDatosPaciente.add(passwordModVerificacion);
		
		label_1_1_2 = new JLabel("Repite tu contraseña nueva:");
		label_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_1_2.setBounds(452, 244, 180, 34);
		panelModificarDatosPaciente.add(label_1_1_2);
		
		passwordModPaciente = new JPasswordField();
		passwordModPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordModPaciente.setBounds(452, 228, 180, 19);
		panelModificarDatosPaciente.add(passwordModPaciente);
		
		label_1_4 = new JLabel("Ingrese nueva contraseña:");
		label_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_4.setBounds(452, 200, 180, 34);
		panelModificarDatosPaciente.add(label_1_4);
		
		txtModUsuarioPaciente = new JTextField();
		txtModUsuarioPaciente.setToolTipText("");
		txtModUsuarioPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModUsuarioPaciente.setColumns(10);
		txtModUsuarioPaciente.setBounds(452, 185, 180, 19);
		panelModificarDatosPaciente.add(txtModUsuarioPaciente);
		
		label_5 = new JLabel("Ingrese su nombre de Usuario:");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(452, 156, 180, 34);
		panelModificarDatosPaciente.add(label_5);
		
		txtModEmailPaciente = new JTextField();
		txtModEmailPaciente.setToolTipText("");
		txtModEmailPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtModEmailPaciente.setColumns(10);
		txtModEmailPaciente.setBounds(452, 135, 180, 19);
		panelModificarDatosPaciente.add(txtModEmailPaciente);
		
		lblIngreseSuEmail_1 = new JLabel("Ingrese su email:");
		lblIngreseSuEmail_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuEmail_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuEmail_1.setBounds(452, 93, 180, 34);
		panelModificarDatosPaciente.add(lblIngreseSuEmail_1);
		
		btnVolverMain = new JButton("Volver");
		btnVolverMain.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolverMain.setBounds(577, 0, 91, 33);
		panelModificarDatosPaciente.add(btnVolverMain);
		panelModificarDatosPaciente.setVisible(false);
		btnVolverMain.addActionListener(this);
		
		panelRegistroPaciente = new JPanel();
		panelRegistroPaciente.setBounds(10, 10, 668, 381);
		contentPane.add(panelRegistroPaciente);
		panelRegistroPaciente.setLayout(null);
		panelRegistroPaciente.setVisible(false);
		
		lblNewLabel_2 = new JLabel("Te damos la bienvenida otra vez");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 29));
		lblNewLabel_2.setBounds(20, 10, 648, 54);
		panelRegistroPaciente.add(lblNewLabel_2);
		
		btnRedireccionIniciarSesionPaciente = new JButton("Iniciar sesion");
		btnRedireccionIniciarSesionPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRedireccionIniciarSesionPaciente.setBounds(462, 330, 150, 27);
		panelRegistroPaciente.add(btnRedireccionIniciarSesionPaciente);
		btnRedireccionIniciarSesionPaciente.addActionListener(this);
		
		txtUsuarioPaciente = new JTextField();
		txtUsuarioPaciente.setToolTipText("");
		txtUsuarioPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsuarioPaciente.setColumns(10);
		txtUsuarioPaciente.setBounds(462, 145, 150, 19);
		panelRegistroPaciente.add(txtUsuarioPaciente);
		
		label_2 = new JLabel("Ingrese su nombre de Usuario:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(452, 120, 180, 34);
		panelRegistroPaciente.add(label_2);
		
		label_1_1 = new JLabel("Ingrese su contraseña:");
		label_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_1.setBounds(452, 164, 180, 34);
		panelRegistroPaciente.add(label_1_1);
		
		btnRegistrarPaciente = new JButton("Regisrarse");
		btnRegistrarPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegistrarPaciente.setBounds(462, 270, 150, 27);
		panelRegistroPaciente.add(btnRegistrarPaciente);
		btnRegistrarPaciente.addActionListener(this);
		
		lblnoTieneCuenta_1 = new JLabel("¿Ya tienes una cuenta? Inicia sesion");
		lblnoTieneCuenta_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblnoTieneCuenta_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblnoTieneCuenta_1.setBounds(452, 307, 206, 34);
		panelRegistroPaciente.add(lblnoTieneCuenta_1);
		
		lblIngreseSuNombre = new JLabel("Ingrese su nombre:");
		lblIngreseSuNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuNombre.setBounds(20, 74, 180, 34);
		panelRegistroPaciente.add(lblIngreseSuNombre);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setToolTipText("");
		txtNombrePaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(20, 103, 101, 19);
		panelRegistroPaciente.add(txtNombrePaciente);
		
		lblIngreseSuApellido = new JLabel("Ingrese su apellido:");
		lblIngreseSuApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuApellido.setBounds(148, 74, 180, 34);
		panelRegistroPaciente.add(lblIngreseSuApellido);
		
		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setToolTipText("");
		txtApellidoPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(148, 103, 113, 19);
		panelRegistroPaciente.add(txtApellidoPaciente);
		
		label_1_2 = new JLabel("Ingrese su nombre de DNI:");
		label_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2.setBounds(20, 137, 180, 34);
		panelRegistroPaciente.add(label_1_2);
		
		txtDniPaciente = new JTextField();
		txtDniPaciente.setToolTipText("");
		txtDniPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(20, 181, 150, 19);
		panelRegistroPaciente.add(txtDniPaciente);
		
		label_1_2_1 = new JLabel("Ingrese su fecha de nacimiento (dd/mm/yyyy):");
		label_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_1.setBounds(30, 205, 252, 34);
		panelRegistroPaciente.add(label_1_2_1);
		
		txtFechaPaciente = new JTextField();
		txtFechaPaciente.setToolTipText("");
		txtFechaPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFechaPaciente.setColumns(10);
		txtFechaPaciente.setBounds(20, 238, 150, 19);
		panelRegistroPaciente.add(txtFechaPaciente);
		
		label_1_2_3 = new JLabel("Ingrese su numero de telefono:");
		label_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_3.setBounds(30, 267, 252, 34);
		panelRegistroPaciente.add(label_1_2_3);
		
		txtNumeroPaciente = new JTextField();
		txtNumeroPaciente.setToolTipText("");
		txtNumeroPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNumeroPaciente.setColumns(10);
		txtNumeroPaciente.setBounds(20, 300, 150, 19);
		panelRegistroPaciente.add(txtNumeroPaciente);
		
		lblIngreseSuEmail = new JLabel("Ingrese su email:");
		lblIngreseSuEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuEmail.setBounds(452, 74, 180, 34);
		panelRegistroPaciente.add(lblIngreseSuEmail);
		
		txtEmaiPaciente = new JTextField();
		txtEmaiPaciente.setToolTipText("");
		txtEmaiPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmaiPaciente.setColumns(10);
		txtEmaiPaciente.setBounds(462, 103, 170, 19);
		panelRegistroPaciente.add(txtEmaiPaciente);
		
		passwordRegistroPaciente = new JPasswordField();
		passwordRegistroPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordRegistroPaciente.setBounds(462, 191, 150, 19);
		panelRegistroPaciente.add(passwordRegistroPaciente);
		
		label_1_1_1 = new JLabel("Repite tu contraseña:");
		label_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_1_1.setBounds(452, 205, 180, 34);
		panelRegistroPaciente.add(label_1_1_1);
		
		passwordRegistroVerificacion = new JPasswordField();
		passwordRegistroVerificacion.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordRegistroVerificacion.setBounds(462, 241, 150, 19);
		panelRegistroPaciente.add(passwordRegistroVerificacion);
		
		label_1_2_2 = new JLabel("Ingrese su direccion:");
		label_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_2.setBounds(30, 319, 252, 34);
		panelRegistroPaciente.add(label_1_2_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setToolTipText("");
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(20, 352, 150, 19);
		panelRegistroPaciente.add(txtDireccion);
		panelLoginPersonal = new JPanel();
		panelLoginPersonal.setBounds(10, 10, 668, 381);
		contentPane.add(panelLoginPersonal);
		panelLoginPersonal.setLayout(null);
		panelLoginPersonal.setVisible(false);
		
		lblNewLabel_3 = new JLabel("Te damos la bienvenida otra vez");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 29));
		lblNewLabel_3.setBounds(10, 10, 648, 54);
		panelLoginPersonal.add(lblNewLabel_3);
		
		btnIniciarSesionPersonal = new JButton("Iniciar sesion");
		btnIniciarSesionPersonal.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIniciarSesionPersonal.setBounds(247, 259, 150, 27);
		panelLoginPersonal.add(btnIniciarSesionPersonal);
		btnIniciarSesionPersonal.addActionListener(this);
		
		txtUsuarioPersonal = new JTextField();
		txtUsuarioPersonal.setToolTipText("");
		txtUsuarioPersonal.setColumns(10);
		txtUsuarioPersonal.setBounds(247, 153, 150, 19);
		panelLoginPersonal.add(txtUsuarioPersonal);
		
		label_3 = new JLabel("Ingrese su nombre de Usuario:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(247, 112, 180, 34);
		panelLoginPersonal.add(label_3);
		
		label_4 = new JLabel("Ingrese su contraseña:");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(247, 182, 180, 34);
		panelLoginPersonal.add(label_4);
		
		passwordPersonal = new JPasswordField();
		passwordPersonal.setBounds(247, 214, 150, 19);
		panelLoginPersonal.add(passwordPersonal);
		
		btnVolver1 = new JButton("Volver");
		btnVolver1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver1.setBounds(10, 344, 85, 27);
		panelLoginPersonal.add(btnVolver1);
		
		panelLoginPaciente = new JPanel();
		panelLoginPaciente.setVisible(false);
		panelLoginPaciente.setLayout(null);
		panelLoginPaciente.setBounds(10, 10, 668, 381);
		contentPane.add(panelLoginPaciente);
		
		lblNewLabel_1 = new JLabel("Te damos la bienvenida otra vez");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(10, 10, 648, 54);
		panelLoginPaciente.add(lblNewLabel_1);
		
		btnIniciarSesionPaciente = new JButton("Iniciar sesion");
		btnIniciarSesionPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIniciarSesionPaciente.setBounds(247, 259, 150, 27);
		panelLoginPaciente.add(btnIniciarSesionPaciente);
		btnIniciarSesionPaciente.addActionListener(this);
		
		txtUsuarioInicioSesion = new JTextField();
		txtUsuarioInicioSesion.setToolTipText("");
		txtUsuarioInicioSesion.setColumns(10);
		txtUsuarioInicioSesion.setBounds(247, 153, 150, 19);
		panelLoginPaciente.add(txtUsuarioInicioSesion);
		
		label = new JLabel("Ingrese su nombre de Usuario:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(247, 112, 180, 34);
		panelLoginPaciente.add(label);
		
		label_1 = new JLabel("Ingrese su contraseña:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(247, 182, 180, 34);
		panelLoginPaciente.add(label_1);
		
		btnRedireccionRegistrarPaciente = new JButton("Registrarte");
		btnRedireccionRegistrarPaciente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRedireccionRegistrarPaciente.setBounds(247, 344, 150, 27);
		panelLoginPaciente.add(btnRedireccionRegistrarPaciente);
		btnRedireccionRegistrarPaciente.addActionListener(this);
		
		passwordPaciente = new JPasswordField();
		passwordPaciente.setBounds(247, 214, 150, 19);
		panelLoginPaciente.add(passwordPaciente);
		
		lblnoTieneCuenta = new JLabel("¿No tiene cuenta? Registrese aqui");
		lblnoTieneCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		lblnoTieneCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
		lblnoTieneCuenta.setBounds(231, 300, 196, 34);
		panelLoginPaciente.add(lblnoTieneCuenta);
		
		btnVolver2 = new JButton("Volver");
		btnVolver2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver2.setBounds(10, 344, 83, 27);
		panelLoginPaciente.add(btnVolver2);
		panelLoginPaciente.setVisible(false);
		btnVolver2.addActionListener(this);
		btnVolver1.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (btnVolverMain == e.getSource()) {
			panelMainPaciente.setVisible(true);
			panelModificarDatosPaciente.setVisible(false);
		}
		if (btnModificarPaciente == e.getSource()) {
			panelMainPaciente.setVisible(false);
			panelModificarDatosPaciente.setVisible(true);
		}
		if (btnModificarDatosPaciente == e.getSource()) {
			if (btnModificarDatosPaciente == e.getSource()) {
			    // Validar campos (versión compacta)
				boolean isNumeroEmpty = true;
				
			    boolean isNombreEmpty = txtModNombrePaciente == null || txtModNombrePaciente.getText().trim().isEmpty();
			    boolean isApellidoEmpty = txtModApellidoPaciente == null || txtModApellidoPaciente.getText().trim().isEmpty();
			    try {
			    	int numeromod = Integer.parseInt(txtModNumeroPaciente.getText()); // Intenta convertir
			    	isNumeroEmpty = txtModNumeroPaciente == null || txtModNumeroPaciente.getText().trim().isEmpty() || numeromod >= 900000000 && numeromod <= 999999999;
			    	if (numeromod >= 900000000 && numeromod <= 999999999) {
			            isNumeroEmpty = false; // Número válido
			        } else {
			            JOptionPane.showMessageDialog(null, "El número debe estar entre 900000000 y 999999999");
			        }
			    } catch (NumberFormatException e1) {
			    	JOptionPane.showMessageDialog(null, "Número de teléfono inválido");
			    }
			    
			   
			    boolean isDireccionEmpty = txtModDireccionPaciente == null || txtModDireccionPaciente.getText().trim().isEmpty();
			    boolean isFechaEmpty = txtModFechaPaciente == null || txtModFechaPaciente.getText().trim().isEmpty() || !txtModFechaPaciente.getText().trim().matches("\\d{2}/\\d{2}/\\d{4}");
			    boolean isDniEmpty = txtModDniPaciente == null || txtModDniPaciente.getText().trim().isEmpty();
			    boolean isEmailEmpty = txtModEmailPaciente == null || txtModEmailPaciente.getText().trim().isEmpty();
			    boolean isUsuarioEmpty = txtModUsuarioPaciente == null || txtModUsuarioPaciente.getText().trim().isEmpty();
			    boolean isPasswordEmpty = passwordModPaciente == null;

			    // Actualizar solo si hay cambios
			    try {
			        if (!isNombreEmpty) {
			            ActualPaciente.setNombre(txtModNombrePaciente.getText().trim());
			        }
			        if (!isApellidoEmpty) {
			            ActualPaciente.setApellido(txtModApellidoPaciente.getText().trim());
			        }
			        if (!isNumeroEmpty) {
			            try {
			                ActualPaciente.setTelefono(Integer.parseInt(txtModNumeroPaciente.getText().trim()));
			            } catch (NumberFormatException ex) {
			                JOptionPane.showMessageDialog(null, "Número de teléfono inválido");
			            }
			        }
			        if (!isDireccionEmpty) {
			            ActualPaciente.setDireccion(txtModDireccionPaciente.getText().trim());
			        }
			        if (!isFechaEmpty) {
			            try {
			                Date fecha = FormatoFecha.parse(txtModFechaPaciente.getText().trim());
			                ActualPaciente.setFechaNac(fecha);
			            } catch (ParseException ex) {
			                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy");
			            }
			        }
			        if (!isDniEmpty) {
			            ActualPaciente.setDNI(txtModDniPaciente.getText().trim());
			        }
			        if (!isEmailEmpty) {
			            ActualPaciente.setEmail(txtModEmailPaciente.getText().trim());
			        }
			        if (!isUsuarioEmpty) {
			            ActualUsuario.setUserName(txtModUsuarioPaciente.getText().trim());
			        }
			        if (!isPasswordEmpty) {
			            String password = new String(passwordModPaciente.getPassword());
			            ActualUsuario.setPassword(password);
			        }

			        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage());
			    }
			}
		}
		
		if (btnPaciente == e.getSource()){
			panelLoginPaciente.setVisible(true);
			panelLogIn.setVisible(false);
			List<Paciente> listaPacientes = Paciente.getPacientes();
			List<Usuario> listaUsuarios = Usuario.getUsuarios();
	            System.out.println("\n--- Registro exitoso ---");
	            System.out.println("Total pacientes registrados: " + listaPacientes.size());
	            
	            Paciente ultimoPaciente = listaPacientes.get(listaPacientes.size() - 1);
	            Usuario ultimoUsuario = listaUsuarios.get(listaUsuarios.size() - 1);
	            System.out.println("\nDatos del último paciente:");
	            System.out.println("ID: " + ultimoPaciente.getID());
	            System.out.println("Nombre: " + ultimoPaciente.getNombre() + " " + ultimoPaciente.getApellido());
	            System.out.println("DNI: " + ultimoPaciente.getDNI());
	            System.out.println("Teléfono: " + ultimoPaciente.getTelefono());
	            System.out.println("Usuario: " + ultimoPaciente.getUsuario().getUserName());
	            System.out.println("----------------------------------------------------------------");
	            System.out.println("Usuario: " + ultimoUsuario.getUserName());
	            System.out.println("contraseña: " + ultimoUsuario.getPassword());
	            System.out.println("Nombre rol: " + ultimoUsuario.getRol().getNombre());
	            
		}
		
		if (btnIniciarSesionPaciente== e.getSource()){
			
			String usuariotxt = txtUsuarioInicioSesion.getText();
			char[] passwordChars = passwordPaciente.getPassword();
			boolean encontrado = false;
			boolean acceso = false;
			String password = new String(passwordChars);
			for (Paciente paciente: Paciente.getPacientes()) {
				if(paciente.getUsuario().getRol().getNombre().equals("Paciente")) {
					if (paciente.getUsuario().getUserName().equals(usuariotxt)) {
						encontrado = true;
						if (paciente.getUsuario().getPassword().equals(password)) {
							acceso = true;
							ActualUsuario = paciente.getUsuario();
							ActualPaciente= paciente;
							break;
						}
						break;
					}		
				}
			}
			if(encontrado == false) {
				JOptionPane.showMessageDialog(null,"Ningún paciente encontrado con ese nombre");
			}else if(encontrado == true && acceso == false) {
				JOptionPane.showMessageDialog(null,"La contraseña está mal escrita");
			}else {
				JOptionPane.showMessageDialog(null,"Se inició sesion con éxito");
				panelLoginPaciente.setVisible(false);
				panelMainPaciente.setVisible(true);
			}
		}
		
		if (btnIniciarSesionPersonal== e.getSource()){
			String personaltxt = txtUsuarioPersonal.getText();
			char[] passwordChars = passwordPersonal.getPassword();
			boolean encontrado = false;
			boolean acceso = false;
			String password = new String(passwordChars);
			for (Medico medico : Medico.getMedicos()) {
				if(medico.getUsuario().getRol().getNombre().equals("Medico")) {
					if (medico.getUsuario().getUserName().equals(personaltxt)) {
						encontrado = true;
						if (medico.getUsuario().getPassword().equals(password)) {
							acceso = true;
							ActualUsuario = medico.getUsuario();
							ActualMedico= medico;
							break;
						}
						break;
					}		
				}
			}
			if(encontrado == false) {
				JOptionPane.showMessageDialog(null,"Ningún usuario encontrado con ese nombre");
			}else if(encontrado == true && acceso == false) {
				JOptionPane.showMessageDialog(null,"La contraseña está mal escrita");
			}else {
				JOptionPane.showMessageDialog(null,"Se inició sesion con éxito");
			}
		}
		
		if (btnPersonal== e.getSource()){
			panelLoginPersonal.setVisible(true);
			panelLogIn.setVisible(false);
		}
		if (btnRedireccionRegistrarPaciente == e.getSource()){
			panelRegistroPaciente.setVisible(true);
			panelLoginPaciente.setVisible(false);
		}
		if (btnRedireccionIniciarSesionPaciente == e.getSource()){
			panelLoginPaciente.setVisible(true);
			panelRegistroPaciente.setVisible(false);
		}
		if (btnVolver1 == e.getSource() || btnVolver2 == e.getSource()){
			panelLoginPersonal.setVisible(false);
			panelLoginPaciente.setVisible(false);
			panelLogIn.setVisible(true);
		}
		if (btnRevisarPerfilPaciente == e.getSource()){
			SimpleDateFormat FormatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
			String fechaFormateada = FormatoDeFecha.format(ActualPaciente.getFechaNac());
			txtNombreSalida.setText(ActualPaciente.getNombre());
			txtApellidoSalida.setText(ActualPaciente.getApellido());
			txtDniSalida.setText(ActualPaciente.getDNI());
			txtFechaSalida.setText(fechaFormateada);
			txtNumeroSalida.setText(String.valueOf(ActualPaciente.getTelefono()));
			txtDireccionSalida.setText(ActualPaciente.getDireccion());
			txtEmailSalida.setText(ActualPaciente.getEmail());
			txtNomUsarioSalida.setText(ActualUsuario.getUserName());
			panelMainPaciente.setVisible(false);
			panelPerfilPaciente.setVisible(true);
		}
		
		if (btnVolverPerfilPaciente == e.getSource()){
			panelMainPaciente.setVisible(true);
			panelPerfilPaciente.setVisible(false);
		}
		if (btnRegistrarPaciente == e.getSource()){
			try {
				char[] passwordChars = passwordRegistroPaciente.getPassword();
				String password = new String(passwordChars);
				char[] passwordChars2 = passwordRegistroVerificacion.getPassword();
				if(Arrays.equals(passwordChars, passwordChars2)) {
					 try {
					    	int numeromod = Integer.parseInt(txtNumeroPaciente.getText()); // Intenta convertir
					    	if (numeromod >= 900000000 && numeromod <= 999999999) {
					    		Paciente.registrarPaciente(txtNombrePaciente.getText(), txtApellidoPaciente.getText(), txtDniPaciente.getText(), txtFechaPaciente.getText(), numeromod, txtEmaiPaciente.getText(), txtDireccion.getText(), txtUsuarioPaciente.getText(), password);
								System.out.println("llega a intentar registrar");
					        } else {
					            JOptionPane.showMessageDialog(null, "El número debe estar entre 900000000 y 999999999");
					        }
					    } catch (NumberFormatException e1) {
					    	JOptionPane.showMessageDialog(null, "Número de teléfono inválido");
					    }

					
					
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

		}
	}
}
