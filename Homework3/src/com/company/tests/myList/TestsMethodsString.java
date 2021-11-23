package com.company.tests.myList;

import com.company.list.MyLinkedList;

public class TestsMethodsString {
    public static void main(String[] args) {
        MyLinkedList<String> myListString = new MyLinkedList<>();
        myListString.addHead("Hello");
        myListString.addHead("my");
        myListString.addHead("dear");
        System.out.println("Hello" == myListString.get(0));
        System.out.println("my" == myListString.get(1));
        System.out.println("dear" == myListString.get(2));
        myListString.print();
        myListString.addTail("ANYBODY");
        myListString.addTail("ALL");
        myListString.addTail("HELLO");
        myListString.print();
        System.out.println("HELLO" == myListString.get(0));
        System.out.println("ALL" == myListString.get(1));
        System.out.println("ANYBODY" == myListString.get(2));
        System.out.println("Hello" == myListString.get(3));
        System.out.println("my" == myListString.get(4));
        System.out.println("dear" == myListString.get(5));
        myListString.print();
        myListString.add(0,"stop");
        myListString.add(3,"wait");
        myListString.print();
        System.out.println("stop" == myListString.get(0));
        System.out.println("HELLO" == myListString.get(1));
        System.out.println("ALL" == myListString.get(2));
        System.out.println("wait" == myListString.get(3));
        System.out.println("ANYBODY" == myListString.get(4));
        System.out.println("Hello" == myListString.get(5));
        System.out.println("my" == myListString.get(6));
        System.out.println("dear" == myListString.get(7));
        myListString.print();
        System.out.println(8 == myListString.size());
        myListString.remove(7);
        myListString.remove(0);
        myListString.remove(4);
        myListString.print();
        System.out.println(5 == myListString.size());
        System.out.println("HELLO" == myListString.get(0));
        System.out.println("ALL" == myListString.get(1));
        System.out.println("wait" == myListString.get(2));
        System.out.println("ANYBODY" == myListString.get(3));
        System.out.println("my" == myListString.get(4));
        myListString.print();
        System.out.println(2 == myListString.indexOf("wait"));
        myListString.set(3,"onemore");
        System.out.println("onemore" == myListString.get(3));
        myListString.clear();
        myListString.print();
        System.out.println(0 == myListString.size());
        myListString.addTail("ANYBODY");
        myListString.addTail("ALL");
        myListString.addTail("HELLO");
        for (Object i :myListString) {
            System.out.print(i + " ");
        }
    }
    
}

