package main;

import utils.StudentValidator;
import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_03_listLeves.ListNode;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉  Correo: " + estudiante.correo());

        System.out.println("\n");
        System.out.println("#    ALGORITMOS DE ARBOLES        #");
        System.out.println("#    ESTRUCTURAS NO LINEALES      #");
        
        ejecutarPrimerEjercicio();
        ejecutarSegundoEjercicio();
        ejecutarTercerEjercicio();
        ejecutarCuartoEjercicio();
        
        System.out.println("\n+++ Finalizacion exitosa de todos los algoritmos +++");
    }
    
    private static void ejecutarPrimerEjercicio() {
        System.out.println("\n");
        System.out.println("║          ALGORITMO 01: BST INSERT        ║");
        System.out.println("* Datos de entrada: [5, 3, 7, 2, 4, 6, 8]");
        
        InsertBST constructorBST = new InsertBST();
        Node arbol = null;
        
        int[] elementos = {5, 3, 7, 2, 4, 6, 8};
        for (int elemento : elementos) {
            arbol = constructorBST.insert(arbol, elemento);
        }
        
        System.out.println("* Resultado: Arbol BST generado correctamente");
        visualizarEstructura(arbol);
    }
    
    private static void ejecutarSegundoEjercicio() {
        System.out.println("\n");
        System.out.println("║       ALGORITMO 02: TREE INVERSION       ║");
        
        InvertBinaryTree inversor = new InvertBinaryTree();
        Node arbolOriginal = generarArbolPrueba();
        
        System.out.println("* Estado inicial del arbol:");
        visualizarEstructura(arbolOriginal);
        
        Node arbolInvertido = inversor.invertTree(arbolOriginal);
        System.out.println("\n* Arbol tras aplicar inversion:");
        visualizarEstructura(arbolInvertido);
    }
    
    private static void ejecutarTercerEjercicio() {
        System.out.println("\n");
        System.out.println("║     ALGORITMO 03: LEVEL LINKED LISTS     ║");
        
        ListLevels procesadorNiveles = new ListLevels();
        Node arbolDemo = generarArbolPrueba();
        
        System.out.println("* Estructura base del arbol:");
        visualizarEstructura(arbolDemo);
        
        List<ListNode> nivelesEnListas = procesadorNiveles.listLevels(arbolDemo);
        
        System.out.println("\n* Listas enlazadas generadas:");
        for (int nivel = 0; nivel < nivelesEnListas.size(); nivel++) {
            System.out.println("  >> Nivel " + nivel + ": " + generarTextoLista(nivelesEnListas.get(nivel)));
        }
    }
    
    private static void ejecutarCuartoEjercicio() {
        System.out.println("\n");
        System.out.println("║      ALGORITMO 04: DEPTH CALCULATOR      ║");
        
        Depth calculadorAltura = new Depth();
        Node arbolProfundidad = generarArbolConProfundidad();
        
        System.out.println("* Arbol a analizar:");
        visualizarEstructura(arbolProfundidad);
        
        int profundidadResultado = calculadorAltura.maxDepth(arbolProfundidad);
        System.out.println("\n* Profundidad maxima detectada: " + profundidadResultado);
    }
    
    private static Node generarArbolPrueba() {
        Node raiz = new Node(4);
        raiz.setLeft(new Node(2));
        raiz.setRight(new Node(7));
        raiz.getLeft().setLeft(new Node(1));
        raiz.getLeft().setRight(new Node(3));
        raiz.getRight().setLeft(new Node(6));
        raiz.getRight().setRight(new Node(9));
        return raiz;
    }
    
    private static Node generarArbolConProfundidad() {
        Node raiz = new Node(4);
        raiz.setLeft(new Node(2));
        raiz.setRight(new Node(7));
        raiz.getLeft().setLeft(new Node(1));
        raiz.getLeft().setRight(new Node(3));
        raiz.getLeft().getLeft().setLeft(new Node(8));
        return raiz;
    }
    
    private static void visualizarEstructura(Node nodo) {
        if (nodo == null) {
            System.out.println("  [Estructura vacia]");
            return;
        }
        dibujarNodo(nodo, "  ", true);
    }
    
    private static void dibujarNodo(Node nodo, String prefijo, boolean esTerminal) {
        if (nodo != null) {
            System.out.println(prefijo + (esTerminal ? "└─ " : "├─ ") + "[" + nodo.getValue() + "]");
            
            if (nodo.getLeft() != null || nodo.getRight() != null) {
                if (nodo.getLeft() != null) {
                    dibujarNodo(nodo.getLeft(), prefijo + (esTerminal ? "   " : "│  "), nodo.getRight() == null);
                }
                if (nodo.getRight() != null) {
                    dibujarNodo(nodo.getRight(), prefijo + (esTerminal ? "   " : "│  "), true);
                }
            }
        }
    }
    
    private static String generarTextoLista(ListNode cabecera) {
        StringBuilder texto = new StringBuilder();
        ListNode actual = cabecera;
        while (actual != null) {
            texto.append("[").append(actual.getVal()).append("]");
            if (actual.getNext() != null) {
                texto.append(" --> ");
            }
            actual = actual.getNext();
        }
        return texto.toString();
    }
}