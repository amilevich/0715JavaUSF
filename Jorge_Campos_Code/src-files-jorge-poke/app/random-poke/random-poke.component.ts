import { Component, OnInit } from '@angular/core';
import { PokeServiceService } from '../poke-service.service';


@Component({
  selector: 'app-random-poke',
  templateUrl: './random-poke.component.html',
  styleUrls: ['./random-poke.component.css']
})
export class RandomPokeComponent implements OnInit {

  _poke = "Click the button to get a random Pokemon";

  constructor(private _pokeService: PokeServiceService) { }

  ngOnInit() {
  }

  randomPokeButtonClicked(){
    this._pokeService.getPoke().subscribe(data => {
      this._poke = data['name'];

    })
  }
}
