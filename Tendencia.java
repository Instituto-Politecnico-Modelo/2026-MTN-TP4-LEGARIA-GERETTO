import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Tendencia extends Popularidad {

    public Icono getIcono() {
        return Icono.FIRE;
    }

    public String getLeyenda(Cancion cancion) {
        return cancion.getTitulo() + " - "
             + cancion.getArtista().getNombre() + " ("
             + cancion.getAlbum().getNombre() + " - "
             + cancion.getAlbum().getAnio() + ")";
    }

    public void reproducir(Cancion cancion) {
        reproduccionesAux++;
        int horasSinReproduccion = (int) ChronoUnit.HOURS.between(cancion.getUltimaReproduccion(), LocalDateTime.now());
        if (horasSinReproduccion >= 24) {
            cancion.cambiarPopularidad(new Normal());
        }
    }
}
