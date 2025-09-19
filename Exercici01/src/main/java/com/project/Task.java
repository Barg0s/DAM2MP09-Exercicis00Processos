package com.project;

public class Task implements Runnable{
    private  int id;
    private String enviador;
    private  String destinatari;
    private  int quantitat;
    public Task(int id,String enviador,String destinatari){
        this.id = id; 
        this.enviador = enviador;
        this.destinatari = destinatari;
    }


    @Override
    public void run(){
        System.out.println("El compte" + enviador + "envia" + quantitat + "€ al compte" + destinatari);
    }
}
