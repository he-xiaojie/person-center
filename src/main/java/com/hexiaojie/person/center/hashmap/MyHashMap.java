package com.hexiaojie.person.center.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hexj-d
 * @date 2023/3/13 10:05
 */

public class MyHashMap {

    public interface MyMap<K,V>{

        V put(K k, V v);

        V get(K k);

        int size();

        V remove(K k);

        boolean isEmpty();

        void clear();
    }

    class  Entry<K,V>{
        K k;
        V v;
        Entry<K,V> next;

        public Entry(K k, V v, Entry<K,V> next){
            this.k = k;
            this.v = v;
            this.next = next;
        }

        final static int DEFAULT_CAPACITY = 16;
        final static float DEFAULT_LOAD_FACTOR = 0.75f;

        int capacity;
        float loadFactor;
        int size = 0;
        Entry<K,V>[] table;
    }
}
