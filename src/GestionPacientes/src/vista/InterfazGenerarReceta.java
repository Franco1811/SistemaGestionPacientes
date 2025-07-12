package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo.BaseDatosSimulada;
import modelo.Medico;
import modelo.Paciente;
import modelo.RecetaPaciente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class InterfazGenerarReceta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDni;
    private JTextField txtNombrePaciente;
    private JTextArea txtReceta;
    private Medico medicoActual;

    public InterfazGenerarReceta(JFrame parent, Medico medico) {
        setTitle("Generar Receta Médica");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(parent);
        
        this.medicoActual = medico;

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        // Panel superior (búsqueda de paciente)
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(SystemColor.textHighlight);
        panelSuperior.setPreferredSize(new Dimension(0, 100));
        contentPane.add(panelSuperior, BorderLayout.NORTH);
        panelSuperior.setLayout(null);
        
        JLabel lblDni = new JLabel("DNI del Paciente:");
        lblDni.setForeground(Color.WHITE);
        lblDni.setBounds(30, 20, 150, 20);
        panelSuperior.add(lblDni);
        
        txtDni = new JTextField();
        txtDni.setBounds(180, 20, 200, 25);
        panelSuperior.add(txtDni);
        txtDni.setColumns(10);
        
        JButton btnBuscar = new JButton("Buscar Paciente");
        btnBuscar.setBounds(400, 20, 150, 25);
        btnBuscar.addActionListener(e -> buscarPaciente());
        panelSuperior.add(btnBuscar);
        
        JLabel lblNombre = new JLabel("Nombre del Paciente:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(30, 60, 150, 20);
        panelSuperior.add(lblNombre);
        
        txtNombrePaciente = new JTextField();
        txtNombrePaciente.setEditable(false);
        txtNombrePaciente.setBounds(180, 60, 300, 25);
        panelSuperior.add(txtNombrePaciente);
        txtNombrePaciente.setColumns(10);

        // Panel central (texto de la receta)
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout(0, 0));
        contentPane.add(panelCentral, BorderLayout.CENTER);
        
        JLabel lblReceta = new JLabel("Receta Médica:");
        panelCentral.add(lblReceta, BorderLayout.NORTH);
        
        txtReceta = new JTextArea();
        txtReceta.setLineWrap(true);
        txtReceta.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtReceta);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior (botones)
        JPanel panelInferior = new JPanel();
        contentPane.add(panelInferior, BorderLayout.SOUTH);
        
        JButton btnGenerar = new JButton("Generar Receta");
        btnGenerar.addActionListener(e -> generarReceta());
        panelInferior.add(btnGenerar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panelInferior.add(btnCancelar);
    }

    private void buscarPaciente() {
        String dni = txtDni.getText().trim();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el DNI del paciente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Paciente paciente = BaseDatosSimulada.buscarPacientePorDNI(dni);
        if (paciente == null) {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            txtNombrePaciente.setText("");
            return;
        }
        
        txtNombrePaciente.setText(paciente.getNombre() + " " + paciente.getApellidoPaterno());
    }

    private void generarReceta() {
        String dniPaciente = txtDni.getText().trim();
        if (dniPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero busque y seleccione un paciente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String textoReceta = txtReceta.getText().trim();
        if (textoReceta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba la receta médica", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Crear la receta
        RecetaPaciente receta = new RecetaPaciente(
            dniPaciente,
            medicoActual.getNombre() + " " + medicoActual.getApellidoPaterno(),
            textoReceta
        );
        
        // Guardar la receta (simulada)
        BaseDatosSimulada.agregarRecetaPaciente(receta);
        
        // Mostrar vista previa
        mostrarVistaPrevia(receta);
        
        JOptionPane.showMessageDialog(this, 
            "Receta generada exitosamente\nID: " + receta.getId(), 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
        
        dispose();
    }
    
    private void mostrarVistaPrevia(RecetaPaciente receta) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String html = "<html><body style='font-family:Arial; padding:20px;'>"
            + "<h2>Receta Médica</h2>"
            + "<p><b>Fecha:</b> " + sdf.format(receta.getFechaEmision()) + "</p>"
            + "<p><b>Médico:</b> " + receta.getNombreMedico() + "</p>"
            + "<p><b>Paciente:</b> " + txtNombrePaciente.getText() + "</p>"
            + "<p><b>DNI Paciente:</b> " + receta.getDniPaciente() + "</p>"
            + "<hr>"
            + "<p><b>Receta:</b></p>"
            + "<p style='border:1px solid #ccc; padding:10px;'>" 
            + receta.getTextoReceta().replace("\n", "<br>") 
            + "</p>"
            + "</body></html>";
        
        JOptionPane.showMessageDialog(this, html, "Vista Previa Receta", JOptionPane.PLAIN_MESSAGE);
    }
}