import { Component, OnInit } from '@angular/core';
import { PokeServService } from '../poke-serv.service';

@Component({
  selector: 'app-search-pokemon',
  templateUrl: './search-pokemon.component.html',
  styleUrls: ['./search-pokemon.component.css']
})
export class SearchPokemonComponent implements OnInit {

  constructor(private _pokeService: PokeServService) {}


  _searchTerm: string;
  data: any;

  set search(search: string){
    this._searchTerm = search;
  }

  get searchTerm(){
    return this._searchTerm;
  }

  onSearch(){
    this._pokeService.searchPokeman(this._searchTerm).subscribe(data =>{
      this.data = data['name'];
    })
  }

  clickSearch(): void{
    this.onSearch();
  }

  ngOnInit() {
  }

}
