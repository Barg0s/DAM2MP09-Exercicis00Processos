package com.project;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        
        int quantitat = 2;
        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> { //al ser asincrona,se ejecuta cuando haya un thread libre
                System.out.println("Validant dades");
                if (quantitat > 0){
                    return quantitat;

                }else{
                    return 0;
                }
            }, es);

            CompletableFuture<Integer> f2 = f1.thenApplyAsync(result -> { //se aplica justo al acabar el f1,tmb asincrona.
                System.out.println("Calculant dades");
                return result * 5;
            }, es);


            f2.thenAccept(result -> { //executa una accion al acabar f2,de las que no devuelven nada.
                System.out.println("El preu final es: " + result + "€");
            });

            f2.join(); //fem que el fil principal esperi fins que el proces acabi per tancar

        } finally {
            es.shutdown();
        }
    }
}
