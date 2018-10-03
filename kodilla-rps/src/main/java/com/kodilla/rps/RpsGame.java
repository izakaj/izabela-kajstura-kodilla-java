package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {
    private String username;
    private int numberOfRoundsToWin;

    Random r = new Random();

    public boolean playRps() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What's your name?");
        username = scan.nextLine();
        System.out.println("How many rounds are needed to win?");
        while (!scan.hasNextInt()){
            scan.next();
            System.out.print("Please enter a number: ");
        }
        numberOfRoundsToWin = scan.nextInt();

        System.out.println("Hello, " + username + ", you need to win " + numberOfRoundsToWin + " rounds.");

        System.out.println("\nControls:\n" +
                "1 - rock\n" +
                "2 - paper\n" +
                "3 - scissors\n" +
                "x - end game\n" +
                "n - new game");

        int computerWins = 0;
        int playerWins = 0;

        char yourMove = ' ';

        int userMove = 0;
        String userMoveName = "";
        int computerMove;
        String computerMoveName;

        boolean checkKey = false;

        System.out.println("Time to play!");

        while (computerWins < numberOfRoundsToWin && playerWins < numberOfRoundsToWin){
            System.out.println("Your move:");

            yourMove = scan.next().charAt(0);
            checkKey = false;

            while (!checkKey){

                checkKey = true;

                switch (yourMove){
                    case '1':
                        userMoveName = "rock";
                        break;
                    case '2':
                        userMoveName = "paper";
                        break;
                    case '3':
                        userMoveName = "scissors";
                        break;
                    case 'x':
                        System.out.println("Exit game? x - exit game, any key - continue.");
                        yourMove = scan.next().charAt(0);
                        if(yourMove == 'x'){
                            System.out.println("Goodbye!");
                            return true;
                        } else {
                            System.out.println("Your move: ");
                            yourMove = scan.next().charAt(0);
                            checkKey = false;
                        }
                        break;
                    case 'n':
                        System.out.println("New game? n - start a new game, any key - continue.");
                        yourMove = scan.next().charAt(0);
                        if(yourMove == 'n'){
                            return false;
                        } else {
                            System.out.println("Your move: ");
                            yourMove = scan.next().charAt(0);
                            checkKey = false;
                        }
                        break;
                    default:
                        System.out.println("Wrong key! Try again:");
                        yourMove = scan.next().charAt(0);
                        checkKey = false;
                        break;
                }
            }


            userMove = Character.getNumericValue(yourMove);

            computerMove = (r.nextInt(3) + 1);
            computerMoveName = (computerMove == 1 ? "rock" :
                    (computerMove == 2 ? "paper" : "scissors"));

            System.out.println("You: " + userMoveName);
            System.out.println("Computer: " + computerMoveName);

            if(userMove == computerMove){
                System.out.println("Draw!");
            }else if(userMove - computerMove == 1 || userMove - computerMove == -2){
                System.out.println("You win!");
                playerWins++;
            }else{
                System.out.println("You lose!");
                computerWins++;
            }

            System.out.println("User vs Computer : " + playerWins + " - " + computerWins);
        }

        if(playerWins > computerWins){
            System.out.println("Congratulations! You won the game!");
        }else{
            System.out.println("LOSER!");
        }

        checkKey = false;



        System.out.println("Do you want to play another game? n - new game, x - exit");

        while (!checkKey){
            yourMove = scan.next().charAt(0);
            if(yourMove == 'n'){
                System.out.println("Let's play another game!");
                return false;
            } else if (yourMove == 'x'){
                System.out.println("Goodbye!");
                return true;
            } else {
                System.out.println("Wrong key! Try again:");
            }
        }


        return true;
    }
}
