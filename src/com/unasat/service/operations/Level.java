package com.unasat.service.operations;

public class Level {
    private int numMoves;
    private int points;
    private int mistakes;
    private boolean isFinished;


    private static final int MAX_MISTAKES = 10;

    public Level(int points, int mistakes) {
        this.points = 0;
        this.mistakes = 0;
        this.isFinished = false;
    }

    public Level() {
    }

    //Methods

    //Simple methods

    public int getMistakes() {
        return mistakes;
    }

    public int getPoints() {
        return points;
    }

    public void cardMatched() {
        points += 2;
    }

    public void incrementMistakes() {
        mistakes += 1;
    }

    public boolean isGameOverEarly() {
         return mistakes >= MAX_MISTAKES;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}

class EasyLevel extends Level {

    public EasyLevel(int numMoves, int points, int mistakes){
        super(0, 0);
    }

    public EasyLevel() {}
}

class MediumLevel extends Level {

    public MediumLevel(int numMoves, int points, int mistakes){
        super(0, 0);
    }

    public MediumLevel() {}
}

class HardLevel extends Level {

    public HardLevel(int numMoves, int points, int mistakes){
        super(0, 0);
    }

    public HardLevel() {}
}