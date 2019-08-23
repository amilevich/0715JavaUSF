import { Injectable } from '@angular/core';
import {HttpHeaders, HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class StatsServiceService {

  private _url: string = "https://pokeapi.co/api/v2/pokemon/"
  private temp: string;

  private httpOptions = {
    headers: new HttpHeaders({
    'Accept' : 'application/json'
    })
  }

  constructor(private httpServe: HttpClient) { }

  getAbility(search: string): Observable<string> 
  {
    this.temp = this._url + search
    return this.httpServe.get(this.temp, this.httpOptions).pipe(
      map(res => res as string)
    )
  }
}
