import java.time.LocalDateTime;

public class Cancion {
    private String titulo;
    private Artista artista;
    private Album album;
    private Popularidad popularidad;
    private LocalDateTime ultimaReproduccion;
    private int reproduccionesTotales;
    private int likes;
    private int dislikes;

    public Cancion(String titulo, Artista artista, Album album) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.popularidad = new Normal();
        this.ultimaReproduccion = LocalDateTime.now();
        this.reproduccionesTotales = 0;
        this.likes = 0;
        this.dislikes = 0;
    }

    public void reproducir() {
        this.reproduccionesTotales++;
        popularidad.reproducir(this);
        this.ultimaReproduccion = LocalDateTime.now();
    }
    public int getReproduccionesTotales() {
        return reproduccionesTotales;
    }

    public void darLike() {
        this.likes++;
    }

    public void darDislike() {
        this.dislikes++;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
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
