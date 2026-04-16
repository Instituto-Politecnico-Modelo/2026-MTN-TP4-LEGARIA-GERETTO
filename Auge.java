// Estado Auge: la cancion supero las 1000 reproducciones en Normal
public class Auge extends Popularidad {

    private int reproducciones = 0;
    private int likes = 0;
    private int dislikes = 0;

    // Icono: cohete
    public Icono getIcono() {
        return Icono.COHETE;
    }

    // Formato: "Artista - Titulo (Album - anio)"
    public String getLeyenda(Cancion cancion) {
        return cancion.getArtista().getNombre() + " - "
             + cancion.getTitulo() + " ("
             + cancion.getAlbum().getNombre() + " - "
             + cancion.getAlbum().getAnio() + ")";
    }

    // Si supera 50000 reproducciones y tiene mas de 20000 likes, pasa a Tendencia
    public void reproducir(Cancion cancion) {
        reproducciones++;
        verificarCambioATendencia(cancion);
    }

    // Suma un like y verifica si pasa a Tendencia
    public void darLike(Cancion cancion) {
        likes++;
        verificarCambioATendencia(cancion);
    }

    // Si llega a 5000 dislikes, vuelve a Normal
    public void darDislike(Cancion cancion) {
        dislikes++;
        if (dislikes >= 5000) {
            cancion.setPopularidad(new Normal());
        }
    }

    // En estado Auge, no importa si pasan 24hs sin reproduccion
    public void pasaron24HsSinReproduccion(Cancion cancion) {
        // no hace nada en este estado
    }

    // Verifica si cumple las condiciones para pasar a Tendencia
    private void verificarCambioATendencia(Cancion cancion) {
        if (reproducciones > 50000 && likes > 20000) {
            cancion.setPopularidad(new Tendencia());
        }
    }
}
