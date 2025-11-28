package com.anderson;

public class BusquedaCentinela {

    public int buscarConCentinela(int[] array, int valorBuscado) {
        int comparaciones = 0;

        // validamos que el arreglo no este vacio
        if (array.length == 0) {
            System.out.println("El arreglo esta vacío");
            return -1;
        }

        int n = array.length;

        comparaciones++;
        if (array[n - 1] == valorBuscado) {
            System.out.println("Valor encontrado en la ultima posición");
            System.out.println("Comparaciones realizadas: " + comparaciones);
            return n - 1;
        }

        // guardamos el ultimo elemento antes de modificarlo
        int ultimo = array[n - 1];

        // escribimos el centinela en la ultima posicion
        array[n - 1] = valorBuscado;

        // buscamos sin condición de límite
        int i = 0;
        while (true) {
            comparaciones++;

            if (array[i] == valorBuscado) { //comparamos si cada valor del array que recorre no coincide con el valorBuscado
                break; // se detuvo por el centinela o por encontrar el valor real
            }

            i++;
        }

        // restauramos el valor original del arreglo
        array[n - 1] = ultimo;

        // verificamos si fue encontrado antes de llegar al centinela
        if (i < n - 1) {
            System.out.println("Valor encontrado en el índice: " + i);
            System.out.println("Comparaciones realizadas: " + comparaciones);
            return i;
        }

        // si llegamos al centinela significa que no estaba en el arreglo original
        System.out.println("Valor NO encontrado.");
        System.out.println("Comparaciones realizadas: " + comparaciones);
        return -1;
    }
}
