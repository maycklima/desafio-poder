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
	public List<Mesa> game(String player1nome, String player2nome) {		
		// make game
        Game game = new Game();
        List<Mesa> listaMesa = new ArrayList<Mesa>();
        Mesa mesa = new Mesa();
        

        // play game
        Player player = new Player();
        Player player2 = new Player();

        player.setNome(player1nome);
        player2.setNome(player2nome);
        
        mesa.setPlayer1(player);
        mesa.setPlayer2(player2);
        
        int[] playerGame = game.play(player);
        int[] playerGame2 = game.play(player2);
        
        mesa.setHand1(playerGame);
        mesa.setHand2(playerGame2);
        
        if (playerGame[5] == playerGame2[5]) {
            int desempate = desempatar(playerGame, playerGame2);
            switch (desempate) {
                case 1:
                	mesa.setResultado(player.getNome() + " venceu!");
                	break;
                case 2:
                	mesa.setResultado(player2.getNome() + " venceu!");
                	break;
                case 3:
                	mesa.setResultado("O jogo deu empate!");
                	break;
            }
        } else {
            if (playerGame[10] > playerGame2[10]) {
            	mesa.setResultado(player.getNome() + " venceu!");
            } else {
            	mesa.setResultado(player2.getNome() + " venceu!");
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
