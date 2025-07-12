package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelo.BaseDatosSimulada;
import modelo.Entrega;
import modelo.MedicamentoEntregado;
import modelo.Medicamentos;
import modelo.Paciente;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazRegistrarEntrega extends JFrame {
    private JTextField txtDniPaciente;
    private static final long serialVersionUID = 1L;
    private JTextField txtIdMedicamento;
    private JTextField txtCantidad;
    private DefaultTableModel modeloTabla;
    private JFrame ventanaAnterior;

    private List<MedicamentoEntregado> listaMedicamentosEntrega = new ArrayList<>();

    public InterfazRegistrarEntrega(JFrame ventanaAnterior) {
    	getContentPane().setBackground(SystemColor.textHighlight);
        this.ventanaAnterior = ventanaAnterior;
        setTitle("Registrar Entrega de Medicamentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        getContentPane().setLayout(null);

        JLabel lblPaciente = new JLabel("DNI Paciente:");
        lblPaciente.setBounds(30, 30, 120, 25);
        getContentPane().add(lblPaciente);

        txtDniPaciente = new JTextField();
        txtDniPaciente.setBounds(160, 30, 150, 25);
        getContentPane().add(txtDniPaciente);

        JLabel lblIdMedicamento = new JLabel("ID Medicamento:");
        lblIdMedicamento.setBounds(30, 70, 120, 25);
        getContentPane().add(lblIdMedicamento);

        txtIdMedicamento = new JTextField();
        txtIdMedicamento.setBounds(160, 70, 150, 25);
        getContentPane().add(txtIdMedicamento);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(30, 110, 120, 25);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(160, 110, 150, 25);
        getContentPane().add(txtCantidad);

        JButton btnAgregarMedicamento = new JButton("Agregar Medicamento");
        btnAgregarMedicamento.setBounds(341, 48, 200, 30);
        getContentPane().add(btnAgregarMedicamento);
        btnAgregarMedicamento.addActionListener(e -> agregarMedicamento());


        JButton btnGuardarEntrega = new JButton("Guardar Entrega");
        btnGuardarEntrega.setBounds(250, 400, 200, 40);
        getContentPane().add(btnGuardarEntrega);
        btnGuardarEntrega.addActionListener(e -> guardarEntrega());




        modeloTabla = new DefaultTableModel(new String[]{"DNI Paciente","ID", "Nombre", "Cantidad"}, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(22, 160, 628, 200);
        getContentPane().add(scrollPane);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });
        btnVolver.setBounds(10, 404, 78, 40);
        getContentPane().add(btnVolver);
        
        
        JButton btnEliminarFila = new JButton("Eliminar Registro");
        btnEliminarFila.setBounds(341, 89, 200, 30);
        getContentPane().add(btnEliminarFila);
        btnEliminarFila.addActionListener(e -> eliminarFilaSeleccionada(tabla));
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(22, 11, 533, 139);
        getContentPane().add(panelBotones);

    }

    private void agregarMedicamento() {
        try {
            String dniPaciente = txtDniPaciente.getText().trim();
            
            // Validar DNI vacío
            if (dniPaciente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Primero ingresa el DNI del paciente.");
                return;
            }

            // Validar longitud de DNI (solo 8 dígitos)
            if (dniPaciente.length() != 8 || !dniPaciente.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "El DNI debe tener exactamente 8 dígitos numéricos.");
                return;
            }

            // Validar existencia del paciente
            Paciente paciente = BaseDatosSimulada.buscarPacientePorDNI(dniPaciente);
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "El paciente con DNI " + dniPaciente + " no existe.");
                return;
            }

            int id = Integer.parseInt(txtIdMedicamento.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            // Buscar medicamento
            Medicamentos med = null;
            for (Medicamentos m : BaseDatosSimulada.getListaMedicamentos()) {
                if (m.getID() == id) {
                    med = m;
                    break;
                }
            }

            if (med == null) {
                JOptionPane.showMessageDialog(this, "Medicamento no encontrado.");
                return;
            }

            if (cantidad > med.getStock()) {
                JOptionPane.showMessageDialog(this, "No hay suficiente stock.");
                return;
            }

            listaMedicamentosEntrega.add(
                    new MedicamentoEntregado(id, med.getNombre(), cantidad)
            );

            modeloTabla.addRow(new Object[]{
                    dniPaciente, 
                    id, 
                    med.getNombre(), 
                    cantidad
            });

            txtIdMedicamento.setText("");
            txtCantidad.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar medicamento: " + ex.getMessage());
        }
    }



    private void guardarEntrega() {
        if (modeloTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay medicamentos para registrar.");
            return;
        }

        // Agrupar medicamentos por paciente
        java.util.Map<String, List<MedicamentoEntregado>> mapaEntregas = new java.util.HashMap<>();

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            String dni = modeloTabla.getValueAt(i, 0).toString();
            int id = Integer.parseInt(modeloTabla.getValueAt(i, 1).toString());
            String nombre = modeloTabla.getValueAt(i, 2).toString();
            int cantidad = Integer.parseInt(modeloTabla.getValueAt(i, 3).toString());

            MedicamentoEntregado med = new MedicamentoEntregado(id, nombre, cantidad);

            mapaEntregas.putIfAbsent(dni, new ArrayList<>());
            mapaEntregas.get(dni).add(med);
        }

        for (String dni : mapaEntregas.keySet()) {
            Paciente paciente = BaseDatosSimulada.buscarPacientePorDNI(dni);
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "Paciente con DNI " + dni + " no encontrado. No se guardó la entrega para este paciente.");
                continue;
            }

            List<MedicamentoEntregado> listaMed = mapaEntregas.get(dni);

            // Actualizar stock
            for (MedicamentoEntregado me : listaMedicamentosEntrega) {
                for (Medicamentos m : BaseDatosSimulada.getListaMedicamentos()) {
                    if (m.getID() == me.getIdMedicamento()) {
                        int nuevoStock = m.getStock() - me.getCantidad();
                        m.setStock(nuevoStock);

                        if (nuevoStock <= 10) {
                            m.setAlertaStock(true);
                        }
                    }
                }
            }


            int nuevoId = BaseDatosSimulada.getListaEntregas().size() + 1;
            String nuevoIdReceta = "R-" + nuevoId;

            Entrega entrega = new Entrega(
                nuevoId,
                nuevoIdReceta,
                false,               // recetaUtilizada inicialmente es false
                paciente,
                new Date(),
                listaMed
            );

            BaseDatosSimulada.agregarEntrega(entrega);

        }

        JOptionPane.showMessageDialog(this, "Entregas registradas correctamente.");
        
        // Limpiar tabla y campos
        modeloTabla.setRowCount(0);
        listaMedicamentosEntrega.clear();
        txtDniPaciente.setText("");
    }

    
    private void eliminarFilaSeleccionada(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta fila?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        // Obtener datos de la fila
        String dni = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
        int idMed = Integer.parseInt(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
        int cantidad = Integer.parseInt(modeloTabla.getValueAt(filaSeleccionada, 3).toString());

        // Eliminar de la lista de medicamentos (la que se usa para guardar)
        listaMedicamentosEntrega.removeIf(m -> m.getIdMedicamento() == idMed && m.getCantidad() == cantidad);

        // Eliminar la fila de la tabla
        modeloTabla.removeRow(filaSeleccionada);
    }

}


