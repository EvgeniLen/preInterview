package ru.lenivtsev.lesson2.exercise1;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    public MyLinkedList() {
    }

    private int size;

    private Elem<E> first;
    private Elem<E> last;

    public boolean add(E e) {
        Elem<E> l = last;
        Elem<E> addedElem = new Elem<>(e, l, null);
        last = addedElem;
        if (l == null) {
            first = addedElem;
        } else {
            l.next = addedElem;
        }
        size++;
        return true;
    }

    private Elem<E> findElem(int i) {
        if (i < size/2){
            Elem<E> f = first;
            for (int j = 0; j < i; j++) {
                f = f.next;
            }
            return f;
        } else {
            Elem<E> l = last;
            for (int j = size-1; j > i; j--) {
                l = l.prev;
            }
            return l;
        }
    }

    public E get(int i) {
        checkIndex(i);
        return findElem(i).item;
    }

    private void checkIndex(int i){
        if (i >= size || i < 0) {
            throw new ArrayIndexOutOfBoundsException("Error");
        }
    }

    public E getFirst() {
        final Elem<E> e = first;
        if (e == null)
            throw new NoSuchElementException();
        return e.item;
    }

    public E getLast() {
        final Elem<E> e = last;
        if (e == null)
            throw new NoSuchElementException();
        return e.item;
    }

    public E remove(int i){
        checkIndex(i);
        Elem<E> e = findElem(i);
        return removeElem(e);
    }

    private E removeElem(Elem<E> e) {
        E elem = e.item;
        Elem<E> prev = e.prev;
        Elem<E> next = e.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;

        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        e.prev = null;
        e.next = null;
        e.item = null;
        size--;
        return elem;
    }

    public int indexOf(Object e) {
        int i = 0;
        for (Elem<E> f = first; f != null; f = f.next) {
            if (e == null && f.item == null) {
                return i;
            } else if ( e != null && e.equals(f.item)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static class Elem<E> {
        E item;

        Elem<E> prev;
        Elem<E> next;


        public Elem(E item, Elem<E> prev, Elem<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }



    public int getSize() {
        return size;
    }
}
