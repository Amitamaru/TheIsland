package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.organisms.Organism;

import java.util.HashMap;
import java.util.Map;

public class Cell {

    private Map<Organism, Integer> organismSet = new HashMap<>(); // key - organism, value - quantity

    @Override
    public String toString() {

        return "[ " +" ]";
    }
}
