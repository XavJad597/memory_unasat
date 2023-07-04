package com.unasat.repository.entity.person;

import com.unasat.service.connection.Scores;
import com.unasat.service.operations.GameController;

public class Combinescore {
    GameController getScore = new GameController();
    Scores send = new Scores();

    public void gamePlay(){
        getScore.playGame();
        int playerPoint = getScore.calculatePoints();
        send.sendScore();
    }
}
