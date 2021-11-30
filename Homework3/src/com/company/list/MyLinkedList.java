package com.company.list;

import com.sun.org.apache.bcel.internal.generic.ArrayInstruction;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Consumer;

public class MyLinkedList<E> implements ILinkedList<E>{


    @Override
    public Iterator<E> iterator() {
        class MyIterator implements Iterator<E> {
            private int indexHasNext = 0;
            private int indexNext = 0;
            private Node<E> lastReturned;
            private Node<E> next = tail;
            @Override
            public boolean hasNext() {
                indexHasNext++;
                return indexNext < size;
            }

            @Override
            public E next() {
                lastReturned = next;
                next = next.nextNode;
                indexNext++;
                return lastReturned.element;
            }
        }
        return new MyIterator();
    }

    private class Node<E> {
        E element;
        Node<E> nextNode;
        Node<E> prevNode;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    @Override
    public void addHead(E element) {
        Node<E> newNode = new Node<E>(element);
        if (head == null) {
            head = newNode;
            ++size;
            tail = newNode;
            newNode.prevNode = null;
            newNode.nextNode = null;
        } else {
            ++size;
            Node<E> tmpNode = head;
            head.nextNode = newNode;
            head = newNode;
            head.prevNode = tmpNode;
            head.nextNode = null;
        }
    }
    @Override
    public void addTail(E element) {
        Node<E> newNode = new Node<E>(element);
        if (tail == null) {
            tail = newNode;
            ++size;
            head = newNode;
            newNode.prevNode = null;
            newNode.nextNode = null;
        } else {
            ++size;
            Node<E> tmpNode = new Node<E>(element);
            tail.prevNode = newNode;
            tmpNode = tail;
            tail = newNode;
            tail.nextNode = tmpNode;
            tail.prevNode = null;
        }
    }


    @Override
    public void add(int index, E element) {
        Node<E> newNode = new Node<E>(element);
        Node<E> tmpNode = tail;
        Node<E> current = tmpNode;
        if (index == 0) {
            addTail(element);
        } else if (index == size) {
            addHead(element);
        } else  {
            for (int i = 0; i < index - 1; ++i) {
                tmpNode = tmpNode.nextNode;
            }
            current = tmpNode.nextNode;
            tmpNode.nextNode = newNode;
            newNode.prevNode = tmpNode;
            newNode.nextNode = current;
            ++size;
        }
    }

    @Override
    public void add(E element) {
        addHead(element);
    }


    @Override
    public void clear() {
        Node<E> tmp = tail;
        while (tmp != null) {
            Node<E> current = tmp.nextNode;
            tmp.element = null;
            tmp.nextNode = null;
            tmp.prevNode = null;
            tmp = current;
        }
        tail = null;
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> tmpNode = tail;
        for (int i = 0; i < index; ++i) {
            tmpNode = tmpNode.nextNode;
        }
        return tmpNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> tmpNode = tail;
        for (int i = 0; i < size; ++i) {
            if (tmpNode.element.equals(element)) {
                return i;
            }
            tmpNode = tmpNode.nextNode;
        }
        return -1;
    }
    public E removeHead() {
        E tmp = head.element;
        head = head.prevNode;
        head.nextNode = null;
        size--;
        return  tmp;
    }

    public E removeTail() {
        E tmp = tail.element;
        tail = tail.nextNode;
        tail.prevNode = null;
        size--;
        return  tmp;
    }
    @Override
    public E remove(int index) {
        if (index == 0) {
            return removeTail();
        }
        if (index == size - 1) {
            return removeHead();
        }
        Node<E> tmpNode = tail;
        for (int i = 0; i < index; ++i) {
            tmpNode = tmpNode.nextNode;
        }
        Node<E> current1 = tmpNode.prevNode;
        Node<E> current2 = tmpNode.nextNode;
        current1.nextNode = tmpNode.nextNode;
        current2.prevNode = tmpNode.prevNode;
        --size;
        return tmpNode.element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> tmpNode = tail;
        E current;
        for (int i = 0; i < index; ++i) {
            tmpNode = tmpNode.nextNode;
        }
        current = tmpNode.element;
        tmpNode.element = element;
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray(E[] e) {
        Node<E> tmpNode = tail;
        for (int i = 0; i < e.length; i++) {
            e[i] = tmpNode.element;
            tmpNode = tmpNode.nextNode;
        }
        return e;
    }

    @Override
    public Object[] toArray() {
        Node<E> tmpNode = tail;
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = tmpNode.element;
            tmpNode = tmpNode.nextNode;
        }
        return array;
    }

    public void print() {
        Node<E> tmp = tail;
        for (int i = 0; i < size; ++i) {
            System.out.print(tmp.element + " ");
            tmp = tmp.nextNode;
        }
        System.out.println();
    }
}
