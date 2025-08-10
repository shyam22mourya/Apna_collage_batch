class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
    
    public static void main(String[] args) {
        
    }
}

class Queue {
    static Node head;
    static Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int front = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return front;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }
}

class Stack {
    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    // push
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // pop
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }
}

public class InnerStack {
    public static void main(String[] args) {
        Queue q = new Queue();
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
       q.add(6);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
