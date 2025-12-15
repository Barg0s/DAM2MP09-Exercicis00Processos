package com.project;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class Task2 implements Callable<Double> {
    private ConcurrentHashMap<String, Double> dades;

    public Task2(ConcurrentHashMap<String, Double> dades) {
        this.dades = dades;
    }

    @Override
    public Double call() { //com el run,pero retorna un valor que s'agafa amb .get()
        System.out.println("Saldo final");
        return dades.get("saldo");
    }
}
