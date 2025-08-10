package ARRAYSMENU.LinkedList;

public class Link {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null, tail = null;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addIth(int idx, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int size() {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public int removeFirst() {
        int size = size();
        if (size == 0 || head == null) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            return data;

        } else {
            int data = head.data;
            head = head.next;
            return data;
        }
    }

    public int removeLast() {
        int size = size();
        Node prev = head;
        if (size == 0 || head == null) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            return data;
        }
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int data = tail.data;
        prev.next = null;
        tail = prev;
        return data;
    }

    public int search(int key) {
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public int search(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = search(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public static void main(String[] args) {
        Link list = new Link();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(40);
        list.addLast(50);

        list.print();
        list.addIth(3, 0);
        list.print();
        System.out.println(list.removeFirst());
        list.print();
        System.out.println(list.removeLast());
        list.print();
        System.out.println(list.search(10));
        System.out.println(list.search(list.head, 0));
        list.reverse();
        list.print();
        
        while (true) {
            System.out.print("Radhe Radhe ");
        }
    }
}
