package ru.lenivtsev.lesson1.exercise3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Square extends Figure{
    private int a;

    @Override
    public double calculateSquare() {
        System.out.println("Площадь квадрата - ");
        return Math.pow(a, 2);
    }
}
