import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddrecipeComponent } from './addrecipe/addrecipe.component';
import { ProfileComponent } from './profile/profile.component';


const routes: Routes = [
  {path: 'home', component:HomeComponent},
  {path: 'addrecipe', component:AddrecipeComponent},
  {path: 'profile', component:ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
