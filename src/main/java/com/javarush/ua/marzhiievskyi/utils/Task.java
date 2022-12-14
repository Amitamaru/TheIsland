package com.javarush.ua.marzhiievskyi.utils;

import com.javarush.ua.marzhiievskyi.entity.organisms.Organism;

import java.util.function.Consumer;

public class Task {
    private final Organism organism;
    private final Consumer<Organism> action;


    public Task(Organism organism, Consumer<Organism> action) {
        this.organism = organism;
        this.action = action;
    }

    public void execute() {
        action.accept(organism);
    }
}
