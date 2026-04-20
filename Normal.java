public class Normal extends Popularidad {

    public Icono getIcono() {
        return Icono.MUSICAL_NOTE;
    }

    public String getLeyenda(Cancion cancion) {
        return cancion.getArtista().getNombre() + " - "
             + cancion.getAlbum().getNombre() + " - "
             + cancion.getTitulo();
    }

    public void reproducir(Cancion cancion) {
        if (cancion.getReproduccionesTotales() > 1000) {
            cancion.cambiarPopularidad(new Auge());
        }
    }

    public void verificarInactividad(Cancion cancion) {
        // En estado Normal, no se realiza acción por inactividad
    }
}
