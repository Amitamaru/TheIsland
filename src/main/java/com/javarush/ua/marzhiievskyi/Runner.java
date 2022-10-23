package com.javarush.ua.marzhiievskyi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.ua.marzhiievskyi.services.ThreadsWorker;
import com.javarush.ua.marzhiievskyi.utils.Constants;
import com.javarush.ua.marzhiievskyi.utils.gettingParameters.GettingParametersOfEating;

import java.io.File;
import java.io.IOException;


public class Runner {


    public static void main(String[] args) throws IOException {
        ThreadsWorker threadsWorker = new ThreadsWorker();
        threadsWorker.startExecutor();


    }
}


