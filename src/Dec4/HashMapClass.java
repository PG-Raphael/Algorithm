package Dec4;


/**
 * Created by Raphael Yun on 12/4/2019
 */

public class HashMapClass<K, V> {
    private class LinkedList<K, V> {
        private class Node {
            private K key;
            private V value;
            private Node next;

            @Override
            public String toString() {
                return "Node{" +
                        "key=" + key +
                        ", value=" + value +
                        ", next=" + next +
                        '}';
            }

            private Node(K key, V value, Node node) {
                this.key = key;
                this.value = value;
                this.next = node;
            }
        }

        private Node head;

        private void put(K key, V value) {
            for (Node c = head; c != null; c = c.next) {
                if (c.key.equals(key)) {
                    c.value = value;
                    return;
                }
            }
            head = new Node(key, value, head);
        }

        private Node get(K key) {
            for (Node c = head; c != null; c = c.next)
                if (c.key.equals(key)) {
                    return c;
                }
            return null;
        }
    }

    private LinkedList[] hashTable;
    private int N;

    HashMapClass() {
        this(100);
    }

    HashMapClass(int capacity) {
        this.N = capacity;
        hashTable = new LinkedList[N];
        for (int i = 0; i < N; i++)
            hashTable[i] = new LinkedList<K, V>();
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % N;
    }

    public void put(K key, V value) {
        hashTable[hash(key)].put(key, value);
    }

    public V get(K key) {
        LinkedList.Node node= hashTable[hash(key)].get(key);
        return node == null? null: (V) node.value;
    }

    public static void main(String[] args) {
        HashMapClass<String, String> hashMapClass = new HashMapClass<>();
        hashMapClass.put("HI", "John");
        hashMapClass.put("Hi", "Amy");
        hashMapClass.put("Hello", "Tom");
        hashMapClass.put("HIl", "Harry");

        System.out.println(hashMapClass.get("HSAJSAD"));
        System.out.println(hashMapClass.get("HI"));
    }
}
