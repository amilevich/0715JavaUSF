import { Injectable } from '@angular/core';
import { Recipe } from './recipe';

@Injectable({
  providedIn: 'root'
})

export class RecipeService {

  recipes:Array<Recipe> = [
    new Recipe ('Fluffy Pancakes', 'Breakfast', 'https://images.media-allrecipes.com/userphotos/720x405/5079227.jpg', 
    `3/4 cup milk
     2 tablespoons white vinegar
     1 cup all-purpose flour
     2 tablespoons white sugar
     1 teaspoon baking powder

     1/2 teaspoon baking soda
     1/2 teaspoon salt
     1 egg
     2 tablespoons butter, melted
     cooking spray`, 
     `
     Combine milk with vinegar in a medium bowl and set aside for 5 minutes to "sour".
     Combine flour, sugar, baking powder, baking soda, and salt in a large mixing bowl. Whisk egg and butter into "soured" milk. Pour the flour mixture into the wet ingredients and whisk until lumps are gone.
     Heat a large skillet over medium heat, and coat with cooking spray. Pour 1/4 cupfuls of batter onto the skillet, and cook until bubbles appear on the surface. Flip with a spatula, and cook until browned on the other side.
 `
 ), new Recipe('Vegetable Soup','Lunch','https://www.inspiredtaste.net/wp-content/uploads/2018/10/Homemade-Vegetable-Soup-Recipe-2-1200.jpg','Test','Test')
  ]

  constructor() { }
}
