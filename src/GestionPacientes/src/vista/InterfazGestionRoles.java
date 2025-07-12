package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import modelo.BaseDatosSimulada;
import modelo.Rol;
import modelo.Usuario;
import java.awt.SystemColor;
import vista.InterfazAdmin;



public class InterfazGestionRoles extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable tablaUsuarios;
    private JTextField txtUsernameEditar;
    private JComboBox<String> comboRolEditar;
    private JCheckBox checkActivo;
    private JTextField txtNuevoUsername;
    private JPasswordField txtNuevoPassword;
    private JComboBox<String> comboRolNuevo;
    private JFrame ventanaAnterior;


    public InterfazGestionRoles(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    	getContentPane().setBackground(SystemColor.textHighlight);
        setTitle("Gestión de Roles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        getContentPane().setLayout(null);

        // Tabla usuarios
        String[] columnas = {"Username", "Rol", "Estado"};
        tablaUsuarios = new JTable(new DefaultTableModel(cargarDatosTabla(), columnas));
        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        scroll.setBounds(20, 50, 650, 150);
        getContentPane().add(scroll);

        // Selección de fila para cargar datos en el panel de edición
        tablaUsuarios.getSelectionModel().addListSelectionListener(e -> {
            int fila = tablaUsuarios.getSelectedRow();
            if (fila >= 0) {
                String username = tablaUsuarios.getValueAt(fila, 0).toString();
                Usuario usuario = BaseDatosSimulada.buscarUsuario(username);
                if (usuario != null) {
                    txtUsernameEditar.setText(usuario.getUserName());
                    comboRolEditar.setSelectedItem(usuario.getRol().getNombre());
                    checkActivo.setSelected(usuario.isActivo());
                }
            }
        });

        // Panel Editar usuario
        JPanel panelEditar = new JPanel();
        panelEditar.setBorder(new TitledBorder("Editar Usuario"));
        panelEditar.setLayout(null);
        panelEditar.setBounds(20, 210, 320, 180);
        getContentPane().add(panelEditar);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 30, 100, 20);
        panelEditar.add(lblUsername);

        txtUsernameEditar = new JTextField();
        txtUsernameEditar.setBounds(110, 30, 180, 20);
        panelEditar.add(txtUsernameEditar);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(10, 60, 100, 20);
        panelEditar.add(lblRol);

        comboRolEditar = new JComboBox<>(new String[]{
                Rol.ADMINISTRADOR,
                Rol.MEDICO,
                Rol.ENFERMERO,
                Rol.FARMACEUTICO,
                Rol.LABORATORIO,
                Rol.RECEPCIONISTA
        });
        comboRolEditar.setBounds(110, 60, 180, 20);
        panelEditar.add(comboRolEditar);

        checkActivo = new JCheckBox("Activo");
        checkActivo.setBounds(110, 90, 100, 20);
        panelEditar.add(checkActivo);

        JButton btnGuardar = new JButton("Guardar Cambios");
        btnGuardar.setBounds(90, 120, 150, 25);
        panelEditar.add(btnGuardar);

        JButton btnEliminar = new JButton("Eliminar Usuario");
        btnEliminar.setBounds(90, 150, 150, 25);
        panelEditar.add(btnEliminar);

        // Panel Crear usuario
        JPanel panelNuevo = new JPanel();
        panelNuevo.setBorder(new TitledBorder("Crear Nuevo Usuario"));
        panelNuevo.setLayout(null);
        panelNuevo.setBounds(360, 210, 310, 180);
        getContentPane().add(panelNuevo);

        JLabel lblNuevoUser = new JLabel("Username:");
        lblNuevoUser.setBounds(10, 30, 100, 20);
        panelNuevo.add(lblNuevoUser);

        txtNuevoUsername = new JTextField();
        txtNuevoUsername.setBounds(110, 30, 180, 20);
        panelNuevo.add(txtNuevoUsername);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(10, 60, 100, 20);
        panelNuevo.add(lblPassword);

        txtNuevoPassword = new JPasswordField();
        txtNuevoPassword.setBounds(110, 60, 180, 20);
        panelNuevo.add(txtNuevoPassword);

        JLabel lblNuevoRol = new JLabel("Rol:");
        lblNuevoRol.setBounds(10, 90, 100, 20);
        panelNuevo.add(lblNuevoRol);

        comboRolNuevo = new JComboBox<>(new String[]{
                Rol.ADMINISTRADOR,
                Rol.MEDICO,
                Rol.ENFERMERO,
                Rol.FARMACEUTICO,
                Rol.LABORATORIO,
                Rol.RECEPCIONISTA
        });
        comboRolNuevo.setBounds(110, 90, 180, 20);
        panelNuevo.add(comboRolNuevo);

        JButton btnCrear = new JButton("Crear Usuario");
        btnCrear.setBounds(80, 130, 150, 25);
        panelNuevo.add(btnCrear);
        
        
        //BOTON PARA RETROCEDE A INTERFAZ ADMIN
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            if (ventanaAnterior != null) {
                ventanaAnterior.setVisible(true);
            }
            dispose();
        });

        btnVolver.setBounds(507, 425, 150, 25);
        getContentPane().add(btnVolver);
        
        
        
        JLabel lblGestionDeRoles = new JLabel("GESTION DE ROLES");
        lblGestionDeRoles.setForeground(SystemColor.window);
        lblGestionDeRoles.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblGestionDeRoles.setBounds(174, 0, 422, 49);
        getContentPane().add(lblGestionDeRoles);

        // AACCIONES DE BOTONES

        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtNuevoUsername.getText();
                String password = new String(txtNuevoPassword.getPassword());
                String rolSeleccionado = (String) comboRolNuevo.getSelectedItem();

                if (!username.isEmpty() && !password.isEmpty()) {
                    Usuario nuevoUsuario = new Usuario(username, password, new Rol(0, rolSeleccionado), true);
                    BaseDatosSimulada.agregarUsuario(nuevoUsuario);
                    actualizarTabla();
                    limpiarCamposNuevo();
                } else {
                    JOptionPane.showMessageDialog(null, "Completa todos los campos.");
                }
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsernameEditar.getText();
                Usuario usuario = BaseDatosSimulada.buscarUsuario(username);
                if (usuario != null) {
                    usuario.setRol(new Rol(0, (String) comboRolEditar.getSelectedItem()));
                    usuario.setActivo(checkActivo.isSelected());
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsernameEditar.getText();
                Usuario usuario = BaseDatosSimulada.buscarUsuario(username);
                if (usuario != null) {
                    BaseDatosSimulada.eliminarUsuario(usuario);
                    actualizarTabla();
                    limpiarCamposEditar();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                }
            }
        });
    }

    private Object[][] cargarDatosTabla() {
        var lista = BaseDatosSimulada.getUsuarios();
        Object[][] datos = new Object[lista.size()][3];
        for (int i = 0; i < lista.size(); i++) {
            Usuario u = lista.get(i);
            datos[i][0] = u.getUserName();
            datos[i][1] = u.getRol().getNombre();
            datos[i][2] = u.isActivo() ? "Activo" : "Inactivo";
        }
        return datos;
    }

    private void actualizarTabla() {
        String[] columnas = {"Username", "Rol", "Estado"};
        tablaUsuarios.setModel(new DefaultTableModel(cargarDatosTabla(), columnas));
    }

    private void limpiarCamposNuevo() {
        txtNuevoUsername.setText("");
        txtNuevoPassword.setText("");
        comboRolNuevo.setSelectedIndex(0);
    }

    private void limpiarCamposEditar() {
        txtUsernameEditar.setText("");
        comboRolEditar.setSelectedIndex(0);
        checkActivo.setSelected(false);
    }
}
