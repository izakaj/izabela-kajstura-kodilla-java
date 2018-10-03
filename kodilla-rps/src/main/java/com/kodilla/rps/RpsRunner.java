package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        RpsGame rpsGame = new RpsGame();

        boolean end = false;

        while(!end){
            end = rpsGame.playRps();
        }
    }
}
