package com.project;

import java.util.concurrent.Semaphore;

class ParkingLot {
    private final Semaphore semafor;

    public ParkingLot(int capacitat) {
        this.semafor = new Semaphore(capacitat);
    }

    public void entrar(String nom) {
        try {
            if (!semafor.tryAcquire()) { //https://learn.microsoft.com/es-es/dotnet/api/java.util.concurrent.semaphore.tryacquire?view=net-android-34.0
                System.out.println(nom + " espera, aparcament ple.");
                semafor.acquire(); 
            }
            System.out.println(nom + " ha entrat.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void sortir(String nom) {
        semafor.release();
        System.out.println(nom + " ha sortit.");
    }
}
    