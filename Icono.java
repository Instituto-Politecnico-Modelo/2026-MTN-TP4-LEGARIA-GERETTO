public class Icono {
    public static Icono NOTA_MUSICAL = new Icono(new int[]{0xD83C, 0xDFB5});
    public static Icono COHETE = new Icono(new int[]{0xD83D, 0xDE80});
    public static Icono FUEGO = new Icono(new int[]{0xD83D, 0xDD25});

    private int[] codificacion;

    Icono(int[] codificacion) {
        this.codificacion = codificacion;
    }

    // Convierte la codificacion interna a texto (emoji)
    public String texto() {
        return new String(codificacion, 0, codificacion.length);
    }
}
