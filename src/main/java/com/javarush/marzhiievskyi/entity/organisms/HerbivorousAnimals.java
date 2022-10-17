package com.javarush.marzhiievskyi.entity.organisms;

public abstract class HerbivorousAnimals extends Animals{


    public HerbivorousAnimals(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        super(name, icon, weight, maxCountOnCell, maxSpeed, needFood);
    }

    @Override
    public void eat() {
        System.out.println( super.getIcon() + " is eating the grass");
    }

    @Override
    public void move() {
        System.out.println( super.getIcon() + " is moving");
    }

    @Override
    public void multiply() {
        System.out.println(super.getIcon() + " is multiplying");
    }
}
