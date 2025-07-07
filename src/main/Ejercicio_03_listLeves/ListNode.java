package main.Ejercicio_03_listLeves;

public class ListNode {
    private int data;
    private ListNode proximo;
    
    public ListNode(int data) {
        this.data = data;
        this.proximo = null;
    }
    
    public int getVal() {
        return data;
    }
    
    public void setVal(int data) {
        this.data = data;
    }
    
    public ListNode getNext() {
        return proximo;
    }
    
    public void setNext(ListNode proximo) {
        this.proximo = proximo;
    }
}