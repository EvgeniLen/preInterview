package ru.lenivtsev.lesson1.exercise1;

public class Main {
    public static void main(String[] args) {
        Person person = Person.Builder.newBuilder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setMiddleName("Ivanovich")
                .setGender("male")
                .build();

    }
}
