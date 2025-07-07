package main.Ejercicio_01_insert;

import main.Materia.Models.Node;

public class InsertBST {
    
    public Node insert(Node nodo, int elemento) {
        if (nodo == null) {
            return new Node(elemento);
        }
        
        if (elemento < nodo.getValue()) {
            nodo.setLeft(insert(nodo.getLeft(), elemento));
        } else if (elemento > nodo.getValue()) {
            nodo.setRight(insert(nodo.getRight(), elemento));
        } else {
            return nodo;
        }
        
        return nodo;
    }
    
    public Node insertarElemento(Node arbol, int valor) {
        return insert(arbol,valor);
    }
}