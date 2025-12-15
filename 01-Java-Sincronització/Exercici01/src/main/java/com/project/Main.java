package com.project;

import java.util.concurrent.*;
import java.util.List;

public class Main {

    // Variables compartides a nivell de classe
    private static double suma;
    private static double mitjana;
    private static double desviacio;

    public static void main(String[] args) {

        // Dades d'exemple en llista
        List<Double> dades = List.of(10.0, 20.0, 30.0, 40.0, 50.0);

        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("=== Tots els calculs han acabat ===");
            System.out.println("Suma: " + suma);
            System.out.println("Mitjana: " + mitjana);
            System.out.println("Desviacio estandard: " + desviacio);
        });

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable tascaSuma = () -> {
            suma = dades.stream().mapToDouble(Double::doubleValue).sum();
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

¡        Runnable tascaMitjana = () -> {
            mitjana = dades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        Runnable tascaDesviacio = () -> {
            double mitjanaLocal = dades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            desviacio = Math.sqrt(dades.stream()
                    .mapToDouble(d -> Math.pow(d - mitjanaLocal, 2))
                    .sum() / dades.size());
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        executor.submit(tascaSuma);
        executor.submit(tascaMitjana);
        executor.submit(tascaDesviacio);

        executor.shutdown();
        try { 
            executor.awaitTermination(5, TimeUnit.SECONDS); 
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
    }
}
