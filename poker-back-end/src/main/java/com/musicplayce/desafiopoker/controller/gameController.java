package com.musicplayce.desafiopoker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicplayce.desafiopoker.model.Mesa;
import com.musicplayce.desafiopoker.model.Player;
import com.musicplayce.desafiopoker.model.Produto;

@RestController
@RequestMapping("/poker")
public class gameController {
	
	
	@RequestMapping("/produto")
	public List<Produto> produto() {
		
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		List<Produto> listaProduto = new ArrayList<Produto>();
		produto1.setNome("Refrigerante");
		produto1.setValor("10 Reais");
		produto1.setQnt("2");
		
		produto1.setNome("Salgadinho");
		produto1.setValor("5 Reais");
		produto1.setQnt("9");
		
		listaProduto.add(produto1);
		listaProduto.add(produto2);
		
		
		return listaProduto;
	} 
	
	
	@RequestMapping("/ola")
	public String retornarOla() {
		return "Hello World!";
	}
	
	
	
	@RequestMapping("/game")
	public List<Mesa> game() {		
		// make game
        Game game = new Game();
        List<Mesa> listaMesa = new ArrayList<Mesa>();
        Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa();
        

        // play game
        Player player = new Player();
        Player player2 = new Player();

        player.setNome("Mayck");
        player2.setNome("Policena");
        
        mesa1.setPlayer(player);
        mesa2.setPlayer(player2);
        
        int[] playerGame = game.play(player);
        System.out.println("____________________________________");
        System.out.println("Player 1 " + player.getNome() + " result: " + playerGame[5]);
        System.out.println("____________________________________");
        int[] playerGame2 = game.play(player2);
        System.out.println("____________________________________");
        System.out.println("Player 2 " + player2.getNome() + " result: " + playerGame2[5]);
        System.out.println("____________________________________");
        
        mesa1.setHand(playerGame);
        mesa2.setHand(playerGame2);
        
        if (playerGame[5] == playerGame2[5]) {
            int desempate = desempatar(playerGame, playerGame2);
            switch (desempate) {
                case 1:
                	//return "Player 1 - " + player.getNome() + " Win";
                	mesa1.setResultado("Player 1 - " + player.getNome() + " Win");
                	mesa2.setResultado("Player 1 - " + player.getNome() + " Win");
                case 2:
                	//return "Player 2 - " + player2.getNome() + " Win";
                	mesa1.setResultado("Player 2 - " + player2.getNome() + " Win");
                	mesa2.setResultado("Player 2 - " + player2.getNome() + " Win");
                default:
                	//return "Empate";
                	mesa1.setResultado("Empate");
                	mesa2.setResultado("Empate");
            }
        } else {
            if (playerGame[5] > playerGame2[5]) {
            	//return  "Player 1 - " + player.getNome() + " Win";
            	mesa1.setResultado("Player 1 - " + player.getNome() + " Win");
            	mesa2.setResultado("Player 1 - " + player.getNome() + " Win");
            } else {
            	//return "Player 2 - " + player2.getNome() + " Win";
            	mesa1.setResultado("Player 2 - " + player2.getNome() + " Win");
            	mesa2.setResultado("Player 2 - " + player2.getNome() + " Win");
            }
        }
        
        listaMesa.add(mesa1);
        listaMesa.add(mesa2);
        
        return listaMesa;
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
