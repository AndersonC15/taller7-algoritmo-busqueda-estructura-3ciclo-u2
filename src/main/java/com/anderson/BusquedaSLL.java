package com.anderson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Implementación de algoritmos de búsqueda para una lista simple enlazada (SLL).
 *
 * Autores:
 * - Persona A
 * - Persona B
 * - Persona C
 * - Persona D
 */
public class BusquedaSLL {

    /**
     * Busca la primera coincidencia de la clave dentro de la lista.
     */
    public NodoSLL buscarPrimero(NodoSLL cabeza, int clave) {
        NodoSLL actual = cabeza;

        while (actual != null) {
            if (actual.valor == clave) {
                return actual;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    /**
     * Busca la última coincidencia de una clave dentro de la lista.
     */
    public NodoSLL buscarUltimo(NodoSLL cabeza, int clave) {
        NodoSLL actual = cabeza;
        NodoSLL ultimo = null;

        while (actual != null) {
            if (actual.valor == clave) {
                ultimo = actual;
            }
            actual = actual.siguiente;
        }

        return ultimo;
    }

    /**
     * Retorna todos los nodos que cumplen un predicado.
     */
    public List<NodoSLL> buscarTodos(NodoSLL cabeza, Predicate<NodoSLL> predicado) {
        List<NodoSLL> lista = new ArrayList<>();
        NodoSLL actual = cabeza;

        while (actual != null) {
            if (predicado.test(actual)) {
                lista.add(actual);
            }
            actual = actual.siguiente;
        }

        return lista;
    }
}
