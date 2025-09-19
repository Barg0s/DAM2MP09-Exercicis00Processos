package com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {


        ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5;i++){
            es.execute(new Task(i));

        }
        for (int j = 0; j < 5;j++){
            es.execute(new Task1(j));

        }

        es.shutdown();    
    }
    
}

