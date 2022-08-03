package com.company;

import java.util.ArrayList;

import static com.company.Field.*;

public class Main {

    public static void main(String[] args) {
        String[][] computerField = generateField();
        String[][] computerFieldPublic = generateField();
        String[][] playerField = generateField();
        ArrayList<Ship> playerShips = new ArrayList<>();
        ArrayList<Ship> computerShips = new ArrayList<>();

        BattleshipGame game = new BattleshipGame();

        game.gameInitialize( computerField, computerShips, playerField, playerShips);

        game.gamePlay(playerField,computerFieldPublic, computerField, computerShips, playerShips);

    }
}

