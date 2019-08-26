import { Component, OnInit } from '@angular/core';
import { FoodServiceService } from '../food-service.service';
import { Router } from '@angular/router';
import { Food } from '../Food';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private foods: FoodServiceService, private rout: Router) { }
  _cat: string;
  foodList: Array<Food> = this.foods.foods;

  redirect(food) {
    this.rout.navigate(['Profile']);
    
  }

  populate() {
    if (this._cat.length > 0) {
      this.foodList = [];
      for (let i of this.foods.foods) {
        if (i.category == this._cat) {
          this.foodList.push(i);
        }
      }
    }
    else {
      this.foodList = this.foods.foods
    }
  }
  ngOnInit() {
  }

}
