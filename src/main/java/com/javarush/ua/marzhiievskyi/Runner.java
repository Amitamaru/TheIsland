package com.javarush.ua.marzhiievskyi;

import com.javarush.ua.marzhiievskyi.services.ThreadsWorker;



public class Runner {


    public static void main(String[] args) {
        ThreadsWorker threadsWorker = new ThreadsWorker();
        threadsWorker.startExecutor();
    }
}


