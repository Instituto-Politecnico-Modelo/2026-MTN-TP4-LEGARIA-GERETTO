// Clase de prueba para verificar los casos pedidos
public class TestCancion {
    public static void main(String[] args) {
        Artista coldplay = new Artista("Coldplay");
        Album album = new Album("A Rush of Blood to the Head", 2002);
        Cancion cancion = new Cancion("The Scientist", coldplay, album);

        // Test 1: Cancion recien lanzada (popularidad Normal)
        System.out.println("=== Test 1: Cancion recien lanzada (Normal) ===");
        System.out.println("Estado: " + cancion.getPopularidad().getClass().getSimpleName());
        System.out.println("Detalle: " + cancion.mostrarDetalle());
        assert cancion.getPopularidad() instanceof Normal;

        // Test 2: Supera 1000 reproducciones -> pasa a Auge
        System.out.println("\n=== Test 2: Pasa a Auge (supera 1000 reproducciones) ===");
        for (int i = 0; i <= 1000; i++) {
            cancion.reproducir();
        }
        System.out.println("Estado: " + cancion.getPopularidad().getClass().getSimpleName());
        System.out.println("Detalle: " + cancion.mostrarDetalle());
        assert cancion.getPopularidad() instanceof Auge;

        // Test 3: Baja del auge por muchos dislikes (5000)
        System.out.println("\n=== Test 3: Baja de Auge a Normal por dislikes ===");
        for (int i = 0; i < 5000; i++) {
            cancion.darDislike();
        }
        System.out.println("Estado: " + cancion.getPopularidad().getClass().getSimpleName());
        System.out.println("Detalle: " + cancion.mostrarDetalle());
        assert cancion.getPopularidad() instanceof Normal;

        // Volvemos a Auge para el test 4
        for (int i = 0; i <= 1000; i++) {
            cancion.reproducir();
        }
        assert cancion.getPopularidad() instanceof Auge;

        // Test 4: Es tendencia por record de reproducciones y likes
        System.out.println("\n=== Test 4: Pasa a Tendencia (reproducciones + likes) ===");
        for (int i = 0; i <= 50000; i++) {
            cancion.reproducir();
        }
        for (int i = 0; i <= 20000; i++) {
            cancion.darLike();
        }
        System.out.println("Estado: " + cancion.getPopularidad().getClass().getSimpleName());
        System.out.println("Detalle: " + cancion.mostrarDetalle());
        assert cancion.getPopularidad() instanceof Tendencia;

        // Test 5: Era tendencia, vuelve a Normal por no ser escuchada en 24hs
        System.out.println("\n=== Test 5: Vuelve a Normal por 24hs sin reproduccion ===");
        cancion.pasaron24HsSinReproduccion();
        System.out.println("Estado: " + cancion.getPopularidad().getClass().getSimpleName());
        System.out.println("Detalle: " + cancion.mostrarDetalle());
        assert cancion.getPopularidad() instanceof Normal;

        System.out.println("\n=== Todos los tests pasaron correctamente ===");
    }
}
