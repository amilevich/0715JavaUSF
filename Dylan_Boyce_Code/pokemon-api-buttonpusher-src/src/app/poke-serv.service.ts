import { Injectable } from '@angular/core';
import {HttpHeaders, HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PokeServService {

  private _url = "https://pokeapi.co/";
  private _urlSearch = "https://pokeapi.co/api/v2/pokemon/";
  private temp: string;
  private httpOptions = {
    headers: new HttpHeaders({
    'Accept' : 'application/json'
    })
  }


  constructor( private httpServ: HttpClient) { }

  getPokemon(): Observable<string>{
    this.temp = this._urlSearch + this.generateRandomNumber();
    return this.httpServ.get(this.temp, this.httpOptions).pipe(
      map(res => res as string)
    )
  }

  generateRandomNumber(): string{
    let numTemp = Math.floor((Math.random()* 151) +1);
    let n = numTemp.toString();
    return n;
  }
  

  searchPokeman(search: string): Observable<string>{
    this.temp = this._urlSearch + search;
    return this.httpServ.get(this.temp, this.httpOptions).pipe(
      map(res => res as string)
    )
  }
}
