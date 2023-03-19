package ru.lenivtsev.lesson2.exercise2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String name0 = "Abram";
        String name1 = "Bob";
        String name2 = "Cindy";
        String name3 = "Dilan";

        ArrayList<String> list = new ArrayList<>();
        list.add(name0);
        list.add(name1);
        list.add(name2);
        list.add(name3);
        System.out.println(list);

        list.add("David");
        System.out.println(list.contains("David"));
        System.out.println(list.get(list.size()-1));
        System.out.println(list.indexOf("Cindy"));

        list.forEach(System.out::println);

        list.set(0, "Ann");
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        list.clear();
        System.out.println(list);
    }
}
