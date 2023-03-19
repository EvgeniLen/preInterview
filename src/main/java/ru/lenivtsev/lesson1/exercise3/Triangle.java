package ru.lenivtsev.lesson1.exercise3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Triangle extends Figure{
    private int a;

    @Override
    public double calculateSquare() {
        System.out.println("Площадь треугольника - ");
        return (Math.sqrt(3) * Math.pow(a, 2))/4;
    }
}
