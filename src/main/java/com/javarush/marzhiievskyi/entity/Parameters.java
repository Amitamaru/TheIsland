package com.javarush.marzhiievskyi.entity;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class Parameters {



   private final Map<AnimalNames, List<String>> carnivorousAnimalsParameters = new HashMap<>();

    public Map<AnimalNames, List<String>> getCarnivorousAnimalsParameters() {
        return carnivorousAnimalsParameters;
    }

    public void addAnimalParam() {
        carnivorousAnimalsParameters.put(AnimalNames.WOOLF, Arrays.stream(AnimalsParameters.NAME_WOOLF).toList());
        carnivorousAnimalsParameters.put(AnimalNames.SNAKE, Arrays.stream(AnimalsParameters.NAME_SNAKE).toList());
        carnivorousAnimalsParameters.put(AnimalNames.FOX, Arrays.stream(AnimalsParameters.NAME_FOX).toList());
        carnivorousAnimalsParameters.put(AnimalNames.BEAR, Arrays.stream(AnimalsParameters.NAME_BEAR).toList());
        carnivorousAnimalsParameters.put(AnimalNames.EAGLE, Arrays.stream(AnimalsParameters.NAME_EAGLE).toList());
    }
    public static class AnimalsParameters {
        //Names & symbols of animals
        //Carnivorous
        public final static String[] NAME_WOOLF = {"\uD83D\uDC3A", "50", "30", "3", "8"};
        public final static String[] NAME_SNAKE = {"\uD83D\uDC0D", "15", "30", "1", "3"};
        public final static String[] NAME_FOX = {"\uD83E\uDD8A", "8", "3", "2", "2"};
        public final static String[] NAME_BEAR = {"\uD83D\uDC3B", "500", "5", "2", "80"};
        public final static String[] NAME_EAGLE = {"\uD83E\uDD85", "6", "20", "3", "1"} ;

        //Herbivorous
        //TODO make array params and add to map
        public final static String NAME_HORSE = "\uD83D\uDC0E";
        public final static String NAME_DEER = "\uD83E\uDD8C";
        public final static String NAME_RABBIT = "\uD83D\uDC07";
        public final static String NAME_MOUSE = "\uD83D\uDC01";
        public final static String NAME_GOAT = "\uD83D\uDC10";
        public final static String NAME_SHEEP = "\uD83D\uDC11";
        public final static String NAME_BOAR = "\uD83D\uDC17";
        public final static String NAME_BUFFALO = "\uD83D\uDC03";
        public final static String NAME_DUCK = "\uD83E\uDD86";
        public final static String NAME_CATERPILLAR = "\uD83D\uDC1B";
        //Plants
        public final static String NAME_HERB = "\uD83C\uDF3F";
    }







}
