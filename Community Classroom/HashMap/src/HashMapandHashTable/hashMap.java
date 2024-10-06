package HashMapandHashTable;
import java.util.HashMap;
import java.util.*;

class MapUsingHash{
    private Entity[] entities;

    public MapUsingHash(){
        entities = new Entity[100];
    }

    public void put(String key, String value) {
        int hash = Math.abs(key.hashCode() % entities.length);
            entities[hash] = new Entity(key, value); // overriding
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }
    }

    private class Entity{
        String key;
        String value;

        public Entity(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
class Main{
    public static void main(String[] args) {
        MapUsingHash map = new MapUsingHash();
        map.put("Mango", "King of fruits");
        map.put("Apple", "A sweet red fruit");
        map.put("Litchi", "Kunal's favourite fruit");
        System.out.println(map.get("Litchi"));

    }
}

public class hashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Kunal", 89);
        map.put("Karan", 90);
        map.put("Rahul", 94);
        System.out.println(map.get("Kunal"));

        // hash set is used to store unique elements
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(69);
        set.add(22);
        set.add(56);
        set.add(23);
        set.add(22);
        System.out.println(set);

        // TreeMap is used to store elements in sorted order
        // TreeMap has <key, value> a pair, and it is sorted according to key
        TreeMap<String, Integer> tree = new TreeMap<>();
        tree.put("Kunal", 89);
        tree.put("Karan", 90);
        tree.put("Rahul", 94);
        System.out.println(tree);
    }
}
