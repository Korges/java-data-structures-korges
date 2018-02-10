package com.codecool.krk;

import com.codecool.krk.stack.*;
import com.codecool.krk.stack.exception.StackOverflow;
import com.codecool.krk.stack.exception.StackUnderflow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StackTest {


    @Test
    void pushTest() throws StackOverflow {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        Integer expected = 7;
        assertEquals(expected, stack.peek());
    }

    @Test
    void popTest() throws StackOverflow, StackUnderflow {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.pop();
        Integer expected = 3;
        assertEquals(expected, stack.peek());
    }

    @Test
    void sizeTest() {
        Stack<Integer> stack = new Stack<Integer>(10);
        int expected = 10;
        assertEquals(expected, stack.getStackSize());
    }

    @Test
    void freeSpaceTest() throws StackUnderflow, StackOverflow {
        Stack<Integer> stack = new Stack<Integer>(5);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        int expected = 2;
        assertEquals(expected, stack.getFreeSpace());
    }

}