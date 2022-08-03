package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static com.company.BattleshipGame.convertMoveToIndexes;
import static com.company.Field.LENGTH_OF_FIELD;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

public class PlayerMoves extends GameMoves {
    Field f = new Field();

    @Override
    public void createShip(String[][] playerField, ArrayList<Ship> playerShips) {
        for (int i = 2; i < 7; i++) {
            Ship s = new Ship(i);

            do {
                defineShipLocation(s, playerField, playerShips.size() + 1);
            } while (s.getSquares().isEmpty());

            playerShips.add(s);
            f.printField(playerField);
        }
    }

    @Override
    public void defineShipLocation(Ship ship, String[][] playerField, int shipNo) {
        String move1;
        int[] indexes1;
        do {
            Scanner input1 = new Scanner(System.in);
            System.out.println("Please enter start square coordinates (e.g., E09) for ship (length " + ship.getLength() + "): ");
            move1 = input1.nextLine().toUpperCase(Locale.ROOT);
            indexes1 = convertMoveToIndexes(move1, playerField);
        } while (indexes1 == null);
        if (move1.length() != 3) {
            return;
        }
        if (indexes1[0] == 0 || indexes1[1] == 0) {
            return;
        }
        String move2;
        int[] indexes2;
        do {
            Scanner input2 = new Scanner(System.in);
            System.out.println("Please enter end square coordinates (e.g., E09) for ship: ");
            move2 = input2.nextLine().toUpperCase(Locale.ROOT);
            indexes2 = convertMoveToIndexes(move2, playerField);
        } while (indexes2 == null);
        if (move2.length() != 3) {
            return;
        }
        if (indexes2[0] == 0 || indexes2[1] == 0) {
            return;
        }
// 1)determine direction
        if (indexes1[0] == indexes2[0]) {
            //row remains, letter changes
            // 2)check whether squares are empty
            if (indexes1[1] - 1 + ship.getLength() > LENGTH_OF_FIELD) {
                System.out.println(ansi().fg(RED).a("Ship too long to be placed at the coordinates given, choose another square").reset());
                return;
            }
            int count = 0;
            for (int i = 0; i < ship.getLength(); i++) {
                if (playerField[indexes1[0]][indexes1[1] + i].equals("")) {
                    count++;
                } else {
                    System.out.println(ansi().fg(RED).a("Square already taken, please choose another one").reset());
                    break;
                }
                if (count == ship.getLength()) {
                    for (int j = 0; j < ship.getLength(); j++) {
                        playerField[indexes1[0]][indexes1[1] + j] = "s" + shipNo;
                        String move = playerField[0][indexes1[1] + j] + playerField[indexes1[0]][0];
                        int[] indexes = convertMoveToIndexes(move, playerField);
                        ship.setSquares(indexes);
                    }
                }
            }
        }
        if (indexes1[1] == indexes2[1]) {
            //letter remains, row changes
            // 2)check whether square is empty
            if (indexes1[0] - 1 + ship.getLength() > LENGTH_OF_FIELD) {
                System.out.println(ansi().fg(RED).a("Ship too long to be placed at the coordinates given, choose another square").reset());
                return;
            }
            int count = 0;
            for (int i = 0; i < ship.getLength(); i++) {
                if (playerField[indexes1[0] + i][indexes1[1]].equals("")) {
                    count++;
                } else {
                    System.out.println(ansi().fg(RED).a("Square already taken, please choose another one").reset());
                    break;
                }
                if (count == ship.getLength()) {
                    for (int j = 0; j < ship.getLength(); j++) {
                        playerField[indexes1[0] + j][indexes1[1]] = "s" + shipNo;
                        int[] indexes = convertMoveToIndexes(playerField[0][indexes1[1]] + playerField[indexes1[0] + j][0], playerField);
                        ship.setSquares(indexes);
                    }
                }
            }
        }
    }

    @Override
    public int[] makeMove(String[][] computerField, String[][] computerFieldPublic, ArrayList<Ship> computerShips) {
        int[] indexes;
        boolean getMove;
        do {
            do {
                String move = askPlayerForMove();
                indexes = convertMoveToIndexes(move, computerField);
            } while (indexes == null);
            getMove = updateFieldAfterMove(computerField, computerFieldPublic, indexes, computerShips);
        } while (!getMove);
        f.printPlayerField(computerFieldPublic);
        return indexes;
    }

    @Override
    public boolean updateFieldAfterMove(String[][] computerField, String[][] computerFieldPublic, int[] indexes, ArrayList<Ship> computerShips) {
        boolean getMove;
        String ship = "";
        switch (computerField[indexes[0]][indexes[1]]) {

            case " o" -> {
                System.out.println(ansi().fg(RED).a("Square already hit and missed, please choose another one").reset());
                getMove = false;
            }
            case " x" -> {
                System.out.println(ansi().fg(RED).a("Square already hit, please choose another one").reset());
                getMove = false;
            }
            case "" -> {
                getMove = true;
                System.out.println("It's a miss");
                computerField[indexes[0]][indexes[1]] = " o";
                computerFieldPublic[indexes[0]][indexes[1]] = " o";
            }
            default -> {
                getMove = true;
                if (computerField[indexes[0]][indexes[1]].contains("s")) {
                    System.out.println("It's a hit");
                    ship = computerField[indexes[0]][indexes[1]];
                    computerField[indexes[0]][indexes[1]] = " x";
                    computerFieldPublic[indexes[0]][indexes[1]] = " x";
                    markShipSunk(ship,computerField, computerShips);
                }
            }
        }
        return getMove;
    }


    private String askPlayerForMove() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter coordinates (e.g., E09) for your move: ");
        return input.nextLine().toUpperCase(Locale.ROOT);
    }


}

