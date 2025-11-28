package com.anderson;

import java.util.List;
import java.util.function.IntPredicate;

public class SearchDemo {

    public static void main(String[] args) {

        System.out.println("=== EJECUTANDO CASOS PARA ARREGLOS ===");

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
                        System.out.println("Método no reconocido en casos de arreglo.");
                }

            } catch (Exception e) {
                System.out.println("Error ejecutando caso: " + e.getMessage());
            }
        }



        System.out.println("\n\n=== DEMOSTRACIÓN DE BÚSQUEDAS EN SLL (TU APORTE) ===");

        // Crear lista desde un arreglo
        ListaSimpleEnlazada lista = new ListaSimpleEnlazada();
        lista.desdeArreglo(new int[]{3, 7, 7, 2, 9, 7, 12, 7});

        BusquedaSLL buscadorSLL = new BusquedaSLL();

        // 1) Buscar primero
        NodoSLL primero = buscadorSLL.buscarPrimero(lista.obtenerCabeza(), 7);
        System.out.println("Primera aparición de 7: " + (primero != null ? primero : "No encontrado"));

        // 2) Buscar último
        NodoSLL ultimo = buscadorSLL.buscarUltimo(lista.obtenerCabeza(), 7);
        System.out.println("Última aparición de 7: " + (ultimo != null ? ultimo : "No encontrado"));

        // 3) Buscar todos mayores a 5
        List<NodoSLL> mayoresA5 = buscadorSLL.buscarTodos(
                lista.obtenerCabeza(),
                nodo -> nodo.valor > 5
        );
        System.out.println("Nodos con valor > 5: " + mayoresA5);

        // 4) Buscar nodos pares
        List<NodoSLL> pares = buscadorSLL.buscarTodos(
                lista.obtenerCabeza(),
                nodo -> nodo.valor % 2 == 0
        );
        System.out.println("Nodos pares: " + pares);

        System.out.println("\n=== FIN DE DEMOSTRACIÓN SLL ===");
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
