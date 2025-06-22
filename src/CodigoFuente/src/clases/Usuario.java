package clases;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int ID;
    private String UserName;
    private String Password;
    private Rol rol;
    private boolean activo;
    private static int count;
    private static List<Usuario> Usuarios = new ArrayList<>();
    public Usuario(String userName, String password, Rol rol, boolean activo) {
    	this.ID = count++;
        this.UserName = userName;
        this.Password = password;
        this.rol = rol;
        this.activo = activo;
        registrarUsuario();
    }
    
    private void registrarUsuario() {
        synchronized (Usuarios) {
            Usuarios.add(this);
        }
    }
	public static List<Usuario> getUsuarios() {
		return Usuarios;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		Usuarios = usuarios;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
}