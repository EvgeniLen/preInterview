package ru.lenivtsev.lesson2.exercise2;

import java.util.Arrays;

public class MyArrayList<E>{
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private Object[] arr;
    private static final Object[] DEFAULT_ARR = {};

    public MyArrayList() {
        this.arr = DEFAULT_ARR;
    }

    public boolean add(E e) {
        if (size == this.arr.length) {
            arr = enlargeArr();
        }
        arr[size] = e;
        size++;
        return true;
    }

    private Object[] enlargeArr(){
        int oldSize = arr.length;
        if (oldSize != 0) {
            return Arrays.copyOf(arr, oldSize + DEFAULT_SIZE);
        } else {
            return new Object[DEFAULT_SIZE];
        }
    }

    public Object get(int i) throws ArrayIndexOutOfBoundsException{
        checkIndex(i);
        return arr[i];
    }

    private void checkIndex(int i){
        if (i >= size || i < 0) {
            throw new ArrayIndexOutOfBoundsException("Error");
        }
    }

    public int indexOf(E e) {
        if (e == null){
            for (int i = 0; i < size; i++) {
                if (arr[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
               if (e.equals(arr[i])) {
                   return i;
               }
            }
        }
        return -1;
    }

    public E remove(int i){
        checkIndex(i);
        E oldValue = (E) arr[i];
        int newSize = size - 1;
        if (newSize > i) {
            System.arraycopy(arr, i + 1, arr, i, newSize - i);
        }
        arr[size = newSize] = null;
        return oldValue;
    }

    public int getSize() {
        return size;
    }
}
