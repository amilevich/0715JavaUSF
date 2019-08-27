import { Component, OnInit, Input, Injectable } from '@angular/core';
import { Food } from '../Food';
import { FoodServiceService } from '../food-service.service';
import { SelectedService } from '../selected.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {


  constructor(private foods:FoodServiceService, private sel: SelectedService) { }

  food:Food;
  _search:string;

  populate(){
    for(let i of this.foods.foods){
      if (i.name == this._search){
        this.food=i;
      }
    }
    this.sel.selected= this.food;
  }


  ngOnInit() {
  }

 
}
