package com.company;

import java.util.ArrayList;

public class Ship {
    private final int size;
    public ArrayList<Integer> xyPositions;
    public Ship(int size){
        xyPositions=new ArrayList<>();
        this.size=size;
    }
    public int getSize() {
        return size;
    }
}
