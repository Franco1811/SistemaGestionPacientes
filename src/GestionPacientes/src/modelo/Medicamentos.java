package modelo;

public class Medicamentos {
    private int ID;
    private String Nombre;
    private int Stock;
    private boolean AlertaStock;
    private double Precio;

    
	public Medicamentos(int iD, String nombre, int stock ,boolean alertaStock, double precio) {
		super();
		ID = iD;
		Nombre = nombre;
		Stock = stock;
		AlertaStock = alertaStock;
		Precio = precio;
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
	
	public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }
	
    

}
