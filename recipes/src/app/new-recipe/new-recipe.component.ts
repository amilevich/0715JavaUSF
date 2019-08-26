import { Component, OnInit } from '@angular/core';
import { GetRecipesService } from '../get-recipes.service';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-new-recipe',
  templateUrl: './new-recipe.component.html',
  styleUrls: ['./new-recipe.component.css']
})
export class NewRecipeComponent implements OnInit {

  constructor(private _recipeService: GetRecipesService) { }

  name: string
  type: string
  pictureUrl: string
  tempIngredient: string
  ingredients: Array<string> = new Array<string>()
  directions:string
  ingredientsString: string = ""

  addIngredient(): void
  {
    this.ingredients.push(this.tempIngredient)
    this.ingredientsString += `${this.tempIngredient}, `
    console.log(this.ingredientsString)
  }

  submitRecipe(): void
  {
    let recipe: Recipe = new Recipe(this.name, this.type, this.pictureUrl, this.ingredients, this.directions)
    this._recipeService.addRecipe(recipe)
    this.ingredientsString = ""
  }

  ngOnInit() {
  }

}
