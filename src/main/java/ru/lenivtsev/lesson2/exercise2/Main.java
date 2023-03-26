package ru.lenivtsev.lesson2.exercise2;

public class Main {
    public static void main(String[] args) {
        String name0 = "Abram";
        String name1 = "Bob";
        String name2 = "Cindy";
        String name3 = "Dilan";

        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add(name0);
        myArrayList.add(name1);
        myArrayList.add(null);
        System.out.println(myArrayList.getSize());
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(1));
        System.out.println(myArrayList.indexOf(null));

        System.out.println(myArrayList.remove(0));
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(1));


    }
}
