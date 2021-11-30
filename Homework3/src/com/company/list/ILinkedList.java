package com.company.list;

import java.util.Iterator;

public interface ILinkedList<E> extends Iterable {
    public void addHead(E element);
    public void addTail(E element);
    public void add(int index, E element);
    public void add(E element);
    public void clear();
    public E get(int index);
    public int indexOf(E element);
    public E remove(int index);
    public E set(int index, E element);
    public int size();
    public E[] toArray(E[] e);
    public Object[] toArray();
}
