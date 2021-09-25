package learn.dsa;

public class HashNTable {
    private Node[] bucket;
    private int capacity;
    private int size;
   public HashNTable(){
       this(10);
   }
    public HashNTable(Integer capacity) {
        this.capacity = capacity;
        this.bucket= new Node[capacity];
    }
    public int size(){
       return size;
    }

    public boolean isEmpty(){
       return size==0;
    }
    public void put(Integer key,String value){
     int hash=hash(key);

     Node head= bucket[hash];
     while (head!=null){
         if(head.key.equals(key)){
             head.value=value;
             return;
         }
         head=head.next;
     }
     size++;
     head=bucket[hash];
     Node node= new Node(key,value);
     node.next=head;
     bucket[hash]=node;
    }
    public String get(Integer key){
       int hash=hash(key);
       Node head=bucket[hash];
       while(head!=null){
           if(head.key.equals(key)){
               return head.value;
           }
           head=head.next;
       }
       return null;
    }

    public String remove(Integer key){
      int hash=hash(key);
      Node head=bucket[hash];
      Node prev=null;
      while (head!=null){
          if(head.key.equals(key)){
           break;
          }
          prev=head;
          head=head.next;
      }
      if(head==null) return null;
      size--;
      if(prev!=null){
          prev.next=head.next;
      }else {
          bucket[hash]=head.next;
      }
      return head.value;
    }
    private int hash(int key){
       return key%capacity;
    }

    private class Node {
        private Integer key;
        private String value;
        private Node next;

        public Node(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashNTable table = new HashNTable(10);
        table.put(105,"dkj");
        table.put(5,"dkd");
        table.put(1,"dkdk");
        System.out.println(table.size());
        System.out.println(table.get(1));
    }
}
