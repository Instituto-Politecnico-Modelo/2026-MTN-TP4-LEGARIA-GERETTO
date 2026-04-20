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
        reproduccionesEnEstado++;
        if (cancion.getDislikes() >= 5000 || reproduccionesEnEstado < 1000) {
            cancion.cambiarPopularidad(new Normal());
        } else if (reproduccionesEnEstado > 50000 && cancion.getLikes() > 20000) {
            cancion.cambiarPopularidad(new Tendencia());
        }
    }

    public void verificarInactividad(Cancion cancion) {
        // En Auge, no se realiza acción por inactividad
    }
}
