package com.project;
import java.util.concurrent.ConcurrentHashMap;

public class Task1 implements Runnable {
    private ConcurrentHashMap<String, Double> dades;

    public Task1(ConcurrentHashMap<String, Double> dades) {
        this.dades = dades;
    }

    @Override
    public void run() {
        Double saldo = dades.get("saldo");


        dades.put("saldo", saldo -= saldo * 0.2);
        System.out.println("Saldo modificat per comissió: " + dades.get("saldo"));
    }
}

