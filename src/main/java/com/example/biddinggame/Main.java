package com.example.biddinggame;

import com.example.biddinggame.gamepieces.GemBag;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello World!");

        GemBag g = new GemBag();
        System.out.println(g.getNItems(5));
        System.out.println(g.getNItems(5));
        System.out.println(g.getNItems(5));
        System.out.println(g.getNItems(5));
        System.out.println(g.getNItems(5));
    }
    
}
