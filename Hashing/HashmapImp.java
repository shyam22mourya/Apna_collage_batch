package Hashing;

import java.util.*;

class Hash<K, V> { // generic
    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n; // number of elements
    private int N; // size of buckets array
    private LinkedList<Node>[] buckets; // buckets array

    @SuppressWarnings("unchecked")
    public Hash() {
        this.N = 4;
        this.buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public int hashFunction(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % N;
    }

    public int searchInLL(K key, int bi) {
        LinkedList<Node> ll = buckets[bi];
        for (int i = 0; i < ll.size(); i++) {
            Node node = ll.get(i);
            if (node.key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        buckets = new LinkedList[N * 2];
        N = N * 2;

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Node> ll : oldBuckets) {
            for (Node node : ll) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        int bi = hashFunction(key); //
        int di = searchInLL(key, bi);

        if (di == -1) {
            buckets[bi].add(new Node(key, value));
            n++;
        } else {
            Node node = buckets[bi].get(di);
            node.value = value; // Update value if key existts
        }

        double lambda = (double) n / N;
        if (lambda > 2.0) {
            rehash();
        }
    }

    public V get(K key) {
        int bi = hashFunction(key); //
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            return node.value;
        } else {
            return null;
        }
    }

    public V remove(K key) {
        int bi = hashFunction(key); //
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        } else {
            return null;
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key); //
        int di = searchInLL(key, bi);

        if (di != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Node> ll : buckets) {
            for (Node node : ll) {
                keys.add(node.key);
            }
        }
        return keys;
    }
}

public class HashmapImp {

    static class HashMap<K, V> { // generic

        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of elements
        private int N; // size of buckets array
        private LinkedList<Node>[] buckets; // buckets array

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) { // O(1)
            int bi = hashFunction(key); // bucket index
            int di = searchInLL(key, bi); // data index in the bucket

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value; // Update value if key exists
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            // Check load factor
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) { // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public V get(K key) { // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            return null;
        }

        public V remove(K key) { // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }
    }

    public static void main(String[] args) {
        Hash<String, Integer> hm = new Hash<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        System.out.println(hm.get("US"));
        System.out.println(hm.remove("US"));
        System.out.println(hm.containsKey("US"));
        System.out.println(hm.size());

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key + " -> " + hm.get(key));
        }
    }
}
