package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class InterfazNuevaCita extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtdnipaciente;
    private JTextField txtnombrecompleto;
    private JTextField txtfecha;
    private JTextField txtarea;
    private JTextField txtmedico;
    private JComboBox<String> comboHora;
    private JTextField txtmotivo;

    public InterfazNuevaCita(
    	    InterfazReservarCitas ventanaAnterior,
    	    String dni,
    	    String nombreCompleto,
    	    String area,
    	    String medico,
    	    DefaultTableModel modeloTabla
    	) {
        setTitle("Nueva Cita");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel bg10 = new JPanel();
        bg10.setBackground(SystemColor.textHighlight);
        bg10.setBounds(0, 0, 534, 73);
        contentPane.add(bg10);
        bg10.setLayout(null);

        JLabel lblNuevaCita = new JLabel("NUEVA CITA");
        lblNuevaCita.setForeground(SystemColor.window);
        lblNuevaCita.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNuevaCita.setBounds(155, 11, 324, 49);
        bg10.add(lblNuevaCita);

        JPanel bg11 = new JPanel();
        bg11.setLayout(null);
        bg11.setBounds(0, 70, 534, 291);
        contentPane.add(bg11);

        JLabel lbldni = new JLabel("DNI Paciente:");
        lbldni.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbldni.setBounds(28, 23, 103, 14);
        bg11.add(lbldni);

        JLabel lblNombresPaciente = new JLabel("Nombres Paciente:");
        lblNombresPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNombresPaciente.setBounds(28, 50, 130, 14);
        bg11.add(lblNombresPaciente);

        txtdnipaciente = new JTextField(dni);
        txtdnipaciente.setEditable(false);
        txtdnipaciente.setBorder(null);
        txtdnipaciente.setOpaque(false);
        txtdnipaciente.setBounds(182, 23, 175, 20);
        bg11.add(txtdnipaciente);

        txtnombrecompleto = new JTextField(nombreCompleto);
        txtnombrecompleto.setEditable(false);
        txtnombrecompleto.setBorder(null);
        txtnombrecompleto.setOpaque(false);
        txtnombrecompleto.setBounds(182, 50, 175, 20);
        bg11.add(txtnombrecompleto);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFecha.setBounds(28, 81, 103, 14);
        bg11.add(lblFecha);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblHora.setBounds(28, 110, 103, 14);
        bg11.add(lblHora);

        
        //txt FECHA
        txtfecha = new JTextField();
        txtfecha.setForeground(Color.LIGHT_GRAY);
        txtfecha.setText("dd/mm/yyyy");
        txtfecha.setColumns(10);
        txtfecha.setBounds(182, 81, 175, 20);
        bg11.add(txtfecha);

        txtfecha.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtfecha.getText().equals("dd/mm/yyyy")) {
                    txtfecha.setText("");
                }
                txtfecha.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtfecha.getText().isEmpty()) {
                    txtfecha.setText("dd/mm/yyyy");
                    txtfecha.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        JLabel lblArea = new JLabel("Área:");
        lblArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblArea.setBounds(28, 141, 103, 14);
        bg11.add(lblArea);

        JLabel lblMdico = new JLabel("Médico:");
        lblMdico.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMdico.setBounds(28, 170, 103, 14);
        bg11.add(lblMdico);

        txtarea = new JTextField(area);
        txtarea.setEditable(false);
        txtarea.setBorder(null);
        txtarea.setOpaque(false);
        txtarea.setBounds(182, 141, 175, 20);
        bg11.add(txtarea);

        txtmedico = new JTextField(medico);
        txtmedico.setEditable(false);
        txtmedico.setBorder(null);
        txtmedico.setOpaque(false);
        txtmedico.setBounds(182, 170, 175, 20);
        bg11.add(txtmedico);

        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMotivo.setBounds(28, 198, 103, 14);
        bg11.add(lblMotivo);

        txtmotivo = new JTextField();
        txtmotivo.setColumns(10);
        txtmotivo.setBounds(28, 223, 468, 44);
        bg11.add(txtmotivo);

        
        //BOTON GUARDAR
        JButton btnguardar = new JButton("GUARDAR");
        btnguardar.setBounds(407, 23, 89, 56);
        bg11.add(btnguardar);
        btnguardar.addActionListener(e -> {
            String fechaStr = txtfecha.getText();
            String horaSeleccionada = (String) comboHora.getSelectedItem();
            String motivo = txtmotivo.getText();

            if (fechaStr.isEmpty() || fechaStr.equals("dd/mm/yyyy")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la fecha.");
                return;
            }

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try {
                java.util.Date fecha = sdf.parse(fechaStr);

                //llamada 
                ventanaAnterior.agregarCita(
                	    txtdnipaciente.getText(),
                	    sdf.format(fecha),
                	    horaSeleccionada,
                	    txtarea.getText(),
                	    txtmedico.getText(),
                	    motivo
                	);

                JOptionPane.showMessageDialog(null, "¡Cita guardada correctamente!");

                ventanaAnterior.setVisible(true);
                dispose();

            } catch (java.text.ParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy");
            }
        });


        
        
        //BOTON ATRAS
        JButton btnatras = new JButton("ATRÁS");
        btnatras.setBounds(407, 107, 89, 56);
        bg11.add(btnatras);
        
        comboHora = new JComboBox<>(new String[]{
        	    "Selecciona hora","08:00", "09:00", "10:00", "11:00", "12:00",
        	    "13:00", "14:00", "15:00", "16:00", "17:00"
        	});
        	comboHora.setBounds(182, 110, 175, 20);
        	bg11.add(comboHora);

        btnatras.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });

        setLocationRelativeTo(null);
    }
}

