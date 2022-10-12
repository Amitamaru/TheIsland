package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.organisms.Organism;
import com.javarush.marzhiievskyi.entity.organisms.carnivorous.Bear;
import com.javarush.marzhiievskyi.services.GenerateOrganisms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cell {

    private Map<Organism, Integer> organismSet = new HashMap<>(); // key - organism, value - quantity



    @Override
    public String toString() {

        return "[ " +" ]";
    }
}
