package com.musicplayce.desafiopoker.model;

import lombok.Data;

@Data
public class Player {

    private String nome;

    // gets 5 cards from deck
    public Card[] draw(Deck deck) {
        Card[] hand = deck.deal();
        return hand;
    }

    // switches card for a new card
    public Card redraw(int counter, Deck deck) {
        Card card = deck.redeal();
        return card;
    }
}
