package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.BaseDatosSimulada;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import vista.InterfazGestionRoles;


public class InterfazAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame ventanaAnterior;

	public InterfazAdmin() {
	    this(null);
	}
	
	public InterfazAdmin(JFrame ventanaAnterior) {
	    this.ventanaAnterior = ventanaAnterior;
		setTitle("Panel de Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bg4 = new JPanel();
		bg4.setBounds(0, 0, 484, 99);
		contentPane.add(bg4);
		bg4.setLayout(null);
		bg4.setBackground(SystemColor.textHighlight);
		
		JLabel lblNewLabel = new JLabel("PANEL ADMIN");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(149, 21, 219, 49);
		bg4.add(lblNewLabel);
		
		JPanel bg10 = new JPanel();
		bg10.setBounds(0, 99, 484, 362);
		contentPane.add(bg10);
		bg10.setLayout(null);
		
		JLabel lblseleccionaaccion = new JLabel("Selecciona la acción a realizar: ");
		lblseleccionaaccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblseleccionaaccion.setBounds(10, 11, 255, 14);
		bg10.add(lblseleccionaaccion);
		
		//BOTON PARA ASIGNAR Y GESTIONAR ROLES
		JButton btnasignarygestroles = new JButton("Gestion de roles");
		btnasignarygestroles.setBounds(48, 50, 182, 101);
		bg10.add(btnasignarygestroles);
		btnasignarygestroles.addActionListener(e -> {
		    InterfazGestionRoles ventanaRoles = new InterfazGestionRoles(this);
		    ventanaRoles.setVisible(true);
		    this.setVisible(false);
		});
		
		//BOTON PARA CONFIGURAR HORAS Y PRECIOS
		JButton btnconfigurarhoraprecios = new JButton("Horarios y/o precios");
		btnconfigurarhoraprecios.setBounds(262, 50, 182, 101);
		bg10.add(btnconfigurarhoraprecios);
		btnconfigurarhoraprecios.addActionListener(e -> {
		    new InterfazConfigurarHoraPrecios(this).setVisible(true);
		    setVisible(false);
		});
		
		//BOTON PARA REVISAR STOCK DE MEDICAMENTTOS
		JButton btnRevisarStockDe = new JButton("Stock de medicamentos");
		btnRevisarStockDe.setBounds(48, 174, 182, 101);
		bg10.add(btnRevisarStockDe);
		btnRevisarStockDe.addActionListener(e -> {
			InterfazStockMedicamentos ventana = new InterfazStockMedicamentos(InterfazAdmin.this);
			ventana.setVisible(true);
			setVisible(false);
		    dispose();
		});
		
		//BOTON PARA REPORTES DIARIOOS
		JButton btnreportesdiarios = new JButton("Reportes diarios");
		btnreportesdiarios.setBounds(262, 174, 182, 101);
		bg10.add(btnreportesdiarios);
		btnreportesdiarios.addActionListener(e -> {
		    InterfazReportesDiarios ventana = new InterfazReportesDiarios();
		    ventana.setVisible(true);
		});
		
		//BOTON CERRAR SESION QUE ME LLLEVA A INTERFAZ LOGIN PERSONAL
		JButton btnCerrarSesiOn = new JButton("Cerrar Sesión");
		btnCerrarSesiOn.setBounds(339, 322, 135, 29);
		bg10.add(btnCerrarSesiOn);
		btnCerrarSesiOn.addActionListener(e -> {
		    InterfazLoginEmpleado login = new InterfazLoginEmpleado(null);
		    login.limpiarCampos();
		    login.setVisible(true);
		    dispose();
		});
	}
}
