package learn.dsa;

public class QueueL {
    private Node front;
    private Node rear;
    private int length;
    public int size(){
        return length;
    }
    public void enqueue(int data){
        Node newNode=new Node(data);
        if(front == null && rear==null){
            front=newNode;
        }else{
            rear.next=newNode;
        }
        rear=newNode;
        length++;
    }
    public Node dequeue(){
        Node res=front;
        front= front.next;
        if(front==null){
            rear=null;
        }
        length--;
        return res;
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

    public static void main(String[] args) {
        QueueL queueL= new QueueL();
        queueL.enqueue(78);
        queueL.enqueue(9);
        System.out.println(queueL.size());
        System.out.println(queueL.dequeue());
        System.out.println(queueL.size());
    }
}
