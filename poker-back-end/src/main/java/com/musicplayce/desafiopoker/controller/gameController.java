package com.musicplayce.desafiopoker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicplayce.desafiopoker.model.Mesa;
import com.musicplayce.desafiopoker.model.Player;

@RestController
@RequestMapping("/poker")
public class gameController {
	
	
	@RequestMapping("/ola")
	public String retornarOla() {
		return "Hello World!";
	}	
	
	
	@RequestMapping("/game")
	public List<Mesa> game() {		
		// make game
        Game game = new Game();
        List<Mesa> listaMesa = new ArrayList<Mesa>();
        Mesa mesa = new Mesa();
        

        // play game
        Player player = new Player();
        Player player2 = new Player();

        player.setNome("Jorge Mayck");
        player2.setNome("Raphael Policena");
        
        mesa.setPlayer1(player);
        mesa.setPlayer2(player2);
        
        int[] playerGame = game.play(player);
        System.out.println("____________________________________");
        System.out.println("Player 1 " + player.getNome() + " result: " + playerGame[5]);
        System.out.println("____________________________________");
        int[] playerGame2 = game.play(player2);
        System.out.println("____________________________________");
        System.out.println("Player 2 " + player2.getNome() + " result: " + playerGame2[5]);
        System.out.println("____________________________________");
        
        mesa.setHand1(playerGame);
        mesa.setHand2(playerGame2);
        
        if (playerGame[5] == playerGame2[5]) {
            int desempate = desempatar(playerGame, playerGame2);
            switch (desempate) {
                case 1:
                	mesa.setResultado("Player 1 - " + player.getNome() + " Win");
                	break;
                case 2:
                	mesa.setResultado("Player 2 - " + player2.getNome() + " Win");
                	break;
                case 3:
                	mesa.setResultado("Empate");
                	break;
            }
        } else {
            if (playerGame[10] > playerGame2[10]) {
            	//return  "Player 1 - " + player.getNome() + " Win";
            	//mesa1.setResultado("Player 1 - " + player.getNome() + " Win");
            	mesa.setResultado("Player 1 - " + player.getNome() + " Win");
            } else {
            	//return "Player 2 - " + player2.getNome() + " Win";
            	//mesa1.setResultado("Player 2 - " + player2.getNome() + " Win");
            	mesa.setResultado("Player 2 - " + player2.getNome() + " Win");
            }
        }
        
        listaMesa.add(mesa);
        
        return listaMesa;
	}
	
	public static int desempatar(int[] player1, int[] player2) {
        if (player1[8] > player2[8]) {
            return 1;
        } else if (player1[8] == player2[8]) {
            if (player1[6] > player2[6]) {
                return 1;
            } else if (player1[6] == player2[6]) {
                if (player1[4] > player2[4]) {
                    return 1;
                } else if (player1[4] == player2[4]) {
                    if (player1[2] > player2[2]) {
                        return 1;
                    } else if (player1[2] == player2[2]) {
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
