package com.project;

import java.util.concurrent.*;

public class Main {

    private static final ConcurrentHashMap<Integer, Integer> partials = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            int total = partials.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("=== TOTS els microserveis han acabat ===");
            System.out.println("Parcials: " + partials);
            System.out.println("Resultat global combinat: " + total);
        });

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(microservice(1, barrier));
        executor.submit(microservice(2, barrier));
        executor.submit(microservice(3, barrier));

        executor.shutdown();
        try { 
            executor.awaitTermination(5, TimeUnit.SECONDS); 
        } catch (InterruptedException ignored) {}
    }

    private static Runnable microservice(int id, CyclicBarrier barrier) {
        return () -> {
            try {
                System.out.println("Microservei " + id + " processant dades...");
                int base = id * 100;
                int partial = 0;
                for (int i = base; i < base + 10; i++) partial += i;
                partials.put(id, partial);

                System.out.println("Microservei " + id + " completat. (parcial=" + partial + ")");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.err.println("Error al microservei " + id + ": " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        };
    }
}
