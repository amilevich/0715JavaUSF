import { Injectable } from '@angular/core';
import { HttpHeaders,HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PokeServiceService {
  private _url = "https://pokeapi.co/api/v2/";
  private _urlSearch = "https://pokeapi.co/api/v2/pokemon/";
  private temp: string;
  private httpOptions = {
    headers: new HttpHeaders({
      'Accept': 'application/json'
    })
  }
  constructor(private httpServ: HttpClient) { }

  getPoke(): Observable<string> {
    return this.httpServ.get(this._url, this.httpOptions).pipe(
      map(res=> res as string) // convert the received data into string
    )
  }

  searchPoke(search: string): Observable<string> {
    this.temp = this._urlSearch + search;
    return this.httpServ.get(this.temp, this.httpOptions).pipe(
      map(res => res as string)
    )
  }
}


