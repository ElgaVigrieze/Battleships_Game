package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class GameMoves {

    public abstract void createShip(String[][] field, ArrayList<Ship> ships);

    public abstract void defineShipLocation(Ship ship, String[][] playerField, int shipNo);

    public abstract int[] makeMove(String[][] field, String[][] fieldPublic, ArrayList<Ship> ships);

    public abstract boolean updateFieldAfterMove(String[][] computerField, String[][] computerFieldPublic, int[] indexes, ArrayList<Ship> computerShips);

    public void markShipSunk(String hitShip, String[][] field, ArrayList<Ship> ships){
        int countX = 0;
        int sunk = 0;
        switch (hitShip) {
            case "s1" -> {
                Ship ship =ships.get(0);
                    for (int i = 0; i < ship.getSquares().size(); i++) {
                        int[] indexesShip = ship.getSquares().get(i);
                        if (field[indexesShip[0]][indexesShip[1]].equals(" x")) {
                            countX++;
                        }
                    }
                    if (countX == ship.getLength()) {
                        sunk++;

                        for (int i = 0; i < ship.getSquares().size(); i++) {
                            int[] indexesShip = ship.getSquares().get(i);
                            field[indexesShip[0]][indexesShip[1]] = "xx";
                        }
                    }
                }
            case "s2" -> {
                Ship ship = ships.get(1);
                    for (int i = 0; i < ship.getSquares().size(); i++) {
                        int[] indexesShip = ship.getSquares().get(i);
                        if (field[indexesShip[0]][indexesShip[1]].equals(" x")) {
                            countX++;
                        }
                    }
                        if (countX  == ship.getLength()) {
                            sunk++;
                            for (int i = 0; i < ship.getSquares().size(); i++) {
                                int[] indexesShip = ship.getSquares().get(i);
                                field[indexesShip[0]][indexesShip[1]] = "xx";
                            }
                        }
                    }
            case "s3" -> {
                Ship ship = ships.get(2);
                for (int i = 0; i < ship.getSquares().size(); i++) {
                    int[] indexesShip = ship.getSquares().get(i);
                    if (field[indexesShip[0]][indexesShip[1]].equals(" x")) {
                        countX++;
                        }
                    }
                    if (countX == ship.getLength()) {
                        sunk++;
                        for (int i = 0; i < ship.getSquares().size(); i++) {
                            int[] indexesShip = ship.getSquares().get(i);
                            field[indexesShip[0]][indexesShip[1]] = "xx";
                            }
                        }
                    }
            case "s4" -> {
                Ship ship = ships.get(3);
                for (int i = 0; i < ship.getSquares().size(); i++) {
                    int[] indexesShip = ship.getSquares().get(i);
                    if (field[indexesShip[0]][indexesShip[1]].equals(" x")) {
                        countX++;
                        }
                    }
                    if (countX == ship.getLength()) {
                        sunk++;
                        for (int i = 0; i < ship.getSquares().size(); i++) {
                            int[] indexesShip = ship.getSquares().get(i);
                            System.out.println(Arrays.toString(indexesShip));
                            field[indexesShip[0]][indexesShip[1]] = "xx";
                        }
                    }
                System.out.println(countX);
                System.out.println(sunk);
                }
            case "s5" -> {
                Ship ship = ships.get(4);
                for (int i = 0; i < ship.getSquares().size(); i++) {
                    int[] indexesShip = ship.getSquares().get(i);
                    if (field[indexesShip[0]][indexesShip[1]].equals(" x")) {
                        countX++;
                        }
                    }
                    if (countX  == ship.getLength()) {
                        sunk++;
                        for (int i = 0; i < ship.getSquares().size(); i++) {
                            int[] indexesShip = ship.getSquares().get(i);
                            field[indexesShip[0]][indexesShip[1]] = "xx";
                        }
                    }
                }
            case "s6" -> {
                Ship ship = ships.get(5);
                for (int i = 0; i < ship.getSquares().size(); i++) {
                    int[] indexesShip = ship.getSquares().get(i);
                    if (field[indexesShip[0]][indexesShip[1]].equals(" x")) {
                        countX++;
                        }
                    }
                    if (countX  == ship.getLength()) {
                        sunk++;
                        for (int i = 0; i < ship.getSquares().size(); i++) {
                            int[] indexesShip = ship.getSquares().get(i);
                            field[indexesShip[0]][indexesShip[1]] = "xx";
                        }
                    }
                }
            }
            if(sunk >= 1){
                System.out.println("Ship has been sunk!");
            }
        }



}
