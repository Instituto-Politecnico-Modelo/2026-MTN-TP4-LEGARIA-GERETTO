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
        reproduccionesAux++;
        if (reproduccionesAux > 1000) {
            cancion.cambiarPopularidad(new Auge());
        }
    }
}
