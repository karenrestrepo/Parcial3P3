package co.edu.uniquindio.preparcial3.parcial3.ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class AppCliente {
    private String host;
    private int puerto;
    private Socket socketComunicacion;
    ObjectInputStream flujoEntradaObjeto;

    public AppCliente(String host, int puerto) {
        this.puerto = puerto;
        this.host = host;
    }

    public void iniciarCliente() {
        try {
            crearConexion();

            flujoEntradaObjeto = new ObjectInputStream(socketComunicacion.getInputStream());

            recibirObjeto();
            recibirConfirmacion();


            flujoEntradaObjeto.close();
            socketComunicacion.close();



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    private void recibirObjeto() throws ClassNotFoundException, IOException {

        Estacion estacion = (Estacion) flujoEntradaObjeto.readObject();

        for (Registro registro : estacion.getListaRegistros()) {
            System.out.println("Identificación cliente: "+registro.getIdentificacionCliente()+ " Tipo vehículo: "+registro.getTipoVehiculo()+ " Galones: "+registro.getGalones()+ " Fecha y hora: "+registro.getFechaHora());
        }

    }

    private void recibirConfirmacion() throws IOException {
        String confirmacion = flujoEntradaObjeto.readUTF();
        System.out.println("Respuesta del servidor: " + confirmacion);
    }

    private void crearConexion() throws IOException {
        socketComunicacion = new Socket(host, puerto);
    }
}
