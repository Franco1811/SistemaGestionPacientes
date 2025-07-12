package modelo;

public abstract class Persona {
    protected int ID;
    protected String DNI;
    protected String Nombre;
    protected String ApellidoPaterno;
    protected String ApellidoMaterno;
    protected int Edad;
    protected String Sexo;
    protected Usuario Usuario;
    protected Rol Rol;

    public Persona() {
    }

    public Persona(int ID, String DNI, String Nombre, String ApellidoPaterno,
                   String ApellidoMaterno, int Edad, String Sexo,
                   Usuario usuario) {
        this.ID = ID;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Usuario = usuario;
    }

    public Persona(int ID, String DNI, String Nombre, String ApellidoPaterno,
                   String ApellidoMaterno, int Edad, String Sexo,
                   Usuario usuario, Rol rol) {
        this.ID = ID;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Usuario = usuario;
        this.Rol = rol;
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Rol getRol() {
		return Rol;
	}

	public void setRol(Rol rol) {
		Rol = rol;
	}
    



}

