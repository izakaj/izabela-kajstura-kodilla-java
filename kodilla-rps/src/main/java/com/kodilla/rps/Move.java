package com.kodilla.rps;

import java.util.Optional;

public enum Move {

    PAPER, SCISSORS, ROCK, END_GAME, NEW_GAME;

    public static Optional<Move> fromUserInput(String userInput) {
        switch (userInput) {
            case "1":
                return Optional.of(ROCK);
            case "2":
                return Optional.of(PAPER);
            case "3":
                return Optional.of(SCISSORS);
            case "x":
                return Optional.of(END_GAME);
            case "n":
                return Optional.of(NEW_GAME);
        }
        return Optional.empty();
    }
}
