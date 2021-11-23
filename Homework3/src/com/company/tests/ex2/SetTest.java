package com.company.tests.ex2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {
        // sort on hash
        HashSet<Integer> hashSet = new HashSet<>();
        // sort on add
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        // sort on vozrastanie
        TreeSet<Integer> treeSet = new TreeSet<>();
        int size = 150000;

        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }
        long startHash = System.nanoTime();
        hashSet.remove(size/2);
        long endHash = System.nanoTime();
        System.out.println("Hash set time to add : " + (endHash - startHash) );
        for (int i = 0; i < size; i++) {
            linkedHashSet.add(i);
        }
        long startLinked = System.nanoTime();

        linkedHashSet.remove(size/2);
        long endLinked = System.nanoTime();
        System.out.println("Linked hash set time to add : " + (endLinked - startLinked));

        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }
        long startTree = System.nanoTime();
        treeSet.remove(size / 2);
        long endTree = System.nanoTime();
        System.out.println("TreeSet time to add : " + (endTree - startTree));
    }
}
