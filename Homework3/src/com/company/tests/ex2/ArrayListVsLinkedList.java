package com.company.tests.ex2;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int size = 100000;
        // ADD

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long startArray = System.nanoTime();
        arrayList.add(100);
        long endArray = System.nanoTime();
        System.out.println("Array list time to add : " + (endArray - startArray) );

        for (int i = 0; i < size; i++) {
            linkedList.addFirst(i);
        }
        long startList = System.nanoTime();
        linkedList.addLast(100);
        long endList = System.nanoTime();
        System.out.println("Linked list time to add : " + (endList - startList));
    }
}
