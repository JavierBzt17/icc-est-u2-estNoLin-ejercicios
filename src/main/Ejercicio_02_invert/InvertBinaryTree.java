package main.Ejercicio_02_invert;

import main.Materia.Models.Node;

public class InvertBinaryTree {
    
    public Node invertTree(Node nodo) {
        if (nodo == null) {
            return null;
        }
        
        invertTree(nodo.getLeft());
        invertTree(nodo.getRight());
        
        Node auxiliar = nodo.getLeft();
        nodo.setLeft(nodo.getRight());
        nodo.setRight(auxiliar);
        
        return nodo;
    }
    
    public Node invertirArbol(Node raizArbol) {
        return invertTree(raizArbol);
    }
}