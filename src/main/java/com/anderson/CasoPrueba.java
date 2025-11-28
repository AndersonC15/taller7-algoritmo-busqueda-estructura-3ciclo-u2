package com.anderson;

import java.util.List;
/**
 * Clase que representa un caso de prueba para los métodos de búsqueda secuencial.
 */
public class CasoPrueba {
    public int id;
    public String metodo;
    public int[] arreglo;
    public String claveOPredicado;
    public String resultadoEsperado;
    public String descripcion;

    public CasoPrueba(int id, String metodo, int[] arreglo,
                      String claveOPredicado, String resultadoEsperado,
                      String descripcion) {
        this.id = id;
        this.metodo = metodo;
        this.arreglo = arreglo;
        this.claveOPredicado = claveOPredicado;
        this.resultadoEsperado = resultadoEsperado;
        this.descripcion = descripcion;
    }
}