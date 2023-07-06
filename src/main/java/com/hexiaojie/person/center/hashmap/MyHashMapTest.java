package com.hexiaojie.person.center.hashmap;

class MyHashMap<K,V> {


    static class Entry<K,V> {

        final K key;

        final int hash;

        V value;

        Entry<K,V> next;

        public Entry(int hash,K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    private Entry<K,V>[] table;


    private int size;


    private final float loadFactor;

    private int threashHold;


    public MyHashMap() {
        this.loadFactor = 0.75f;
        table = new Entry[16];
        threashHold = (int) (16 * loadFactor);
    }


    public V put(K key,V value){

        int h = key.hashCode();
        int index = h & (table.length - 1);
        for(Entry<K,V> entry = table[index];entry != null;entry = entry.next){
            if(h == entry.hash &&
                    (key == entry.getKey() || (key != null && key.equals(entry.getKey())))){

                V old = entry.getValue();
                entry.setValue(value);
                return old;
            }
        }
        Entry<K,V> newEntry = new Entry<>(h,key,value,table[index]);
        table[index] = newEntry;
        size++;
        return null;
    }


    public V get(K key){

        int h = key.hashCode();
        int index = h & (table.length - 1);
        for(Entry<K,V> entry = table[index];entry != null;entry = entry.next){
            if(h == entry.hash &&
                    (key == entry.getKey() || (key != null && key.equals(entry.getKey())))){
                return entry.getValue();
            }
        }
        return null;
    }

    public V remove(K key){
        int h = key.hashCode();
        int index = h & (table.length - 1);
        Entry<K,V> current = table[index];
        Entry<K,V>  prev = null;
        while(current != null){
            if(h == current.hash &&
                    (key == current.getKey() || (key != null && key.equals(current.getKey())))){
               if(prev == null){
                   table[index] = current.next;
               }else {
                   prev.next = current.next;
               }
               size--;
            }
            prev = current;
            current = current.next;


        }
        return null;
    }



    public int size(){

        return size;
    }


    public boolean isEmpty(){

        return size == 0;
    }




}
