package com.kodilla.rps;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class RpsGame {

    public boolean playRps() {
        final Scanner scan = new Scanner(System.in);
        System.out.println("What's your name?");

        final String username = scan.nextLine();

        System.out.println("How many rounds are needed to win?");

        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("Please enter a number: ");
        }
        int numberOfRoundsToWin = scan.nextInt();

        System.out.println("Hello, " + username + ", you need to win " + numberOfRoundsToWin + " rounds.");

        int computerWins = 0;
        int userWins = 0;

        System.out.println("Time to play!");

        while (computerWins < numberOfRoundsToWin && userWins < numberOfRoundsToWin) {
            System.out.println("Your move:");

            System.out.println("\nControls:\n" +
                    "1 - rock\n" +
                    "2 - paper\n" +
                    "3 - scissors\n" +
                    "x - end game\n" +
                    "n - new game");
            final Move userMove = getUserMove();

            switch (userMove) {
                case END_GAME:
                    System.out.println("Exit game? x - exit game, any key - continue.");
                    if (getUserMove() == Move.END_GAME) {
                        System.out.println("Goodbye!");
                        return true;
                    } else {
                        continue;
                    }
                case NEW_GAME:
                    System.out.println("New game? n - start a new game, any key - continue.");

                    if (getUserMove() == Move.NEW_GAME) {
                        return false;
                    } else {
                        continue;
                    }
            }


            final Move computerMove = Move.values()[new Random().nextInt(3)];

            final Result result = GameEngine.getResult(computerMove, userMove);

            System.out.println("You: " + userMove);
            System.out.println("Computer: " + computerMove);

            switch (result) {
                case COMPUTER_WIN:
                    computerWins++;
                    break;
                case USER_WIN:
                    userWins++;
                    break;
            }

            System.out.println("User vs Computer : " + userWins + " - " + computerWins);
        }

        if (userWins > computerWins) {
            System.out.println("Congratulations! You won the game!");
        } else {
            System.out.println("LOSER!");
        }
        return true;
    }

    private Move getUserMove() {

        while (true) {
            String userInput = new Scanner(System.in).nextLine();
            Optional<Move> moveOptional = Move.fromUserInput(userInput);
            if (moveOptional.isPresent()) {
                return moveOptional.get();
            }
        }

    }
}
