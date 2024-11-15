package co.edu.uniquindio.preparcial3.parcial3.ejercicio2;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro implements Serializable {
    private String identificacionCliente;
    private String tipoVehiculo;
    private double galones;
    private String fechaHora;

    public Registro(String identificacionCliente, String tipoVehiculo, double galones) {
        this.identificacionCliente = identificacionCliente;
        this.tipoVehiculo = tipoVehiculo;
        this.galones = galones;
        this.fechaHora = fechaHora;
    }

    public Registro(){}

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getGalones() {
        return galones;
    }

    public void setGalones(double galones) {
        this.galones = galones;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "identificacionCliente='" + identificacionCliente + '\'' +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", galones=" + galones +
                ", fechaHora=" + fechaHora +
                '}';
    }

    public String toFileString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s,%s,%.2f,%s%n",
                identificacionCliente,
                tipoVehiculo,
                galones,
                fechaHora);
    }
}
