package com.javarush.marzhiievskyi;


import com.javarush.marzhiievskyi.services.ThreadsWorker;
import com.javarush.marzhiievskyi.wiev.ConsoleGUI;


import java.io.IOException;


public class Runner {


    public static void main(String[] args) throws IOException {
        ThreadsWorker threadsWorker = new ThreadsWorker(0, 5 );
        threadsWorker.startExecutor();



    }
}


