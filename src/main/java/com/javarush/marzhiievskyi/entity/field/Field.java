package com.javarush.marzhiievskyi.entity.field;

import java.util.Arrays;

public class Field {
    Cell cell;
    private Cell[][] fieldIsland = new Cell[20][100];



    public void print() {
        for (int i = 0; i < fieldIsland.length; i++) {
            for (int j = 0; j < fieldIsland[i].length; j++) {

                System.out.print(cell = new Cell());
            }
            System.out.println();
        }
    }
}
