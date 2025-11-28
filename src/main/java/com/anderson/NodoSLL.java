package com.anderson;

/**
 * Clase que representa un nodo de una lista simple enlazada.
 *
 * Autores:
 * - Persona A
 * - Persona B
 * - Persona C
 * - Persona D
 *
 * Taller 7: Implementación de algoritmos de búsqueda (SLL).
 */
public class NodoSLL {

    public int valor;
    public NodoSLL siguiente;

    /**
     * Constructor del nodo.
     *
     * @param valor Valor numérico del nodo.
     */
    public NodoSLL(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "Nodo(" + valor + ")";
    }
}
