import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PokerService {


  playersUrl = '/api/poker/game';

  constructor( private http: HttpClient) {   }

  mostrar(){
    return this.http.get<any>(`${this.playersUrl}`);
  }
}
