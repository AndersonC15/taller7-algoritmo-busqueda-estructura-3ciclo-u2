import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CasosLoader {

    public static List<CasoPrueba> leerCSV(String ruta) {
        List<CasoPrueba> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine(); // saltar encabezado

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 6);

                int id = Integer.parseInt(partes[0]);
                String metodo = partes[1];
                int[] arreglo = parseArreglo(partes[2]);
                String claveOPred = partes[3];
                String resultado = partes[4];
                String descripcion = partes[5];

                lista.add(new CasoPrueba(id, metodo, arreglo, claveOPred, resultado, descripcion));
            }

        } catch (Exception e) {
            System.err.println("Error al leer el CSV: " + e.getMessage());
        }

        return lista;
    }

    private static int[] parseArreglo(String txt) {
        if (txt == null || txt.equalsIgnoreCase("null") || txt.isBlank()) {
            return null; // <-- aquí lo resolvemos
        }
        txt = txt.replace("[", "").replace("]", "");
        if (txt.isBlank()) return new int[0];
        String[] partes = txt.split(",");
        int[] arr = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            arr[i] = Integer.parseInt(partes[i].trim());
        }
        return arr;
    }

}