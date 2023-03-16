import java.util.Arrays;

public class ColeccionVinilos {
    public static void main(String[] args) {
        String[][] vinilos = new String[20][3];

        agregarVinilo(vinilos, "Iron Maiden", "Iron Maiden", "1980");
        agregarVinilo(vinilos, "Iron Maiden", "Killers", "1981");
        agregarVinilo(vinilos, "Iron Maiden", "The number of the beast", "1982");
        agregarVinilo(vinilos, "AC-DC", "Back in black", "1980");
        agregarVinilo(vinilos, "AC-DC", "Highway to Hell", "1979");
        agregarVinilo(vinilos, "AC-DC", "Who made who", "1986");
        agregarVinilo(vinilos, "Judas Priest", "British steel", "1980");
        agregarVinilo(vinilos, "Judas Priest", "Painkiller", "1990");
        agregarVinilo(vinilos, "Judas Priest", "Defenders of the faith", "1984");
        agregarVinilo(vinilos, "Kiss", "Destroyer", "1976");

        System.out.println("Espacio maximo coleccion: " + vinilos.length);

        System.out.println("Cantidad de Vinilos en la coleccion: " + cantidadVinilosEnColeccion(vinilos));
        System.out.println("Espacios disponibles en la coleccion: " + espaciosDisponiblesEnColeccion(vinilos));

        String artista = "ACC";
        System.out.println("Buscar artista: " + artista);
        System.out.println(resultadoBusqueda(artista, vinilos));


        mostrarBusquedaArtista(vinilos, artista);
        System.out.println("Vinilos:");
        mostrarColeccion(vinilos);
    }

    private static String resultadoBusqueda(String artista, String[][] vinilos) {
        return String.format("El artista %s %s en la coleccion %n", artista, buscarArtista(vinilos, artista) ? "esta" : "no esta");
    }

    private static int espaciosDisponiblesEnColeccion(String[][] vinilos) {
        return vinilos.length - cantidadVinilosEnColeccion(vinilos);
    }

    private static void mostrarColeccion(String[][] vinilos) {
        for (int i = 0; i < cantidadVinilosEnColeccion(vinilos); i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            System.out.println(Arrays.toString(vinilos[i]));
        }
    }

    private static boolean buscarArtista(String[][] vinilos, String artista) {
        for (int i = 0; i < cantidadVinilosEnColeccion(vinilos); i++) {
            if (artista.equals(vinilos[i][0])) return true;
        }
        return false;
    }

    private static void mostrarBusquedaArtista(String[][] vinilos, String artista) {
        for (int i = 0; i < cantidadVinilosEnColeccion(vinilos); i++) {
            if (artista.equals(vinilos[i][0])) {
                System.out.println(Arrays.toString(vinilos[i]));
            }
        }
    }

    private static int cantidadVinilosEnColeccion(String[][] vinilos) {
        for (int i = 0; i < vinilos.length; i++) {
            if (vinilos[i][0] == null) return i;
        }
        return vinilos.length;
    }


    private static void agregarVinilo(String[][] vinilos, String artista, String album, String year) {
        if (hayEspaciosLibresEnColeccion(vinilos)) {
            int espacioLibre = cantidadVinilosEnColeccion(vinilos);
            vinilos[espacioLibre][0] = artista;
            vinilos[espacioLibre][1] = album;
            vinilos[espacioLibre][2] = year;
        }
    }

    private static boolean hayEspaciosLibresEnColeccion(String[][] vinilos) {
        return cantidadVinilosEnColeccion(vinilos) < vinilos.length;
    }

}
