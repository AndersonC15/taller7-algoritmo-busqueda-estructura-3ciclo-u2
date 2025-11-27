import java.util.List;
import java.util.function.IntPredicate;

public class SearchDemo {

    public static void main(String[] args) {

        List<CasoPrueba> casos = CasosLoader.leerCSV("src/DataSets/Casos.csv");

        BusquedaSecuencial bs = new BusquedaSecuencial();

        for (CasoPrueba c : casos) {
            System.out.println("\nCaso " + c.id + " → " + c.descripcion);

            try {
                switch (c.metodo) {

                    case "buscarPrimero":
                        int clavePrim = Integer.parseInt(c.claveOPredicado);
                        int resPrim = bs.buscarPrimero(c.arreglo, clavePrim);
                        validar("" + resPrim, c.resultadoEsperado);
                        break;

                    case "buscarUltimo":
                        int claveUlt = Integer.parseInt(c.claveOPredicado);
                        int resUlt = bs.buscarUltimo(c.arreglo, claveUlt);
                        validar("" + resUlt, c.resultadoEsperado);
                        break;

                    case "buscarTodos":
                        IntPredicate pred = construirPredicado(c.claveOPredicado);
                        List<Integer> resLista = bs.buscarTodos(c.arreglo, pred);
                        validar(resLista.toString(), c.resultadoEsperado);
                        break;

                    default:
                        System.out.println("Método no reconocido.");
                }

            } catch (Exception e) {
                System.out.println("Error ejecutando caso: " + e.getMessage());
            }
        }
    }

    private static void validar(String obtenido, String esperado) {
        if (obtenido.equals(esperado)) {
            System.out.println("PASA — obtenido = " + obtenido);
        } else {
            System.out.println("FALLA — obtenido = " + obtenido + ", esperado = " + esperado);
        }
    }

    private static IntPredicate construirPredicado(String expr) {
        if (expr.contains(">"))
            return x -> x > Integer.parseInt(expr.split(">")[1].trim());
        if (expr.contains("=="))
            return x -> x == Integer.parseInt(expr.split("==")[1].trim());
        if (expr.contains("%"))
            return x -> x % 2 == 0;

        return x -> false;
    }
}
