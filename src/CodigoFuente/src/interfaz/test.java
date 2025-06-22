package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class test extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelInicioSesionPersonal;
	/**
	/**
	 * Create the frame.
	 */
	public test() {
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
		
		panelInicioSesionPersonal = new JPanel();
		panelInicioSesionPersonal.setLayout(null);
		panelInicioSesionPersonal.setBounds(10, 10, 668, 381);
		contentPane.add(panelInicioSesionPersonal);
		
		JButton btnIniciarSesionPaciente_2_1_1_1_1 = new JButton("Volver");
		btnIniciarSesionPaciente_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciarSesionPaciente_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIniciarSesionPaciente_2_1_1_1_1.setBounds(567, 10, 91, 33);
		panelInicioSesionPersonal.add(btnIniciarSesionPaciente_2_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Su perfil:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(10, 10, 263, 54);
		panelInicioSesionPersonal.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("Su nombre de Usuario:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(10, 292, 180, 34);
		panelInicioSesionPersonal.add(label_2);
		
		JLabel lblIngreseSuNombre = new JLabel("Su nombre:");
		lblIngreseSuNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuNombre.setBounds(10, 74, 118, 34);
		panelInicioSesionPersonal.add(lblIngreseSuNombre);
		
		JLabel lblIngreseSuApellido = new JLabel("Su apellido:");
		lblIngreseSuApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuApellido.setBounds(10, 107, 180, 34);
		panelInicioSesionPersonal.add(lblIngreseSuApellido);
		
		JLabel label_1_2 = new JLabel("Su nombre de DNI:");
		label_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2.setBounds(10, 138, 180, 34);
		panelInicioSesionPersonal.add(label_1_2);
		
		JLabel label_1_2_1 = new JLabel("Su fecha de nacimiento (dd/mm/yyyy):");
		label_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_1.setBounds(10, 170, 252, 34);
		panelInicioSesionPersonal.add(label_1_2_1);
		
		JLabel label_1_2_3 = new JLabel("Su numero de telefono:");
		label_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_3.setBounds(10, 201, 252, 34);
		panelInicioSesionPersonal.add(label_1_2_3);
		
		JLabel lblIngreseSuEmail = new JLabel("Su email:");
		lblIngreseSuEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseSuEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseSuEmail.setBounds(10, 261, 180, 34);
		panelInicioSesionPersonal.add(lblIngreseSuEmail);
		
		JLabel label_1_2_2 = new JLabel("Su direccion:");
		label_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1_2_2.setBounds(10, 232, 252, 34);
		panelInicioSesionPersonal.add(label_1_2_2);
		
		JTextArea txtNombreSalida = new JTextArea();
		txtNombreSalida.setEditable(false);
		txtNombreSalida.setBounds(238, 79, 214, 22);
		panelInicioSesionPersonal.add(txtNombreSalida);
		
		JTextArea txtApellidoSalida = new JTextArea();
		txtApellidoSalida .setEditable(false);
		txtApellidoSalida .setBounds(238, 112, 214, 22);
		panelInicioSesionPersonal.add(txtApellidoSalida );
		
		JTextArea txtDniSalida  = new JTextArea();
		txtDniSalida.setEditable(false);
		txtDniSalida.setBounds(238, 143, 214, 22);
		panelInicioSesionPersonal.add(txtDniSalida);
		
		JTextArea txtFechaSalida = new JTextArea();
		txtFechaSalida.setEditable(false);
		txtFechaSalida.setBounds(238, 175, 214, 22);
		panelInicioSesionPersonal.add(txtFechaSalida);
		
		JTextArea txtNumeroSalida = new JTextArea();
		txtNumeroSalida.setEditable(false);
		txtNumeroSalida.setBounds(238, 206, 214, 22);
		panelInicioSesionPersonal.add(txtNumeroSalida);
		
		JTextArea txtDireccionSalida = new JTextArea();
		txtDireccionSalida .setEditable(false);
		txtDireccionSalida .setBounds(238, 237, 214, 22);
		panelInicioSesionPersonal.add(txtDireccionSalida );
		
		JTextArea txtEmailSalida  = new JTextArea();
		txtEmailSalida .setEditable(false);
		txtEmailSalida .setBounds(238, 266, 214, 22);
		panelInicioSesionPersonal.add(txtEmailSalida);
		
		JTextArea txtNomUsarioSalida = new JTextArea();
		txtNomUsarioSalida .setEditable(false);
		txtNomUsarioSalida .setBounds(238, 297, 214, 22);
		panelInicioSesionPersonal.add(txtNomUsarioSalida );
		panelInicioSesionPersonal.setVisible(false);
		
	}
}