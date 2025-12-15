package com.project;

import java.util.concurrent.TimeUnit;

public class Cotxe implements Runnable {
    private final ParkingLot parking;
    private final String nom;

    public Cotxe(ParkingLot parking, String nom) {
        this.parking = parking;
        this.nom = nom;
    }

    @Override
    public void run() {
        parking.entrar(nom);
        try {
            TimeUnit.SECONDS.sleep((long) (Math.random() * 5 + 1));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            parking.sortir(nom);
        }
    }
}