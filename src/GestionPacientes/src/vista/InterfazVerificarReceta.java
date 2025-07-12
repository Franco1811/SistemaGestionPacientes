package vista;

import javax.swing.*;
import java.awt.*;
import modelo.BaseDatosSimulada;
import modelo.Entrega;

public class InterfazVerificarReceta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtIdReceta;
    private JTextArea areaResultado;
    private JFrame ventanaAnterior;

    public InterfazVerificarReceta(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Verificar Receta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        getContentPane().setLayout(null);

        JLabel lblIdReceta = new JLabel("ID de Receta:");
        lblIdReceta.setBounds(50, 70, 100, 25);
        getContentPane().add(lblIdReceta);

        txtIdReceta = new JTextField();
        txtIdReceta.setBounds(160, 70, 200, 25);
        getContentPane().add(txtIdReceta);

        JButton btnVerificar = new JButton("Verificar receta");
        btnVerificar.setBounds(180, 110, 150, 30);
        getContentPane().add(btnVerificar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(362, 220, 100, 30);
        getContentPane().add(btnVolver);
        
        JPanel bg4 = new JPanel();
        bg4.setLayout(null);
        bg4.setBackground(SystemColor.textHighlight);
        bg4.setBounds(0, 0, 484, 45);
        getContentPane().add(bg4);
        
                JLabel lblTitulo = new JLabel("Verificar si la receta fue utilizada");
                lblTitulo.setForeground(SystemColor.text);
                lblTitulo.setBounds(86, 11, 350, 30);
                bg4.add(lblTitulo);
                lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
                
                        areaResultado = new JTextArea();
                        areaResultado.setBounds(52, 151, 378, 45);
                        getContentPane().add(areaResultado);
                        areaResultado.setEditable(false);
                        areaResultado.setLineWrap(true);

        btnVerificar.addActionListener(e -> verificarReceta());
        btnVolver.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });
    }

    private void verificarReceta() {
        String idRecetaIngresada = txtIdReceta.getText().trim();

        if (idRecetaIngresada.isEmpty()) {
            areaResultado.setText("Ingrese un ID de receta.");
            return;
        }

        boolean encontrada = false;
        boolean utilizada = false;
        Entrega entregaEncontrada = null;

        for (Entrega ent : BaseDatosSimulada.getListaEntregas()) {
            if (String.valueOf(ent.getIdEntrega()).equals(idRecetaIngresada)) {
                encontrada = true;
                entregaEncontrada = ent;
                // Suponemos aquí que Entrega tiene un método isRecetaUtilizada
                // Para este ejemplo, lo simularemos así:
                utilizada = ent.isRecetaUtilizada();
                break;
            }
        }

        if (!encontrada) {
            areaResultado.setText("No existe ninguna receta con ese ID.");
        } else {
            if (utilizada) {
                areaResultado.setText(" La receta ID " + idRecetaIngresada + " ya fue utilizada.");
            } else {
                areaResultado.setText(" La receta ID " + idRecetaIngresada + " está disponible.\n"
                        + "Paciente: " + entregaEncontrada.getPaciente().getNombre() + " "
                        + entregaEncontrada.getPaciente().getApellidoPaterno());
            }
        }
    }
}
