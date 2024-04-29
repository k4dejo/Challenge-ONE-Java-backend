import com.alura.conversor.modelos.Pair;
import com.alura.conversor.modelos.PairExchangeRate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {


    public static class ConversorMonedas {

        public static void main(String[] args) throws IOException, InterruptedException {
            mostrarMenu();
        }
    }



    private static void mostrarMenu() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Imprimir el menú
            System.out.println("\n**Menú de Conversión de Monedas**");
            System.out.println("1. Dólar a Euro");
            System.out.println("2. Dólar a Real Brasileño");
            System.out.println("3. Dólar a Peso Argentino");
            System.out.println("4. Real Brasileño a Dólar");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Obtener la opción del usuario
            opcion = scanner.nextInt();

            // Validar la opción
            switch (opcion) {
                case 1:
                    System.out.println("Dólar a Euro");
                    System.out.print("Ingrese la cantidad de dólares: ");
                    double usd = scanner.nextDouble();
                    System.out.println(convertAtoB("USD", "EUR", usd));
                    continue;
                case 2:
                    System.out.println("Dólar a Real Brasileño");
                    System.out.print("Ingrese la cantidad de/Dklares: ");
                    double brl = scanner.nextDouble();
                    System.out.println(convertAtoB("USD", "BRL", brl));
                    continue;
                case 3:
                    System.out.println("Dólar a Peso Argentino");
                    System.out.print("Ingrese la cantidad de/Dklares: ");
                    double ars = scanner.nextDouble();
                    System.out.println(convertAtoB("USD", "ARS", ars));
                    continue;
                case 4:
                    System.out.println("Real Brasileño a Dólar");
                    System.out.print("Ingrese la cantidad de Reales: ");
                    double real = scanner.nextDouble();
                    System.out.println(convertAtoB("BRL", "USD", real));
                    continue;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion < 1 || opcion > 5); // Bucle para repetir el menú
    }

    private static String convertAtoB(String CoinA, String CoinB, double amount) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/fefb38155edd24cfd9418598/pair/" + CoinA + "/" + CoinB + "/" + amount))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gsonTest = new Gson();
        Pair myPair = gsonTest.fromJson(json, Pair.class);
        return amount+" "+CoinA+" son "+myPair.getConversionResult()+" "+CoinB;
    }

}

