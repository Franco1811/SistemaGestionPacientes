package modelo;
import java.util.Date;
import java.util.List;

public class EntradaHistorial {
    private int ID;
    private Date Fecha;
    private String Descripcion;
    private String ArchAdjunto;
    private List<String> Obs;
    
	public EntradaHistorial(int iD, Date fecha, String descripcion, String archAdjunto, List<String> obs) {
		super();
		ID = iD;
		Fecha = fecha;
		Descripcion = descripcion;
		ArchAdjunto = archAdjunto;
		Obs = obs;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getArchAdjunto() {
		return ArchAdjunto;
	}

	public void setArchAdjunto(String archAdjunto) {
		ArchAdjunto = archAdjunto;
	}

	public List<String> getObs() {
		return Obs;
	}

	public void setObs(List<String> obs) {
		Obs = obs;
	}
    
    
}
