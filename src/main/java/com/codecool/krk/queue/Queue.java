package com.codecool.krk.queue;

import com.codecool.krk.queue.exception.*;

public class Queue {

    private Node head;
    private Node tail;

    public void enqueue (String value) {
        Node node = new Node(value);
        if(tail != null) {
            tail.setNextNode(node);
        }
        tail = node;
        if(head == null) {
            head = node;
        }



    }
    public String peek() throws QueueUnderFlow {
        if(head==null) {
            throw new QueueUnderFlow("Queue is empty!");
        }
        return this.head.getValue();

    }
    public String dequeue() throws QueueUnderFlow {
        if(head == null) {
            throw new QueueUnderFlow("Queue is empty!");
        }
        String data = head.getValue();
        head = head.getNextNode();
        if(head == null) {
            tail = null;
        }
        return data;
    }

    public int getQueueSize() {

        int nodeCounter = 0;

        Node node = head;
        while(node!=null) {
            nodeCounter++;
            node = node.getNextNode();

        }
        return nodeCounter;
    }

    public boolean isEmpty() {
        return head == null;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node node = head;
        while (node != null) {
            builder.append(" " + node.getValue());
            node = node.getNextNode();
        }
        return builder.toString();
    }
}

