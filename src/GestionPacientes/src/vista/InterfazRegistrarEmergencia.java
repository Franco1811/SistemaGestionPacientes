	package vista;
	
	import modelo.Paciente;
	import modelo.Usuario;
	import modelo.Rol;
	import modelo.IngresoEmergencia;
	
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.Date;
	
	public class InterfazRegistrarEmergencia extends JFrame {
	
	    private JTextField txtDNI, txtNombres, txtApellidos, txtEdad, txtMotivo;
	    private JComboBox<String> comboSexo;
	    private JButton btnBuscarPaciente, btnGuardar;
	    private JFrame ventanaAnterior;
	
	    private Paciente pacienteEncontrado;
	
	    public InterfazRegistrarEmergencia(JFrame ventanaAnterior) {
	        this.ventanaAnterior = ventanaAnterior;
	
	        setTitle("Ingreso por Emergencia");
	        setSize(500, 450);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        getContentPane().setLayout(null);
	
	        JLabel lblDni = new JLabel("DNI Paciente:");
	        lblDni.setBounds(30, 30, 120, 25);
	        getContentPane().add(lblDni);
	
	        txtDNI = new JTextField();
	        txtDNI.setBounds(160, 30, 150, 25);
	        getContentPane().add(txtDNI);
	
	        btnBuscarPaciente = new JButton("Buscar Paciente");
	        btnBuscarPaciente.setBounds(320, 30, 140, 25);
	        getContentPane().add(btnBuscarPaciente);
	
	        JLabel lblNombres = new JLabel("Nombres:");
	        lblNombres.setBounds(30, 70, 120, 25);
	        getContentPane().add(lblNombres);
	
	        txtNombres = new JTextField();
	        txtNombres.setBounds(160, 70, 300, 25);
	        txtNombres.setEnabled(false);
	        getContentPane().add(txtNombres);
	
	        JLabel lblApellidos = new JLabel("Apellidos:");
	        lblApellidos.setBounds(30, 110, 120, 25);
	        getContentPane().add(lblApellidos);
	
	        txtApellidos = new JTextField();
	        txtApellidos.setBounds(160, 110, 300, 25);
	        txtApellidos.setEnabled(false);
	        getContentPane().add(txtApellidos);
	
	        JLabel lblEdad = new JLabel("Edad:");
	        lblEdad.setBounds(30, 150, 120, 25);
	        getContentPane().add(lblEdad);
	
	        txtEdad = new JTextField();
	        txtEdad.setBounds(160, 150, 100, 25);
	        txtEdad.setEnabled(false);
	        getContentPane().add(txtEdad);
	
	        JLabel lblSexo = new JLabel("Sexo:");
	        lblSexo.setBounds(280, 150, 60, 25);
	        getContentPane().add(lblSexo);
	
	        comboSexo = new JComboBox<>(new String[]{"Seleccione...", "Masculino", "Femenino"});
	        comboSexo.setBounds(340, 150, 120, 25);
	        comboSexo.setEnabled(false);
	        getContentPane().add(comboSexo);
	
	        JLabel lblMotivo = new JLabel("Motivo Emergencia:");
	        lblMotivo.setBounds(30, 190, 150, 25);
	        getContentPane().add(lblMotivo);
	
	        txtMotivo = new JTextField();
	        txtMotivo.setBounds(30, 220, 430, 80);
	        getContentPane().add(txtMotivo);
	
	        btnGuardar = new JButton("Registrar Ingreso");
	        btnGuardar.setBounds(160, 320, 180, 35);
	        getContentPane().add(btnGuardar);
	
	        JButton btnVolver = new JButton("Volver");
	        btnVolver.setBounds(10, 370, 80, 30);
	        getContentPane().add(btnVolver);
	
	        // EVENTOS
	        btnBuscarPaciente.addActionListener(e -> buscarPaciente());
	
	        btnGuardar.addActionListener(e -> registrarIngreso());
	
	        btnVolver.addActionListener(e -> {
	            ventanaAnterior.setVisible(true);
	            dispose();
	        });
	    }
	
	    private void buscarPaciente() {
	        String dni = txtDNI.getText().trim();
	
	        if (dni.isEmpty() || !dni.matches("\\d{8}")) {
	            JOptionPane.showMessageDialog(this, "Ingrese un DNI válido (8 dígitos).");
	            return;
	        }
	
	        pacienteEncontrado = null;
	        for (Paciente p : Paciente.getPacientes()) {
	            if (p.getDNI().equals(dni)) {
	                pacienteEncontrado = p;
	                break;
	            }
	        }
	
	        if (pacienteEncontrado != null) {
	            // Paciente EXISTE → llenar datos
	            txtNombres.setText(pacienteEncontrado.getNombre());
	            txtApellidos.setText(pacienteEncontrado.getApellidoPaterno() + " " + pacienteEncontrado.getApellidoMaterno());
	            txtEdad.setText(String.valueOf(pacienteEncontrado.getEdad()));
	            comboSexo.setSelectedItem(pacienteEncontrado.getSexo());
	
	            txtNombres.setEnabled(false);
	            txtApellidos.setEnabled(false);
	            txtEdad.setEnabled(false);
	            comboSexo.setEnabled(false);
	
	            JOptionPane.showMessageDialog(this, "Paciente encontrado.");
	
	        } else {
	            // Paciente NO existe → permitir registro rápido
	            JOptionPane.showMessageDialog(this, "Paciente no encontrado. Ingrese datos mínimos para registrarlo.");
	
	            txtNombres.setText("");
	            txtApellidos.setText("");
	            txtEdad.setText("");
	            comboSexo.setSelectedIndex(0);
	
	            txtNombres.setEnabled(true);
	            txtApellidos.setEnabled(true);
	            txtEdad.setEnabled(true);
	            comboSexo.setEnabled(true);
	        }
	    }
	
	    private void registrarIngreso() {
	        String dni = txtDNI.getText().trim();
	        String nombres = txtNombres.getText().trim();
	        String apellidos = txtApellidos.getText().trim();
	        String edadStr = txtEdad.getText().trim();
	        String sexo = comboSexo.getSelectedItem().toString();
	        String motivo = txtMotivo.getText().trim();
	
	        if (dni.isEmpty() || motivo.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Debe ingresar DNI y motivo de emergencia.");
	            return;
	        }
	
	        if (pacienteEncontrado == null) {
	            // Registrar paciente rápido
	            if (nombres.isEmpty() || apellidos.isEmpty() || edadStr.isEmpty() || sexo.equals("Seleccione...")) {
	                JOptionPane.showMessageDialog(this, "Complete todos los datos mínimos del paciente.");
	                return;
	            }
	
	            int edad;
	            try {
	                edad = Integer.parseInt(edadStr);
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(this, "Edad inválida.");
	                return;
	            }
	
	            // Crear usuario ficticio
	            Usuario nuevoUsuario = new Usuario(
	                    dni, // usuario = dni en caso de emergencia rápida
	                    "123456", // contraseña por defecto
	                    new Rol(3, "PACIENTE"),
	                    true
	            );
	
	            pacienteEncontrado = new Paciente(
	                    dni,
	                    nombres,
	                    apellidos.split(" ")[0],
	                    (apellidos.split(" ").length > 1 ? apellidos.split(" ")[1] : ""),
	                    edad,
	                    sexo,
	                    new Date(), // fecha nacimiento aproximada
	                    0,
	                    "",
	                    "",
	                    nuevoUsuario
	            );
	
	            JOptionPane.showMessageDialog(this,
	                    "Paciente registrado rápidamente.\nUsuario: " + dni + "\nContraseña: 123456");
	        }
	
	        // Registrar ingreso de emergencia
	        IngresoEmergencia nuevoIngreso = new IngresoEmergencia(
	                pacienteEncontrado,
	                motivo,
	                new Date()
	        );
	
	        IngresoEmergencia.getIngresos().add(nuevoIngreso);
	
	        JOptionPane.showMessageDialog(this,
	                "Ingreso de emergencia registrado correctamente.");
	
	        limpiarCampos();
	    }
	
	    private void limpiarCampos() {
	        txtDNI.setText("");
	        txtNombres.setText("");
	        txtApellidos.setText("");
	        txtEdad.setText("");
	        comboSexo.setSelectedIndex(0);
	        txtMotivo.setText("");
	        txtNombres.setEnabled(false);
	        txtApellidos.setEnabled(false);
	        txtEdad.setEnabled(false);
	        comboSexo.setEnabled(false);
	        pacienteEncontrado = null;
	    }
	}
	

