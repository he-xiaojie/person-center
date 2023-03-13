package com.hexiaojie.person.center.hashmap;

public interface MyMap<K,V>{

        V put(K k, V v);

        V get(K k);

        int size();

        V remove(K k);

        boolean isEmpty();

        void clear();
    }