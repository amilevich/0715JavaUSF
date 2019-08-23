import { Component, OnInit } from '@angular/core';
import { PokeServiceService } from '../poke-service.service';
import { Pokemon } from '../pokemon.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private _pokeService: PokeServiceService) { }

  _searchTerm: string;
  // data: Pokemon = new Pokemon();
  // data: any;
  _pokemon = '';
  _pokemonImg = '';
  _pokemonType = '';
  set searchTerm(search: string){
    this._searchTerm = search;
  }

  get searchTerm(){
    return this._searchTerm;
  }

  onSearch(){
    this._pokeService.searchPoke(this._searchTerm).subscribe(data=>{
      // console.log(pokemon['results']);
      // this.data= data['results'];
      this._pokemon = data['name'];
      this._pokemonImg = data['sprites']['front_default'];
      this._pokemonType = JSON.stringify(data['types'][0].name);
      // console.log(_pokemonImg);
    })
  }

  clickSearch(): void {
    this.onSearch();
  }
  ngOnInit() {
  }

}
