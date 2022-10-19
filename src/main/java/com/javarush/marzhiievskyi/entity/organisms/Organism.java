package com.javarush.marzhiievskyi.entity.organisms;


public abstract class Organism implements Cloneable {

    @Override
    public Organism clone() {
        try {
            return (Organism) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
