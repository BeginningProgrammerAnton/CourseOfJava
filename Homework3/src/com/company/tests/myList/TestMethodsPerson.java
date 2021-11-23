package com.company.tests.myList;

import com.company.list.MyLinkedList;

public class TestMethodsPerson {

    public static void main(String[] args) {
        Person per1 = new Person("Anton",22,"Polovinkin","Novgorod");
        Person per2 = new Person("Antony",31,"Dream","Monaco");
        Person per3 = new Person("Dima",11,"Kid","Saratov");
        Person per4 = new Person("Dimitrio",43,"Italiano","Rome");
        MyLinkedList<Person> myListPerson= new MyLinkedList<>();
        myListPerson.addHead(per1);
        myListPerson.print();
        myListPerson.addHead(per4);
        myListPerson.print();
        myListPerson.addTail(per3);
        myListPerson.print();
        System.out.println(myListPerson.indexOf(per3) == 0);
        System.out.println(3 == myListPerson.size());
        myListPerson.removeTail();
        System.out.println(2 == myListPerson.size());
        myListPerson.print();
        myListPerson.add(2,per1);
        myListPerson.add(1,per1);
        myListPerson.print();
        myListPerson.remove(1);
        myListPerson.print();
    }
}
