public enum Icono {
    MUSICAL_NOTE("🎵"),
    ROCKET("🚀"),
    FIRE("🔥");

    private final String texto;

    Icono(String texto) {
        this.texto = texto;
    }

    public String texto() {
        return texto;
    }
}
