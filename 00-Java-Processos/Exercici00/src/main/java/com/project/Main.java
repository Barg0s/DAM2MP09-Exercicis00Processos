package com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        


        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Task(0));
        es.execute(new Task1(1));
        es.shutdown();    
    }
    
}

