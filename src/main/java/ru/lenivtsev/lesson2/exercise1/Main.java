package ru.lenivtsev.lesson2.exercise1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String name0 = "Abram";
        String name1 = "Bob";
        String name2 = "Cindy";
        String name3 = "Dilan";

        LinkedList<String> list = new LinkedList<>();
        list.add(name0);
        list.add(name1);
        list.add(name2);
        list.add(name3);

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(2));
        System.out.println(list.contains("Abram"));

        list.addFirst("Alfred");
        list.addLast("Frank");
        System.out.println(list);

        list.remove("Abram");
        System.out.println(list);

        list.addAll(List.of("Ann", "David"));
        System.out.println(list);

        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(list);

        list.set(0, "Bobby");
        System.out.println(list);

        Iterator<String> i = list.descendingIterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        list.clear();
        System.out.println(list);
    }
}
