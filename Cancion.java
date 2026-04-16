import java.time.LocalDateTime;

public class Cancion {
    private String titulo;
    private Artista artista;
    private Album album;
    private Popularidad popularidad;
    private LocalDateTime ultimaReproduccion;

    public Cancion(String titulo, Artista artista, Album album) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.popularidad = new Normal();
        this.ultimaReproduccion = LocalDateTime.now();
    }

    public void reproducir() {
        this.ultimaReproduccion = LocalDateTime.now();
        popularidad.reproducir(this);
    }

    public void darLike() {
        popularidad.darLike(this);
    }

    public void darDislike() {
        popularidad.darDislike(this);
    }

    public void verificarInactividad() {
        popularidad.verificarInactividad(this);
    }

    public String mostrarDetalle() {
        return popularidad.mostrarDetalle(this);
    }

    public void cambiarPopularidad(Popularidad nuevaPopularidad) {
        this.popularidad = nuevaPopularidad;
    }

    public Popularidad getPopularidad() {
        return popularidad;
    }

    public LocalDateTime getUltimaReproduccion() {
        return ultimaReproduccion;
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
