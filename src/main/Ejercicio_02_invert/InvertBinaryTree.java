package main.Ejercicio_02_invert;

import main.Materia.Models.Node;

public class InvertBinaryTree {
    
    public Node invert(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.getLeft();
        root.setLeft(invert(root.getRight()));
        root.setRight(invert(temp));
        return root;
    }
}
