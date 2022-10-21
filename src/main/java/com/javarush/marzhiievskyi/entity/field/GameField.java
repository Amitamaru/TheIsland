package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.organisms.Animals;
import com.javarush.marzhiievskyi.entity.organisms.Organism;
import com.javarush.marzhiievskyi.entity.organisms.Plants;
import com.javarush.marzhiievskyi.services.factories.OrganismFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameField {

    private final OrganismFactory organismFactory = new OrganismFactory();
    private static GameField gameField;
    private final Cell[][] fieldIsland;

    private GameField(int rows, int columns) {
        fieldIsland = new Cell[rows][columns];
    }

    public static GameField getGameField(int rows, int columns) {
        if (gameField == null) {
            gameField = new GameField(rows, columns);
        }
        return gameField;
    }


    public Cell[][] getFieldIsland() {
        return fieldIsland;
    }

    //TODO create for every Cell list with moves
    public void initField() {
        for (int i = 0; i < fieldIsland.length; i++) {
            for (int j = 0; j < fieldIsland[i].length; j++) {
                fieldIsland[i][j] = new Cell(generateOrganismsInCell());
            }
        }
    }
    public List<Organism> getListOfPrototypes() {
        return organismFactory.getListOfPrototypes();
    }
    private Map<Organism, Set<Organism>> generateOrganismsInCell() {

        Map<Organism, Set<Organism>> organisms = new HashMap<>();
        List<Organism> gotPrototypes = getListOfPrototypes();

        for (var organism : gotPrototypes) {
            if (organism instanceof Animals) {
                int count = ThreadLocalRandom.current().nextInt(0, ((Animals) organism).getMaxCountOnCell());
                if (count != 0) {
                    organisms.put(organism, cloneOrganism(organism, count));
                } else {
                    organisms.put(organism, new HashSet<>(0));
                }
            }
            if (organism instanceof Plants) {
                int count = ThreadLocalRandom.current().nextInt(0, ((Plants) organism).getMaxCountOnCell());
                if (count != 0) {
                    organisms.put(organism, cloneOrganism(organism, count));
                } else {
                    organisms.put(organism, new HashSet<>(0));
                }
            }
        }
        return organisms;
    }

    private Set<Organism> cloneOrganism(Organism type, int count) {
        Set<Organism> organismSet = new HashSet<>();

        for (int i = 0; i < count; i++) {
            organismSet.add(type.clone());
        }
        return organismSet;
    }


}
