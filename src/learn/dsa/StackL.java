package learn.dsa;

public class StackL {
   private Node top;
    private int length;
    public int size(){
        return length;
    }
    public void push(int data){
        Node newNode= new Node(data);
        newNode.next=top;
        top=newNode;
        length++;
    }
    public Node pop(){
        Node temp=top;
        top=top.next;
        length--;
        return temp;
    }

    public Node peek() throws IllegalAccessException {
        if(length==0){
            throw new IllegalAccessException();
        }
        return top;
    }
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        StackL stackL= new StackL();
        stackL.push(60);
        stackL.push(66);
        System.out.println(stackL.size());
        System.out.println(stackL.pop());
        System.out.println(stackL.peek());
    }
}
