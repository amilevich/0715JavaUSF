import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { SearchComponent } from './search/search.component';
import { RandomComponent } from './random/random.component';


const routes: Routes = [{path: 'welcome', component: WelcomeComponent}, {path:'search', component: SearchComponent}, {path:'random', component: RandomComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
