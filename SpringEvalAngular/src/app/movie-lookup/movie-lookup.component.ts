import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-movie-lookup',
  templateUrl: './movie-lookup.component.html',
  styleUrls: ['./movie-lookup.component.css']
})
export class MovieLookupComponent implements OnInit {

  myresponse: any

  name: string

  baseURL: string = "http://localhost:9005/api" 

  constructor(private _http: HttpClient) { }

  getMovie()
  {
    this._http.get(this.baseURL + "/getMovie?name=" + this.name).subscribe(
      data => {
        this.myresponse = data
      }
    )
  }

  ngOnInit() {
  }

}
