import { PokerService } from './poker.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-poker',
  templateUrl: './poker.component.html',
  styleUrls: ['./poker.component.sass']
})
export class PokerComponent implements OnInit {

  players: any;

  constructor(private pokerService: PokerService) { }

  ngOnInit(): void {

    this.mostrar();
  }

  mostrar(){
    this.pokerService.mostrar().subscribe(dados => this.players = dados)
  }

  getJogada(valor)
  {
    if (valor == 22) {
      return "You have a royal flush!";
  } else if (valor == 21) {
      return "You have a straight flush!";
  } else if (valor == 20) {
      return "You have four of a kind!";
  } else if (valor == 19) {
      return "You have a full house!";
  } else if (valor == 18) {
      return "You have a flush!";
  } else if (valor == 17) {
      return "You have a straight!";
  } else if (valor == 16) {
      return "You have a triple!";
  } else if (valor == 15) {
      return "You have two pairs!";
  } else if (valor == 14) {
      return "You have a pair!";
  } else{
      return "Your highest card is " + valor;
  }
  }

 display(rank, suit) {
   let rank2;
   let suit2;
   suit2:"";
    if (rank == 1) {
        rank2 = "Ace of ";
    }
    if (rank == 2) {
      rank2 = "Two of ";
    }
    if (rank == 3) {
      rank2 = "Three of ";
    }
    if (rank == 4) {
      rank2 = "Four of ";
    }
    if (rank == 5) {
      rank2 = "Five of ";
    }
    if (rank == 6) {
      rank2 = "Six of ";
    }
    if (rank == 7) {
      rank2 = "Seven of ";
    }
    if (rank == 8) {
      rank2 = "Eight of ";
    }
    if (rank == 9) {
      rank2 = "Nine of ";
    }
    if (rank == 10) {
      rank2 = "Ten of ";
    }
    if (rank == 11) {
      rank2 = "Jack of ";
    }
    if (rank == 12) {
      rank2 = "Queen of ";
    }
    if (rank == 13) {
      rank2 = "King of ";
    }
    if (suit == 1) {
      suit2 = "Spades";
    }
    if (suit == 2) {
      suit2 = "Hearts";
    }
    if (suit == 3) {
      suit2 = "Diamonds";
    }
    if (suit == 4) {
      suit2 = "Clubs";
    }
    return rank2 + suit2;
  }
}
