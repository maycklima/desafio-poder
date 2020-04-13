import { PokerService } from './poker.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-poker',
  templateUrl: './poker.component.html',
  styleUrls: ['./poker.component.sass']
})
export class PokerComponent implements OnInit {

  players: any;
  player1Name:string;
  player2Name:string;
  
  player1Score = 0;
  player2Score = 0;
  resultado;

  imagePath = '/assets/poker-icon.png'
  mostrarResultado = true;
  mostrarBotaoResultado = true;  
  mostrarBotoesResultado = true;
  mostrarDivCartas = true;
  mostrarForm = false;
  placar = true;

   

  constructor(private pokerService: PokerService) { }

  ngOnInit(): void {
  }

  getResultado(){
    this.mostrarResultado = !this.mostrarResultado;
  }

  setResultado(resultado){
    this.resultado = resultado;
  }

  salvarResultado(){
    for (const p of this.players) {
      if(p.resultado == this.player1Name +" venceu!")
      {
        this.player1Score++;
      }else
      {
        this.player2Score++;
      }
    }
    this.limpar()    
    this.placar = false;
  }

  limpar(){
    this.mostrarResultado = true;
    this.mostrarBotaoResultado = true;
  }

  darCartas(nomePlayer1, nomePlayer2){
    if(nomePlayer1 == "" || nomePlayer2 == ""){
    alert("Digite os nomes dos jogadores")
    }else{
      this.player1Name = nomePlayer1;
      this.player2Name = nomePlayer2;
      this.mostrar();
      this.mostrarResultado = true;    
      this.mostrarBotaoResultado = false;
      this.mostrarDivCartas = false;
      this.mostrarBotoesResultado = false;
      this.mostrarForm = true;
    }
  }
  novoJogo(){
    this.player1Name = "";
    this.player2Name = "";
    this.player1Score = 0;
    this.player2Score = 0;
    this.mostrarResultado = false;    
    this.mostrarBotoesResultado = true;
    this.mostrarDivCartas = true;
    this.mostrarForm = false;
    this.placar = true;
  }

  mostrar(){
    this.pokerService.mostrar( this.player1Name,  this.player2Name).subscribe(dados => this.players = dados)
  }

  getJogada(valor)
  {
    if (valor == 22) {
      return "Você tem um royal flush!";
  } else if (valor == 21) {
      return "Você tem um straight flush!";
  } else if (valor == 20) {
      return "Você tem um four of a kind!";
  } else if (valor == 19) {
      return "Você tem um full house!";
  } else if (valor == 18) {
      return "Você tem um flush!";
  } else if (valor == 17) {
      return "Você tem um straight!";
  } else if (valor == 16) {
      return "Você tem um triple!";
  } else if (valor == 15) {
      return "Você tem dois pares!!";
  } else if (valor == 14) {
      return "Você tem um par!";
  } else{
      return "Sua maior carta é a " + valor + "!";
  }
  }

  retornaImagem(rank,suit)
  {
    return "/assets/baralho/" + rank + "-" + suit + ".png"
  }
  
}
