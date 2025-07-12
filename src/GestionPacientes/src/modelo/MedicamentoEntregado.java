package modelo;

import java.awt.List;

public class MedicamentoEntregado {
    private int idMedicamento;
    private String nombreMedicamento;
    private int cantidad;

    public MedicamentoEntregado(int idMedicamento, String nombreMedicamento, int cantidad) {
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.cantidad = cantidad;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

}
