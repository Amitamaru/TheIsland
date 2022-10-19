package com.javarush.marzhiievskyi.services;


import com.javarush.marzhiievskyi.entity.organisms.Organism;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadsWorker {
    private final int START_FROM;
    private final int PERIOD;
    private final int cores;


    private final IslandFactory islandFactory = new IslandFactory(2, 2);


    public ThreadsWorker(int start_from, int period) {
        START_FROM = start_from;
        PERIOD = period;
        cores = Runtime.getRuntime().availableProcessors();
    }


    public void startExecutor() {

        List<OrganismsWorker> workerList = new ArrayList<>();

        List<Organism> listOfPrototypes = islandFactory.getGameField().getListOfPrototypes();

        for (var organismType : listOfPrototypes) {
            workerList.add(new OrganismsWorker(islandFactory.getGameField(), organismType));
        }

        ScheduledExecutorService threadsPool = Executors.newScheduledThreadPool(cores);
        threadsPool.scheduleAtFixedRate(() -> {
            ExecutorService service = Executors.newFixedThreadPool(listOfPrototypes.size());
            workerList.forEach(service::submit);
            service.shutdown();
        }, START_FROM, PERIOD, TimeUnit.SECONDS);


    }
}
