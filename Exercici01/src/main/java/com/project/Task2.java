package com.project;

import java.util.concurrent.Callable;

public class Task2 implements Callable<Integer>{
    private  int id;

    public Task2(int id){
        this.id = id; 
    }


    @Override
    public Integer call(){
        
        return r;
    }
}
