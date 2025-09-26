package com.project;

import java.util.Random;

public class Task1 implements Runnable{
    private String[] xarxaEstats = {"La xarxa funciona correctament","La xarxa te alguns problemes","La xarxa esta caiguda"};
    private  int id;

    public Task1(int id){
        this.id = id; 
    }


    @Override
    public void run(){

        Random r = new Random();
        int pos = r.nextInt(xarxaEstats.length);
        String estat = xarxaEstats[pos];
        System.out.println("Tasca de manteniment " + id + ":" + estat  );    }
}
