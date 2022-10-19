package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.organisms.Organism;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final Lock lock = new ReentrantLock();

    public Lock getLock() {
        return lock;
    }

    private List<Cell> moveList;

    private Map<Organism, Set<Organism>> mapOfAnimalsOPnCell;

    public Cell(Map<Organism, Set<Organism>> mapOfAnimalsOPnCell) {
        this.mapOfAnimalsOPnCell = mapOfAnimalsOPnCell;
    }


    public Map<Organism, Set<Organism>> getMapOfAnimalsOnCell() {
        return mapOfAnimalsOPnCell;
    }

    public void setMapOfAnimalsOPnCell(Map<Organism, Set<Organism>> mapOfAnimalsOPnCell) {
        this.mapOfAnimalsOPnCell = mapOfAnimalsOPnCell;
    }

    public List<Cell> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Cell> moveList) {
        this.moveList = moveList;
    }







}
