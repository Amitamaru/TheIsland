package com.javarush.marzhiievskyi.wiev;

import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.field.GameField;
import com.javarush.marzhiievskyi.entity.organisms.Organism;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class ConsoleGUI {
    private GameField gameField;

    public void initialisation(int rows, int cols) throws IOException {
        gameField = new GameField(rows, cols);
        gameField.initField();
    }

    public void printField() {
        Cell[][] fieldIsland = gameField.getFieldIsland();
        for (int i = 0; i < fieldIsland.length; i++) {
            for (int j = 0; j < fieldIsland[i].length; j++) {
                Map<Organism, Set<Organism>> mapOfAnimalsOPnCell = fieldIsland[i][j].getMapOfAnimalsOnCell();

                System.out.print("[");

                for (var organism : mapOfAnimalsOPnCell.entrySet()) {
                    String type = organism.getKey().toString();
                    int count = organism.getValue().size();

                        System.out.print(type + " : " + (new DecimalFormat("000").format(count)) + "; ");


                }

                System.out.print(("] "));
            }
            System.out.println();
        }
    }
}
