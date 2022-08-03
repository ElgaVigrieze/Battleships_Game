package com.company;

import java.util.ArrayList;


public class Ship {
    private final int length;
    private final ArrayList<int[]> squares = new ArrayList<>();


    public ArrayList<int[]> getSquares() {
        return squares;
    }


    public Ship(int length) {
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public void setSquares(int[] square) {
        squares.add(square);
    }




}


