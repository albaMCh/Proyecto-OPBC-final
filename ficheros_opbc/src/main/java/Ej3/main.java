package Ej3;

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
            "/:::/  \\:::\\   \\:::\\____\\/:::/____/     \\:::|    |/::\\   \\/:::/  \\:::\\____\\|:::|____|     |:::|    |/::\\   \\:::\\   \\:::\\____\\\n" +
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
        System.out.println("1 - Registrar usuario");
        System.out.println("2 - Login");
        System.out.println("3 - Mostrar usuarios");
        System.out.println("4 - salir");
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

                        String email = "", password = "";

                        System.out.flush();
                        System.out.println("Nuevo registro");
                        System.out.println("Introduce Email: ");
                        email = input.next();
                        input.nextLine();
                        System.out.println("Introduce Contraseña:");
                        password = input.next();
                        input.nextLine();

                        if (funciones.register(email, password)){

                            System.out.println("Usuario guardado: " + email);
                        }

                        System.out.println("¿Desea introducir más alumnos? 1 = SI | 2 = NO");
                        op2 = input.nextInt();

                        email = "";
                        password = "";
                    }

                    op2 = 0;

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
                    input.nextLine();

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
                    System.exit(0);

                    break;
                default:

                    System.out.flush();
                    break;
            }

            op1 = 0;
        }

        input.close();
    }
}
