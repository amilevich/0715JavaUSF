import { Component, OnInit } from '@angular/core';
import { FoodServiceService } from '../food-service.service';
import { Food } from '../Food';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private foods:FoodServiceService) { }

  _name:string;
  _category:string;
  _ingredients:string;
  _description:string;
  _url:string;


  addFood(){
    this.foods.foods.push(new Food(this._name,this._category, this._url, this._ingredients,this._description));
    alert(this._name+" added.")
  }
  ngOnInit() {
  }


}
