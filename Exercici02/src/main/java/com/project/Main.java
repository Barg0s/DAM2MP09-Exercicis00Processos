package com.project;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        
        int quantitat = 2;
        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("Validant dades");
                if (quantitat > 0){
                    return quantitat;

                }else{
                    return 0;
                }
            }, es);

            CompletableFuture<Integer> f2 = f1.thenApplyAsync(result -> {
                System.out.println("Calculant dades");
                return result * 5;
            }, es);


            CompletableFuture<Void> f3 = f2.thenAccept(result -> {
                System.out.println("El preu final es: " + result + "€");
            });

            f3.join();

        } finally {
            es.shutdown();
        }
    }
}
