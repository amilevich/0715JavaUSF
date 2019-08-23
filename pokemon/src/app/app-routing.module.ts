import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { AbilitySearchComponent } from './ability-search/ability-search.component';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path: 'welcome', component: WelcomeComponent},
    {path: 'abilitySearch', component: AbilitySearchComponent}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
