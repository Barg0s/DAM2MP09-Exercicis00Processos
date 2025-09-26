package com.project;

import java.util.concurrent.ConcurrentHashMap;

public class Task implements Runnable {
    private ConcurrentHashMap<String, Double> dades;

    public Task(ConcurrentHashMap<String, Double> dades) {
        this.dades = dades;
    }

    @Override
    public void run() {
        dades.put("saldo", 200.0);
        System.out.println("Transferencia rebuda: " + dades.get("saldo") + "€");
    }
}
