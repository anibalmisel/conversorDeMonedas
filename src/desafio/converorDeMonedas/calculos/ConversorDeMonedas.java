package desafio.converorDeMonedas.calculos;

import com.google.gson.Gson;
import desafio.converorDeMonedas.modelos.Moneda;
import desafio.converorDeMonedas.modelos.MonedaExchanceRate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorDeMonedas {

    public void conversor(int indice, int option, Scanner sc){

        switch (option){
            case 1:
                if (indice == 1) {
                    System.out.println("Dolar a Bolivar");

                    conexionApi("USD", "VES",sc);
                } else if (indice==2) {
                    System.out.println("Bolívar a Dólar");
                    conexionApi("VES","USD", sc);
                }
                break;
            case 2:
                if (indice == 1) {
                    System.out.println("Bolivar a Peso Colombiano");
                    conexionApi("VES","COP", sc);
                } else if (indice==2) {
                    System.out.println("Peso Colombiano a Bolívar");
                    conexionApi("COP","VES", sc);
                }
                break;
            case 3:
                if (indice == 1) {
                    System.out.println("Dólar a Peso Colombiano");
                    conexionApi("USD","COP", sc);
                } else if (indice==2) {
                    System.out.println("Peso Colombiano a Dolar");
                    conexionApi("COP","USD", sc);
                }
                break;
            case 4:
                if (indice == 1) {
                    System.out.println("Real a Dólar");
                    conexionApi("BRL","USD", sc);
                } else if (indice==2) {
                    System.out.println("Dólar a Real");
                    conexionApi("USD","BRL", sc);
                }
                break;
        }
    }

    public void conexionApi(String monedaBase, String monedaDestino,Scanner sc){
        System.out.println("Escriba una cantidad a convertir:");
        double cantidad=sc.nextDouble();
        sc.nextLine();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/cdcad24b9504e0386ea2dbe8/pair/"+monedaBase+"/"+monedaDestino+"/"+cantidad))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json=response.body();
            //creo un objeto Gson;
            Gson gson=new Gson();
            //conecto el objeto Gson, al record
            MonedaExchanceRate miMonedaExchanceRate=gson.fromJson(json, MonedaExchanceRate.class);
            //conecto el record a mi clase Moneda
            Moneda moneda=new Moneda(miMonedaExchanceRate);
            String texto = String.format("%.2f %s, equivalen a : %.5f %s",cantidad, moneda.getNombreA(), moneda.getResultado(), moneda.getNombreB()); // Muestra 8 decimales
            System.out.println(texto);
        } catch (Exception e) {
            System.out.println("Por favor ingrese una opción válida.");
            sc.nextLine();  // Limpiar buffer de entrada en caso de error
        }
    }
}