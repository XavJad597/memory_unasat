package com.unasat.service.operations;

import java.util.ArrayList;

public class GameBoard {

    protected ArrayList<Character> board;
    protected String[][] tryString;

    public GameBoard() {
        board = new ArrayList<>();
        tryString = new String[0][0];
    }

    public void printBoard() {
        for (int j = 0; j < tryString.length; j++) {
            for (int i = 0; i < tryString.length; i++) {
                System.out.print("| " + i + " ");
            }
            System.out.println("|");
        }
    }

}

class Easy extends GameBoard{

    public Easy() {
        tryString = new String[3][4];

        tryString[0][0] = " │1 │ "; // Number 1 in a box
        tryString[0][1] = " │2 │ "; // Number 2 in a box
        tryString[0][2] = " │3 │ "; // Number 3 in a box
        tryString[0][3] = " │4 │ "; // Number 4 in a box
        tryString[1][0] = " │5 │ "; // Number 5 in a box
        tryString[1][1] = " │6 │ "; // Number 6 in a box
        tryString[1][2] = " │7 │ "; // Number 7 in a box
        tryString[1][3] = " │8 │ "; // Number 8 in a box
        tryString[2][0] = " │9 │ "; // Number 9 in a box
        tryString[2][1] = " │10│ "; // Number 10 in a box
        tryString[2][2] = " │11│ "; // Number 11 in a box
        tryString[2][3] = " │12│ "; // Number 12 in a box



    }

    @Override
    public void printBoard(/*String[] board*/) {
        for (int j = 0; j < tryString.length; j++) {
            for (int i = 0; i < tryString.length + 1; i++) {
                System.out.print("| " + tryString[j][i] + " ");
            }
            System.out.println("|");
        }
    }
}

class Medium extends GameBoard{



public Medium() {
            tryString = new String[4][5];

            tryString[0][0] = " │1 │ "; // Number 1 in a box
            tryString[0][1] = " │2 │ "; // Number 2 in a box
            tryString[0][2] = " │3 │ "; // Number 3 in a box
            tryString[0][3] = " │4 │ "; // Number 4 in a box
            tryString[0][4] = " │5 │ "; // Number 5 in a box
            tryString[1][0] = " │6 │ "; // Number 6 in a box
            tryString[1][1] = " │7 │ "; // Number 7 in a box
            tryString[1][2] = " │8 │ "; // Number 8 in a box
            tryString[1][3] = " │9 │ "; // Number 9 in a box
            tryString[1][4] = " │10│ "; // Number 10 in a box
            tryString[2][0] = " │11│ "; // Number 11 in a box
            tryString[2][1] = " │12│ "; // Number 12 in a box
            tryString[2][2] = " │13│ "; // Number 13 in a box
            tryString[2][3] = " │14│ "; // Number 14 in a box
            tryString[2][4] = " │15│ "; // Number 15 in a box
            tryString[3][0] = " │16│ "; // Number 16 in a box
            tryString[3][1] = " │17│ "; // Number 17 in a box
            tryString[3][2] = " │18│ "; // Number 18 in a box
            tryString[3][3] = " │19│ "; // Number 19 in a box
            tryString[3][4] = " │20│ "; // Number 20 in a box
    }

    @Override
    public void printBoard(/*String[] board*/) {
        for (int j = 0; j < tryString.length; j++) {
            for (int i = 0; i < tryString.length + 1; i++) {
                System.out.print("| " + tryString[j][i] + " ");
            }
            System.out.println("|");
        }
    }
}

class Hard extends GameBoard{

    public Hard() {
        tryString = new String[5][6];

        tryString[0][0] = " │1 │ "; // Number 1 in a box
        tryString[0][1] = " │2 │ "; // Number 2 in a box
        tryString[0][2] = " │3 │ "; // Number 3 in a box
        tryString[0][3] = " │4 │ "; // Number 4 in a box
        tryString[0][4] = " │5 │ "; // Number 5 in a box
        tryString[0][5] = " │6 │ "; // Number 6 in a box
        tryString[1][0] = " │7 │ "; // Number 7 in a box
        tryString[1][1] = " │8 │ "; // Number 8 in a box
        tryString[1][2] = " │9 │ "; // Number 9 in a box
        tryString[1][3] = " │10│ "; // Number 10 in a box
        tryString[1][4] = " │11│ "; // Number 11 in a box
        tryString[1][5] = " │12│ "; // Number 12 in a box
        tryString[2][0] = " │13│ "; // Number 13 in a box
        tryString[2][1] = " │14│ "; // Number 14 in a box
        tryString[2][2] = " │15│ "; // Number 15 in a box
        tryString[2][3] = " │16│ "; // Number 16 in a box
        tryString[2][4] = " │17│ "; // Number 17 in a box
        tryString[2][5] = " │18│ "; // Number 18 in a box
        tryString[3][0] = " │19│ "; // Number 19 in a box
        tryString[3][1] = " │20│ "; // Number 20 in a box
        tryString[3][2] = " │21│ "; // Number 21 in a box
        tryString[3][3] = " │22│ "; // Number 22 in a box
        tryString[3][4] = " │23│ "; // Number 23 in a box
        tryString[3][5] = " │24│ "; // Number 24 in a box
        tryString[4][0] = " │25│ "; // Number 25 in a box
        tryString[4][1] = " │26│ "; // Number 26 in a box
        tryString[4][2] = " │27│ "; // Number 27 in a box
        tryString[4][3] = " │28│ "; // Number 28 in a box
        tryString[4][4] = " │29│ "; // Number 29 in a box
        tryString[4][5] = " │30│ "; // Number 30 in a box
    }

    @Override
    public void printBoard(/*String[] board*/) {
        for (int j = 0; j < tryString.length; j++) {
            for (int i = 0; i < tryString.length + 1; i++) {
                System.out.print("| " + tryString[j][i] + " ");
            }
            System.out.println("|");
        }
    }
}