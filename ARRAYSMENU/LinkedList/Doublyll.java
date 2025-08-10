package ARRAYSMENU.LinkedList;

public class Doublyll {
    public static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Stack {
        static int cnt = 0;
        static Node temp = new Node(-1);
        static Node head = temp;
        static Node mid = temp;

        public static void push(int data) {
            Node newnode = new Node(data);
            newnode.prev = null;
            newnode.next = head;
            cnt++;
            head.prev = newnode;
            head = newnode;
            if (cnt == 1) {
                mid = newnode;
            } else if (cnt % 2 == 0) {
                mid = mid.prev;
            }
        }

        public static int pop() {
            if (cnt == 0) {
                System.out.println("OUR STACK IS EMPTY() ; ");
                return -1;
            }
            Node dummy = head;
            int x = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            cnt--;

            if (cnt % 2 != 0) {
                mid = mid.next;
            }

            return x;
        }

        public static int mid() {
            if (cnt == 0) {
                return -1;
            }
            return mid.data;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int data) {
        
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }

    public void addlast(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = null;
            return;
        }
        tail.next = newnode;
        newnode.prev = tail;
        tail = newnode;
    }

    public void add(int ind, int data) {
        Node newnode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < ind - 1) {
            temp = temp.next;
            i++;
        }
        if (ind == 0) {
            addFirst(data);
            return;
        } else {

            newnode.next = temp.next;
            temp.next = newnode;
            newnode.prev = temp;
        }
    }

    // remove fisst
    public int removefirst() {
        if (head == null) {
            System.out.println("this is empty ");
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        } else {
            int val = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return val;
        }
    }

    public void removelast() {
        if (head == null) {
            return;
        } else if (size == 1) {
            head = tail = null;
            return;
        }
        //
        tail = tail.prev;
        tail.next = null;
        size--;

    }

    public Node reverseDLL(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ->  ");
            temp = temp.next; // Move to the next node
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Stack dll = new Stack();
        dll.push(1);
        dll.push(2);
        dll.push(5);
        dll.push(8);
        dll.push(9);
        dll.pop();
        dll.pop();
        dll.pop();
        System.out.println(dll.mid());
    }
}
