package Ej1;

public class usuario {

    private String nombre_completo;
    private String email;
    private String username;

    //Constructor

    public usuario (){

    }

    public usuario(String email, String nombre_completo, String username) {
        this.nombre_completo = nombre_completo;
        this.email = email;
        this.username = username;
    }

    //Getters and Setters


    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "nombre_completo='" + nombre_completo + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

