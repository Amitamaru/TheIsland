package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.organisms.Animals;
import com.javarush.marzhiievskyi.entity.organisms.Organism;
import com.javarush.marzhiievskyi.entity.organisms.Plants;
import com.javarush.marzhiievskyi.services.OrganismFactory;

import java.io.IOException;

import java.util.concurrent.ThreadLocalRandom;

public class Field {
    ;
    private final Cell[][] fieldIsland = new Cell[20][100];

    OrganismFactory organismFactory = new OrganismFactory();


    public void initField() throws IOException {

        int size = organismFactory.gettingSetOfOrganisms().size();


        for (int i = 0; i < fieldIsland.length; i++) {
            for (int j = 0; j < fieldIsland[i].length; j++) {

                int random = ThreadLocalRandom.current().nextInt(size);
                Organism o = organismFactory.gettingSetOfOrganisms().get(random);
                Cell  cell = new Cell(o);

                System.out.print(cell);
            }
            System.out.println();
        }
    }

}
