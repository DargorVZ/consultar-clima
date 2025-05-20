package com.dargorvz.clima;

import java.util.Scanner;

public class ClimaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClimaApi buscarCiudad = new ClimaApi();

        System.out.println("************************************************");
        System.out.println("🌦 Bienvenido/a al Consultor del Clima");

        boolean menu = true;
        while (menu) {
            System.out.println("\nIngrese el nombre de una ciudad (o escriba 'salir' para terminar):");
            String ciudad = scanner.nextLine().trim();

            if (ciudad.equalsIgnoreCase("salir")) {
                menu = false;
                System.out.println("Gracias por usar la app del clima. ¡Hasta pronto!");
                continue;
            }

            try {
                Clima clima = buscarCiudad.obtenerClima(ciudad);
                System.out.println("\n🌍 Resultado:");
                System.out.println(clima);
            } catch (RuntimeException e) {
                System.out.println("⚠️ Ocurrió un error: " + e.getMessage() + "\n");
            }
        }

        scanner.close();
    }
}
