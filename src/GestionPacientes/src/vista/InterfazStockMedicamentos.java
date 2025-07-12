package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.util.List;
import modelo.BaseDatosSimulada;
import modelo.Medicamentos;
import java.awt.SystemColor;


public class InterfazStockMedicamentos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable tablaMedicamentos;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtStock;
    private JCheckBox checkAlertaStock;
    private JTextField txtPrecio;
    private JFrame ventanaAnterior;


    private DefaultTableModel modeloTabla;

    public InterfazStockMedicamentos(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        getContentPane().setBackground(SystemColor.textHighlight);
        setTitle("Stock de Medicamentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        getContentPane().setLayout(null);

        // Tabla medicamentos
        String[] columnas = {"ID", "Nombre", "Stock", "Alerta Stock", "Precio"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaMedicamentos = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaMedicamentos);
        scroll.setBounds(20, 50, 700, 150);
        getContentPane().add(scroll);

        cargarDatosEnTabla();

        // Panel Medicamento
        JPanel panelMedicamento = new JPanel();
        panelMedicamento.setBorder(new TitledBorder("Datos del Medicamento"));
        panelMedicamento.setLayout(null);
        panelMedicamento.setBounds(20, 210, 350, 225);
        getContentPane().add(panelMedicamento);

        JLabel lblID = new JLabel("ID:");
        lblID.setBounds(10, 30, 100, 20);
        panelMedicamento.add(lblID);

        txtID = new JTextField();
        txtID.setBounds(120, 30, 200, 20);
        txtID.setEnabled(false);
        panelMedicamento.add(txtID);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 60, 100, 20);
        panelMedicamento.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 200, 20);
        panelMedicamento.add(txtNombre);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setBounds(10, 90, 100, 20);
        panelMedicamento.add(lblStock);

        txtStock = new JTextField();
        txtStock.setBounds(120, 90, 200, 20);
        panelMedicamento.add(txtStock);
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(10, 121, 100, 20);
        panelMedicamento.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(120, 121, 200, 20);
        panelMedicamento.add(txtPrecio);

        checkAlertaStock = new JCheckBox("Alerta Stock");
        checkAlertaStock.setBounds(130, 149, 150, 20);
        panelMedicamento.add(checkAlertaStock);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 176, 120, 38);
        panelMedicamento.add(btnGuardar);
        btnGuardar.addActionListener(e -> guardarMedicamento());
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(180, 176, 117, 38);
        panelMedicamento.add(btnEliminar);
        btnEliminar.addActionListener(e -> eliminarMedicamento());

        // Panel Botones generales
        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(400, 210, 320, 225);
        panelBotones.setLayout(null);
        getContentPane().add(panelBotones);

        JButton btnNuevo = new JButton("Nuevo Medicamento");
        btnNuevo.setBounds(80, 39, 160, 48);
        panelBotones.add(btnNuevo);
        btnNuevo.addActionListener(e -> limpiarCampos());

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(80, 105, 160, 48);
        panelBotones.add(btnVolver);
        btnVolver.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });
        
        JLabel lblStockDeMedicamentos = new JLabel("REGISTRO DE MEDICAMENTOS");
        lblStockDeMedicamentos.setForeground(SystemColor.window);
        lblStockDeMedicamentos.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblStockDeMedicamentos.setBounds(122, 0, 495, 49);
        getContentPane().add(lblStockDeMedicamentos);


        tablaMedicamentos.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && tablaMedicamentos.getSelectedRow() != -1) {
                cargarDatosDesdeTabla();
            }
        });
    }

    private void cargarDatosEnTabla() {
        modeloTabla.setRowCount(0); // limpia tabla
        List<Medicamentos> lista = BaseDatosSimulada.getListaMedicamentos();
        for (Medicamentos m : lista) {
            Object[] fila = {
                m.getID(),
                m.getNombre(),
                m.getStock(),
                m.isAlertaStock() ? "Sí" : "No",
                m.getPrecio()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void limpiarCampos() {
        txtID.setText("");
        txtNombre.setText("");
        txtStock.setText("");
        checkAlertaStock.setSelected(false);
        txtPrecio.setText("");
    }

    private void cargarDatosDesdeTabla() {
        int fila = tablaMedicamentos.getSelectedRow();
        if (fila != -1) {
            txtID.setText(tablaMedicamentos.getValueAt(fila, 0).toString());
            txtNombre.setText(tablaMedicamentos.getValueAt(fila, 1).toString());
            txtStock.setText(tablaMedicamentos.getValueAt(fila, 2).toString());
            String alerta = tablaMedicamentos.getValueAt(fila, 3).toString();
            txtPrecio.setText(tablaMedicamentos.getValueAt(fila, 4).toString());
            checkAlertaStock.setSelected(alerta.equals("Sí"));
        }
    }

    private void guardarMedicamento() {
        try {
            int id;
            if (txtID.getText().isEmpty()) {
                id = BaseDatosSimulada.getListaMedicamentos().size() + 1;
            } else {
                id = Integer.parseInt(txtID.getText());
            }

            String nombre = txtNombre.getText().trim();
            int stock = Integer.parseInt(txtStock.getText().trim());
            boolean alerta = checkAlertaStock.isSelected();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            
            Medicamentos nuevo = new Medicamentos(id, nombre, stock, alerta, precio);

            if (txtID.getText().isEmpty()) {
                BaseDatosSimulada.agregarMedicamento(nuevo);
            } else {
                new BaseDatosSimulada().eliminarMedicamento(id);
                BaseDatosSimulada.agregarMedicamento(nuevo);
            }

            cargarDatosEnTabla();
            limpiarCampos();

            JOptionPane.showMessageDialog(this, "Medicamento guardado correctamente.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }


    private void eliminarMedicamento() {
        int fila = tablaMedicamentos.getSelectedRow();
        if (fila != -1) {
            int id = Integer.parseInt(tablaMedicamentos.getValueAt(fila, 0).toString());
            new BaseDatosSimulada().eliminarMedicamento(id);
            cargarDatosEnTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Medicamento eliminado.");
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un medicamento para eliminar.");
        }
    }
}


