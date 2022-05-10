import java.util.ArrayList;

public class MyHashTable<K, V> {
    private ArrayList<HashNode<K, V> > hashArray;
    private int capacity;
    private int size;

    public static class HashNode<K, V> {
        K key;
        V value;
        final int hashCode;

        // Reference to next node
        HashNode<K, V> next;

        // Constructor
        public HashNode(K key, V value, int hashCode)
        {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }

    public MyHashTable()
    {
        hashArray = new ArrayList<>();
        capacity = 11;
        size = 0;

        for (int i = 0; i < capacity; i++)
            hashArray.add(null);
    }

    public MyHashTable(int M)
    {
        hashArray = new ArrayList<>();
        this.capacity = M;
        size = 0;

        // Create empty chains
        for (int i = 0; i < capacity; i++)
            hashArray.add(null);
    }

    public int size() {
        return size;
    }

    public int hash (K key) {
        if(key instanceof String) {
            StrCode code = new StrCode((String) key);
            return code.hashCodeOfString();

        }
        else{
            return (int) key;
        }
    }

    public void put(K key, V value)
    {
        int index = getIndex(key);
        int hashCode = hash(key);
        HashNode<K, V> n = hashArray.get(index);

        while (n != null) {
            if (n.key==key && n.hashCode == hashCode) {
                n.value = value;
                return;
            }
            n = n.next;
        }

        // collision
        size++;
        n = hashArray.get(index);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
        newNode.next = n; // linking nodes

        hashArray.set(index, newNode);

        if ((1.0 * size) / capacity >= 0.7) {
            ArrayList<HashNode<K, V> > temp = hashArray;
            hashArray = new ArrayList<>();
            capacity = 2 * capacity;
            size = 0;

            for (int i = 0; i < capacity; i++)
                hashArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public int getIndex(K key)
    {
        return hash(key) % capacity;
    }

    public V get(K key)
    {
        int bucketIndex = getIndex(key);
        int hashCode = hash(key);
        HashNode<K, V> node = hashArray.get(bucketIndex);

        while (node != null) {
            if (node.key==key && node.hashCode == hashCode)
                return node.value;
            node = node.next;
        }
        return null;
    }

    public void remove(K key)
    {
        int bucketIndex = getIndex(key);
        int hashCode = hash(key);
        HashNode<K, V> head = hashArray.get(bucketIndex);
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key == key && hashCode == head.hashCode){
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null)
            return;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            hashArray.set(bucketIndex, head.next);

    }


    public boolean contains(V value){
        for(HashNode<K,V> node : hashArray ){
            if(node != null && node.value == value) {
                return true;
            }
        }
        return false;
    }

    public K getKey(V value){
        for(HashNode<K,V> node : hashArray ){
            if(node != null && node.value == value) {
                return node.key;
            }
        }
        return null;
    }

    public void output(){
        System.out.print("{");
        for(HashNode<K,V> node : hashArray ){
            if(node != null){
                System.out.print(" <" + node.key + ": " + node.value + "> ");
            }

        }
        System.out.print("}");
    }
}

