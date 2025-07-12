package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.ResultadoLaboratorio;

import java.awt.Font;
import java.time.LocalDate;
import java.util.*;

public class InterfazRegistrarResultadoLabo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdPaciente, txtResultado, txtMinimo, txtMaximo;
	private JTable tablaResultados;
	private DefaultTableModel modeloTabla;
	private JFrame ventanaAnterior;
	private List<ResultadoLaboratorio> resultados = new ArrayList<>();

	private JComboBox<String> comboExamen;
	private Map<String, double[]> valoresReferencia;

	public InterfazRegistrarResultadoLabo(JFrame ventanaAnterior) {
		this.ventanaAnterior = ventanaAnterior;

		setTitle("Registro de Resultados de Laboratorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Registrar Resultados de Laboratorio");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(160, 10, 390, 30);
		contentPane.add(lblTitulo);

		JLabel lblId = new JLabel("ID Paciente:");
		lblId.setBounds(20, 60, 100, 20);
		contentPane.add(lblId);

		txtIdPaciente = new JTextField();
		txtIdPaciente.setBounds(110, 60, 100, 20);
		contentPane.add(txtIdPaciente);

		// Valores de referencia
		valoresReferencia = new HashMap<>();
		valoresReferencia.put("Glucosa", new double[]{70, 110});
		valoresReferencia.put("Hemoglobina", new double[]{12, 16});
		valoresReferencia.put("Urea", new double[]{10, 50});
		valoresReferencia.put("Creatinina", new double[]{0.6, 1.3});
		valoresReferencia.put("Colesterol", new double[]{125, 200});
		valoresReferencia.put("Plaquetas", new double[]{150000, 450000});
		valoresReferencia.put("Hematocrito", new double[]{36, 52});

		JLabel lblExamen = new JLabel("Examen:");
		lblExamen.setBounds(220, 60, 80, 20);
		contentPane.add(lblExamen);

		comboExamen = new JComboBox<>(valoresReferencia.keySet().toArray(new String[0]));
		comboExamen.setBounds(290, 60, 120, 20);
		contentPane.add(comboExamen);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(420, 60, 80, 20);
		contentPane.add(lblResultado);

		txtResultado = new JTextField();
		txtResultado.setBounds(490, 60, 100, 20);
		contentPane.add(txtResultado);

		JLabel lblMin = new JLabel("Mínimo:");
		lblMin.setBounds(20, 90, 80, 20);
		contentPane.add(lblMin);

		txtMinimo = new JTextField();
		txtMinimo.setBounds(110, 90, 100, 20);
		txtMinimo.setEditable(false); // No editable
		contentPane.add(txtMinimo);

		JLabel lblMax = new JLabel("Máximo:");
		lblMax.setBounds(220, 90, 80, 20);
		contentPane.add(lblMax);

		txtMaximo = new JTextField();
		txtMaximo.setBounds(290, 90, 120, 20);
		txtMaximo.setEditable(false); // No editable
		contentPane.add(txtMaximo);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(450, 90, 100, 25);
		contentPane.add(btnRegistrar);

		btnRegistrar.addActionListener(e -> registrarResultado());

		// Tabla
		String[] columnas = {"Paciente", "Examen", "Resultado", "Mín", "Máx", "Fecha"};
		modeloTabla = new DefaultTableModel(columnas, 0);
		tablaResultados = new JTable(modeloTabla);
		tablaResultados.setFont(new Font("SansSerif", Font.PLAIN, 13));
		tablaResultados.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(tablaResultados);
		scrollPane.setBounds(20, 140, 690, 280);
		contentPane.add(scrollPane);

		// Botón Volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(20, 430, 100, 25);
		btnVolver.addActionListener(e -> {
			if (ventanaAnterior != null) {
				ventanaAnterior.setVisible(true);
			}
			dispose();
		});
		contentPane.add(btnVolver);

		// Acción al seleccionar un examen del combo
		comboExamen.addActionListener(e -> {
			String examenSeleccionado = (String) comboExamen.getSelectedItem();
			if (examenSeleccionado != null) {
				double[] valores = valoresReferencia.get(examenSeleccionado);
				txtMinimo.setText(String.valueOf(valores[0]));
				txtMaximo.setText(String.valueOf(valores[1]));
			}
		});

		// Inicializa con valores del primer examen
		comboExamen.setSelectedIndex(0);
	}
	
	private void registrarResultado() {
		try {
			String id = txtIdPaciente.getText().trim();
			String examen = (String) comboExamen.getSelectedItem();
			double resultado = Double.parseDouble(txtResultado.getText().trim());
			double minimo = Double.parseDouble(txtMinimo.getText().trim());
			double maximo = Double.parseDouble(txtMaximo.getText().trim());

			if (id.isEmpty() || examen.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Completa todos los campos.");
				return;
			}

			LocalDate fecha = LocalDate.now();
			ResultadoLaboratorio r = new ResultadoLaboratorio(id, examen, resultado, minimo, maximo, fecha);
			resultados.add(r);

			modeloTabla.addRow(new Object[] {
					id, examen, resultado, minimo, maximo, fecha
			});

			txtIdPaciente.setText("");
			txtResultado.setText("");

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Los valores numéricos deben ser válidos.");
		}
	}
}
