package ru.lenivtsev.lesson1.exercise3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Circle extends Figure{
    private int r;

    @Override
    public double calculateSquare() {
        System.out.println("Площадь круга - ");
        return 3.14 * Math.pow(r, 2);
    }
}
