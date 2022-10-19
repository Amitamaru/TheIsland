package com.javarush.marzhiievskyi;


import com.javarush.marzhiievskyi.wiev.ConsoleGUI;


import java.io.IOException;


public class Runner {


    public static void main(String[] args) throws IOException {
        ConsoleGUI consoleGUI = new ConsoleGUI();
        consoleGUI.initialisation(4, 4);
        consoleGUI.printField();
    }
}


