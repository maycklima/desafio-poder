import { PokerService } from './poker.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-poker',
  templateUrl: './poker.component.html',
  styleUrls: ['./poker.component.sass']
})
export class PokerComponent implements OnInit {

  players: Array<any>;

  constructor(private pokerService: PokerService) { }

  ngOnInit(): void {

    this.mostrar();
  }

  mostrar(){
    this.pokerService.mostrar().subscribe(dados => this.players = dados)
  }
}
