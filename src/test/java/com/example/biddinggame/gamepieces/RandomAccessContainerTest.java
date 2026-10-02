package com.example.biddinggame.gamepieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomAccessContainerTest {

    private static class TestContainer<T> extends RandomAccessContainer<T> {
    }
    @Test 
    void drawFromEmptyBagReturnsNull(){
        RandomAccessContainer<Integer> r = new TestContainer<>();
        assertNull(r.getItem());
    }

    @Test 
    void overdrawReturnsAll(){
        RandomAccessContainer<Integer> r = new TestContainer<>();
        r.addItem(1);
        r.addItem(2);
        r.addItem(3);
        assertEquals(r.getNItems(5).size(), 3);
    }
}
