package vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import herramientas.UtilidadesImagen;




public class InterfazMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public InterfazMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
        setTitle("Programa de hospital");
        setLocationRelativeTo(null);
        setResizable(false);
        // Inicializar componentes de la interfaz
        iniciarComponentes();

	}
    private void iniciarComponentes() {
        // Configuración del panel principal
        setBounds(100, 100, 702, 432);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLayeredPane bg = new JLayeredPane();
        bg.setBackground(new Color(0, 191, 255));
        bg.setBounds(0, 0, 686, 393);
        contentPane.add(bg);
        
     // Imagen 1 (logo principal - fondo)
        JLabel lblLogo = new JLabel();
        lblLogo.setBounds(363, 0, 323, 393);
        lblLogo.setIcon(UtilidadesImagen.cargarImagenEscalada("/imagenes/3.png", 323, 393));
        bg.add(lblLogo, JLayeredPane.DEFAULT_LAYER); // fondo
        

     // Imagen 2 (logo Minsa)
        JLabel lblMinsa = new JLabel();
        lblMinsa.setBounds(0, 341, 141, 52);
        lblMinsa.setIcon(UtilidadesImagen.cargarImagenEscalada("/imagenes/ministerio de salud.png", 141, 52));
        bg.add(lblMinsa, JLayeredPane.PALETTE_LAYER); // por encima
        
     // Imagen 3 (logo Perú Primero - superpuesta encima de lblLogo)
        JLabel lblPeruPrim = new JLabel();
        lblPeruPrim.setBounds(586, 343, 100, 50); // posición sobre el logo
        lblPeruPrim.setIcon(UtilidadesImagen.cargarImagenEscalada("/imagenes/PeruPrimero.png", 100, 50));
        bg.add(lblPeruPrim, JLayeredPane.PALETTE_LAYER); // encima del logo
        
        JLabel lblBienvenido = new JLabel("BIENVENIDO");
        lblBienvenido.setFont(new Font("Tahoma", Font.ITALIC, 32));
        lblBienvenido.setBounds(70, 37, 308, 52);
        bg.add(lblBienvenido);
        
        JLabel lblOpcionessesion = new JLabel("Opcciones de inicio de sesión ");
        lblOpcionessesion.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblOpcionessesion.setBounds(10, 117, 254, 32);
        bg.add(lblOpcionessesion);
        
        
        // BOTON PACIENTE
     // BOTON PACIENTE
        JButton btnPaciente = new JButton("Paciente");
        btnPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	InterfazPaciente ventanaPaciente = new InterfazPaciente(InterfazMain.this);
                ventanaPaciente.setVisible(true);
                dispose(); // Esto cierra la ventana actual si lo deseas
                
            }
        });
        btnPaciente.setFont(new Font("Tahoma", Font.ITALIC, 13));
        btnPaciente.setBounds(102, 177, 130, 45);
        bg.add(btnPaciente);
        
        
        // BOTON PERSONAL DEL HOSPITAL
        JButton btnPersonal = new JButton("Personal");
        btnPersonal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfazLoginEmpleado login = new InterfazLoginEmpleado(InterfazMain.this);
                login.limpiarCampos();
                login.setVisible(true);
                dispose();
            }
        });
        btnPersonal.setFont(new Font("Tahoma", Font.ITALIC, 13));
        btnPersonal.setBounds(102, 233, 130, 45);
        bg.add(btnPersonal);
        
        // Imagen 4 (logo paciente)
        JLabel lblPaciente = new JLabel("");
        lblPaciente.setBounds(22, 175, 70, 50);
        lblPaciente.setIcon(UtilidadesImagen.cargarImagenEscalada("/imagenes/paciente.png", 70, 50));
        bg.add(lblPaciente, JLayeredPane.PALETTE_LAYER);
        
        // Imagen 5 (logo personal)
        JLabel lblPersonal = new JLabel("");
        lblPersonal.setBounds(22, 231, 70, 50);
        lblPersonal.setIcon(UtilidadesImagen.cargarImagenEscalada("/imagenes/personal.png", 70, 50));
        bg.add(lblPersonal, JLayeredPane.PALETTE_LAYER);

        
        setVisible(true);
        
        
    }
    
   

    public static void main(String[] args) {
    	new InterfazMain();
 
    }

}
