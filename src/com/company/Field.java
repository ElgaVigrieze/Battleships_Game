package com.company;

import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

public class Field {
    final static int LENGTH_OF_FIELD = 10;
    final static String[] fNumbers = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"};
    final static String[] fLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};


   static String[][] generateField() {
        String[][] field = new String[11][11];

        for (int i = 0; i < LENGTH_OF_FIELD; i++) {
            field[i + 1][0] = fNumbers[i];
        }
        for (int i = 0; i < LENGTH_OF_FIELD; i++) {
            field[0][i + 1] = fLetters[i] + " ";
        }
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {
                if (field[i][j] == null) {
                    field[i][j] = "";
                }
            }
        }
        field[0][0] = "  ";

        return field;
    }

    public void printField(String[][] field) {
        for (String[] strings : field) {
            for (String string : strings) {
                if (string.equals("")) {
                    System.out.print(string + "  |");
                }
                if (!string.equals("")) {
                    System.out.print(string + "|");
                }
            }
            System.out.println();
        }
    }
    public void printPlayerField(String[][] field) {
        for (String[] strings : field) {
            for (String string : strings) {
                if (string.equals("")) {
                    System.out.print(ansi().fg(GREEN).a(string + "  |").reset());
                }
                if (!string.equals("")) {
                    System.out.print(ansi().fg(GREEN).a(string + "|").reset());
                }
            }
            System.out.println();
        }

    }



}




