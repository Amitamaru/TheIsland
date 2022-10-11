package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.animals.Animal;

import java.util.List;

public class Cell {

    private final int X;
    private final int Y;

    private List<Animal> animals;



    public Cell(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "[" + Y +" "+ X + "]";
    }
}
