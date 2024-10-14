package desafio.converorDeMonedas.calculos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaDeMonedas {
    private final ConversorDeMonedas conversorDeMonedas=new ConversorDeMonedas();


    public void menu(){
        System.out.println("***********************************************");
        System.out.println("*** Sea bienvenido/a al Conversor de Monedas **");
        System.out.println("***********************************************");
        String menu="""
                1-Dólar <==> Bolívar
                2-Bolívar <==> Peso Colombiano
                3-Dólar <==> Peso Colombiano
                4-Real <==> Dólar
                7-Salir
                Elija una opción válida:
                """;
        System.out.println(menu);
    }

    public boolean eleccionMenu(int option, boolean exit, Scanner sc) {
        int selec;
        switch (option){
            case 1:
                System.out.println("1-Dólar==>Bolívar");
                System.out.println("2-Bolívar==>Dólar");
                selec= sc.nextInt();
                sc.nextLine();
                try{
                    conversorDeMonedas.conversor(selec, option, sc);
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción válida");
                }
                break;
            case 2:
                System.out.println("1-Bolívar==>Peso Colombiano");
                System.out.println("2-Peso Colombiano==>Bolívar");
                selec= sc.nextInt();
                sc.nextLine();
                try{
                    conversorDeMonedas.conversor(selec, option, sc);
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción válida");
                }
                break;
            case 3:
                System.out.println("1-Dólar==>Peso Colombiano");
                System.out.println("2-Peso Colombiano==>Dólar");
                selec= sc.nextInt();
                sc.nextLine();
                try{
                    conversorDeMonedas.conversor(selec, option, sc);
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción válida");
                }
                break;
            case 4:
                System.out.println("1-Real==>Dólar");
                System.out.println("2-Dólar==>Real");
                selec= sc.nextInt();
                sc.nextLine();
                try{
                    conversorDeMonedas.conversor(selec, option, sc);
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción válida");
                }
                break;
            case 7:
                System.out.println("Gracias por preferirnos, hasta luego");
                exit=false;
                break;
            default:
                System.out.println("Por favor ingrese una opción válida");
                break;
        }
        return exit;
    }
}