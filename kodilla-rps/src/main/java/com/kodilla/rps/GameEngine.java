package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

public class GameEngine {

    private final static Map<MovePair, Result> gameMap = new HashMap<>();

    static {
        gameMap.put(new MovePair(Move.SCISSORS, Move.SCISSORS), Result.TIE);
        gameMap.put(new MovePair(Move.PAPER, Move.PAPER), Result.TIE);
        gameMap.put(new MovePair(Move.ROCK, Move.ROCK), Result.TIE);

        gameMap.put(new MovePair(Move.ROCK, Move.SCISSORS), Result.COMPUTER_WIN);
        gameMap.put(new MovePair(Move.ROCK, Move.PAPER), Result.USER_WIN);

        gameMap.put(new MovePair(Move.SCISSORS, Move.PAPER), Result.COMPUTER_WIN);
        gameMap.put(new MovePair(Move.SCISSORS, Move.ROCK), Result.USER_WIN);

        gameMap.put(new MovePair(Move.PAPER, Move.ROCK), Result.COMPUTER_WIN);
        gameMap.put(new MovePair(Move.PAPER, Move.SCISSORS), Result.USER_WIN);
    }

    public static Result getResult(Move computerMove, Move userMove) {
        return gameMap.get(new MovePair(computerMove, userMove));
    }
}
