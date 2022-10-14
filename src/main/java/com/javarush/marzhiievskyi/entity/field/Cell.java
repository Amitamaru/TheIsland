package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.organisms.Animals;
import com.javarush.marzhiievskyi.entity.organisms.Organism;

import java.util.HashMap;
import java.util.Map;

public class Cell {
    private Organism organism;
    private int count;

    public Cell(Organism organism) {
        this.organism = organism;
    }


    public Organism getOrganism() {
        return organism;
    }

    @Override
    public String toString() {

        return "[" + organism + "]";
    }
}
