package Ej7;

import Ej2.funciones;

import java.util.Locale;
import java.util.Scanner;

public class main {

    private static String banner = "          _____                    _____                    _____                   _______                   _____          \n" +
            "         /\\    \\                  /\\    \\                  /\\    \\                 /::\\    \\                 /\\    \\         \n" +
            "        /::\\    \\                /::\\    \\                /::\\    \\               /::::\\    \\               /::\\    \\        \n" +
            "       /::::\\    \\              /::::\\    \\               \\:::\\    \\             /::::::\\    \\             /::::\\    \\       \n" +
            "      /::::::\\    \\            /::::::\\    \\               \\:::\\    \\           /::::::::\\    \\           /::::::\\    \\      \n" +
            "     /:::/\\:::\\    \\          /:::/\\:::\\    \\               \\:::\\    \\         /:::/~~\\:::\\    \\         /:::/\\:::\\    \\     \n" +
            "    /:::/__\\:::\\    \\        /:::/  \\:::\\    \\               \\:::\\    \\       /:::/    \\:::\\    \\       /:::/__\\:::\\    \\    \n" +
            "   /::::\\   \\:::\\    \\      /:::/    \\:::\\    \\              /::::\\    \\     /:::/    / \\:::\\    \\      \\:::\\   \\:::\\    \\   \n" +
            "  /::::::\\   \\:::\\    \\    /:::/    / \\:::\\    \\    ____    /::::::\\    \\   /:::/____/   \\:::\\____\\   ___\\:::\\   \\:::\\    \\  \n" +
            " /:::/\\:::\\   \\:::\\    \\  /:::/    /   \\:::\\ ___\\  /\\   \\  /:::/\\:::\\    \\ |:::|    |     |:::|    | /\\   \\:::\\   \\:::\\    \\ \n" +
            "/:::/  \\:::\\   \\::: \\____\\/:::/____/     \\:::|    |/::\\   \\/:::/  \\:::\\____\\|:::|____|     |:::|    |/::\\   \\:::\\   \\:::\\____\\\n" +
            "\\::/    \\:::\\  /:::/    /\\:::\\    \\     /:::|____|\\:::\\  /:::/    \\::/    / \\:::\\    \\   /:::/    / \\:::\\   \\:::\\   \\::/    /\n" +
            " \\/____/ \\:::\\/:::/    /  \\:::\\    \\   /:::/    /  \\:::\\/:::/    / \\/____/   \\:::\\    \\ /:::/    /   \\:::\\   \\:::\\   \\/____/ \n" +
            "          \\::::::/    /    \\:::\\    \\ /:::/    /    \\::::::/    /             \\:::\\    /:::/    /     \\:::\\   \\:::\\    \\     \n" +
            "           \\::::/    /      \\:::\\    /:::/    /      \\::::/____/               \\:::\\__/:::/    /       \\:::\\   \\:::\\____\\    \n" +
            "           /:::/    /        \\:::\\  /:::/    /        \\:::\\    \\                \\::::::::/    /         \\:::\\  /:::/    /    \n" +
            "          /:::/    /          \\:::\\/:::/    /          \\:::\\    \\                \\::::::/    /           \\:::\\/:::/    /     \n" +
            "         /:::/    /            \\::::::/    /            \\:::\\    \\                \\::::/    /             \\::::::/    /      \n" +
            "        /:::/    /              \\::::/    /              \\:::\\____\\                \\::/____/               \\::::/    /       \n" +
            "        \\::/    /                \\::/____/                \\::/    /                 ~~                      \\::/    /        \n" +
            "         \\/____/                  ~~                       \\/____/                                           \\/____/         \n" +
            "                                                                                                                             ";

