package com.codecool.krk;

import com.codecool.krk.hash.map.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMapTest {

    @Test
    void getValueTest() {
        HashMap hashMap = new HashMap<>();
        hashMap.add("key2", 55);
        hashMap.add("key3", 45);
        hashMap.add("key5", 23);
        int expected = 45;
        assertEquals(expected, hashMap.getValue("key3"));
    }

    @Test
    void removeTest() {

        HashMap hashMap = new HashMap<>();
        hashMap.add("key2", 55);
        hashMap.add("key3", 45);
        hashMap.add("key5", 23);
        hashMap.remove("key5");
        hashMap.getValue("key5");
        assertEquals(null, hashMap.getValue("key5"));
    }

    @Test
    void clearTest() {
        HashMap hashMap = new HashMap();
        hashMap.add("key2", 55);
        hashMap.add("key3", 45);
        hashMap.add("key5", 23);
        hashMap.clearAll();
        assertEquals(null, hashMap.getValue("key2"));
    }
}