import { Component, OnInit } from '@angular/core';
import { GetRecipesService } from '../get-recipes.service';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-view-recipe',
  templateUrl: './view-recipe.component.html',
  styleUrls: ['./view-recipe.component.css']
})
export class ViewRecipeComponent implements OnInit {

  constructor(private _recipeService: GetRecipesService) { }

  recipe: Recipe = this._recipeService.getSelectedRecipe()

  ngOnInit() {
  }

}
