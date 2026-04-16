// Estado Normal: estado inicial de una cancion
public class Normal extends Popularidad {

    private int reproducciones = 0;

    // Icono: nota musical
    public Icono getIcono() {
        return Icono.NOTA_MUSICAL;
    }

    // Formato: "Artista - Album - Titulo"
    public String getLeyenda(Cancion cancion) {
        return cancion.getArtista().getNombre() + " - "
             + cancion.getAlbum().getNombre() + " - "
             + cancion.getTitulo();
    }

    // Si supera 1000 reproducciones, pasa a Auge
    public void reproducir(Cancion cancion) {
        reproducciones++;
        if (reproducciones > 1000) {
            cancion.setPopularidad(new Auge());
        }
    }

    // En estado Normal, dar like no produce cambio de estado
    public void darLike(Cancion cancion) {
        // no hace nada en este estado
    }

    // En estado Normal, dar dislike no produce cambio de estado
    public void darDislike(Cancion cancion) {
        // no hace nada en este estado
    }

    // En estado Normal, no importa si pasan 24hs sin reproduccion
    public void pasaron24HsSinReproduccion(Cancion cancion) {
        // no hace nada en este estado
    }
}
