package com.company.tests.linkedList;

import com.company.list.MyLinkedList;

import java.util.LinkedList;

public class MyListVSLinkedList {
    public static void main(String[] args) {

        MyLinkedList<Integer> myList = new MyLinkedList<>();
        int size = 200000;
        int randNumber = (int) (Math.random() * size);
        for (int i = 0; i < size ; i++) {
            myList.addTail(i);
        }
        long timeMineStart = System.nanoTime();
        System.out.println(myList.remove(randNumber));
        long timeMineEnd = System.nanoTime();
        System.out.println("My list time: " + (timeMineEnd - timeMineStart));
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size ; i++) {
            linkedList.addFirst(i);
        }
        long timeOrigStart = System.nanoTime();
        System.out.println(linkedList.remove(randNumber));
        long timeOrigEnd = System.nanoTime();

        System.out.println("Original list time: " + (timeOrigEnd - timeOrigStart));


    }
}
