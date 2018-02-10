package com.codecool.krk.stack;

import com.codecool.krk.stack.exception.StackOverflow;
import com.codecool.krk.stack.exception.StackUnderflow;


public class Stack<E> {
    private int top=-1;
    private int size = 5;
    private E[] stack;

    public Stack() {
        this.stack = (E[]) new Object[size];
    }

    public Stack(int size) {
        this.size = size;
        this.stack = (E[]) new Object[size];
    }

    public void push(E data) throws StackOverflow {
        if(top == size) {
            throw new StackOverflow(String.format("Stack is full, cannot push %s", data));

        }
        this.stack[++top] = data;
    }

    public E pop() throws StackUnderflow {
        if (top == -1) {
            throw new StackUnderflow("Stack is empty, cannot pop");
        }
        return stack[top--];
    }

    public E peek() {
        if(top == -1) {
            System.out.println("Stack is empty, cannot peek");
        }
        return stack[top];
    }

    public int getStackSize() {
        return this.size;
    }

    public int getFreeSpace() {
        return this.size - top - 1;
    }


}
