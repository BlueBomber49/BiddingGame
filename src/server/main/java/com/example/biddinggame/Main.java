package com.example.biddinggame;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello World!");

        Server s = new Server();
        s.run(9999);
    }
    
}
