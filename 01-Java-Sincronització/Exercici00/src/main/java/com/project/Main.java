package com.project;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        


        
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Tots els microserveis han acabat. Combinant els resultats...");
            }
        });
        ExecutorService es = Executors.newFixedThreadPool(2);
        

        Runnable ms1 = () -> { try {
                barrier.await();
        } catch (Exception e) {
        }
    
    };
}
}
