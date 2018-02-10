package com.codecool.krk;

import com.codecool.krk.queue.exception.*;
import com.codecool.krk.queue.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueueTest {


    @Test
    void enqueueTest() {
        Queue queue = new Queue();
        queue.enqueue("5");
        queue.enqueue("7");
        queue.enqueue("4");
        String excepted = " 5 7 4";
        assertEquals(excepted, queue.toString());
    }

    @Test
    void peekTest() throws QueueUnderFlow {
        Queue queue = new Queue();
        queue.enqueue("5");
        String excepted = "5";
        assertEquals(excepted, queue.peek());
    }

    @Test
    void dequeueTest() throws QueueUnderFlow {
        Queue queue = createQueue(5);
        queue.dequeue();
        String excepted = "1";
        assertEquals(excepted, queue.peek());
    }

    @Test
    void booleanIsTrueTest() {
        Queue queue = new Queue();
        boolean excepted = true;
        assertEquals(excepted, queue.isEmpty());
    }

    @Test
    void dequeueBooleanIsTrueTest() throws QueueUnderFlow {
        Queue queue = new Queue();
        queue.enqueue("6");
        queue.dequeue();
        boolean excepted = true;
        assertEquals(excepted, queue.isEmpty());

    }

    @Test
    void dequeueEmptyQueue() {
        Queue queue = new Queue();

        assertThrows(QueueUnderFlow.class, ()-> {queue.dequeue();}
        );
    }

    @Test
    void peekEmptyQueue() {
        Queue queue = new Queue();

        assertThrows(QueueUnderFlow.class, ()-> {queue.peek();}
        );
    }

    @Test
    void queueSizeTest() {
        Queue queue = createQueue(10);
        int excepted = 10;
        assertEquals(excepted, queue.getQueueSize());
    }



    private Queue createQueue(int numOfElements) {
        Queue queue = new Queue();
        for (int i = 0; i < numOfElements; ++i)
        {
            queue.enqueue(String.valueOf(i));
        }
        return queue;
    }

}