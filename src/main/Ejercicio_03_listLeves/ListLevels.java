package main.Ejercicio_03_listLeves;


import main.Materia.Models.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListLevels {
    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                levelNodes.add(current);
                if (current.getLeft() != null) queue.offer(current.getLeft());
                if (current.getRight() != null) queue.offer(current.getRight());
            }
            result.add(levelNodes);
        }
        return result;
    }
}
