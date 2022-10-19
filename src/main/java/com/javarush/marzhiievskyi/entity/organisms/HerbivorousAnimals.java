package com.javarush.marzhiievskyi.entity.organisms;

import com.javarush.marzhiievskyi.entity.field.Cell;

public abstract class HerbivorousAnimals extends Animals{


    public HerbivorousAnimals(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        super(name, icon, weight, maxCountOnCell, maxSpeed, needFood);
    }

    @Override
    public void eat(Organism organism, Cell currentCell) {
        Plants plant = (Plants) organism;
        //Our herbivorous animals always eats the plants
        if (isDead()) {
            //our organism THIS is trying to eat organism from argument
            double  weightOfOrganism = plant.getCurrentWeight();
            double  currentWeight = this.getCurrentWeight() + weightOfOrganism;
            this.setCurrentWeight(Math.min(currentWeight, this.getMaxWeight()));
            ((Plants) organism).remove(currentCell);
        } else {
            this.remove(currentCell);
        }
    }
}
