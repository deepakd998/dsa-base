package learn.dsa;

import java.util.Arrays;

public class MaxPQ {
    private int[] heap;
    private int length;

    public MaxPQ(int capacity) {
        this.heap = new int[capacity+1];
        this.length=0;
    }
    public int size(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public void add(int data){
        if(length==heap.length-1){
            resize(2*heap.length);
        }
        length++;
        heap[length]=data;
        swim(length);
    }

    private void swim(int k) {
        while (k>1&&heap[k/2]<heap[k]){
            int temp=heap[k];
            heap[k]=heap[k/2];
            heap[k/2]=temp;
            k=k/2;
        }
    }

    private void resize(int capacity) {
        int [] newHeap=new int[capacity];
        System.arraycopy(heap,1,newHeap,1,heap.length-1);
        heap=newHeap;
    }

    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(3);
        maxPQ.add(10);
        maxPQ.add(2);
        maxPQ.add(3);
        maxPQ.add(1);
        maxPQ.add(6);
        maxPQ.add(5);
        System.out.println(Arrays.toString(maxPQ.heap));
    }
}
