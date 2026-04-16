// Interfaz State: define el comportamiento comun para todos los estados de popularidad
public abstract class Popularidad {

    // Muestra el detalle de la cancion con formato: icono-leyenda
    public String mostrarDetalle(Cancion cancion) {
        return getIcono().texto() + "-" + getLeyenda(cancion);
    }

    // Cada estado define su propio icono
    public abstract Icono getIcono();

    // Cada estado define su propia leyenda con formato distinto
    public abstract String getLeyenda(Cancion cancion);

    // Cada estado decide si hay que cambiar de estado al reproducir
    public abstract void reproducir(Cancion cancion);

    // Cada estado decide si hay que cambiar de estado al dar like
    public abstract void darLike(Cancion cancion);

    // Cada estado decide si hay que cambiar de estado al dar dislike
    public abstract void darDislike(Cancion cancion);

    // Cada estado decide que pasa cuando pasan 24hs sin reproduccion
    public abstract void pasaron24HsSinReproduccion(Cancion cancion);
}
