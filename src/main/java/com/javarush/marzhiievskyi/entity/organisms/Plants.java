package com.javarush.marzhiievskyi.entity.organisms;

import com.javarush.marzhiievskyi.entity.organisms.actions.Reproductionable;

public abstract class Plants extends Organism implements Reproductionable {

    private final String name;
    private final String icon;
    private final double weight;
    private final int maxCountOnCell;

    public Plants(String name, String icon, double weight, int maxCountOnCell) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
    }

    @Override
    public String toString() {
        return icon;
    }
}
