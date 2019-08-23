import { Component, OnInit } from '@angular/core';
import { PokeServiceService } from '../poke-service.service';

@Component({
  selector: 'app-search-poke',
  templateUrl: './search-poke.component.html',
  styleUrls: ['./search-poke.component.css']
})
export class SearchPokeComponent implements OnInit {

  constructor(private _pokeService: PokeServiceService) { }

  _searchTerm: string;
  name: string;
  img: ImageData;

  set searchTerm(search: string){
    this._searchTerm = search;
  }

  get searchTerm(){
    return this._searchTerm;
  }

  onSearch(){
    this._pokeService.searchPoke(this._searchTerm).subscribe(data =>{
      this.name = data['name'];
      this.img = data['sprites']['front_default'];
    })
  }

  clickSearch(): void{
    this.onSearch();
  }

  ngOnInit() {
  }

}
