package com.example.biddinggame.gamepieces;

import java.util.ArrayList;
import java.util.Collections;

public class GemBag extends RandomAccessContainer<Gem>{

    public GemBag(){
        this.items = new ArrayList<>();
        for(int i=0; i<12; i++){
            this.addItem(new Gem(1));
        }
        for(int i=0; i<6; i++){
            this.addItem(new Gem(2));
        }
        for(int i=0; i<3; i++){
            this.addItem(new Gem(4));
        }
        for(int i=0; i<1; i++){
            this.addItem(new Gem(7));
        }
        Collections.shuffle(this.items);
    }
}
