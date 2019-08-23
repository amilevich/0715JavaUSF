import { Component, OnInit } from '@angular/core';
import { PokeServService } from '../poke-serv.service';

@Component({
  selector: 'app-random-pokeman',
  templateUrl: './random-pokeman.component.html',
  styleUrls: ['./random-pokeman.component.css']
})
export class RandomPokemanComponent implements OnInit {

  _pokeman = "Click for a Random Pokeman";
  _pokemanImg = "";



  constructor(private _pokemanService: PokeServService) { }

  ngOnInit() {
  }

  randomPokeButtonClicked(){
    this._pokemanService.getPokemon().subscribe(data => {
      this._pokeman = data['name'];
      this._pokemanImg = data['sprites']['front_default'];
    })
  }



}
