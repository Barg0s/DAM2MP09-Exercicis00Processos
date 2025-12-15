package com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int capacitat = 3; 
        ParkingLot parking = new ParkingLot(capacitat);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            executor.submit(new Cotxe(parking, "Cotxe " + i));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}