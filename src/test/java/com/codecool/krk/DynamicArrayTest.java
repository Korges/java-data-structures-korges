package com.codecool.krk;

import com.codecool.krk.dynamic.array.DynamicArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DynamicArrayTest {

    @Test
    void DynamicArrayTest_WithInitialSize() {
        new DynamicArray(15);
    }

    @Test
    void addTest() {
        DynamicArray array = createArray(11);
        array.add(32);
        array.add(42);
        String result = " 0 1 2 3 4 5 6 7 8 9 10 32 42";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest() {
        DynamicArray array = createArray(11);
        array.removeByElement(5);
        array.removeByElement(0);
        String result = " 1 2 3 4 6 7 8 9 10";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_LastItem() {
        DynamicArray array = createArray(10);
        array.removeByElement(9);
        String result = " 0 1 2 3 4 5 6 7 8";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_InvalidItem() {
        DynamicArray array = createArray(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.removeByElement(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.removeByElement(-1));
    }

    @Test
    void removeByIdTest() throws Exception {
        DynamicArray array = createArray(11);
        array.removeByPosition(10);
        array.removeByPosition(8);
        String result = " 0 1 2 3 4 5 6 7 9";
        assertEquals(result, array.toString());
    }

    @Test
    void insertTest() {
        DynamicArray array = createArray(11);
        array.insert(8, 223);
        array.insert(100, 654);

        String result = " 0 1 2 3 4 5 6 7 223 8 9 10 654";
        assertEquals(result, array.toString());
    }

    private DynamicArray createArray(int numOfElements) {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < numOfElements; i++)
        {
            array.add(i);
        }
        return array;
    }
}