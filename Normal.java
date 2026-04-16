public class Normal extends Popularidad {

    private int reproducciones = 0;

    public Icono getIcono() {
        return Icono.MUSICAL_NOTE;
    }

    public String getLeyenda(Cancion cancion) {
        return cancion.getArtista().getNombre() + " - "
             + cancion.getAlbum().getNombre() + " - "
             + cancion.getTitulo();
    }

    public void reproducir(Cancion cancion) {
        reproducciones++;
        if (reproducciones > 1000) {
            cancion.cambiarPopularidad(new Auge());
        }
    }

    public void darLike(Cancion cancion) {
    }

    public void darDislike(Cancion cancion) {
    }

    public void verificarInactividad(Cancion cancion) {
    }
}
