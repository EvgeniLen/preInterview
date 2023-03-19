package ru.lenivtsev.lesson1.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Circle(2));
        figures.add(new Square(2));
        figures.add(new Triangle(2));

        figures.forEach(f -> {
            System.out.println(f.calculateSquare());
                });
    }
}
