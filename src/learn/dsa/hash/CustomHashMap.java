package learn.dsa.hash;

class CustomHashMap<K,V>{
    private Node<K,V> [] bucket;
    private int capacity;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this. bucket= new Node[capacity];
    }
    public CustomHashMap() {
        this.capacity = 16;
        this. bucket= new Node[capacity];
    }
    public void put(K k,V v){
       Node<K,V> head= bucket[getHash(k)];
       while (head!=null){
           if(head.key.equals(k)){
               head.value=v;
               return;
           }
           head=head.next;
       }
       head=bucket[getHash(k)];
       Node<K,V> newNode= new Node<K,V>(k,v);
       newNode.next=head;
       head=newNode;
       bucket[getHash(k)]=head;
    }

    public V get(K k){
        Node<K,V> head= bucket[getHash(k)];
        while (head!=null){
            if(head.key.equals(k)){
                return head.value;
            }
            head=head.next;
        }
        return null;
    }

     private int getHash(K k){
        return k.hashCode()%capacity;
    }

    static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

