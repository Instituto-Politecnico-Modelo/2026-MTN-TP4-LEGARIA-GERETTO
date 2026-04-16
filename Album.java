public class Album {
    private String nombre;
    private int anio;

    public Album(String nombre, int anio) {
        this.nombre = nombre;
        this.anio = anio;
    }

    // Retorna el nombre del album
    public String getNombre() {
        return nombre;
    }

    // Retorna el anio del album
    public int getAnio() {
        return anio;
    }
}
