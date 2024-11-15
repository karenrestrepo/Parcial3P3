package co.edu.uniquindio.preparcial3.parcial3.ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {
    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;

    Socket socketComunicacion;
    ObjectOutputStream flujoSalidaObjeto;
    String mensajeCliente;
    private GestorArchivos gestorArchivos;

    public AppServidor() {
        gestorArchivos = new GestorArchivos();
    }

    public void iniciarServidor() {
        try {
            server = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en puerto " + puerto);
            System.out.println("Registros actuales:");
            System.out.println(gestorArchivos.leerRegistros());


            System.out.println("Esperando cliente");
            socketComunicacion = server.accept();

            flujoSalidaObjeto = new ObjectOutputStream(socketComunicacion.getOutputStream());

            enviarObjeto();

            flujoSalidaObjeto.close();
            socketComunicacion.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void enviarObjeto() throws IOException {

        Estacion estacion = new Estacion();
        estacion.inicializar();
        System.out.println("Se envió el objeto estación: "+estacion.getNombre());
        gestorArchivos.guardarRegistro(estacion);

        flujoSalidaObjeto.writeObject(estacion);
    }



}
