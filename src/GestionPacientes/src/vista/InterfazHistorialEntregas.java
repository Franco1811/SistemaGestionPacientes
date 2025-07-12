package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.BaseDatosSimulada;
import modelo.Entrega;
import modelo.MedicamentoEntregado;

public class InterfazHistorialEntregas extends JFrame {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel modeloTabla;
    private JPanel contentPane;
    private JFrame ventanaAnterior;
    private JTextField txtBuscarDni;

    public InterfazHistorialEntregas(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Historial de Entregas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 850, 450);
        getContentPane().setLayout(new BorderLayout());

        // --- Panel de búsqueda ---
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setBackground(SystemColor.textHighlight);
        JLabel lblBuscarDni = new JLabel("Buscar por DNI:");
        txtBuscarDni = new JTextField(10);
        JButton btnBuscar = new JButton("Buscar");
        JButton btnVerTodo = new JButton("Ver Todo");

        panelBusqueda.add(lblBuscarDni);
        panelBusqueda.add(txtBuscarDni);
        panelBusqueda.add(btnBuscar);
        panelBusqueda.add(btnVerTodo);
        getContentPane().add(panelBusqueda, BorderLayout.NORTH);

        // --- Tabla de entregas ---
        modeloTabla = new DefaultTableModel(
                new String[]{"ID Entrega", "DNI Paciente", "Paciente", "Fecha", "Medicamentos"}, 0
        );
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // --- Botón volver ---
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });
        getContentPane().add(btnVolver, BorderLayout.SOUTH);

        // --- Acción del botón buscar ---
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dniIngresado = txtBuscarDni.getText().trim();
                cargarEntregas(dniIngresado);
            }
        });

        // --- Acción del botón ver todo ---
        btnVerTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBuscarDni.setText("");
                cargarEntregas("");
            }
        });

        // Cargar todas las entregas al inicio
        cargarEntregas("");
    }

    private void cargarEntregas(String dniFiltrado) {
        modeloTabla.setRowCount(0); // Limpiar tabla
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Entrega e : BaseDatosSimulada.getListaEntregas()) {
            if (dniFiltrado.isEmpty() || e.getPaciente().getDNI().equals(dniFiltrado)) {
                StringBuilder meds = new StringBuilder();
                for (MedicamentoEntregado me : e.getListaMedicamentos()) {
                    meds.append(me.getNombreMedicamento())
                            .append(" (")
                            .append(me.getCantidad())
                            .append("), ");
                }
                if (meds.length() > 0) {
                    meds.setLength(meds.length() - 2); // quitar última coma
                }

                modeloTabla.addRow(new Object[]{
                        e.getIdEntrega(),
                        e.getPaciente().getDNI(),
                        e.getPaciente().getNombre() + " " + e.getPaciente().getApellidoPaterno(),
                        sdf.format(e.getFecha()),
                        meds.toString()
                });
            }
        }
    }
}


