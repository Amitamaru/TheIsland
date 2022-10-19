package com.javarush.marzhiievskyi;


import com.javarush.marzhiievskyi.services.ThreadsWorker;


import java.io.IOException;


public class Runner {


    public static void main(String[] args) {
        ThreadsWorker threadsWorker = new ThreadsWorker(0, 5 );
        threadsWorker.startExecutor();



    }
}


