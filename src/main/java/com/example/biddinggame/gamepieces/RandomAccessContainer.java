package com.example.biddinggame.gamepieces;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class RandomAccessContainer<T> {
    protected List<T> items;
    public RandomAccessContainer(){
        this.items = new ArrayList<>();
    }

    public T getItem(){
        if(this.items.size() == 0){
            return null;
        } 
        int i = ThreadLocalRandom.current().nextInt(this.items.size());
        T result = this.items.get(i);
        this.items.set(i, this.items.get(this.items.size()-1));
        this.items.remove(this.items.size()-1);
        return result;
    }

    public List<T> getNItems(int n){
        List<T> itemsList = new ArrayList<>();
        for(int i=0; i<n; i++){
            T g = getItem();
            if(g != null){
                itemsList.add(g);
            }
            else{
                break;
            }
        }
        return itemsList;
    }

    public List<T> getAllItems(){
        return this.items;
    }

    public void addItem(T item){
        this.items.add(item);
    }

    public void addItems(List<T> items){
        this.items.addAll(items);
    }
}
