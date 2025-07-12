package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
public class InterfazLaboratorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame ventanaAnterior;

	public InterfazLaboratorio() {
	    this(null);
	}
	
	public InterfazLaboratorio(JFrame ventanaAnterior) {
	    this.ventanaAnterior = ventanaAnterior;
		setTitle("Panel de Laboratorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bg4 = new JPanel();
		bg4.setBounds(0, 0, 627, 99);
		contentPane.add(bg4);
		bg4.setLayout(null);
		bg4.setBackground(SystemColor.textHighlight);
		
		JLabel lblNewLabel = new JLabel("PANEL LABORATORIO");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(149, 21, 334, 49);
		bg4.add(lblNewLabel);
		
		JPanel bg10 = new JPanel();
		bg10.setBounds(0, 99, 627, 362);
		contentPane.add(bg10);
		bg10.setLayout(null);
		
		JLabel lblseleccionaaccion = new JLabel("Selecciona la acción a realizar: ");
		lblseleccionaaccion.setBounds(10, 11, 219, 14);
		lblseleccionaaccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bg10.add(lblseleccionaaccion);
		
		//BOTON PARA REGISTRAR RESULTADOS
		JButton btnregistrarresultados = new JButton("Registrar resultados");
		btnregistrarresultados.setBounds(10, 162, 182, 101);
		bg10.add(btnregistrarresultados);
		btnregistrarresultados.addActionListener(e -> {
			//InterfazRegistrarResultadoLabo ventanaRegistrar = new InterfazRegistrarResultadoLabo(this);
		    //ventanaRegistrar.setVisible(true);
		    //this.setVisible(false);
		});
		
		//BOTON VISUALIZAR RESULTADOS
		JButton btnvisualizarresultados = new JButton("Visualizar resultados");
		btnvisualizarresultados.setBounds(226, 162, 182, 101);
		bg10.add(btnvisualizarresultados);
		btnvisualizarresultados.addActionListener(e -> {
			//InterfazVisualizarResultadoLabo ventanaVisualizar = new InterfazVisualizarResultadoLabo(this);
			//ventanaVisualizar.setVisible(true);
		    //this.setVisible(false);
		});
		
		//BOTON ALERTA
		JButton btnAlerta = new JButton("Alerta resultados");
		btnAlerta.setBounds(435, 162, 182, 101);
		bg10.add(btnAlerta);
		btnAlerta.addActionListener(e -> {			
			//InterfazAlerta ventanaAlerta = new InterfazAlerta(this);
			//ventanaAlerta.setVisible(true);
		    //this.setVisible(false);
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
