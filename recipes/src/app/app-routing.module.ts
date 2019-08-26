import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NewRecipeComponent } from './new-recipe/new-recipe.component';
import { ViewRecipeComponent } from './view-recipe/view-recipe.component';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path: 'home', component: HomeComponent},
    {path: 'addRecipe', component: NewRecipeComponent},
    {path: 'home/view', component: ViewRecipeComponent}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
