package view;

import control.Game;
import model.Player;

public class GameTest {

    public static void main(String[] args) {

        // make game
        Game game = new Game();

        // play game
        Player player = new Player();
        Player player2 = new Player();

        int[] playerGame = game.play(player);
        System.out.println("____________________________________");
        System.out.println("Player 1 result: " + playerGame[5]);
        System.out.println("____________________________________");
        int[] playerGame2 = game.play(player2);
        System.out.println("____________________________________");
        System.out.println("Player 2 result: " + playerGame2[5]);
        System.out.println("____________________________________");

        if (playerGame[5] == playerGame2[5]) {
            int desempate = desempatar(playerGame, playerGame2);
            switch (desempate) {
                case 1:
                    System.out.println("Player 1 Win");
                    break;
                case 2:
                    System.out.println("Player 2 Win");
                    break;
                default:
                    System.out.println("Empate");
                    break;
            }
        } else {
            if (playerGame[5] > playerGame2[5]) {
                System.out.println("Player 1 Win");
            } else {
                System.out.println("Player 2 Win");
            }
        }

        /*
        System.out.println("__________________");
        int[] player2Game = game.play(player2);
        System.out.println(player2Game);
        System.out.println("__________________");

        if (playerGame == player2Game) {
            System.out.println("Empate");
        } else {
            if (playerGame > player2Game) {
                System.out.println("Player 1 Win");
            } else {
                System.out.println("Player 2 Win");
            }
        }
         */
    }

    public static int desempatar(int[] player1, int[] player2) {
        if (player1[4] > player2[4]) {
            return 1;
        } else if (player1[4] == player2[4]) {
            if (player1[3] > player2[3]) {
                return 1;
            } else if (player1[3] == player2[3]) {
                if (player1[2] > player2[2]) {
                    return 1;
                } else if (player1[2] == player2[2]) {
                    if (player1[1] > player2[1]) {
                        return 1;
                    } else if (player1[1] == player2[1]) {
                        if (player1[0] > player2[0]) {
                            return 1;
                        } else if (player1[0] == player2[0]) {
                            return 3;
                        } else {
                            return 2;
                        }
                    } else {
                        return 2;
                    }
                } else {
                    return 2;
                }
            } else {
                return 2;
            }
        } else {
            return 2;
        }
    }
}
