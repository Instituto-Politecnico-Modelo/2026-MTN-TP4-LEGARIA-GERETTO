// Contexto del patron State: la cancion delega el comportamiento a su estado de popularidad
public class Cancion {
    private String titulo;
    private Artista artista;
    private Album album;
    private Popularidad popularidad;

    public Cancion(String titulo, Artista artista, Album album) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.popularidad = new Normal(); // toda cancion arranca como Normal
    }

    // Delega la reproduccion al estado actual de popularidad
    public void reproducir() {
        popularidad.reproducir(this);
    }

    // Delega el like al estado actual
    public void darLike() {
        popularidad.darLike(this);
    }

    // Delega el dislike al estado actual
    public void darDislike() {
        popularidad.darDislike(this);
    }

    // Simula que pasaron 24hs sin reproduccion
    public void pasaron24HsSinReproduccion() {
        popularidad.pasaron24HsSinReproduccion(this);
    }

    // Muestra el detalle segun el estado actual: icono-leyenda
    public String mostrarDetalle() {
        return popularidad.mostrarDetalle(this);
    }

    // Cambia el estado de popularidad (usado por los estados para hacer transiciones)
    public void setPopularidad(Popularidad nuevaPopularidad) {
        this.popularidad = nuevaPopularidad;
    }

    // Retorna el estado actual de popularidad
    public Popularidad getPopularidad() {
        return popularidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public Album getAlbum() {
        return album;
    }
}
