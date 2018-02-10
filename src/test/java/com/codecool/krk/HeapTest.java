package com.codecool.krk;

import com.codecool.krk.heap.Heap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapTest {

    @Test
    void createTest() {
        Heap heap = new Heap();
        createHeap(heap);
        String expected = "2 4 6 8 10 12 14 16 18 20 ";
        assertEquals(expected, heap.toString());
    }

    @Test
    void peekTest() {
        Heap heap = new Heap();
        createHeap(heap);
        int expected = 2;
        assertEquals(expected, heap.peek());
    }

    @Test
    void poolReturnTest() {
        Heap heap = new Heap();
        createHeap(heap);
        int expected = 2;
        assertEquals(expected, heap.pool());
    }

    @Test
    void poolRootTest() {
        Heap heap = new Heap();
        createHeap(heap);
        heap.pool();
        int expected = 4;
        assertEquals(expected, heap.pool());
    }

    @Test
    void addTest() {
        Heap heap = new Heap();
        createHeap(heap);
        heap.add(1);
        heap.add(7);
        heap.add(11);
        String expected = "1 2 6 8 4 7 14 16 18 20 10 12 11 ";
        assertEquals(expected, heap.toString());
    }

    @Test
    void poolTest() {
        Heap heap = new Heap();
        createHeap(heap);
        heap.pool();
        String expected = "4 8 6 16 10 12 14 20 18 20 ";
        assertEquals(expected, heap.toString());
    }

    void createHeap(Heap heap) {
        for (int i=1; i< 11; i++) {
            heap.add(i*2);
        }
    }
}