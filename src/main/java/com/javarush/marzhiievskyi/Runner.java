package com.javarush.marzhiievskyi;


import com.javarush.marzhiievskyi.entity.field.Field;
import com.javarush.marzhiievskyi.services.OrganismFactory;
import com.javarush.marzhiievskyi.wiev.ConsoleView;


import java.io.IOException;


public class Runner {


    public static void main(String[] args) throws IOException {
        ConsoleView consoleView = new ConsoleView();
        consoleView.initialisation(20, 100);
        consoleView.printField();
    }
}


