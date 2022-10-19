package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.organisms.Animals;
import com.javarush.marzhiievskyi.entity.organisms.Organism;
import com.javarush.marzhiievskyi.entity.organisms.Plants;
import com.javarush.marzhiievskyi.services.OrganismFactory;

import java.io.IOException;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameField {
    private final Cell[][] fieldIsland;

    public GameField(int rows, int columns) {
        fieldIsland = new Cell[rows][columns];
    }


    public Cell[][] getFieldIsland() {
        return fieldIsland;
    }

    public void initField() throws IOException {

        for (int i = 0; i < fieldIsland.length; i++) {
            for (int j = 0; j < fieldIsland[i].length; j++) {
                fieldIsland[i][j] = new Cell(generateOrganismsInCell());
            }
        }
    }

    private Map<Organism, Set<Organism>> generateOrganismsInCell() throws IOException {
        OrganismFactory organismFactory = new OrganismFactory();
        Map<Organism, Set<Organism>> organisms = new HashMap<>();
        List<Organism> gotPrototypes = organismFactory.gettingSetOfOrganisms();

        for (var organism : gotPrototypes) {
            if (organism instanceof Animals) {
                int count = ThreadLocalRandom.current().nextInt(0, ((Animals) organism).getMaxCountOnCell());
                if (count != 0) {
                    organisms.put(organism, cloneOrganism(organism, count));
                }
                else {
                    organisms.put(organism, new HashSet<>(0));
                }
            }
            if (organism instanceof Plants) {
                int count = ThreadLocalRandom.current().nextInt(0, ((Plants) organism).getMaxCountOnCell());
                if (count != 0) {
                    organisms.put(organism, cloneOrganism(organism, count));
                }
                else {
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
