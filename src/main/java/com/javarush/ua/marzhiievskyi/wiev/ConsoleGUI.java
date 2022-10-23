package com.javarush.ua.marzhiievskyi.wiev;

import com.javarush.ua.marzhiievskyi.entity.field.Cell;
import com.javarush.ua.marzhiievskyi.entity.field.GameField;
import com.javarush.ua.marzhiievskyi.entity.organisms.Organism;


import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class ConsoleGUI {


    public void printField(GameField gameField) {
        System.out.println();
        Cell[][] fieldIsland = gameField.getFieldIsland();
        for (Cell[] cells : fieldIsland) {
            for (Cell cell : cells) {

                StringBuilder sb = new StringBuilder("[");
                Map<Organism, Set<Organism>> mapOfAnimalsOPnCell = cell.getMapOfAnimalsOnCell();
                mapOfAnimalsOPnCell.forEach((key, value) -> {
                    sb.append(" ").append(key.toString()).append(": ").append(new DecimalFormat("000").format(value.size()));
                });
                sb.append(" ]   ");
                System.out.print(sb);

            }
            System.out.println();
        }
    }
    //TODO in future get statistic by game field
/*

    public void printStatistic(GameField gameField) {
        int totalOrganisms = 0;
        Cell[][] fieldIsland = gameField.getFieldIsland();
        for (Cell[] cells : fieldIsland) {
            for (Cell cell : cells) {
                Map<Organism, Set<Organism>> mapOfAnimalsOnCell = cell.getMapOfAnimalsOnCell();

            }
        }
        System.out.println(totalOrganisms);
    }
*/
}
