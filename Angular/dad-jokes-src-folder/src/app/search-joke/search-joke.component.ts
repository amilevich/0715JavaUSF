import { Component, OnInit } from '@angular/core';
import { JokeService } from '../joke.service';

@Component({
  selector: 'app-search-joke',
  templateUrl: './search-joke.component.html',
  styleUrls: ['./search-joke.component.css']
})
export class SearchJokeComponent implements OnInit {

  constructor(private _jokeService: JokeService) { }

  _searchTerm: string;
  data: any;

  set searchTerm(search: string){
    this._searchTerm = search;
  }

  get searchTerm(){
    return this._searchTerm;
  }

  onSearch(){
    this._jokeService.searchJoke(this._searchTerm).subscribe(data =>{
      this.data = data['results'];
    })
  }

  clickSearch(): void{
    this.onSearch();
  }

  ngOnInit() {
  }

}
