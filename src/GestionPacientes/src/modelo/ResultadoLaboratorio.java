package modelo;
import java.time.LocalDate;
public class ResultadoLaboratorio {
	private String idPaciente;
    private String tipo;
    private double valor;
    private double minimo;
    private double maximo;
    private LocalDate fecha;

    public ResultadoLaboratorio(String idPaciente, String tipo, double valor, double minimo, double maximo, LocalDate fecha) {
        this.idPaciente = idPaciente;
        this.tipo = tipo;
        this.valor = valor;
        this.minimo = minimo;
        this.maximo = maximo;
        this.fecha = fecha;
    }
    
    public ResultadoLaboratorio(String tipo, double valor, double minimo, double maximo, LocalDate fecha) {
      
        this.tipo = tipo;
        this.valor = valor;
        this.minimo = minimo;
        this.maximo = maximo;
        this.fecha = fecha;
    }
    public String getIdPaciente() { return idPaciente; }
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public double getMinimo() { return minimo; }
    public double getMaximo() { return maximo; }
    public LocalDate getFecha() { return fecha; }

    public boolean esCritico() {
        return valor < minimo || valor > maximo;
    }

    @Override
    public String toString() {
        return fecha + " - " + tipo + ": " + valor + " (Rango: " + minimo + " - " + maximo + ")";
    }
}
