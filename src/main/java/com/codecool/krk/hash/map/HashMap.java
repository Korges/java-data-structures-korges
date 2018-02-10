package com.codecool.krk.hash.map;

import java.util.LinkedList;


public class HashMap<K, V> {

    private int initialSize = 16;

    private LinkedList<KeyValue>[] hashMap;

    public HashMap() {

        this.hashMap =  new LinkedList[initialSize];
        for(int i=0; i<initialSize; i++) {
            this.hashMap[i] = new LinkedList<>();
        }
    }


    public void add(K key, V value) {
        int index = getHash(key);
        LinkedList<KeyValue> list = this.hashMap[index];
        list.add(new KeyValue(key, value));
    }


    private int getHash(K key) {

        return key.hashCode()%this.initialSize;
    }


    public V getValue(K key) {

        int index = getHash(key);
        LinkedList<KeyValue> list = this.hashMap[index];
        V value = null;
        for(KeyValue kv : list) {
            if(kv.key == key) {
                value = (V) kv.value;
            }

        }
        return value;
    }


    public void remove(K key) {

        int index = getHash(key);
        LinkedList<KeyValue> list = this.hashMap[index];
        for(int i=0; i< list.size(); i++) {
            if(list.get(i).key == key) {
                this.hashMap[index].remove(i);
            }
        }
    }


    public void clearAll() {
        for(LinkedList list: hashMap) {
            list.clear();
        }
    }
}
