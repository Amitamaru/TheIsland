package com.javarush.marzhiievskyi.entity;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class Parameters {



   private final Map<AnimalNames, List<String>> mapOfAnimalsParameters = new HashMap<>();


    public Map<AnimalNames, List<String>> getMapOfAnimalsParameters() {
        return mapOfAnimalsParameters;
    }


    public void initAnimalParam() {
        mapOfAnimalsParameters.put(AnimalNames.WOOLF, Arrays.stream(AnimalsParameters.NAME_WOOLF).toList());
        mapOfAnimalsParameters.put(AnimalNames.SNAKE, Arrays.stream(AnimalsParameters.NAME_SNAKE).toList());
        mapOfAnimalsParameters.put(AnimalNames.FOX, Arrays.stream(AnimalsParameters.NAME_FOX).toList());
        mapOfAnimalsParameters.put(AnimalNames.BEAR, Arrays.stream(AnimalsParameters.NAME_BEAR).toList());
        mapOfAnimalsParameters.put(AnimalNames.EAGLE, Arrays.stream(AnimalsParameters.NAME_EAGLE).toList());

        mapOfAnimalsParameters.put(AnimalNames.HORSE, Arrays.stream(AnimalsParameters.NAME_HORSE).toList());
        mapOfAnimalsParameters.put(AnimalNames.DEER, Arrays.stream(AnimalsParameters.NAME_DEER).toList());
        mapOfAnimalsParameters.put(AnimalNames.RABBIT, Arrays.stream(AnimalsParameters.NAME_RABBIT).toList());
        mapOfAnimalsParameters.put(AnimalNames.MOUSE, Arrays.stream(AnimalsParameters.NAME_MOUSE).toList());
        mapOfAnimalsParameters.put(AnimalNames.GOAT, Arrays.stream(AnimalsParameters.NAME_GOAT).toList());
        mapOfAnimalsParameters.put(AnimalNames.SHEEP, Arrays.stream(AnimalsParameters.NAME_SHEEP).toList());
        mapOfAnimalsParameters.put(AnimalNames.BOAR, Arrays.stream(AnimalsParameters.NAME_BOAR).toList());
        mapOfAnimalsParameters.put(AnimalNames.BUFFALO, Arrays.stream(AnimalsParameters.NAME_BUFFALO).toList());
        mapOfAnimalsParameters.put(AnimalNames.DUCK, Arrays.stream(AnimalsParameters.NAME_DUCK).toList());
        mapOfAnimalsParameters.put(AnimalNames.CATERPILLAR, Arrays.stream(AnimalsParameters.NAME_CATERPILLAR).toList());
        mapOfAnimalsParameters.put(AnimalNames.HERB, Arrays.stream(AnimalsParameters.NAME_HERB).toList());
    }


    public static class AnimalsParameters {
        //Names & symbols of animals (0)symbol, (1)weight, (2)maxQuantityOnCell, (3)maxMove, (4)needFood
        //Carnivorous
        public final static String[] NAME_WOOLF = {"\uD83D\uDC3A", "50", "30", "3", "8"};
        public final static String[] NAME_SNAKE = {"\uD83D\uDC0D", "15", "30", "1", "3"};
        public final static String[] NAME_FOX = {"\uD83E\uDD8A", "8", "3", "2", "2"};
        public final static String[] NAME_BEAR = {"\uD83D\uDC3B", "500", "5", "2", "80"};
        public final static String[] NAME_EAGLE = {"\uD83E\uDD85", "6", "20", "3", "1"} ;

        //Herbivorous
        public final static String[] NAME_HORSE = {"\uD83D\uDC0E", "400", "20", "60"};
        public final static String[] NAME_DEER = {"\uD83E\uDD8C", "300", "20", "4", "50"};
        public final static String[] NAME_RABBIT = {"\uD83D\uDC07", "2", "150", "2", "0.45"};
        public final static String[] NAME_MOUSE = {"\uD83D\uDC01", "0.05", "500", "1", "0.01"};
        public final static String[] NAME_GOAT = {"\uD83D\uDC10", "60", "140", "3", "10"};
        public final static String[] NAME_SHEEP = {"\uD83D\uDC11", "70", "140", "3", "15"};
        public final static String[] NAME_BOAR = {"\uD83D\uDC17", "400", "50", "2", "50"};
        public final static String[] NAME_BUFFALO = {"\uD83D\uDC03", "700", "10", "3", "100"};
        public final static String[] NAME_DUCK = {"\uD83E\uDD86", "1", "200", "4", "0.15"};
        public final static String[] NAME_CATERPILLAR = {"\uD83D\uDC1B", "0.01", "1000", "0", "0"};

        //Plants
        public final static String[] NAME_HERB = {"\uD83C\uDF3F", "1", "200", null, null};
    }







}
