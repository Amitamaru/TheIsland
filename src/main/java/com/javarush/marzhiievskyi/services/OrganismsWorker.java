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
            Map<Organism, Set<Organism>> set = cell.getMapOfAnimalsOnCell();
            Set<Organism> organismSet = set.get(typeOfOrganism);
            organismSet.forEach(organism -> {
                if (organism instanceof Animals) {
                    ((Animals) organism).eat(cell);
                    ((Animals) organism).move(cell);
                    ((Animals) organism).multiply(cell);
                } else if (organism instanceof Plants) {
                    ((Plants) organism).multiply(cell);
                }
            });

        } finally {
            cell.getLock().unlock();
        }
    }
}
