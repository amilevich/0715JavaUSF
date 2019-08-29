import { Component, OnInit } from '@angular/core';
import { Recipe } from '../recipe';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-addrecipe',
  templateUrl: './addrecipe.component.html',
  styleUrls: ['./addrecipe.component.css']
})
export class AddrecipeComponent implements OnInit {

  recipes:Array<Recipe>
  newRecipe = new Recipe

  constructor(private recipeService:RecipeService) { }

  ngOnInit() {
    this.recipes = this.recipeService.recipes
  }

  addRecipe(recipe: Recipe){
    this.recipes.unshift(recipe)
    this.recipes = this.recipes.splice(0)
    this.newRecipe = new Recipe();
    console.log("Recipe passed in to addRecipe" + JSON.stringify(recipe))
    console.log("This.recipes" + JSON.stringify(this.recipes))
    this.recipeService.recipes.push(recipe)

  }

}
