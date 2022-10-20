package com.javarush.marzhiievskyi.wiev;

import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.field.GameField;
import com.javarush.marzhiievskyi.entity.organisms.Animals;
import com.javarush.marzhiievskyi.entity.organisms.Organism;


import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class ConsoleGUI {


    public void printField(GameField gameField) {
        Cell[][] fieldIsland = gameField.getFieldIsland();
        for (Cell[] cells : fieldIsland) {
            for (Cell cell : cells) {
                StringBuilder sb = new StringBuilder("[ ");
                Map<Organism, Set<Organism>> mapOfAnimalsOPnCell = cell.getMapOfAnimalsOnCell();
                mapOfAnimalsOPnCell.forEach((key, value) -> {
                    sb.append(key.toString()).append(": ").append(value.size());
                });
                sb.append(" ]");
                System.out.print(sb);
            }
            System.out.println();
        }
    }
}
