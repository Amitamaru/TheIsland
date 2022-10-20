package com.javarush.marzhiievskyi.wiev;

import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.field.GameField;
import com.javarush.marzhiievskyi.entity.organisms.Organism;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsoleGUI {


    public void printField(GameField gameField) {
        System.out.println();
        Cell[][] fieldIsland = gameField.getFieldIsland();
        for (Cell[] cells : fieldIsland) {
            for (Cell cell : cells) {

                StringBuilder sb = new StringBuilder("[ ");
                Map<Organism, Set<Organism>> mapOfAnimalsOPnCell = cell.getMapOfAnimalsOnCell();
                mapOfAnimalsOPnCell.forEach((key, value) -> {
                    sb.append(" ").append(key.toString()).append(": ").append(value.size());
                });
                sb.append(" ]");
                System.out.print(sb);

            }
            System.out.println();
        }
    }
//TODO in future get statistic by game field
    public void printStatistic(GameField gameField) {
        Cell[][] fieldIsland = gameField.getFieldIsland();
        for (Cell[] cells : fieldIsland) {
            for (Cell cell : cells) {
                Map<Organism, Set<Organism>> mapOfAnimalsOnCell = cell.getMapOfAnimalsOnCell();
                System.out.println(cell);
                mapOfAnimalsOnCell.forEach((key, value) -> {

                    System.out.println(key +" "+ value.size());
                });
            }
        }

    }
}
