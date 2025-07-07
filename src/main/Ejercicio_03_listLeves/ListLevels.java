package main.Ejercicio_03_listLeves;

import main.Materia.Models.Node;
import java.util.*;

public class ListLevels {
    
    public List<ListNode> listLevels(Node nodoRaiz) {
        List<ListNode> listaResultado = new ArrayList<>();
        
        if (nodoRaiz == null) {
            return listaResultado;
        }
        
        procesarNiveles(nodoRaiz, listaResultado);
        return listaResultado;
    }
    
    private void procesarNiveles(Node raiz, List<ListNode> resultado) {
        Queue<Node> colaAuxiliar = new LinkedList<>();
        colaAuxiliar.offer(raiz);
        
        while (!colaAuxiliar.isEmpty()) {
            int elementosEnNivel = colaAuxiliar.size();
            ListNode primerNodo = null;
            ListNode ultimoNodo = null;
            
            for (int i = 0; i < elementosEnNivel; i++) {
                Node nodoEnProceso = colaAuxiliar.poll();
                ListNode nuevoNodo = new ListNode(nodoEnProceso.getValue());
                
                if (primerNodo == null) {
                    primerNodo = nuevoNodo;
                    ultimoNodo = nuevoNodo;
                } else {
                    ultimoNodo.setNext(nuevoNodo);
                    ultimoNodo = nuevoNodo;
                }
                
                if (nodoEnProceso.getLeft() != null) {
                    colaAuxiliar.offer(nodoEnProceso.getLeft());
                }
                if (nodoEnProceso.getRight() != null) {
                    colaAuxiliar.offer(nodoEnProceso.getRight());
                }
            }
            
            resultado.add(primerNodo);
        }
    }
    
    public List<ListNode> obtenerListasPorNivel(Node arbol) {
        return listLevels(arbol);
    }
}