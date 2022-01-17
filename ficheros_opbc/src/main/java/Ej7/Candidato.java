package Ej7;

public class Candidato {

    private String nombre;
    private String ciudad;
    private String presencialidad;
    private boolean tipoTraslado;
    private String email;
    private String telefono;
    private String pais;

    public Candidato(String nombre, String ciudad, String presencialidad, boolean tipoTraslado, String email, String telefono, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.presencialidad = presencialidad;
        this.tipoTraslado = tipoTraslado;
        this.email = email;
        this.telefono = telefono;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPresencialidad() {
        return presencialidad;
    }

    public void setPresencialidad(String presencialidad) {
        this.presencialidad = presencialidad;
    }

    public boolean isTipoTraslado() {
        return tipoTraslado;
    }

    public void setTipoTraslado(boolean tipoTraslado) {
        this.tipoTraslado = tipoTraslado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", presencialidad='" + presencialidad + '\'' +
                ", tipoTraslado=" + tipoTraslado +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
