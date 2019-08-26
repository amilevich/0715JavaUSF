import { Component, OnInit } from '@angular/core';
import { GetRecipesService } from '../get-recipes.service';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _recipeService: GetRecipesService) { }

  recipeList: Array<Recipe> = this._recipeService.getRecipes()

  saveRecipe(temp: Recipe)
  {
    this._recipeService.selectRecipe(temp.name)
  }

  filter(type: string)
  {
    let tempList: Array<Recipe> = new Array<Recipe>()
    for (let i = 0; i < this.recipeList.length; i++)
    {
      if (this.recipeList[i].category == type)
      {
        tempList.push(this.recipeList[i])
        console.log(tempList)
        this.recipeList = tempList
      }
      else if (type == "None")
      {
        this.recipeList = this._recipeService.getRecipes()
      }
    }
  }

  ngOnInit() {
  }

}
