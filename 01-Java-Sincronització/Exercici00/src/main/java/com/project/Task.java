package com.project;

public class Task implements Runnable{
    private  int id;

    public Task(int id){
        this.id = id; 
    }


    @Override
    public void run(){ // el run es el que fara la tasca al ser executada al fil.
        System.out.println("Tasca de manteniment " + id + ": Esdeveniment del sistema enregistrat");    }
}
