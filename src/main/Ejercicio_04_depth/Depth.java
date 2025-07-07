package main.Ejercicio_04_depth;


import main.Materia.Models.Node;

public class Depth {
    public int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        int izqDepth = maxDepth(root.getLeft());
        int derDepth = maxDepth(root.getRight());
        return 1 + Math.max(izqDepth, derDepth);
    }
}
