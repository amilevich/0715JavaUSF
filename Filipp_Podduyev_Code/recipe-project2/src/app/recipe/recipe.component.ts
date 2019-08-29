import { Component, OnInit, Input } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';
import { ProfileComponent } from '../profile/profile.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {


  @Input()
  recipe: Recipe = new Recipe();
  recipes: Array<Recipe>;

  constructor(private recipeService:RecipeService, private rout:Router) { }

  clickPicture(recipes){
    this.rout.navigate[('/profile')]
  }

  ngOnInit() {
  }

}
