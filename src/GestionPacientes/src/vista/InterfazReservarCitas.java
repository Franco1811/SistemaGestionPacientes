package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Paciente;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class InterfazReservarCitas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtdnipaciente;
    private JTextField txtnombrecompleto;
    private JComboBox<String> comboBoxareas;
    private JComboBox<String> comboBoxdoctor;
    private Map<String, List<String>> mapaAreasDoctores;
    private Paciente pacienteActual;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private int contadorCitas = 1;


    
    
    public InterfazReservarCitas(Paciente paciente) {
        this(); 
        this.pacienteActual = paciente;
        txtdnipaciente.setText(paciente.getDNI());
        txtnombrecompleto.setText(
            paciente.getNombre() + " " +
            paciente.getApellidoPaterno() + " " +
            paciente.getApellidoMaterno()
        );
    }
    
    public InterfazReservarCitas() {
    	
        setTitle("Citas Médicas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel bg8 = new JPanel();
        bg8.setLayout(null);
        bg8.setBackground(SystemColor.textHighlight);
        bg8.setBounds(0, 0, 984, 88);
        contentPane.add(bg8);

        JLabel lblCitasMdicas = new JLabel("CITAS MÉDICAS");
        lblCitasMdicas.setForeground(SystemColor.window);
        lblCitasMdicas.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblCitasMdicas.setBounds(332, 11, 324, 49);
        bg8.add(lblCitasMdicas);

        JPanel bg9 = new JPanel();
        bg9.setBounds(0, 84, 984, 477);
        contentPane.add(bg9);
        bg9.setLayout(null);

        JLabel lbldni = new JLabel("DNI Paciente:");
        lbldni.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbldni.setBounds(23, 26, 103, 14);
        bg9.add(lbldni);

        JLabel lblrea = new JLabel("Área:");
        lblrea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblrea.setBounds(23, 72, 103, 14);
        bg9.add(lblrea);

        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDoctor.setBounds(467, 72, 103, 14);
        bg9.add(lblDoctor);

        JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
        lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNombreCompleto.setBounds(467, 26, 120, 14);
        bg9.add(lblNombreCompleto);

        txtdnipaciente = new JTextField();
        txtdnipaciente.setColumns(10);
        txtdnipaciente.setBounds(115, 26, 175, 20);
        txtdnipaciente.setEditable(false);
        txtdnipaciente.setBorder(null);
        txtdnipaciente.setOpaque(false);
        bg9.add(txtdnipaciente);

        txtnombrecompleto = new JTextField();
        txtnombrecompleto.setColumns(10);
        txtnombrecompleto.setBounds(583, 26, 175, 20);
        txtnombrecompleto.setEditable(false);
        txtnombrecompleto.setBorder(null);
        txtnombrecompleto.setOpaque(false);
        bg9.add(txtnombrecompleto);

        comboBoxareas = new JComboBox<>();
        comboBoxareas.setModel(new DefaultComboBoxModel<>(new String[]{
                "Seleccione área...", "Cardiología", "Dermatología", "Endocrinología",
                "Gastroenterología", "Ginecología", "Medicina General", "Neurología",
                "Oftalmología", "Otorrinolaringología", "Pediatría", "Psicología",
                "Psiquiatría", "Traumatología", "Urología"
        }));
        comboBoxareas.setBounds(115, 69, 175, 22);
        bg9.add(comboBoxareas);

        comboBoxdoctor = new JComboBox<>();
        comboBoxdoctor.setBounds(583, 69, 175, 22);
        comboBoxdoctor.addItem("Seleccione doctor...");
        bg9.add(comboBoxdoctor);
        
        

        String[] columnas = {
            "ID_CITA", "ID_PACIENTE", "IDUMEDICO", 
            "FECHA_CITA", "HORA_CITA", 
            "AREA", "MOTIVO"
        };

        // Datos vacíos 
        Object[][] datos = new Object[0][8];

        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(20, 120, 940, 229);
        bg9.add(scrollPane);
        
        
        //Boton nueva cita
        JButton btnnuevacita = new JButton("NUEVA CITA");
        btnnuevacita.setBounds(76, 379, 120, 54);
        btnnuevacita.addActionListener(e -> {
            InterfazNuevaCita ventanaNuevaCita = new InterfazNuevaCita(
                this,
                txtdnipaciente.getText(),
                txtnombrecompleto.getText(),
                (String) comboBoxareas.getSelectedItem(),
                (String) comboBoxdoctor.getSelectedItem(),
                modeloTabla
            );
            ventanaNuevaCita.setVisible(true);
            this.setVisible(false);
        });



        bg9.add(btnnuevacita);
        
        
        //Boton atras
        JButton btnatras = new JButton("ATRAS");
        btnatras.addActionListener(e -> {
            InterfazFuncionesPaciente ventanaFunciones = new InterfazFuncionesPaciente(pacienteActual);
            ventanaFunciones.setVisible(true);
            dispose();
        });
        btnatras.setBounds(228, 379, 120, 54);
        bg9.add(btnatras);

        inicializarMapaAreasDoctores();
        inicializarListeners();

        setLocationRelativeTo(null);
    }

    private void inicializarMapaAreasDoctores() {
        mapaAreasDoctores = new HashMap<>();
        mapaAreasDoctores.put("Cardiología", Arrays.asList("Dr. López", "Dra. Hernández"));
        mapaAreasDoctores.put("Dermatología", Arrays.asList("Dr. Rivera", "Dra. Morales"));
        mapaAreasDoctores.put("Endocrinología", Arrays.asList("Dr. Rojas", "Dra. Quintana"));
        mapaAreasDoctores.put("Gastroenterología", Arrays.asList("Dr. Bravo", "Dra. Salinas"));
        mapaAreasDoctores.put("Ginecología", Arrays.asList("Dr. Medina", "Dra. Flores"));
        mapaAreasDoctores.put("Medicina General", Arrays.asList("Dr. Vargas", "Dra. Ruiz"));
        mapaAreasDoctores.put("Neurología", Arrays.asList("Dr. Pérez", "Dra. Estrada"));
        mapaAreasDoctores.put("Oftalmología", Arrays.asList("Dr. Torres", "Dra. Castro"));
        mapaAreasDoctores.put("Otorrinolaringología", Arrays.asList("Dr. Jiménez", "Dra. León"));
        mapaAreasDoctores.put("Pediatría", Arrays.asList("Dr. Gómez", "Dra. Castillo"));
        mapaAreasDoctores.put("Psicología", Arrays.asList("Dr. Serrano", "Dra. Morales"));
        mapaAreasDoctores.put("Psiquiatría", Arrays.asList("Dr. Salazar", "Dra. Mendoza"));
        mapaAreasDoctores.put("Traumatología", Arrays.asList("Dr. Fuentes", "Dra. Cabrera"));
        mapaAreasDoctores.put("Urología", Arrays.asList("Dr. Delgado", "Dra. Silva"));
    }

    private void inicializarListeners() {
        comboBoxareas.addActionListener(e -> {
            String areaSeleccionada = (String) comboBoxareas.getSelectedItem();

            comboBoxdoctor.removeAllItems();
            comboBoxdoctor.addItem("Seleccione doctor...");

            if (mapaAreasDoctores.containsKey(areaSeleccionada)) {
                for (String doctor : mapaAreasDoctores.get(areaSeleccionada)) {
                    comboBoxdoctor.addItem(doctor);
                }
            }
        });
    }
    public void agregarCita(
            String dni,
            String fecha,
            String hora,
            String area,
            String medico,
            String motivo
    ) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        model.addRow(new Object[]{
                contadorCitas,
                dni,
                medico,
                fecha,
                hora,
                area,
                motivo,
        });

        contadorCitas++;
    }
    
    


}


