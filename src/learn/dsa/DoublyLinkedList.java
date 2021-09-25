package learn.dsa;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int size(){
        return length;
    }
    public void addFirst(int data){
        Node newNode= new Node(data);
       if(isEmpty()){
           tail=newNode;
       }else {
           head.prev=newNode;
       }
       newNode.next=head;
       head=newNode;
        length++;
    }
    public void addLast(int data){
        Node newNode= new Node(data);
        if(isEmpty()){
            head=newNode;
        }else {
            tail.next=newNode;
            newNode.prev=tail;
        }
        tail=newNode;
        length++;
    }
    public Node deleteFirst(){
        if(isEmpty()){
            return null;
        }
        Node temp=head;
        if(head==tail){
            tail=null;
        }else{
            head.next.prev=null;
        }
        head=head.next;
        temp.next=null;
        length--;
        return temp;
    }
    public Node deleteLast(){
        if(isEmpty()){
            return null;
        }
        Node temp=tail;
        if(head==tail){
            head=null;
        }else{
            tail.prev.next=null;
        }
        tail=tail.prev;
        temp.prev=null;
        length--;
        return temp;
    }
    public void display(Node head){
        if(head==null){
            return;
        }
         Node temp=head;
         while (temp!=null){
             System.out.print(temp.data+" -> ");
             temp=temp.next;
         }
         System.out.println("null");
    }

    public void displayBackward(Node tail){
        if(tail==null){
            return;
        }
        Node temp=tail;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.prev;
        }
        System.out.println("null");
    }
    private static class Node{
        private int data;
        private Node next;
        public Node prev;
        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList= new DoublyLinkedList();
        linkedList.addFirst(45);
        linkedList.addFirst(46);
        linkedList.addFirst(47);
        linkedList.addLast(50);
        linkedList.display(linkedList.head);
        System.out.println(linkedList.size());
        System.out.println(linkedList.deleteFirst());
        linkedList.display(linkedList.head);
        System.out.println(linkedList.deleteLast());
        linkedList.display(linkedList.head);
    }
}
