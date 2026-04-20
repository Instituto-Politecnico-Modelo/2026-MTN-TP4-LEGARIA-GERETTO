public abstract class Popularidad {

    protected int reproduccionesEnEstado;

    public String mostrarDetalle(Cancion cancion) {
        return getIcono().texto() + "-" + getLeyenda(cancion);
    }

    public abstract Icono getIcono();
    public abstract String getLeyenda(Cancion cancion);
    public abstract void reproducir(Cancion cancion);
    public abstract void verificarInactividad(Cancion cancion);
}
