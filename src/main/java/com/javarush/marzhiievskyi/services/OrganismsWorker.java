package com.javarush.marzhiievskyi.services;

import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.field.GameField;
import com.javarush.marzhiievskyi.entity.organisms.Animals;
import com.javarush.marzhiievskyi.entity.organisms.Organism;
import com.javarush.marzhiievskyi.entity.organisms.Plants;

import java.util.Map;
import java.util.Set;

public class OrganismsWorker implements Runnable {

    private final GameField gameField;
    private final Organism typeOfOrganism;


    public OrganismsWorker(GameField gameField, Organism typeOfOrganism) {
        this.gameField = gameField;
        this.typeOfOrganism = typeOfOrganism;
    }


    @Override
    public void run() {
        Cell[][] fieldIsland = gameField.getFieldIsland();
        for (Cell[] cells : fieldIsland) {
            for (Cell cell : cells) {
                organismDoing(cell);
            }
        }
    }

    private void organismDoing(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> organismSet = cell.getMapOfAnimalsOnCell().get(typeOfOrganism);
            organismSet.forEach(organism -> {
                organism.multiply(cell);
                if (organism instanceof Animals) {
                    ((Animals) organism).eat(cell);
                    ((Animals) organism).move(cell);
                }
            });

        } finally {
            cell.getLock().unlock();
        }
    }
}
