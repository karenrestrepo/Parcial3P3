package co.edu.uniquindio.preparcial3.parcial3.ejercicio2;

public class MainCliente {
    public static void main(String[] args) {
        AppCliente appCliente = new AppCliente("localhost", 8081);
        System.out.println("Iniciando cliente de estación de gasolina\n");
        appCliente.iniciarCliente();
    }
}
