package herramientas;
import javax.swing.*;
import java.awt.*;

public class UtilidadesImagen {
	// Método reutilizable para cargar y escalar imágenes 
	
	public static ImageIcon cargarImagenEscalada(String ruta, int ancho, int alto) {
        ImageIcon original = new ImageIcon(UtilidadesImagen.class.getResource(ruta));
        Image escalada = original.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }
}
