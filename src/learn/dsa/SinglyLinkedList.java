package learn.dsa;

import java.util.LinkedList;

public class SinglyLinkedList {
    private Node head;
    private int length;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        Node curr = head;
        newNode.next = curr;
        head = newNode;
        length++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        length++;
    }

    public void insertAtIndex(int data, int index) {
        Node newNode = new Node(data);
        if (index <= 0) {
            return;
        } else if (index == 1) {
            newNode.next = head;
            head = newNode;
        }

        Node prev = head;
        int count = 1;
        while (count < index - 1) {
            count++;
            prev = prev.next;
        }
        Node temp = prev.next;
        prev.next = newNode;
        newNode.next = temp;
        length++;
    }

    public void removeAtBeginning() {
        Node curr = head;
        head = curr.next;
        curr.next = null;
        length--;
    }

    public void removeAtEnd() {
        Node curr = head;
        Node prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        length--;
    }

    public void removeAtIndex(int index) {
        if (index == 1) {
            head = head.next;
            length--;
        } else {
            Node prev = head;
            int count = 1;
            while (count < index - 1) {
                prev = prev.next;
                count++;
            }
            Node curr = prev.next;
            prev.next = curr.next;
            length--;
        }

    }

    public boolean contains(int data) {
        boolean isPresent = false;
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                isPresent = true;
                break;
            }
            curr = curr.next;
        }
        return isPresent;
    }

    public Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node findMiddle(Node head) {
        Node mid = head;
        Node ptr = head;
        while (ptr != null && ptr.next != null) {
            ptr = ptr.next.next;
            mid = mid.next;
        }
        return mid;
    }

    public Node findNthNodeFromEnd(int n) {
        Node curr = head;
        Node ptr = head;
        int count = 0;
        while (count < n) {
            count++;
            ptr = ptr.next;
        }
        while (ptr != null) {
            curr = curr.next;
            ptr = ptr.next;
        }
        return curr;
    }

    public void removeDuplicateFromASortedList() {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public void insertANodeInSortedList(int data) {
        Node newNode = new Node(data);
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.data < data) {
            prev = curr;
            curr = curr.next;
        }
        newNode.next = curr;
        prev.next = newNode;
    }

    public Node remove(int data) {
        Node curr = head;
        Node prev = null;
        if (curr != null && curr.data == data) {
            head = curr.next;
            return head;
        }
        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;

        }
        if (curr == null) {
            return null;
        }
        prev.next = curr.next;
        return curr;
    }

    public boolean containsLoop() {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    public Node getStartOfLoop() {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                Node temp = head;
                while (temp != slowPtr) {
                    slowPtr = slowPtr.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
        return null;
    }

    public void removeLoop() {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                Node temp = head;
                while (temp.next != slowPtr.next) {
                    slowPtr = slowPtr.next;
                    temp = temp.next;
                }
                slowPtr.next=null;
                return;
            }
        }
    }

    public void display(Node head) {
        if(containsLoop()) return;
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        linkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
        linkedList.removeLoop();
        linkedList.display(linkedList.head);
    }
}
