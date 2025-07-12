package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo.Paciente;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazFuncionesPaciente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Paciente paciente;

    public InterfazFuncionesPaciente(Paciente paciente) {
    	this.paciente = paciente;
		setTitle("Funciones de Paciente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 550);
		setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel bg5 = new JPanel();
        bg5.setBounds(0, 83, 734, 428);
        contentPane.add(bg5);
        bg5.setLayout(null);
        
        JPanel bg4 = new JPanel();
        bg4.setBackground(SystemColor.textHighlight);
        bg4.setBounds(0, 0, 734, 88);
        contentPane.add(bg4);
        bg4.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("BIENVENIDO ");
        lblNewLabel.setBounds(245, 11, 219, 49);
        bg4.add(lblNewLabel);
        lblNewLabel.setForeground(SystemColor.window);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        
        JLabel lblmodificarmis = new JLabel("Modificar mis");
        lblmodificarmis.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblmodificarmis.setBounds(38, 73, 135, 42);
        bg5.add(lblmodificarmis);
        
        JLabel lbldatos = new JLabel("Datos");
        lbldatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbldatos.setBounds(38, 113, 135, 42);
        bg5.add(lbldatos);
        
        JLabel lbldescargarinforme = new JLabel("Descargar Informe");
        lbldescargarinforme.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbldescargarinforme.setBounds(10, 217, 188, 42);
        bg5.add(lbldescargarinforme);
        
        JLabel lblmedico = new JLabel("Medico");
        lblmedico.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblmedico.setBounds(10, 256, 188, 42);
        bg5.add(lblmedico);
        
        JLabel lblreservar = new JLabel("Reservar");
        lblreservar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblreservar.setBounds(430, 73, 102, 42);
        bg5.add(lblreservar);
        
        JLabel lblcita = new JLabel("Cita");
        lblcita.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblcita.setBounds(430, 113, 73, 42);
        bg5.add(lblcita);
        
        JLabel lblcerrar = new JLabel("Cerrar");
        lblcerrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblcerrar.setBounds(430, 220, 102, 42);
        bg5.add(lblcerrar);
        
        JLabel lblsesion = new JLabel("Sesión");
        lblsesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblsesion.setBounds(430, 266, 93, 42);
        bg5.add(lblsesion);
        
        
        //texto de escoger accion
        JLabel lblseleccionaaccion = new JLabel("Selecciona la acción a realizar: ");
        lblseleccionaaccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblseleccionaaccion.setBounds(10, 11, 255, 14);
        bg5.add(lblseleccionaaccion);
        
        

        // BOTÓN DE MODIFICAR DATOS
        JButton btnmodificardatos = new JButton("");
        btnmodificardatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfazModificarPaciente ventanaModificar = new InterfazModificarPaciente(
                        InterfazFuncionesPaciente.this,
                        paciente
                );
                ventanaModificar.setVisible(true);
                setVisible(false);
            }
        });
        btnmodificardatos.setBounds(185, 36, 182, 151);

        // Imagen al botón
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagenes/modificardatos.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(182, 151, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        btnmodificardatos.setIcon(iconoEscalado);
        btnmodificardatos.setContentAreaFilled(false);
        btnmodificardatos.setBorderPainted(false);
        btnmodificardatos.setFocusPainted(false);
        btnmodificardatos.setOpaque(false);
        btnmodificardatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bg5.add(btnmodificardatos);
        
        
        //BOTON PARA RESERVAR CITAS
        JButton btnReservarCita = new JButton("");
        btnReservarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	InterfazReservarCitas ventanaReservar = new InterfazReservarCitas(paciente);
                ventanaReservar.setVisible(true);
                dispose();
            }
        });
        
        btnReservarCita.setBounds(542, 36, 182, 151);

        // Cargar y escalar la imagen (usa nombres diferentes)
        ImageIcon iconoOriginalCita = new ImageIcon(getClass().getResource("/imagenes/reservarcita.png"));
        Image imagenEscaladaCita = iconoOriginalCita.getImage().getScaledInstance(182, 151, Image.SCALE_SMOOTH);
        ImageIcon iconoEscaladoCita = new ImageIcon(imagenEscaladaCita);

        btnReservarCita.setIcon(iconoEscaladoCita);
        btnReservarCita.setContentAreaFilled(false);
        btnReservarCita.setBorderPainted(false);
        btnReservarCita.setFocusPainted(false);
        btnReservarCita.setOpaque(false);
        btnReservarCita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bg5.add(btnReservarCita);


        
        
        
        //BOTON PARA DESCARGAR INFORME MEDICO
        JButton btnDescargarInformeMdico = new JButton("");
        btnDescargarInformeMdico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // aquí pondrás la acción al hacer clic
            }
        });

        btnDescargarInformeMdico.setBounds(185, 188, 182, 156);
        
     // Cargar y escalar la imagen (usa nombres diferentes)
        ImageIcon iconoOriginalinforme = new ImageIcon(getClass().getResource("/imagenes/descargarinforme.png"));
        Image imagenEscaladainforme = iconoOriginalinforme.getImage().getScaledInstance(182, 151, Image.SCALE_SMOOTH);
        ImageIcon iconoEscaladoinforme = new ImageIcon(imagenEscaladainforme);

        btnDescargarInformeMdico.setIcon(iconoEscaladoinforme);
        btnDescargarInformeMdico.setContentAreaFilled(false);
        btnDescargarInformeMdico.setBorderPainted(false);
        btnDescargarInformeMdico.setFocusPainted(false);
        btnDescargarInformeMdico.setOpaque(false);
        btnDescargarInformeMdico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bg5.add(btnDescargarInformeMdico);
        
        
        //BOTON PARA CERRAR SESION
        JButton btncerrarseion = new JButton("");
        btncerrarseion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	InterfazMain ventana = new InterfazMain();
                ventana.setVisible(true);
                dispose();
            }
        });
        
        btncerrarseion.setBounds(542, 188, 182, 156);
        
        // Cargar y escalar la imagen (usa nombres diferentes)
        ImageIcon iconoOriginalcerrarsesion = new ImageIcon(getClass().getResource("/imagenes/cerrarsesion.png"));
        Image imagenEscaladacerrarsesion = iconoOriginalcerrarsesion.getImage().getScaledInstance(182, 151, Image.SCALE_SMOOTH);
        ImageIcon iconoEscaladocerrarsesion = new ImageIcon(imagenEscaladacerrarsesion);

        btncerrarseion.setIcon(iconoEscaladocerrarsesion);
        btncerrarseion.setContentAreaFilled(false);
        btncerrarseion.setBorderPainted(false);
        btncerrarseion.setFocusPainted(false);
        btncerrarseion.setOpaque(false);
        btncerrarseion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bg5.add(btncerrarseion);
        bg5.add(btncerrarseion);
        

        

        

    }

}
