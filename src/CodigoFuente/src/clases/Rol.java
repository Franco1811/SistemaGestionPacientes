package clases;

public class Rol {
    private int ID;
    private String Nombre;
    
    public Rol(int ID, String nombre) {
        this.ID = ID;
        this.Nombre = nombre;
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
    
}