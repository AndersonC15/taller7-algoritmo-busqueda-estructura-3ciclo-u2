package com.anderson;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;


public class DemostracionBusqueda {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("=== DEMOSTRACION DE ALGORITMOS DE BUSQUEDA ===");
        System.out.println("==============================================");

        BusquedaSecuencial busquedaSecuencial = new BusquedaSecuencial();
        BusquedaCentinela busquedaCentinela = new BusquedaCentinela();

        // DATASETS DE PRUEBA 
        int[] A = {1, 3, 7, 7, 9}; // Arreglo ordenado para Binaria
        int[] B = {};               // Arreglo vacío (Caso Borde)
        int[] C = {5, 10, 15, 20};  // Clave no presente (42)
        int[] D = {7, 5, 2, 42};    // Claves: 7, 5, 2, 42 (no está)

        // Arreglo para demostracion de SLL: 3, 7, 7, 2, 9, 7, 12, 7 
        int[] sll_datos = {3, 1, 3, 2};

        // ===============================================
        // A. PRUEBAS CON ARREGLOS (Persona 1: Búsqueda Secuencial)
        // ===============================================
        System.out.println("\n--- A. BUSQUEDA SECUENCIAL CLASICA ---");

        // Caso A: buscarPrimero (Clave 7)
        System.out.println("Arreglo A: " + Arrays.toString(A));
        int resPrimeroA = busquedaSecuencial.buscarPrimero(A, 7);
        System.out.println("  -> Primero(7) esperado 2 | Obtenido: " + resPrimeroA);

        // Caso D: buscarUltimo (Clave 7)
        System.out.println("Arreglo D: " + Arrays.toString(D));
        int resUltimoD = busquedaSecuencial.buscarUltimo(D, 7);
        System.out.println("  -> Ultimo(7) esperado 0 | Obtenido: " + resUltimoD);

        // Caso C: Clave no presente (Clave 42)
        int resNoExiste = busquedaSecuencial.buscarPrimero(C, 42);
        System.out.println("  -> Primero(42) esperado -1 | Obtenido: " + resNoExiste);

        // Caso B: Arreglo vacio
        int resVacio = busquedaSecuencial.buscarPrimero(B, 5);
        System.out.println("  -> Primero(5) en [] esperado -1 | Obtenido: " + resVacio);


        // ===============================================
        // B. PRUEBAS CON PREDICADOS (Persona 1: buscarTodos)
        // ===============================================
        System.out.println("\n--- B. BUSQUEDA POR PREDICADO ---");

        // Predicado sugerido: "par"
        IntPredicate esPar = x -> x % 2 == 0;
        List<Integer> indicesParesD = busquedaSecuencial.buscarTodos(D, esPar);
        System.out.println("Arreglo D: " + Arrays.toString(D));
        System.out.println("  -> Indices Pares esperado [2, 3] | Obtenido: " + indicesParesD); // 2 y 42 son pares

        // Predicado sugerido: "==7"
        IntPredicate esSiete = x -> x == 7;
        List<Integer> indicesSieteA = busquedaSecuencial.buscarTodos(A, esSiete);
        System.out.println("Arreglo A: " + Arrays.toString(A));
        System.out.println("  -> Índices == 7 esperado [2, 3] | Obtenido: " + indicesSieteA);

        // ===============================================
        // C. BUSQUEDA CON CENTINELA 
        // ===============================================
        System.out.println("\n--- C. BUSQUEDA SECUENCIAL CON CENTINELA ---");

        // Copiamos el arreglo D para no modificar el original durante la prueba de centinela
        int[] D_copy_found = Arrays.copyOf(D, D.length); // Clave 7 está
        int[] D_copy_notfound = Arrays.copyOf(D, D.length); // Clave 4 está (no esta)

        System.out.println("Arreglo D (original): " + Arrays.toString(D));
        System.out.println("\nCaso 1: Clave 7 (Encontrado)");
        int resCentinelaFound = busquedaCentinela.buscarConCentinela(D_copy_found, 7);
        System.out.println("  -> Índice Centinela: " + resCentinelaFound);

        System.out.println("\nCaso 2: Clave 4 (No Encontrado)");
        int resCentinelaNotFound = busquedaCentinela.buscarConCentinela(D_copy_notfound, 4);
        System.out.println("  -> Índice Centinela: " + resCentinelaNotFound);

        // ===============================================
        // D. BÚSQUEDAS EN SLL 
        // ===============================================
        System.out.println("\n--- D. BUSQUEDA EN LISTA SIMPLE ENLAZADA ---");
        
        // Crear la lista 3, 1, 3, 2
        ListaSimpleEnlazada lista = new ListaSimpleEnlazada();
        NodoSLL cabeza = lista.desdeArreglo(sll_datos);
        
        BusquedaListaSimple buscadorSLL = new BusquedaListaSimple();

        System.out.println("Lista: [3, 1, 3, 2]");

        // 1) Buscar primero (Clave 3)
        NodoSLL primero = buscadorSLL.buscarPrimero(cabeza, 3);
        System.out.println("  -> Primero(3): " + (primero != null ? "Valor " + primero.valor : "No encontrado"));

        // 2) Buscar ultimo (Clave 3)
        NodoSLL ultimo = buscadorSLL.buscarUltimo(cabeza, 3);
        System.out.println("  -> Ultimo(3): " + (ultimo != null ? "Valor " + ultimo.valor : "No encontrado"));

        // 3) Buscar todos (Predicado: valor < 3)
        Predicate<NodoSLL> valorMenorATres = nodo -> nodo.valor < 3;
        List<NodoSLL> menores = buscadorSLL.buscarTodos(cabeza, valorMenorATres);
        System.out.println("  -> Nodos valor < 3: " + menores.size() + " nodos encontrados.");
        
        System.out.println("\n==============================================");
        System.out.println("=== FIN DE DEMOSTRACION ===");
        System.out.println("==============================================");


    }

}
