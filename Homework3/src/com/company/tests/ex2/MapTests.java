package com.company.tests.ex2;

import java.util.*;

public class MapTests {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        int size = 1000000;

        for (Integer i = 0; i < size; i++) {
            hashMap.put(i,i.toString());
        }
        long startHash = System.nanoTime();
        hashMap.remove(5555);
        long endHash = System.nanoTime();
        System.out.println("Hash set time to add : " + (endHash - startHash) );

        for (Integer i = 0; i < size; i++) {
            linkedHashMap.put(i,i.toString());
        }
        long startLinked = System.nanoTime();
        linkedHashMap.remove(5555);
        long endLinked = System.nanoTime();
        System.out.println("Linked hash set time to add : " + (endLinked - startLinked));

        for (Integer i = 0; i < size; i++) {
            treeMap.put(i,i.toString());
        }
        long startTree = System.nanoTime();
        treeMap.remove(5555);
        long endTree = System.nanoTime();
        System.out.println("TreeSet time to add : " + (endTree - startTree));
    }
}
