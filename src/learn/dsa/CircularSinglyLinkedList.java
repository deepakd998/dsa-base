package learn.dsa;

import java.util.ArrayList;

public class CircularSinglyLinkedList {
    private Node last;
    private int length;
    private static class Node{
        private int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next=null;
        }
    }

    public CircularSinglyLinkedList() {
        this.last=null;
        this.length=0;
    }

    public int size(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }

    public static void main(String[] args) {
     CircularSinglyLinkedList linkedList = new CircularSinglyLinkedList();
    }
}
