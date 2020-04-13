package com.musicplayce.desafiopoker.controller;

import java.util.Arrays;
import java.util.Scanner;

import com.musicplayce.desafiopoker.model.Card;
import com.musicplayce.desafiopoker.model.Deck;
import com.musicplayce.desafiopoker.model.Player;

public class Game {

    private final int HAND_SIZE = 5;

    // instantiate Deck and Player
    Scanner scan = new Scanner(System.in);
    Deck deck = new Deck();

    Card[] hand;

    // plays the game
    public int[] play(Player player) {

        //fill deck
        deck.fillDeck();

        // shuffle
        deck.shuffle();

        // player draws
        hand = player.draw(deck);
        //this.makeHand(); // make a personal hand

        // sort hand
        Arrays.sort(hand);

        // evaluate the hand
        if (this.royalFlush() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 22};
            return handaux;
        } else if (this.straightFlush() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 21};
            return handaux;
        } else if (this.fourOfaKind() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 20};
            return handaux;
        } else if (this.fullHouse() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 19};
            return handaux;
        } else if (this.flush() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 18};
            return handaux;
        } else if (this.straight() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 17};
            return handaux;
        } else if (this.triple() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 16};
            return handaux;
        } else if (this.twoPairs() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 15};
            return handaux;
        } else if (this.pair() == 1) {
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, 14};
            return handaux;
        } else {
            int highCard = this.highCard();
            int[] handaux = {hand[0].rank,hand[0].suit, hand[1].rank,hand[1].suit, hand[2].rank,hand[2].suit, hand[3].rank,hand[3].suit, hand[4].rank,hand[4].suit, highCard};
            return handaux;
        }
    }

    // makes a hand (for TA; testing purposes)
    public void makeHand() {
        hand[0].rank = 1;
        hand[1].rank = 2;
        hand[2].rank = 3;
        hand[3].rank = 4;
        hand[4].rank = 5;

        hand[0].suit = 1;
        hand[1].suit = 1;
        hand[2].suit = 1;
        hand[3].suit = 1;
        hand[4].suit = 1;
    }

    // checks for a royal flush
    public int royalFlush() {
        if (hand[0].rank == 1 && hand[1].rank == 10 && hand[2].rank == 11
                && hand[3].rank == 12 && hand[4].rank == 13) {
            return 1;
        } else {
            return 0;
        }
    }

    // checks for a straight flush
    public int straightFlush() {
        for (int counter = 1; counter < 5; counter++) {
            if (hand[0].suit != hand[counter].suit) {
                return 0;
            }
        }
        for (int counter2 = 1; counter2 < 5; counter2++) {
            if (hand[counter2 - 1].rank != (hand[counter2].rank - 1)) {
                return 0;
            }

        }
        return 1;

    }

    // checks for four of a kind
    public int fourOfaKind() {
        if (hand[0].rank != hand[3].rank && hand[1].rank != hand[4].rank) {
            return 0;
        } else {
            return 1;
        }
    }

    // checks for full house
    public int fullHouse() {
        int comparison = 0;
        for (int counter = 1; counter < 5; counter++) {
            if (hand[counter - 1].rank == hand[counter].rank) {
                comparison++;
            }
        }
        if (comparison == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    // checks for flush
    public int flush() {
        for (int counter = 1; counter < 5; counter++) {
            if (hand[0].suit != hand[counter].suit) {
                return 0;
            }
        }
        return 1;
    }

    // check for straight
    public int straight() {
        for (int counter2 = 1; counter2 < 5; counter2++) {
            if (hand[counter2 - 1].rank != (hand[counter2].rank - 1)) {
                return 0;
            }

        }
        return 1;
    }

    // checks for triple
    public int triple() {
        if (hand[0].rank == hand[2].rank || hand[2].rank == hand[4].rank) {
            return 1;
        }
        return 0;
    }

    // checks for two pairs
    public int twoPairs() {
        int check = 0;
        for (int counter = 1; counter < 5; counter++) {
            if (hand[counter - 1].rank == hand[counter].rank) {
                check++;
            }
        }
        if (check == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    // check for pair
    public int pair() {
        int check = 0;
        for (int counter = 1; counter < 5; counter++) {
            if (hand[counter - 1].rank == hand[counter].rank) {
                check++;
            }
        }
        if (check == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    // find highest card
    public int highCard() {
        int highCard = 0;
        for (int counter = 0; counter < 5; counter++) {
            if (hand[counter].rank > highCard) {
                highCard = hand[counter].rank;
            }
        }
        return highCard;
    }
}
