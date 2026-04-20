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
        if (cancion.getDislikes() >= 5000 || cancion.getReproduccionesTotales() < 1000) {
            cancion.cambiarPopularidad(new Normal());
        } else if (cancion.getReproduccionesTotales() > 50000 && cancion.getLikes() > 20000) {
            cancion.cambiarPopularidad(new Tendencia());
        }
    }

    public void verificarInactividad(Cancion cancion) {
        // En Auge, no se realiza acción por inactividad
    }
}
