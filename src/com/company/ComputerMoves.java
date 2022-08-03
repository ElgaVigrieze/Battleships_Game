package com.company;

import java.util.ArrayList;
import java.util.Objects;

import static com.company.BattleshipGame.convertMoveToIndexes;
import static com.company.BattleshipGame.hitShip;
import static com.company.Field.*;


public class ComputerMoves extends GameMoves {
    Field f = new Field();

    @Override
    public void createShip(String[][] computerField, ArrayList<Ship>computerShips) {
        for (int i = 2; i < 7; i++) {
            Ship s = new Ship(i);
            do {
                defineShipLocation( s, computerField,computerShips.size()+1);
            } while (s.getSquares().isEmpty());
            computerShips.add(s);
        }
    }
    @Override
    public void defineShipLocation(Ship ship, String[][] computerField, int shipNo) {
// gernerate start coordinates   field[row][column]
            int letter = (int) ((Math.random() * (LENGTH_OF_FIELD) + 0)) + 1;
            int number = (int) ((Math.random() * (LENGTH_OF_FIELD) + 0)) + 1;
            int length = ship.getLength();
            int maxFreeLength = LENGTH_OF_FIELD - length;

            if (computerField[number][letter].equals("") && (number+ length-1) <LENGTH_OF_FIELD && letter < LENGTH_OF_FIELD) {
                // can go up or down
                if(computerField[number + length  - 1 + 1][letter].equals("") &&
                        computerField[number + length  - 1][letter + 1].equals("")) {
                    if (number <= maxFreeLength && letter <= maxFreeLength) {
                        int choice = (int)(Math.random()*(1 + 1)+0);
                        if (choice == 0) {
                            if (computerField[number + length - 1][letter].equals("") &&
                                    computerField[number + length - 1 +1][letter].equals("") &&
                                    computerField[number + length - 1][letter +1].equals("")) {
                                int count = 0;
                                for (int i = 0; i < length; i++) {
                                    if(computerField[number + i][letter].equals("")){
                                        count++;
                                    }
                                    if(count == length){
                                        for (int j = 0; j < length ; j++) {
                                            computerField[number + j][letter] = "s"+shipNo;
                                            String move = computerField[0][letter]+computerField[number + j][0];
                                            int[] indexes = convertMoveToIndexes(move,computerField);
                                            ship.setSquares(indexes);
                                        }
                                    }
                                    else{
                                        break;
                                    }
                                }
                            }
                        } else if (choice == 1) {
                            if (computerField[number][letter + length - 1].equals("") &&
                                    computerField[number + length - 1 +1][letter].equals("") &&
                                    computerField[number + length - 1][letter +1].equals("")) {
                                int count = 0;
                                for (int i = 0; i < length ; i++) {
                                    if(computerField[number][letter + i].equals("")){
                                        count++;
                                    }
                                    if (count == length){
                                        for (int j = 0; j < length ; j++) {
                                            computerField[number][letter + j] = "s"+shipNo;
                                            String move = computerField[0][letter+j]+computerField[number][0];
                                            int[] indexes = convertMoveToIndexes(move, computerField);
                                            ship.setSquares(indexes);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (number <= maxFreeLength && letter > maxFreeLength) {
                        //can go down rows+i
                        if (computerField[number + length - 1][letter].equals("") &&
                                computerField[number + length - 1 +1][letter].equals("") &&
                                computerField[number + length - 1][letter +1].equals("")) {
                            int count = 0;
                            for (int i = 0; i < length ; i++) {
                                if(computerField[number + i][letter].equals("")){
                                    count++;
                                }
                                if(count == length ){
                                    for (int j = 0; j < length ; j++) {
                                        computerField[number + j][letter] = "s"+shipNo;
                                        String move = computerField[0][letter]+computerField[number + j][0];
                                        int[] indexes  = convertMoveToIndexes(move, computerField);
                                        ship.setSquares(indexes);
                                    }
                                }
                            }
                        }
                    }
                    if (number > maxFreeLength && letter <= maxFreeLength) {
                        //can go right letters+i
                        if (computerField[number][letter + length  - 1].equals("") &&
                                computerField[number + length - 1 + 1][letter].equals("") &&
                                computerField[number + length - 1][letter + 1].equals("")) {
                            int count = 0;
                            for (int i = 0; i < length ; i++) {
                                if(computerField[number][letter + i].equals("")){
                                    count++;
                                }
                                if(count == length ){
                                    for (int j = 0; j < length ; j++) {
                                        computerField[number][letter + j] = "s"+shipNo;
                                        String move = computerField[0][letter+j]+computerField[number][0];
                                        int[] indexes = convertMoveToIndexes(move, computerField);
                                        ship.setSquares(indexes);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (computerField[number][letter].equals("") && (number+ length - 1) > 0
                    && (number+ length  - 1) <LENGTH_OF_FIELD && letter > 0 && letter <LENGTH_OF_FIELD){
                if(computerField[number + length - 1 - 1][letter].equals("") &&
                        computerField[number + length - 1][letter - 1].equals("")) {
                    if (number <= maxFreeLength && letter <= maxFreeLength) {
                        int choice = (int)(Math.random()*(1 + 1)+0);
                        if (choice == 0) {
                            if (computerField[number + length - 1][letter].equals("") &&
                                    computerField[number + length - 1 -1][letter].equals("") &&
                                    computerField[number + length - 1][letter -1].equals("")) {
                                int count = 0;
                                for (int i = 0; i < length; i++) {
                                    if(computerField[number + i][letter].equals("")) {
                                        count++;
                                    }
                                    if(count == length){
                                        for (int j = 0; j < length; j++) {
                                            computerField[number + j][letter] = "s"+shipNo;
                                            String move = computerField[0][letter]+computerField[number + j][0];
                                            int[] indexes = convertMoveToIndexes(move, computerField) ;
                                            ship.setSquares(indexes);
                                        }
                                    }
                                }
                            }
                        } if (choice == 1) {
                            if (computerField[number][letter + length - 1].equals("") &&
                                    computerField[number + length - 1 -1][letter].equals("") &&
                                    computerField[number + length - 1][letter -1].equals("")) {
                                int count = 0;
                                for (int i = 0; i < length; i++) {
                                    if(computerField[number][letter + i].equals("")) {
                                        count++;
                                    }
                                    if(count== length){
                                        for (int j = 0; j < length; j++) {
                                            computerField[number][letter + j] = "s"+shipNo;
                                            String move = computerField[0][letter+j]+computerField[number][0];
                                            int[] indexes = convertMoveToIndexes(move, computerField);
                                            ship.setSquares(indexes);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (number <= maxFreeLength && letter > maxFreeLength) {
                        if (computerField[number + length - 1][letter].equals("") &&
                                computerField[number + length - 1 -1][letter].equals("") &&
                                computerField[number + length - 1][letter -1].equals("")) {
                            int count = 0;
                            for (int i = 0; i < length; i++) {
                                if(computerField[number + i][letter].equals("")) {
                                    count++;
                                }
                                if(count == length){
                                    for (int j = 0; j < length; j++) {
                                        computerField[number + j][letter] = "s"+shipNo;
                                        String move = computerField[0][letter]+computerField[number + j][0];
                                        int[] indexes = convertMoveToIndexes(move, computerField);
                                        ship.setSquares(indexes);
                                    }
                                }
                            }
                        }
                    }
                    if (number > maxFreeLength && letter <= maxFreeLength) {
                        //can go right letters+i
                        if (computerField[number][letter + length - 1].equals("") &&
                                computerField[number + length - 1 - 1][letter].equals("") &&
                                computerField[number + length - 1][letter - 1].equals("")) {
                            int count = 0;
                            for (int i = 0; i < length; i++) {
                                if(computerField[number][letter +i].equals("")) {
                                    count++;
                                }
                                if(count == length){
                                    for (int j = 0; j < length; j++) {
                                        computerField[number][letter +j] = "s"+shipNo;
                                        String move = computerField[0][letter+j]+computerField[number][0];
                                        int[] indexes= convertMoveToIndexes(move, computerField);
                                        ship.setSquares(indexes);
                                    }
                                }
                            }
                        }
                    }
                }
            }

    }

    @Override
    public int[] makeMove(String[][] playerField, String[][] fieldPublic, ArrayList<Ship> ships) {
        int[] indexes;
        int countX = 0;
        //count shot squares on the field
        for (String[] strings : playerField) {
            for (String s : strings) {
                if (s.equals(" x")) {
                    countX++;
                }
            }
        }
        switch (countX) {//number of squares shot on field
            case 0 -> indexes = computerMovesRandom(playerField);
            case 1 -> indexes = computerMoves2Case1(playerField);
            case 2 -> indexes = computerMoves2Case2(playerField);
            case 3 -> indexes = computerMoves2Case3(playerField);
            case 4 -> indexes = computerMoves2Case4(playerField);
            case 5 -> indexes = computerMoves2Case5(playerField);
            case 6, default -> indexes = computerMoves2Case6(playerField);
        }
        return indexes;
    }

    @Override
    public boolean updateFieldAfterMove(String[][] playerField, String[][] field, int[] indexesComp, ArrayList<Ship> playerShips) {
        int number = indexesComp[0];
        int letter = indexesComp[1];
        if (Objects.equals(playerField[number][letter], "")) {
            System.out.println();
            System.out.println("Computer moves " + playerField[0][letter].replaceAll(" ","") + playerField[number][0] + ", it's a miss");
            playerField[number][letter] = " o";
        }
        if (playerField[number][letter].contains("s")) {
            System.out.println();
            System.out.println("Computer moves " + playerField[0][letter].replaceAll(" ","") + playerField[number][0] + ", it's a hit");
            playerField[number][letter] = " x";
        }
        return true;
    }

    public int[] computerMovesRandom(String[][] playerField) {  //first move or move after all hit ships have been sunk
        int number;
        int letter;
        int[] indexes;
        while(true) {
            letter = (int) ((Math.random() * (LENGTH_OF_FIELD) + 0)) + 1;
            number = (int) ((Math.random() * (LENGTH_OF_FIELD) + 0)) + 1;
            indexes = new int[]{number, letter};
            if(playerField[number][letter].contains("s")){
                break;
            }
            if(playerField[number][letter].equals("")){
                break;
            }
        }
        return indexes;
    }

    private int[] computerMoves2Case1(String[][] playerField){
        ArrayList<int[]> possibleMoves = new ArrayList<>() {};
        for (int i = 1; i < playerField.length; i++) {
            for (int j = 1; j < playerField[i].length; j++) {
                if (playerField[i][j].equals(" x")) {
                    if (i + 1 <= LENGTH_OF_FIELD) {
                        if (playerField[i + 1][j].equals("") || playerField[i + 1][j].contains("s")) {
                            possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i + 1][0], playerField));
                        }
                    }
                    if (i >= 2) {
                        if (playerField[i - 1][j].equals("") || playerField[i - 1][j].contains("s")) {
                            possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i - 1][0], playerField));
                        }
                    }
                    if (j + 1 <= LENGTH_OF_FIELD) {
                        if (playerField[i][j + 1].equals("") || playerField[i][j + 1].contains("s")) {
                            possibleMoves.add(convertMoveToIndexes(playerField[0][j + 1] + playerField[i][0], playerField));
                        }
                    }
                    if (j >= 2) {
                        if (playerField[i][j - 1].equals("") || playerField[i][j - 1].contains("s")) {
                            possibleMoves.add(convertMoveToIndexes(playerField[0][j - 1] + playerField[i][0], playerField));
                        }
                    }
                }
            }
        }
        int moveNo = (int) ((Math.random() * (possibleMoves.size())) + 0);
        return possibleMoves.get(moveNo);
    }

    private int[] computerMoves2Case2(String[][] playerField) {
        ArrayList<int[]> possibleMoves = new ArrayList<>() {};
        for (int i = 1; i < playerField.length; i++) {
            for (int j = 1; j < playerField[i].length; j++) {
                if (playerField[i][j].equals(" x")) {
                    if (i + 1 <= LENGTH_OF_FIELD) {
                        if (playerField[i + 1][j].equals(" x")) {
                            if (i + 2 <= LENGTH_OF_FIELD) {
                                if (playerField[i + 2][j].equals("") || playerField[i + 2][j].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i + 2][0], playerField));
                                }
                                if (i >= 2) {
                                    if (playerField[i - 1][j].equals("") || playerField[i - 1][j].contains("s")) {
                                        possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i - 1][0], playerField));
                                    }
                                }
                            }
                            if (possibleMoves.isEmpty()) {
                                possibleMoves.add(computerMoves2Case1(playerField));
                            }
                        }
                    }
                    if (j + 1 <= LENGTH_OF_FIELD) {
                        if (playerField[i][j + 1].equals(" x")) {
                            if (j + 2 <= LENGTH_OF_FIELD) {
                                if (playerField[i][j + 2].equals("") || playerField[i][j + 2].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j + 2] + playerField[i][0], playerField));
                                }
                                if (j >= 2) {
                                    if (playerField[i][j - 1].equals("") || playerField[i][j - 1].contains("s")) {
                                        possibleMoves.add(convertMoveToIndexes(playerField[0][j - 1] + playerField[i][0], playerField));
                                    }
                                }
                            }
                            if (possibleMoves.isEmpty()) {
                                possibleMoves.add(computerMoves2Case1(playerField));
                            }
                        }
                    }
                }
            }
        }
        int moveNo = (int) ((Math.random() * (possibleMoves.size())) + 0);
        return possibleMoves.get(moveNo);
    }

    private int[] computerMoves2Case3(String[][] playerField) {
        ArrayList<int[]> possibleMoves = new ArrayList<>() {};
        for (int i = 1; i < playerField.length; i++) {
            for (int j = 1; j < playerField[i].length; j++) {
                if (playerField[i][j].equals(" x")) {
                    if (i + 2 <= LENGTH_OF_FIELD) {
                        if (playerField[i + 1][j].equals(" x") && playerField[i + 2][j].equals(" x")) {
                            if (i + 3 <= LENGTH_OF_FIELD) {
                                if (playerField[i + 3][j].equals("") || playerField[i + 3][j].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i + 3][0], playerField));
                                }
                            }
                            if (i >= 2) {
                                if (playerField[i - 1][j].equals("") || playerField[i - 1][j].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i - 1][0], playerField));
                                }
                            }
                        }
                        if (possibleMoves.isEmpty()) {
                            possibleMoves.add(computerMoves2Case2(playerField));
                        }
                    }

                    if (j + 2 <= LENGTH_OF_FIELD) {
                        if (playerField[i][j + 1].equals(" x") && playerField[i][j + 2].equals(" x")) {
                            if (j + 3 <= LENGTH_OF_FIELD) {
                                if (playerField[i][j + 3].equals("") || playerField[i][j + 3].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j + 3] + playerField[i][0], playerField));
                                }
                            }
                            if (j >= 2) {
                                if (playerField[i][j - 1].equals("") || playerField[i][j - 1].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j - 1] + playerField[i][0], playerField));
                                }
                            }
                            if (possibleMoves.isEmpty()) {
                                possibleMoves.add(computerMoves2Case2(playerField));
                            }
                        }
                    }
                }
            }
        }
        int moveNo = (int) ((Math.random() * (possibleMoves.size())) + 0);
        return possibleMoves.get(moveNo);
    }

    private int[] computerMoves2Case4(String[][] playerField) {
        ArrayList<int[]> possibleMoves = new ArrayList<>() {};
        for (int i = 1; i < playerField.length; i++) {
            for (int j = 1; j < playerField[i].length; j++) {
                if (playerField[i][j].equals(" x")) {
                    if (i + 3 <= LENGTH_OF_FIELD) {
                        if (playerField[i + 1][j].equals(" x") && playerField[i + 2][j].equals(" x") && playerField[i + 3][j].equals(" x")) {
                            if (i + 4 <= LENGTH_OF_FIELD) {
                                if (playerField[i + 4][j].equals("") || playerField[i + 4][j].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i + 4][0], playerField));
                                }
                            }
                            if (i >= 2) {
                                if (playerField[i - 1][j].equals("") || playerField[i - 1][j].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i - 1][0], playerField));
                                }
                            }
                        }
                        if (possibleMoves.isEmpty()) {
                            possibleMoves.add(computerMoves2Case3(playerField));
                        }
                    }
                    if (j + 3 <= LENGTH_OF_FIELD) {
                        if (playerField[i][j + 1].equals(" x") && playerField[i][j + 2].equals(" x") && playerField[i][j + 3].equals(" x")) {
                            if (j + 4 <= LENGTH_OF_FIELD) {
                                if (playerField[i][j + 4].equals("") || playerField[i][j + 4].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j + 4] + playerField[i][0], playerField));
                                }
                            }
                            if (j >= 2) {
                                if (playerField[i][j - 1].equals("") || playerField[i][j - 1].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j - 1] + playerField[i][0], playerField));
                                }
                            }
                            if (possibleMoves.isEmpty()) {
                                possibleMoves.add(computerMoves2Case3(playerField));
                            }
                        }
                    }
                }
            }
        }
        int moveNo = (int) ((Math.random() * (possibleMoves.size())) + 0);
        return possibleMoves.get(moveNo);
    }



    private int[] computerMoves2Case5(String[][] playerField) {
        ArrayList<int[]> possibleMoves = new ArrayList<>() {};
        for (int i = 1; i < playerField.length; i++) {
            for (int j = 1; j < playerField[i].length; j++) {
                if (playerField[i][j].equals(" x")) {
                    if (i + 4 <= LENGTH_OF_FIELD) {
                        if (playerField[i + 1][j].equals(" x") && playerField[i + 2][j].equals(" x") && playerField[i + 3][j].equals(" x") && playerField[i + 4][j].equals(" x")) {
                            if (i + 5 <= LENGTH_OF_FIELD) {
                                if (playerField[i + 5][j].equals("") || playerField[i + 5][j].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i + 5][0], playerField));
                                }
                            }
                            if (i >= 2) {
                                if (playerField[i - 1][j].equals("") || playerField[i - 1][j].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j] + playerField[i - 1][0], playerField));
                                }
                            }
                        }
                        if (possibleMoves.isEmpty()) {
                            possibleMoves.add(computerMoves2Case4(playerField));
                        }
                    }
                    if (j + 4 <= LENGTH_OF_FIELD) {
                        if (playerField[i][j + 1].equals(" x") && playerField[i][j + 2].equals(" x") && playerField[i][j + 3].equals(" x") && playerField[i][j + 4].equals(" x")) {
                            if (j + 5 <= LENGTH_OF_FIELD) {
                                if (playerField[i][j + 5].equals("") || playerField[i][j + 5].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j + 5] + playerField[i][0], playerField));
                                }
                            }
                            if (j >= 2) {
                                if (playerField[i][j - 1].equals("") || playerField[i][j - 1].contains("s")) {
                                    possibleMoves.add(convertMoveToIndexes(playerField[0][j - 1] + playerField[i][0], playerField));
                                }
                            }
                        }
                        if (possibleMoves.isEmpty()) {
                            possibleMoves.add(computerMoves2Case3(playerField));
                        }
                    }
                }
            }
        }
        int moveNo = (int) ((Math.random() * (possibleMoves.size())) + 0);
        return possibleMoves.get(moveNo);
    }

    private int[] computerMoves2Case6(String[][] playerField) {
        ArrayList<int[]> possibleMoves = new ArrayList<>() {
        };
        for (int i = 1; i < playerField.length; i++) {
            for (int j = 1; j < playerField[i].length; j++) {
                if (playerField[i][j].equals(" x")) {
                    if (i + 5 <= LENGTH_OF_FIELD) {
                        possibleMoves.add(computerMoves2Case5(playerField));
                    }
                }
                if (j + 5 <= LENGTH_OF_FIELD) {
                    possibleMoves.add(computerMoves2Case5(playerField));
                }
            }
        }
        int moveNo = (int) ((Math.random() * (possibleMoves.size())) + 0);
        return possibleMoves.get(moveNo);
    }

    public void compMoveInitial(String[][]playerField,  String[][] field, ArrayList < Ship > playerShips){
        int[] indexesComp= computerMovesRandom(playerField);
        String hitShip = hitShip(playerField, indexesComp);
        updateFieldAfterMove(playerField, field, indexesComp, playerShips);
        f.printField(playerField);
        markShipSunk(hitShip, playerField, playerShips);
    }


    public void compMoveRecurring(String[][]playerField, String[][] field, ArrayList < Ship > playerShips){
        int[] indexesComp = makeMove(playerField, field,  playerShips);
        String hitShip = hitShip(playerField, indexesComp);
        updateFieldAfterMove(playerField, field, indexesComp, playerShips);
        markShipSunk(hitShip, playerField, playerShips);
    }




}
