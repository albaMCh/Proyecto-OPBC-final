package Ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ficheros {

    private List<usuario> listaUsuarios;
    private Integer num_linea;

    public ficheros() {

        listaUsuarios = new ArrayList<>();
        num_linea = 0;
    }

    public void LeerFicheroCSV(String filePath){

        try {

            String currentLine = "";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while((currentLine = reader.readLine()) != null){

                procesarLinea(currentLine);
                num_linea++;
            }

            mostrarUsuarios();

            System.out.println("Número de líneas procesadas: " + num_linea);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //funciones

    private void procesarLinea (String linea){

        linea = linea + ";";
        int cont_variable = 0;
        String correo = "", nombre = "", username = "", str_temp = "";
        char chr = 0;

        for(int i = 0; i < linea.length(); i ++){

            chr = linea.charAt(i);

            if(chr == 59){

                if(cont_variable == 0){

                    correo = str_temp;
                    cont_variable ++;
                    str_temp = "";
                }

                else if(cont_variable == 1){

                    nombre = str_temp;
                    cont_variable ++;
                    str_temp = "";
                }

                else if(cont_variable == 2){

                    username = str_temp;
                }
            }

            else{

                str_temp = str_temp + chr;
            }
        }



        if(validarVariable(nombre, "nombre") && validarVariable(username, "username") &&
           validarVariable(correo, "correo") && validarCorreo(correo)){

            listaUsuarios.add(new usuario(correo, nombre, username));
        }
    }

    private boolean validarVariable(String var, String nombre_var){

        if(var.isEmpty()){

            System.err.println("Error en la línea: " + num_linea + ", " + nombre_var + " vacio");
            return false;
        }

        return true;
    }

    private boolean validarCorreo (String correo) {

        if(correo.isEmpty()){

            return false;
        }

        for(usuario usuario : listaUsuarios) {

            if (usuario.getEmail().equals(correo)) {

                //si el correo esta repetido lanzamos el error
                System.err.println("Error en linea " + num_linea + ", correo repetido:  " + correo);

                return false;
            }
        }

        return true;
    }

    private void mostrarUsuarios(){

        for(usuario usuario : listaUsuarios){

            System.out.println(usuario.toString());
        }
    }
}
