package vista;

import javax.swing.*;

import modelo.BaseDatosSimulada;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazFarmaceutico extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public InterfazFarmaceutico(JFrame ventanaAnterior) {
        setTitle("Panel Farmacéutico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel bg4 = new JPanel();
        bg4.setLayout(null);
        bg4.setBackground(SystemColor.textHighlight);
        bg4.setBounds(0, 0, 484, 99);
        contentPane.add(bg4);
        
        JLabel lblPanelFarmaceutico = new JLabel("PANEL FARMACEUTICO");
        lblPanelFarmaceutico.setForeground(SystemColor.window);
        lblPanelFarmaceutico.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblPanelFarmaceutico.setBounds(57, 24, 398, 49);
        bg4.add(lblPanelFarmaceutico);

        //BOTON PARA REGISTRAR ENTREGAS  ---HECHOOO
        JButton btnRegistrarEntrega = new JButton("Registrar entrega de medicamentos");
        btnRegistrarEntrega.setBounds(36, 138, 203, 101);
        contentPane.add(btnRegistrarEntrega);
        btnRegistrarEntrega.addActionListener(e -> {
            InterfazRegistrarEntrega entrega = new InterfazRegistrarEntrega(InterfazFarmaceutico.this);
            entrega.setVisible(true);
            setVisible(false);
        });


        //BOTON PARA VERIFICAR LA RECETA SI YA FUE UTILIZADA O NO
        JButton btnVerificarReceta = new JButton("Verificar uso de receta");
        btnVerificarReceta.setBounds(251, 138, 203, 101);
        contentPane.add(btnVerificarReceta);
        btnVerificarReceta.addActionListener(e -> {
            InterfazVerificarReceta ventanaVerificar = new InterfazVerificarReceta(InterfazFarmaceutico.this);
            ventanaVerificar.setVisible(true);
            setVisible(false);
        });

        
        //BOTON PARA REGISTRAR INGRESO DE MEDICAMENTOS - HECHOO
        JButton btnRegistrarIngresoMedicamentos = new JButton("Registrar ingreso/stock  de med.");
        btnRegistrarIngresoMedicamentos.setBounds(251, 269, 203, 101);
        contentPane.add(btnRegistrarIngresoMedicamentos);
        btnRegistrarIngresoMedicamentos.addActionListener(e -> {
        		InterfazStockMedicamentos ventana = new InterfazStockMedicamentos(InterfazFarmaceutico.this);
        		ventana.setVisible(true);
        		setVisible(false);

        	});

        //BOTON PARA VER LA HISTORIAL DE ENTREGAS REALIZADAS --- HECHOOO
        JButton btnHistorialEntregas = new JButton("Consultar historial de entregas");
        btnHistorialEntregas.setBounds(36, 269, 203, 101);
        contentPane.add(btnHistorialEntregas);
        btnHistorialEntregas.addActionListener(e -> {
            InterfazHistorialEntregas historial = new InterfazHistorialEntregas(InterfazFarmaceutico.this);
            historial.setVisible(true);
            setVisible(false);
        });

        //BOTON PARA CERRAR SESION ---HECHO
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setBounds(334, 415, 140, 35);
        contentPane.add(btnCerrarSesion);
        btnCerrarSesion.addActionListener(e -> {
		    InterfazLoginEmpleado login = new InterfazLoginEmpleado(null);
		    login.limpiarCampos();
		    login.setVisible(true);
		    dispose();
		});
        
    }
}
