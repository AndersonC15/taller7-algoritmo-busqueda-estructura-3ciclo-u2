package com.anderson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * Clase que implementa las variantes clásicas de búsqueda secuencial en arreglos.
 * Métodos:
 *  - buscarPrimero: retorna primer índice donde aparece la clave.
 *  - buscarUltimo: retorna último índice donde aparece la clave.
 *  - buscarTodos: retorna todos los índices que cumplen un predicado.
 *
 * Complejidad de todos los métodos: O(n)
 */
public class BusquedaSecuencial {

    /**
     * Retorna el índice de la primera aparición de la clave.
     * @param arreglo arreglo donde se busca
     * @param clave valor a buscar
     * @return índice de la primera aparición, o -1 si no existe
     */
    public int buscarPrimero(int[] arreglo, int clave) {
        if (arreglo == null || arreglo.length == 0) {
            return -1;
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == clave) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Retorna el índice de la última aparición de la clave.
     * @param arreglo arreglo donde se busca
     * @param clave valor a buscar
     * @return índice de la última aparición, o -1 si no existe
     */
    public int buscarUltimo(int[] arreglo, int clave) {
        if (arreglo == null || arreglo.length == 0) {
            return -1;
        }

        int ultimo = -1;

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == clave) {
                ultimo = i;
            }
        }
        return ultimo;
    }


    /**
     * Retorna todos los índices que cumplen con un predicado (par, igual a clave, menor que, etc.).
     * @param arreglo arreglo donde se evalúa el predicado
     * @param predicado condición lógica aplicada a cada elemento
     * @return lista de índices que cumplen el predicado
     */
    public List<Integer> buscarTodos(int[] arreglo, IntPredicate predicado) {
        List<Integer> resultado = new ArrayList<>();

        if (arreglo == null || arreglo.length == 0) {
            return resultado; // retorna lista vacía
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (predicado.test(arreglo[i])) {
                resultado.add(i);
            }
        }

        return resultado;
    }
}
