package vista;

import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.ResultadoLaboratorio;

public class InterfazVisualizarResultadoLabo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame ventanaAnterior;
	private List<ResultadoLaboratorio> resultados;
	private JTable tablaResultados;
	private DefaultTableModel modeloTabla;
	private JTextField campoID;

	public InterfazVisualizarResultadoLabo(JFrame ventanaAnterior) {
		this.ventanaAnterior = ventanaAnterior;

		setTitle("Visualización de Resultados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblBuscar = new JLabel("ID Paciente:");
		lblBuscar.setBounds(20, 10, 100, 25);
		contentPane.add(lblBuscar);

		campoID = new JTextField();
		campoID.setBounds(110, 10, 120, 25);
		contentPane.add(campoID);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(240, 10, 100, 25);
		btnBuscar.addActionListener(e -> filtrarPorID());
		contentPane.add(btnBuscar);

		// Configuración de la tabla
		String[] columnas = {"Paciente", "Examen", "Resultado", "Mínimo", "Máximo", "Fecha"};
		modeloTabla = new DefaultTableModel(columnas, 0);
		tablaResultados = new JTable(modeloTabla);
		tablaResultados.setFont(new Font("SansSerif", Font.PLAIN, 13));
		tablaResultados.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(tablaResultados);
		scrollPane.setBounds(20, 50, 640, 350);
		contentPane.add(scrollPane);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(20, 420, 100, 30);
		btnVolver.addActionListener(e -> {
			if (ventanaAnterior != null) {
				ventanaAnterior.setVisible(true);
			}
			dispose();
		});
		contentPane.add(btnVolver);

		// Simulación de datos
		resultados = new ArrayList<>();
			
		resultados.add(new ResultadoLaboratorio("12345678", "Glucosa", 85, 70, 110, LocalDate.now().minusDays(1)));
		resultados.add(new ResultadoLaboratorio("87654321", "Hemoglobina", 13.2, 12, 16, LocalDate.now().minusDays(2)));
		resultados.add(new ResultadoLaboratorio("11223344", "Creatinina", 1.0, 0.6, 1.3, LocalDate.now().minusDays(4)));
		resultados.add(new ResultadoLaboratorio("44556677", "Colesterol", 150, 125, 200, LocalDate.now().minusDays(5)));
		resultados.add(new ResultadoLaboratorio("55667788", "Plaquetas", 200000, 150000, 450000, LocalDate.now().minusDays(6)));
		resultados.add(new ResultadoLaboratorio("66778899", "Glucosa", 60, 70, 110, LocalDate.now().minusDays(36))); // bajo
		resultados.add(new ResultadoLaboratorio("77889900", "Glucosa", 125, 70, 110, LocalDate.now().minusDays(37))); // alto
		resultados.add(new ResultadoLaboratorio("88990011", "Hemoglobina", 10.5, 12, 16, LocalDate.now().minusDays(38))); // bajo
		resultados.add(new ResultadoLaboratorio("99001122", "Hemoglobina", 17.2, 12, 16, LocalDate.now().minusDays(39))); // alto
		resultados.add(new ResultadoLaboratorio("10111213", "Urea", 8, 10, 50, LocalDate.now().minusDays(40))); // bajo
			
		// Mostrar todos al inicio
		mostrarTodosLosResultados();
	}

	private void mostrarTodosLosResultados() {
		modeloTabla.setRowCount(0); // Limpia tabla
		for (ResultadoLaboratorio r : resultados) {
			modeloTabla.addRow(new Object[]{
				r.getIdPaciente(),
				r.getTipo(),
				r.getValor(),
				r.getMinimo(),
				r.getMaximo(),
				r.getFecha()
			});
		}
	}

	private void filtrarPorID() {
		String id = campoID.getText().trim();
		modeloTabla.setRowCount(0); // Limpia tabla

		if (id.isEmpty()) {
			mostrarTodosLosResultados();
			return;
		}

		for (ResultadoLaboratorio r : resultados) {
			if (r.getIdPaciente().equalsIgnoreCase(id)) {
				modeloTabla.addRow(new Object[]{
					r.getIdPaciente(),
					r.getTipo(),
					r.getValor(),
					r.getMinimo(),
					r.getMaximo(),
					r.getFecha()
				});
			}
		}

		// Si no hay resultados, puedes mostrar un mensaje opcional
		if (modeloTabla.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "No se encontraron resultados para el paciente: " + id);
		}
	}
}
