import desafio.converorDeMonedas.calculos.ListaDeMonedas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //objetos
        Scanner leer = new Scanner(System.in);
        ListaDeMonedas lm=new ListaDeMonedas();
        //variables
        boolean exit=true;

        while (exit) {
            lm.menu();
            try {
                int option = leer.nextInt();
                leer.nextLine();  // Limpia el buffer del Scanner
                exit = lm.eleccionMenu(option, exit, leer);
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese una opción válida.");
                leer.nextLine();  // Limpiar buffer de entrada en caso de error
            }
            System.out.println(" ");
        }
        leer.close();
    }
}