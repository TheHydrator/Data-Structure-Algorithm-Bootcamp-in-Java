package HashMapandHashTable;
import org.w3c.dom.Entity;

import java.util.*;
public class HashMapFinal<K,V> {
    ArrayList<LinkedList<Entity>> list;
    private int size = 0;
    private float loadFactor = 0.5f; // 50% of the arraylist is filled with elements it will create a new arraylist and copy all the elements to the new arraylist in the 51st element.

    public HashMapFinal(){
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(new LinkedList<>());
        }
    }
    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        for(Entity entity: entities){
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }
        if((float)(size)/ list.size() > loadFactor){
            reHash();
        }

        entities.add(new Entity(key, value));
        size++;
    }

    private void reHash() {
        System.out.println("Rehashing");
        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();
        size = 0;
        for (int i = 0; i < old.size() * 2; i++) {
            list.add(new LinkedList<>());
        }
        for (LinkedList<Entity> entities : old){
            for (Entity entries : entities){
                put(entries.key, entries.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        for(Entity entity : entities){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        Entity target = null;
        for(Entity entity : entities){
            if(entity.key.equals(key)){
                target = entity;
                break;
            }
        }
        entities.remove(target);
        size--;
    }

    public boolean containsKey(K key){
        return get(key) != null; // if get(key) returns null then it means that the key is not present in the hashmap
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(LinkedList<Entity> entities :list){
            for(Entity entries : entities){
                if (entries  != null){
                    builder.append(entries.key);
                    builder.append(" = ");
                    builder.append(entries.value);
                    builder.append(" , ");
                }
            }
        }
        builder.append("}");
        return builder.toString(); // converting the string builder to string
    }

    private class Entity{
        private K key;
        private V  value;

        public Entity(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMapFinal<String, String> map = new HashMapFinal<>();
        map.put("Mango", "King of fruits");
        map.put("Apple", "A sweet red fruit");
        map.put("Litchi", "Rohit's favourite fruit");
        map.put("Guava", "A green fruit");
        System.out.println(map.get("Mango"));
        System.out.println(map);
    }

}

