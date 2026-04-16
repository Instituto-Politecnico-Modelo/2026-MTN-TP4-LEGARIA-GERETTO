// Estado Tendencia: la cancion es tendencia por record de reproducciones y likes
public class Tendencia extends Popularidad {

    // Icono: fuego
    public Icono getIcono() {
        return Icono.FUEGO;
    }

    // Formato: "Titulo - Artista (Album - anio)"
    public String getLeyenda(Cancion cancion) {
        return cancion.getTitulo() + " - "
             + cancion.getArtista().getNombre() + " ("
             + cancion.getAlbum().getNombre() + " - "
             + cancion.getAlbum().getAnio() + ")";
    }

    // En tendencia, reproducir no cambia de estado
    public void reproducir(Cancion cancion) {
        // no cambia de estado
    }

    // En tendencia, dar like no cambia de estado
    public void darLike(Cancion cancion) {
        // no cambia de estado
    }

    // En tendencia, dar dislike no cambia de estado
    public void darDislike(Cancion cancion) {
        // no cambia de estado
    }

    // Si pasan 24hs sin reproduccion, vuelve a Normal
    public void pasaron24HsSinReproduccion(Cancion cancion) {
        cancion.setPopularidad(new Normal());
    }
}
