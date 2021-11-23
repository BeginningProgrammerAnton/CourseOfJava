package com.company.tests.myList;

import com.company.list.MyLinkedList;

public class TestMethodsInt {
    public static void main(String[] args) {
        MyLinkedList<Integer> myListInt = new MyLinkedList<>();
        myListInt.addHead(10);
        myListInt.addHead(11);
        myListInt.addHead(12);
        System.out.println(10 == myListInt.get(0));
        System.out.println(11 == myListInt.get(1));
        System.out.println(12 == myListInt.get(2));
        myListInt.print();
        myListInt.addTail(7);
        myListInt.addTail(6);
        myListInt.addTail(5);
        myListInt.print();
        System.out.println(5 == myListInt.get(0));
        System.out.println(6 == myListInt.get(1));
        System.out.println(7 == myListInt.get(2));
        System.out.println(10 == myListInt.get(3));
        System.out.println(11 == myListInt.get(4));
        System.out.println(12 == myListInt.get(5));
        myListInt.print();

        myListInt.add(0,66);
        myListInt.add(3,55);
        myListInt.print();
        System.out.println(66 == myListInt.get(0));
        System.out.println(5 == myListInt.get(1));
        System.out.println(6 == myListInt.get(2));
        System.out.println(55 == myListInt.get(3));
        System.out.println(7 == myListInt.get(4));
        System.out.println(10 == myListInt.get(5));
        System.out.println(11 == myListInt.get(6));
        System.out.println(12 == myListInt.get(7));
        myListInt.print();
        System.out.println(8 == myListInt.size());
        myListInt.remove(7);
        myListInt.remove(0);
        myListInt.remove(4);
        myListInt.print();
        System.out.println(5 == myListInt.size());
        System.out.println(5 == myListInt.get(0));
        System.out.println(6 == myListInt.get(1));
        System.out.println(55 == myListInt.get(2));
        System.out.println(7 == myListInt.get(3));
        System.out.println(11 == myListInt.get(4));
        myListInt.print();
        System.out.println(2 == myListInt.indexOf(55));
        myListInt.set(3,8);
        System.out.println(8 == myListInt.get(3));
        myListInt.clear();
        myListInt.print();
        System.out.println(0 == myListInt.size());
        myListInt.addTail(7);
        myListInt.addTail(6);
        myListInt.addTail(5);
        for (Object i :myListInt) {
            System.out.print(i + " ");
        }
    }
}
