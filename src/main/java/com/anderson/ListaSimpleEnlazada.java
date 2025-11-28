package com.anderson;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de una lista simple enlazada.
 *
 * Autores:
 * - Persona A
 * - Persona B
 * - Persona C
 * - Persona D
 */
public class ListaSimpleEnlazada {

    private NodoSLL cabeza;

    public ListaSimpleEnlazada() {
        this.cabeza = null;
    }

    /**
     * Crea la lista desde un arreglo de enteros.
     *
     * @param datos arreglo de valores
     */
    public void desdeArreglo(int[] datos) {
        if (datos == null || datos.length == 0) {
            cabeza = null;
            return;
        }

        cabeza = new NodoSLL(datos[0]);
        NodoSLL actual = cabeza;

        for (int i = 1; i < datos.length; i++) {
            actual.siguiente = new NodoSLL(datos[i]);
            actual = actual.siguiente;
        }
    }

    public NodoSLL obtenerCabeza() {
        return cabeza;
    }

    /**
     * Inserta un nuevo valor al final de la lista.
     */
    public void insertarAlFinal(int valor) {
        NodoSLL nuevo = new NodoSLL(valor);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        NodoSLL actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    /**
     * Convierte la SLL a una lista estándar.
     */
    public List<Integer> aLista() {
        List<Integer> lista = new ArrayList<>();
        NodoSLL actual = cabeza;

        while (actual != null) {
            lista.add(actual.valor);
            actual = actual.siguiente;
        }

        return lista;
    }
}
