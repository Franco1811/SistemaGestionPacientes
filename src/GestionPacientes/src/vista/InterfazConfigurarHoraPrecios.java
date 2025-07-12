package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import modelo.BaseDatosSimulada;
import modelo.Medicamentos;

public class InterfazConfigurarHoraPrecios extends JFrame {

    private JPanel contentPane;
    private JTable tablaMedicamentos;
    private DefaultTableModel modeloTabla;
    private JTextField txtNuevoPrecio;
    private JComboBox<String> comboDias;
    private JTextField txtHoraInicio;
    private JTextField txtHoraFin;

    public InterfazConfigurarHoraPrecios(JFrame ventanaAnterior) {
        setTitle("Configuración de Precios y Horario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel header = new JPanel();
        header.setBackground(SystemColor.textHighlight);
        header.setBounds(0, 0, 684, 70);
        contentPane.add(header);
        header.setLayout(null);

        JLabel lblTitulo = new JLabel("CONFIGURACIÓN DE PRECIOS Y HORARIO");
        lblTitulo.setForeground(SystemColor.window);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(60, 15, 560, 40);
        header.add(lblTitulo);

        JLabel lblPrecios = new JLabel("Precios de Medicamentos:");
        lblPrecios.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPrecios.setBounds(20, 90, 250, 20);
        contentPane.add(lblPrecios);

        modeloTabla = new DefaultTableModel(
                new String[] { "Medicamento", "Precio" }, 0
        );
        
        tablaMedicamentos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaMedicamentos);
        scrollPane.setBounds(20, 120, 400, 150);
        contentPane.add(scrollPane);

        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio:");
        lblNuevoPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNuevoPrecio.setBounds(440, 130, 100, 20);
        contentPane.add(lblNuevoPrecio);

        txtNuevoPrecio = new JTextField();
        txtNuevoPrecio.setBounds(550, 130, 100, 25);
        contentPane.add(txtNuevoPrecio);
        txtNuevoPrecio.setColumns(10);

        JButton btnActualizarPrecio = new JButton("Actualizar Precio");
        btnActualizarPrecio.setBounds(440, 170, 210, 30);
        contentPane.add(btnActualizarPrecio);
        btnActualizarPrecio.addActionListener(e -> actualizarPrecio());

        JButton btnAgregarMedicamento = new JButton("Agregar Nuevo Medicamento");
        btnAgregarMedicamento.setBounds(440, 220, 210, 30);
        contentPane.add(btnAgregarMedicamento);
        btnAgregarMedicamento.addActionListener(e -> agregarMedicamento());

        // Horario de atención
        JLabel lblHorario = new JLabel("Horario de Atención:");
        lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHorario.setBounds(20, 290, 250, 20);
        contentPane.add(lblHorario);

        JLabel lblDia = new JLabel("Día:");
        lblDia.setBounds(20, 320, 50, 20);
        contentPane.add(lblDia);

        comboDias = new JComboBox<>(new String[] {
                "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
        });
        comboDias.setBounds(70, 320, 100, 25);
        contentPane.add(comboDias);

        JLabel lblInicio = new JLabel("Hora Inicio:");
        lblInicio.setBounds(200, 320, 80, 20);
        contentPane.add(lblInicio);

        txtHoraInicio = new JTextField();
        txtHoraInicio.setBounds(280, 320, 80, 25);
        contentPane.add(txtHoraInicio);

        JLabel lblFin = new JLabel("Hora Fin:");
        lblFin.setBounds(380, 320, 80, 20);
        contentPane.add(lblFin);

        txtHoraFin = new JTextField();
        txtHoraFin.setBounds(450, 320, 80, 25);
        contentPane.add(txtHoraFin);

        JButton btnGuardarHorario = new JButton("Guardar Horario");
        btnGuardarHorario.setBounds(550, 320, 120, 30);
        contentPane.add(btnGuardarHorario);
        btnGuardarHorario.addActionListener(e -> guardarHorario());

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(550, 400, 100, 30);
        contentPane.add(btnVolver);
        btnVolver.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });
        
        cargarMedicamentosDesdeBaseDeDatos();
    }
    private void cargarMedicamentosDesdeBaseDeDatos() {
        modeloTabla.setRowCount(0); // limpia tabla

        for (var m : BaseDatosSimulada.getListaMedicamentos()) {
            Object[] fila = {
                m.getNombre(),
                String.format("%.2f", m.getPrecio())
            };
            modeloTabla.addRow(fila);
        }
    }


    private void actualizarPrecio() {
        int fila = tablaMedicamentos.getSelectedRow();
        String nuevoPrecioStr = txtNuevoPrecio.getText();

        if (fila >= 0 && !nuevoPrecioStr.isEmpty()) {
            try {
                double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);

                // Obtener el nombre del medicamento seleccionado
                String nombre = (String) modeloTabla.getValueAt(fila, 0);

                // Buscar en la base de datos y actualizar el precio
                for (var m : BaseDatosSimulada.getListaMedicamentos()) {
                    if (m.getNombre().equals(nombre)) {
                        m.setPrecio(nuevoPrecio);
                        break;
                    }
                }

                // Refrescar tabla
                cargarMedicamentosDesdeBaseDeDatos();

                JOptionPane.showMessageDialog(this, "Precio actualizado correctamente.");
                txtNuevoPrecio.setText("");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingresa un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un medicamento y escribe un nuevo precio.");
        }
    }


    private void agregarMedicamento() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo medicamento:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            String precioStr = JOptionPane.showInputDialog(this, "Ingrese el precio:");
            if (precioStr != null && !precioStr.trim().isEmpty()) {
                try {
                    double precio = Double.parseDouble(precioStr);

                    int nuevoID = BaseDatosSimulada.getListaMedicamentos().size() + 1;
                    Medicamentos nuevoMed = new Medicamentos(nuevoID, nombre, 0, false, precio);

                    BaseDatosSimulada.agregarMedicamento(nuevoMed);

                    cargarMedicamentosDesdeBaseDeDatos();

                    JOptionPane.showMessageDialog(this, "Medicamento agregado correctamente.");

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Precio inválido.");
                }
            }
        }
    }


    private void guardarHorario() {
        String dia = (String) comboDias.getSelectedItem();
        String inicio = txtHoraInicio.getText();
        String fin = txtHoraFin.getText();

        if (!inicio.isEmpty() && !fin.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Horario guardado:\n" +
                            dia + " de " + inicio + " a " + fin);
            txtHoraInicio.setText("");
            txtHoraFin.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Completa las horas de inicio y fin.");
        }
    }
}

