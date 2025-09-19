package com.project;

public class Task1 implements Runnable{
    private  int id;

    public Task1(int id){
        this.id = id; 
    }


    @Override
    public void run(){
        System.out.println("Tasca de manteniment " + id + ": La xarxa funciona correctament");
    }
}
