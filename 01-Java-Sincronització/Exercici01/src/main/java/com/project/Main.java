package com.project;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {


        ExecutorService es = Executors.newFixedThreadPool(3);


        ConcurrentHashMap<String,Double> dadesBancaries = new ConcurrentHashMap<>();
        
        
        
        es.execute(new Task(dadesBancaries));
        es.execute(new Task1(dadesBancaries));

        Future<Double> resultat = es.submit(new Task2(dadesBancaries)); //resultat pendant d'una operacio
 
        try {
            System.out.println(resultat.get());   //bloquea fil i retorna el resultat de la task         
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        es.shutdown();    
    }
    
}

