# Taller 7 - Implementación de Algoritmos de Búsqueda
## FEIRNNR - Carrera de Computación (Estructura de Datos)
*Docente:* Ing. Andrés Roberto Navas Castellanos

---

## Integrantes: 

### [Ana Panamito](https://github.com/AnaPanamito)
### [Royel Jima](https://github.com/R0yalCode)
### [Daniel Savedra](https://github.com/Dan-San837)
### [Anderson Coello](https://github.com/AndersonC15)

---

 ## 1. Estructura del proyecto

```
taller7-algoritmo-busqueda-estructura-3ciclo-u2-develop/
├── .gitignore
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── anderson/
                    ├── DataSets.csv
                    ├── BusquedaCentinela.java
                    ├── BusquedaListaSimple.java
                    ├── BusquedaSecuencial.java
                    ├── BusquedaSLL.java
                    ├── CasoPrueba.java
                    ├── CasosLoader.java
                    ├── DemostracionBusqueda.java
                    ├── ListaSimpleEnlazada.java
                    ├── NodoSLL.java
                    └── SearchDemo.java
```

---

## 2. Compilación y Ejecución del Proyecto

El proyecto está estructurado con el paquete com.anderson y utiliza *Maven* para la gestión de dependencias y la ejecución.

### Instrucciones de Ejecución
Para compilar y ejecutar el programa principal (DemostracionBusqueda.java), use los siguientes comandos desde la carpeta raíz del proyecto Maven:

1.  *Compilación (Generar clases):*
    bash
    mvn compile
    

2.  *Ejecución de la Demostración:*
    bash
    mvn exec:java -Dexec.mainClass="com.anderson.DemostracionBusqueda"
    
    La ejecución correrá los datasets A, B, C, D y el ejemplo SLL (3+1+3+2), mostrando los resultados observados y el análisis de comparaciones del Centinela.

---

## 3. Implementaciones y Precondiciones

La solución se divide en clases especializadas para cada estructura de datos y técnica de búsqueda, aplicando el principio de Clean Code y separación de responsabilidades.

### 3.1. Algoritmos de Búsqueda
| Algoritmo | Estructura | Clase(s) | Complejidad | Precondición |
| :--- | :--- | :--- | :--- | :--- |
| *Secuencial (first/last/findAll)* | Arreglo (int[]) | BusquedaSecuencial.java | O(n) | Ninguna |
| *Secuencial (first/last/findAll)* | SLL (Nodo) | BusquedaListaSimple.java | O(n) | Ninguna |
| *Secuencial con Centinela* | Arreglo (int[]) | BusquedaCentinela.java | O(n) | Ninguna |
| *Búsqueda Binaria* | Arreglo (int[]) | BusquedaSecuencial.java (o BusquedaBinaria.java) | O(\log n) | *El arreglo debe estar previamente ordenado.* |

### 3.2. Notas sobre Precondiciones
* *Búsqueda Binaria:* La condición de arreglo ordenado es crítica. Si no se cumple, el algoritmo retorna un resultado incorrecto, ya que se basa en la propiedad de poder descartar la mitad del espacio de búsqueda en cada paso.
* *SLL vs. Binaria:* La búsqueda binaria no es adecuada para las Listas Simplemente Enlazadas, aunque la lista esté ordenada. Esto se debe a que la SLL requiere *acceso secuencial* ($O(k)$) para llegar al elemento en la posición media, lo que anularía la ventaja de $O(\log n)$ de la búsqueda binaria.

---

## 4. Validación de Casos Borde y Evidencias

La clase DemostracionBusqueda ejecuta los casos borde requeridos, con los siguientes resultados:

### 4.1. Pruebas de Búsqueda Secuencial Clásica (Arreglos)

<img width="607" height="377" alt="image" src="https://github.com/user-attachments/assets/8301243e-45ae-4323-b3bc-2f37f814ad50" />

| Escenario | Clave / Predicado | Arreglo | Esperado | Obtenido | Resultado | |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| *Clave Duplicada (Primero)* | 7 | A: [1, 3, 7, 7, 9] | 2 | 2 | *PASA* |  
| *Clave en Inicio (Último)* | 7 | D: [7, 5, 2, 42] | 0 | 0 | *PASA* |  
| *Clave No Presente* | 42 | C: [5, 10, 15, 20] | -1 | -1 | *PASA* |  
| *Arreglo Vacío* | 5 | B: [] | -1 | -1 | *PASA* |  
| **findAll por Predicado** | esPar | D: [7, 5, 2, 42] | [2, 3] | [2, 3] | *PASA* |  

### 4.2. Búsqueda Secuencial con Centinela (Análisis de Comparaciones)

La técnica del centinela garantiza la correctitud al asegurar que el bucle de búsqueda while(true) siempre terminará, sea por encontrar la clave real, o por llegar al centinela en la última posición.


<img width="518" height="342" alt="image" src="https://github.com/user-attachments/assets/d5cf1213-95df-4b67-a96b-0fa97e3761ff" /> 

| Casos | Encontrado en | Comparaciones Realizadas | Ahorro vs. Clásico (2N) |
| :--- | :--- | :--- | :--- |
| *Clave 7* (Índice 0) | Índice *0* | *2* | *Ahorro mínimo:* El valor se encuentra en la primera posición. |
| *Clave 4* (No Encontrado) | Índice *-1* | *5* | *Ahorro máximo:* Se requieren $N+1$ comparaciones vs. $2N$ de la clásica. |


### 4.3. Pruebas de Búsqueda en SLL

La demostración utiliza la lista [3, 1, 3, 2] y el nodo se asume como Nodo(valor).
<img width="547" height="177" alt="image" src="https://github.com/user-attachments/assets/cfe88c36-cfa6-4038-bc0d-9706b7323f22" /> 
| Escenario | Clave / Predicado | Resultado Esperado | Obtenido | Nota |
| :--- | :--- | :--- | :--- | :--- |
| **buscarPrimero** | 3 | Primer nodo con valor 3 | *Valor 3* | Confirmación de la primera ocurrencia. |
| **buscarUltimo** | 3 | Último nodo con valor 3 | *Valor 3* | Confirmación de la última ocurrencia tras recorrer la lista. |
| **buscarTodos** | valor < 3 | Nodos con valor 1 y 2 | *2 nodos encontrados* | Validación de predicado. |

---
