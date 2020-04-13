import { Injectable } from '@angular/core';
import { Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PokerService {

  @Input() player1Name = '';
  @Input() player2Name = '';
  playersUrl = '/api/poker/game';

  constructor( private http: HttpClient) {   }

  mostrar(nome1, nome2){
    return this.http.get<any>(`${this.playersUrl}` + "?player1nome=" + nome1 + "&player2nome= " + nome2);
  }
}
