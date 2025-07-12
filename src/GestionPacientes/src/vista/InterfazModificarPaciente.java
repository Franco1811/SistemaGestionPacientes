package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Paciente;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;

public class InterfazModificarPaciente extends JFrame {

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
	private JComboBox<String> comboBoxSexo;
	private JButton btnguardarcambios;
	private JButton btnretroceder;


	
	
	

	/**
	 * Create the frame.
	 */
	public InterfazModificarPaciente() {
		setTitle("Modificar datos de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		
		JPanel bg6 = new JPanel();
		bg6.setBounds(0, 97, 484, 414);
		contentPane.add(bg6);
		bg6.setLayout(null);
		
		JLabel lbldni = new JLabel("DNI Paciente:");
		lbldni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbldni.setBounds(66, 11, 103, 14);
		bg6.add(lbldni);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(220, 11, 175, 20);
		txtdni.setEnabled(false); //PARA QUE NO SE PUEDA CAMBIAR 
		bg6.add(txtdni);
		
		txtnombres = new JTextField();
		txtnombres.setColumns(10);
		txtnombres.setBounds(220, 38, 175, 20);
		bg6.add(txtnombres);
		
		txtapellidopa = new JTextField();
		txtapellidopa.setColumns(10);
		txtapellidopa.setBounds(220, 69, 175, 20);
		bg6.add(txtapellidopa);
		
		txtapellidoma = new JTextField();
		txtapellidoma.setColumns(10);
		txtapellidoma.setBounds(220, 98, 175, 20);
		bg6.add(txtapellidoma);
		
		JLabel lblApellidos = new JLabel("Apellidos Paterno:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setBounds(66, 69, 103, 14);
		bg6.add(lblApellidos);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombres.setBounds(66, 38, 103, 14);
		bg6.add(lblNombres);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidoMaterno.setBounds(66, 98, 103, 14);
		bg6.add(lblApellidoMaterno);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(66, 141, 103, 14);
		bg6.add(lblEdad);
		
		txtedad = new JTextField();
		txtedad.setColumns(10);
		txtedad.setBounds(115, 139, 103, 20);
		bg6.add(txtedad);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(241, 141, 103, 14);
		bg6.add(lblSexo);
		
		comboBoxSexo = new JComboBox<>(new String[] {
			    "Seleccione...", "Masculino", "Femenino"
			});

		comboBoxSexo.setBounds(292, 138, 103, 22);
		bg6.add(comboBoxSexo);
		
		txtnumtelefonico = new JTextField();
		txtnumtelefonico.setColumns(10);
		txtnumtelefonico.setBounds(220, 191, 175, 20);
		bg6.add(txtnumtelefonico);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(220, 218, 175, 20);
		bg6.add(txtemail);
		
		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(220, 247, 175, 20);
		bg6.add(txtdireccion);
		
		txtddmmyyyy = new JTextField();
		txtddmmyyyy.setText("dd/mm/yyyy");
		txtddmmyyyy.setForeground(Color.LIGHT_GRAY);
		txtddmmyyyy.setColumns(10);
		txtddmmyyyy.setBounds(220, 274, 175, 20);
		bg6.add(txtddmmyyyy);
		
		JLabel lblFechaNacimientoddmmyyyy = new JLabel("Fecha nacimiento:");
		lblFechaNacimientoddmmyyyy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaNacimientoddmmyyyy.setBounds(66, 274, 228, 14);
		bg6.add(lblFechaNacimientoddmmyyyy);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(66, 247, 103, 14);
		bg6.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(66, 218, 103, 14);
		bg6.add(lblEmail);
		
		JLabel lblNmeroTelefnico = new JLabel("Número telefónico:");
		lblNmeroTelefnico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNmeroTelefnico.setBounds(66, 191, 115, 14);
		bg6.add(lblNmeroTelefnico);
		
		
		
		btnguardarcambios = new JButton("GUARDAR CAMBIOS");
		btnguardarcambios.setBounds(243, 321, 140, 63);
		bg6.add(btnguardarcambios);
		
		btnretroceder = new JButton("RETROCEDER");
		btnretroceder.setBounds(78, 321, 140, 63);
		bg6.add(btnretroceder);
		
		
		
		JPanel bg7 = new JPanel();
		bg7.setBackground(SystemColor.textHighlight);
		bg7.setBounds(0, 0, 484, 96);
		contentPane.add(bg7);
		bg7.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATOS PERSONALES");
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(86, 24, 325, 50);
		bg7.add(lblNewLabel);
		setLocationRelativeTo(null);
		

	}
	
	public InterfazModificarPaciente(JFrame ventanaAnterior, Paciente pacienteEditar) {
	    this();

	    txtdni.setText(pacienteEditar.getDNI());
	    txtdni.setEnabled(false);

	    txtnombres.setText(pacienteEditar.getNombre());
	    txtapellidopa.setText(pacienteEditar.getApellidoPaterno());
	    txtapellidoma.setText(pacienteEditar.getApellidoMaterno());
	    txtedad.setText(String.valueOf(pacienteEditar.getEdad()));
	    txtnumtelefonico.setText(String.valueOf(pacienteEditar.getTelefono()));
	    txtemail.setText(pacienteEditar.getEmail());
	    txtdireccion.setText(pacienteEditar.getDireccion());
	    txtddmmyyyy.setText(Paciente.getFormatofecha().format(pacienteEditar.getFechaNacimiento()));
	    txtddmmyyyy.setForeground(Color.BLACK);
	    comboBoxSexo.setSelectedItem(pacienteEditar.getSexo());

	    btnguardarcambios.addActionListener(e -> {
	        pacienteEditar.setNombre(txtnombres.getText().trim());
	        pacienteEditar.setApellidoPaterno(txtapellidopa.getText().trim());
	        pacienteEditar.setApellidoMaterno(txtapellidoma.getText().trim());
	        pacienteEditar.setEdad(Integer.parseInt(txtedad.getText().trim()));
	        pacienteEditar.setSexo(comboBoxSexo.getSelectedItem().toString());
	        pacienteEditar.setTelefono(Integer.parseInt(txtnumtelefonico.getText().trim()));
	        pacienteEditar.setEmail(txtemail.getText().trim());
	        pacienteEditar.setDireccion(txtdireccion.getText().trim());

	        try {
	            pacienteEditar.setFechaNacimiento(
	                Paciente.getFormatofecha().parse(txtddmmyyyy.getText().trim())
	            );
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            javax.swing.JOptionPane.showMessageDialog(this, "Fecha inválida.");
	            return;
	        }

	        javax.swing.JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");

	        InterfazFuncionesPaciente ventana = new InterfazFuncionesPaciente(pacienteEditar);
	        ventana.setVisible(true);
	        dispose();
	    });

	    btnretroceder.addActionListener(e -> {
	        ventanaAnterior.setVisible(true);
	        dispose();
	    });
	}


}


