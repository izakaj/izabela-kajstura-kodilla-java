package com.kodilla.rps;

import java.util.Objects;

public class MovePair {
    private Move computerMove;
    private Move userMove;

    public MovePair(Move computerMove, Move userMove) {
        this.computerMove = computerMove;
        this.userMove = userMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovePair movePair = (MovePair) o;
        return computerMove == movePair.computerMove &&
                userMove == movePair.userMove;
    }

    @Override
    public int hashCode() {

        return Objects.hash(computerMove, userMove);
    }

}
