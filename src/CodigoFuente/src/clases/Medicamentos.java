package clases;

public class Medicamentos {
    private int ID;
    private String Nombre;
    private int Stock;
    private boolean AlertaStock;
    
    public Medicamentos(int ID, String nombre, int stock, boolean alertaStock) {
        this.ID = ID;
        this.Nombre = nombre;
        this.Stock = stock;
        this.AlertaStock = alertaStock;
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public boolean isAlertaStock() {
		return AlertaStock;
	}

	public void setAlertaStock(boolean alertaStock) {
		AlertaStock = alertaStock;
	}
    
}