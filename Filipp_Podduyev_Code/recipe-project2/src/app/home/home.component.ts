import { Component, OnInit, Input } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  @Input()
  recipe: Recipe = new Recipe();
  recipes: Array<Recipe>;

  constructor(private recipeService:RecipeService, private rout:Router) { }

  
  clickPicture(recipeService){
    alert(this.rout.navigate[(recipeService)])
    
  }
  ngOnInit() {
    this.recipes = this.recipeService.recipes;
  }

}
