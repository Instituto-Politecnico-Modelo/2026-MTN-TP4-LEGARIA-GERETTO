public class Auge extends Popularidad {

    private int reproducciones = 0;
    private int likes = 0;
    private int dislikes = 0;

    public Icono getIcono() {
        return Icono.ROCKET;
    }

    public String getLeyenda(Cancion cancion) {
        return cancion.getArtista().getNombre() + " - "
             + cancion.getTitulo() + " ("
             + cancion.getAlbum().getNombre() + " - "
             + cancion.getAlbum().getAnio() + ")";
    }

    public void reproducir(Cancion cancion) {
        reproducciones++;
        verificarCambioATendencia(cancion);
    }

    public void darLike(Cancion cancion) {
        likes++;
        verificarCambioATendencia(cancion);
    }

    public void darDislike(Cancion cancion) {
        dislikes++;
        if (dislikes >= 5000) {
            cancion.cambiarPopularidad(new Normal());
        }
    }

    public void verificarInactividad(Cancion cancion) {
    }

    private void verificarCambioATendencia(Cancion cancion) {
        if (reproducciones > 50000 && likes > 20000) {
            cancion.cambiarPopularidad(new Tendencia());
        }
    }
}
