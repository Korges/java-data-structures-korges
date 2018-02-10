package com.codecool.krk.dynamic.array;

public class DynamicArray {

    private static final int SIZE_FACTOR = 5;
    private int size;
    private Object[] dynamicArray;
    private int index;


    public DynamicArray() {

        this.size = SIZE_FACTOR;
        this.dynamicArray = new Object[SIZE_FACTOR];
    }


    public DynamicArray(int size) {

        this.size = size;
        dynamicArray = new Object[size];
    }


    public void add(Object element) {

        if(ifFreeSpace()) {
            increaseArraySize();
        }
        dynamicArray[index++] = element;
    }


    public boolean ifFreeSpace() {
        return index == size;
    }


    public void increaseArraySize() {

        this.size = size + 1;
        Object[] temp = new Object[size];

        for(int i=0;i<dynamicArray.length;i++) {
            temp[i]= dynamicArray[i];
        }
        this.dynamicArray = temp;
    }

    public Object get(int position) throws Exception {

        if(position>index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        } if (position<0) {
            throw new Exception("Negative Value");
        } else {
            return this.dynamicArray[position];
        }
    }


    public void insert(int position, Object element) {

        if(position>=index) {
            add(element);
        } else {
            this.size = size + 1;
            this.index = 0;
            Object[] temp = new Object[size];
            for(Object value: this.dynamicArray) {
                if(index == position) {
                    temp[index++] = element;
                }
                temp[index++] = value;
            }
            this.dynamicArray = temp;
        }
    }


    public void removeByElement(Object element) {

        int i = 0;
        Object[] temp = new Object[--size];
        for(Object value : dynamicArray) {
            if(value!= element) {
                temp[i++] = value;
            }
        }
        this.dynamicArray = temp;
    }


    public void removeByPosition(int position) throws Exception {
        if(position>=this.index) {
            throw new Exception("ArrayIndexOutOfBound");
        } if (position<0) {
            throw new Exception("Negative Value");
        } else {
            for(int i=position; i<this.dynamicArray.length-1;i++) {
                this.dynamicArray[i] = this.dynamicArray[i+1];
            }
            this.index--;
        }
    }


    @Override
    public String toString() {


        StringBuilder builder = new StringBuilder();
        for (int i=0; i<index; i++ ) {
            builder.append(" " + this.dynamicArray[i]);
        }
        return builder.toString();
    }
}
