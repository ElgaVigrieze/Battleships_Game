package com.company;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Ship {
    private final int length;
    private final ArrayList<int[]> squares = new ArrayList<>();

    public void setSquares(int[] square) {
        squares.add(square);
    }


}


