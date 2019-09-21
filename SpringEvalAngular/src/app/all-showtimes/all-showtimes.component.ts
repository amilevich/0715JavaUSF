import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-all-showtimes',
  templateUrl: './all-showtimes.component.html',
  styleUrls: ['./all-showtimes.component.css']
})
export class AllShowtimesComponent implements OnInit {

  myresponse: any

  baseURL: string = "http://localhost:9005/api" 

  constructor(private _http: HttpClient) { 
    this._http.get(this.baseURL + "/getAllShowtimes").subscribe(
      data => {
        this.myresponse = data
      }
    )
  }

  ngOnInit() {

  }
}
