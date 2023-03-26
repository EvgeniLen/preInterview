package ru.lenivtsev.lesson2.exercise1;

public class Main {
    public static void main(String[] args) {
        String name0 = "Abram";
        String name1 = "Bob";
        String name2 = "Cindy";
        String name3 = "Dilan";

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(name0);
        myLinkedList.add(name1);
        myLinkedList.add(name2);
        myLinkedList.add(name3);

        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.getLast());
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println("Remove - " + myLinkedList.remove(0));
        System.out.println(myLinkedList.get(0));

        System.out.println(myLinkedList.indexOf("Abram"));
        System.out.println(myLinkedList.indexOf("Dilan"));
    }
}
