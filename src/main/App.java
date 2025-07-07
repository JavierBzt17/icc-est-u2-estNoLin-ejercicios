package main;

import main.Ejercicio_01_insert.InsertBSTTest;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;
import utils.StudentValidator;

import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {

        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ


        InsertBSTTest inserter = new InsertBSTTest();
        Node root = null;
        int[] valores = {5, 3, 7, 2, 4, 6, 8}; 
        for (int val : valores) {
            root = inserter.insert(root, val);
        }

        System.out.println("\nEjercicio 01: Insertar en un Árbol Binario de Búsqueda (BST)");
        imprimirPorNiveles(root); 


        InvertBinaryTree inverter = new InvertBinaryTree();
        Node invertedRoot = inverter.invert(root);



        System.out.println("\nEjercicio 02: Árbol Binario Invertido");
        imprimirPorNiveles(invertedRoot); 

        ListLevels listLevels = new ListLevels();
        List<List<Node>> niveles = listLevels.listLevels(root);



        System.out.println("\nEjercicio 03: Listar Niveles en Listas Enlazadas");
        for (List<Node> nivel : niveles) {
            for (int i = 0; i < nivel.size(); i++) {
                System.out.print(nivel.get(i).getValue());
                if (i != nivel.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }




        Depth profundidad = new Depth();
        int maxDepth = profundidad.maxDepth(root);
        System.out.println("\nEjercicio 04: Calcular la Profundidad Máxima");
        System.out.println("Profundidad máxima: " + maxDepth);
    }

    private static void imprimirPorNiveles(Node root) {
        ListLevels listLevels = new ListLevels();
        List<List<Node>> niveles = listLevels.listLevels(root);
        for (List<Node> nivel : niveles) {
            for (Node nodo : nivel) {
                System.out.print(nodo.getValue() + " ");
            }
            System.out.println();
        }
    }
}
