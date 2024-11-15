package co.edu.uniquindio.preparcial3.parcial3.ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;

public class Estacion implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String nombre;

    private ArrayList<Registro> listaRegistros = new ArrayList<Registro>();



    public Estacion() {
        // TODO Auto-generated constructor stub
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public ArrayList<Registro> getListaRegistros() {
        return listaRegistros;
    }



    public void setListaRegistros(ArrayList<Registro> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }



    public void inicializar() {

        setNombre("Estación de gasolina tres esquinas");

        Registro registro = new Registro();

        registro.setIdentificacionCliente("1005134065");
        registro.setTipoVehiculo("Carro");
        registro.setGalones(5);
        registro.setFechaHora("24-10-2024 12:30");

        getListaRegistros().add(registro);

        registro = new Registro();

        registro.setIdentificacionCliente("1005100065");
        registro.setTipoVehiculo("Camioneta");
        registro.setGalones(7);
        registro.setFechaHora("14-11-2024 16:32");

        getListaRegistros().add(registro);

        registro = new Registro();

        registro.setIdentificacionCliente("1105134565");
        registro.setTipoVehiculo("Moto");
        registro.setGalones(1.2);
        registro.setFechaHora("14-11-2024 20:30");

        getListaRegistros().add(registro);

    }





}
