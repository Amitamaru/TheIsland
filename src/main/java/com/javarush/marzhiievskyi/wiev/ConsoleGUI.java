package com.javarush.marzhiievskyi.wiev;

import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.field.GameField;
import com.javarush.marzhiievskyi.entity.organisms.Organism;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class ConsoleGUI {


    public void printField(GameField gameField) {
        Cell[][] fieldIsland = gameField.getFieldIsland();
        for (Cell[] cells : fieldIsland) {
            for (Cell cell : cells) {
                Map<Organism, Set<Organism>> mapOfAnimalsOPnCell = cell.getMapOfAnimalsOnCell();

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
