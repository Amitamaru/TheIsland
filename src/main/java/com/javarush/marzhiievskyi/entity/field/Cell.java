package com.javarush.marzhiievskyi.entity.field;

import com.javarush.marzhiievskyi.entity.organisms.Organism;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cell {
    private List<Cell> moveList;

    private Map<Organism , Set<Organism>> mapOfAnimalsOPnCell;

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
