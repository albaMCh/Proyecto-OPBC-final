package Ej7;

import java.util.List;

public interface CandidatosList {

    boolean guardarCandidato (Candidato candidato);

    Boolean borrarCandidatoPorEmail (String email);

    Boolean borrarCandidatoPorNombre (String nombre);

    List<Candidato> filtrarPorCiudad(String ciudad);

    List<Candidato> filtrarPorPresencialidad(String presencialidad);

    List<Candidato> filtrarPorTipoTraslado(boolean tipoTraslado);

    List<Candidato> filtrar(String ciudad, String presencialidad, boolean tipoTraslado);

    Candidato buscarEmail(String email);

    Candidato buscarTelefono(String telefono);

    void imprimeCiudadesTOP ();

    void imprimePaisesTOP ();

    int totalRemotos ();

    int totalPresencial ();

}