    private static String banner2 = "               ___           ___           ___       ___     \n" +
            "              /\\__\\         /\\  \\         /\\__\\     /\\  \\    \n" +
            "             /:/  /        /::\\  \\       /:/  /    /::\\  \\   \n" +
            "            /:/__/        /:/\\:\\  \\     /:/  /    /:/\\:\\  \\  \n" +
            "           /::\\  \\ ___   /:/  \\:\\  \\   /:/  /    /::\\~\\:\\  \\ \n" +
            "          /:/\\:\\  /\\__\\ /:/__/ \\:\\__\\ /:/__/    /:/\\:\\ \\:\\__\\\n" +
            "          \\/__\\:\\/:/  / \\:\\  \\ /:/  / \\:\\  \\    \\/__\\:\\/:/  /\n" +
            "               \\::/  /   \\:\\  /:/  /   \\:\\  \\        \\::/  / \n" +
            "               /:/  /     \\:\\/:/  /     \\:\\  \\       /:/  /  \n" +
            "              /:/  /       \\::/  /       \\:\\__\\     /:/  /   \n" +
            "              \\/__/         \\/__/         \\/__/     \\/__/    ";

    public static void menu(){

        System.out.println("<<<<<<<<<<====================>>>>>>>>>");
        System.out.println("1 - Registrar candidato");
        System.out.println("2 - Borrar Candidato");
        System.out.println("3 - Buscar candidato por ciudad");
        System.out.println("4- Buscar candidato por presencialidad");
        System.out.println("5 - Buscar candidato por traslado");
        System.out.println("6 - Buscar candidato por ciudad, traslado y preencialidad");
        System.out.println("7 - Buscar candidato por email");
        System.out.println("8 - Buscar candidato por teléfono");
        System.out.println("9 - salir");
        System.out.println("<<<<<<<<<<====================>>>>>>>>>");
    }

    public static void main(String[] args) {

        funciones funciones = new funciones();
        Scanner input = new Scanner(System.in);
        int op1 = 0, op2 = 0;

        while(op1 != 4){

            menu();
            op1 = input.nextInt();

            switch (op1){

                //Registrar usuario
                case 1:

                    while (op2 != 2){

                        String  nombre ="", ciudad = "", presencialidad = "", email = "", telefono = "", pais = "";
                        boolean tipoTraslado = false;

                        System.out.flush();
                        System.out.println("Nuevo registro");
                        System.out.println("Introduce noombre: ");
                        nombre = input.next();
                        input.nextLine();
                        System.out.println("Introduce email:");
                        email = input.next();
                        input.nextLine();
                        System.out.println("Introduce teléfono:");
                        telefono = input.next();
                        input.nextLine();
                        System.out.println("Introduce país:");
                        pais = input.next();
                        input.nextLine();
                        System.out.println("Introduce ciudad:");
                        ciudad = input.next();
                        input.nextLine();
                        System.out.println("Introduce presencialidad:");
                        presencialidad = input.next();
                        input.nextLine();
                        System.out.println("Posiblidad de traslado S/N:");
                        String op3 = input.next();
                        input.nextLine();
                        op3 = op3.toLowerCase();

                        if(op3.contains("s")){

                            tipoTraslado = true;
                        }

                        if (funciones.register(email, password)){

                            System.out.println("Usuario guardado: " + email);
                        }

                        System.out.println("¿Desea introducir más alumnos? 1 = SI | 2 = NO");
                        op2 = input.nextInt();
                    }

                    break;

                //Login
                case 2:

                    String email = "", password ="";

                    System.out.flush();
                    System.out.println("Introduce Email: ");
                    email = input.next();
                    input.nextLine();
                    System.out.println("Introduce Contraseña:");
                    password = input.next();

                    switch (funciones.login(email, password)){

                        case -1:

                            System.err.println("Email: " + email + ",  email no existe");
                            System.out.flush();

                            break;
                        case -2:

                            System.err.println("Contraseña incorrecta");
                            System.out.flush();

                            break;
                        case 1:

                            banner2 = banner2.replace(':','X');
                            System.out.println(banner2);
                            break;
                        case 0:

                            System.out.println("Internal error");
                            break;
                    }

                    break;
                //Mostrar usuarios
                case 3:

                    System.out.flush();
                    funciones.mostrarUsuarios();
                    System.out.println();

                    break;
                //Salir
                case 4:

                    banner = banner.replace(':','X');
                    System.out.println(banner);

                    break;
                default:

                    System.out.flush();
                    break;
            }
        }

        input.close();
    }
}
