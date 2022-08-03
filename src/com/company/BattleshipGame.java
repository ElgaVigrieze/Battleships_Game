package com.company;

import java.util.*;


import static com.company.Field.*;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

public class BattleshipGame {
    PlayerMoves p = new PlayerMoves();
    ComputerMoves c = new ComputerMoves();
    Field f = new Field();

    static int[] convertMoveToIndexes(String move, String[][] computerField) {
        int[] indexes;
        move = move.replaceAll(" ", "");
        try {
            if (move.length() == 3) {
                String letter = String.valueOf(move.charAt(0));
                String number = move.charAt(1) + String.valueOf(move.charAt(2));
                indexes = new int [2];
                for (int i = 0; i <= LENGTH_OF_FIELD; i++) {
                    if (computerField[0][i].contains(letter)) {
                        indexes[1] = i;
                        break;
                    }
                }
                for (int j = 0; j <= LENGTH_OF_FIELD; j++) {
                    if (Objects.equals(computerField[j][0], number)) {
                        indexes[0] = j;
                        break;
                    }
                }
                if (indexes[0] == 0 || indexes[1] == 0) {
                    throw new WrongFormatException();
                }
            }
            else {
                throw new WrongFormatException();
            }
        }
        catch (WrongFormatException ex) {
            System.out.println(ansi().fg(RED).a("Wrong format, try again").reset());
            return null;
        }
        return indexes;
    }

    private boolean hasWon(String[][] field){
        boolean win = false;
        int count = 0;
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field[i].length; j++) {
                if (field[i][j].contains("s")) {
                    count++;
                }
            }
        }
        if (count == 0) {
            win = true;
        }
        return win;
    }

    static String hitShip(String[][] playerField, int[] indexesComp){
        int number = indexesComp[0];
        int letter = indexesComp[1];
        if (playerField[number][letter].contains("s")) {
            return playerField[number][letter];
        }
        return "";
    }

    public void gameInitialize(String[][] computerField, ArrayList<Ship> computerShips, String[][] playerField,  ArrayList<Ship> playerShips){
        f.printPlayerField(computerField);
        c.createShip(computerField, computerShips);
        p.createShip(playerField, playerShips);
    }

        public void gamePlay (String[][]playerField, String[][]computerFieldPublic, String[][]
        computerField, ArrayList < Ship > computerShips, ArrayList < Ship > playerShips){
            c.compMoveInitial(playerField, computerFieldPublic,playerShips);
            while (true) {
                p.makeMove(computerField, computerFieldPublic, computerShips);
                if (hasWon(computerField)) {
                    System.out.println("Congrats, all ships are sunk. You win!");
                    break;
                }
                c.compMoveRecurring(playerField, computerFieldPublic, playerShips);
                f.printField(playerField);
                if (hasWon(playerField)) {
                    System.out.println("Game over, all of your ships are sunk. Computer wins!");
                    break;
                }
            }
        }


    }











