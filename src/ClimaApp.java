import java.util.Scanner;

public class ClimaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClimaApi buscarCiudad = new ClimaApi();

        System.out.println("************************************************");
        System.out.println("Ingrese a continuación su ciudad:");
        String ciudad = scanner.nextLine();

        try{
            Clima clima = buscarCiudad.obtenerClima(ciudad);
            System.out.println(clima.toString());
        } catch (RuntimeException e){
            System.out.println("Ocurrio un error: " + e.getMessage() + "/n");
        }
    }
}
