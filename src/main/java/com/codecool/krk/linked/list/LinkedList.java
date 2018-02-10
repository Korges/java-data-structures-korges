package com.codecool.krk.linked.list;

public class LinkedList {

    Node head;
    Node last;
    int length;

    public LinkedList() {
        this.head = null;
    }

    public void append(int data) {

        Node node = new Node(data);
        node.setNext(null);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
    }

    public void insert(int index, int data) {

        if (index==0) {
            Node node = new Node(data);
            node.setNext(head);
            head = node;
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for(int i=0; i<index-1; i++) {
                current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public void remove(int index) {

        if(index == 0) {
            head = head.getNext();
        } else {
            Node current = head;
            for(int i=0; i<index-1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {

        while(head!= null) {
            length++;
            head = head.getNext();
        }
        return length;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.getData() + " ");
            head = head.getNext();
        }
        return sb.toString();
    }
}
