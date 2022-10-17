package com.javarush.marzhiievskyi.entity.organisms;

public abstract class CarnivorousAnimals extends Animals {

    public CarnivorousAnimals(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        super(name, icon, weight, maxCountOnCell, maxSpeed, needFood);
    }

    @Override
    public void eat() {
        System.out.println( super.getIcon() + " is eating another animal");
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
