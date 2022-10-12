package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.services.GenerateOrganisms;

public class Field {
    Cell cell;
    private final Cell[][] fieldIsland = new Cell[20][100];



    public void initField() {
        for (int i = 0; i < fieldIsland.length; i++) {
            for (int j = 0; j < fieldIsland[i].length; j++) {
                cell = new Cell();
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
