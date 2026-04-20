public class Auge extends Popularidad {

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
        reproduccionesAux++;
        if (cancion.getDislikes() >= 5000 || reproduccionesAux < 1000) {
            cancion.cambiarPopularidad(new Normal());
        } else if (reproduccionesAux > 50000 && cancion.getLikes() > 20000) {
            cancion.cambiarPopularidad(new Tendencia());
        }
    }
}
