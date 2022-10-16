package com.javarush.marzhiievskyi.wiev;

import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.field.Field;
import com.javarush.marzhiievskyi.entity.organisms.Organism;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class ConsoleView {
    private Field field;

    public void initialisation(int rows, int cols) throws IOException {
        field = new Field(rows, cols);
        field.initField();
    }

    public void printField() {
        Cell[][] fieldIsland = field.getFieldIsland();
        for (int i = 0; i < fieldIsland.length; i++) {
            for (int j = 0; j < fieldIsland[i].length; j++) {
                Map<Organism, Set<Organism>> mapOfAnimalsOPnCell = fieldIsland[i][j].getMapOfAnimalsOnCell();

                System.out.print("[");

                for (var organism : mapOfAnimalsOPnCell.entrySet()) {
                    String type = organism.getKey().toString();
                    int count = organism.getValue().size();
                    System.out.print(" " + type + " : " + count + "; ");
                }

                System.out.print(("] "));
            }
            System.out.println();
        }
    }
}
