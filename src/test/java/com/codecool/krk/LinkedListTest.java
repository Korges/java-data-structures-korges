package com.codecool.krk;

import com.codecool.krk.linked.list.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {



    @Test
    void headTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(4);
        linkedList.append(1);
        linkedList.append(6);
        int result = 4;
        assertEquals(result, linkedList.getHead().getData());
    }

    @Test
    void addTest() {
        LinkedList linkedList = createList(11);
        String expected = "0 1 2 3 4 5 6 7 8 9 10 ";
        assertEquals(expected, linkedList.toString());
    }

    @Test
    void insertTest() {
        LinkedList linkedList = createList(11);
        linkedList.insert(1, 5);
        String expected = "0 5 1 2 3 4 5 6 7 8 9 10 ";
        assertEquals(expected, linkedList.toString());

    }

    @Test
    void lastTest() {
        LinkedList linkedList = createList(11);
        int expected = 10;
        Node node = linkedList.getLast();
        assertEquals(expected, node.getData());
    }

    @Test
    void removeFirstTest() {
        LinkedList linkedList = createList(11);
        linkedList.remove(0);
        String expected = "1 2 3 4 5 6 7 8 9 10 ";
        assertEquals(expected, linkedList.toString());
    }

    @Test
    void removeTest() {
        LinkedList linkedList = createList(11);
        linkedList.remove(1);
        String expected = "0 2 3 4 5 6 7 8 9 10 ";
        assertEquals(expected, linkedList.toString());
    }

    @Test
    void removeLastTest() {
        LinkedList linkedList = createList(11);
        linkedList.remove(10);
        String expected = "0 1 2 3 4 5 6 7 8 9 ";
        assertEquals(expected, linkedList.toString());
    }

    @Test
    void lengthTest() {
        LinkedList linkedList = createList(11);
        int expected = 11;
        assertEquals(expected, linkedList.getLength());
    }

    private LinkedList createList(int numOfElements) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < numOfElements; ++i)
        {
            list.append(i);
        }
        return list;
    }



}