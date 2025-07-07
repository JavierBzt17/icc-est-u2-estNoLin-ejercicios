package main.Ejercicio_04_depth;

import main.Materia.Models.Node;

public class Depth {
    
    public int maxDepth(Node nodo) {
        return calcularProfundidad(nodo);
    }
    
    private int calcularProfundidad(Node nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        
        int alturaIzquierda = calcularProfundidad(nodoActual.getLeft());
        int alturaDerecha = calcularProfundidad(nodoActual.getRight());
        
        int alturaMaxima = Math.max(alturaIzquierda, alturaDerecha);
        return alturaMaxima + 1;
    }
    
    public int obtenerProfundidadMaxima(Node arbol) {
        return maxDepth(arbol);
    }
}