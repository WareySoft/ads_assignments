public class Main {
    public static void main(String[] args)
    {
        MyHashTable<String, Integer> HashTable = new MyHashTable<>(10);
        HashTable.put("A", 111);
        HashTable.put("B", 22222);
        HashTable.put("C", 33333);
        HashTable.put("D", 5);
        HashTable.put("hisss", 5);  // overwriting
        System.out.println(HashTable.size());
        HashTable.remove("B");
        System.out.println(HashTable.size());
        System.out.println(HashTable.get("B"));
        System.out.println(HashTable.get("D"));
        System.out.println(HashTable.hash("D"));
        System.out.println(HashTable.getIndex("D"));
        System.out.println(HashTable.contains(22222));
        System.out.println(HashTable.getKey(5));
        HashTable.output();
    }
}
