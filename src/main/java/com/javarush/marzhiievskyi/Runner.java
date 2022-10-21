package com.javarush.marzhiievskyi;

import com.javarush.marzhiievskyi.services.ThreadsWorker;



public class Runner {


    public static void main(String[] args) {
        ThreadsWorker threadsWorker = new ThreadsWorker();
        threadsWorker.startExecutor();



    }
}


