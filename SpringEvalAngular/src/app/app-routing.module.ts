import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllShowtimesComponent } from './all-showtimes/all-showtimes.component';
import { MovieLookupComponent } from './movie-lookup/movie-lookup.component';


const routes: Routes = [
  { path: 'showtimes', component: AllShowtimesComponent },
  { path: 'lookup', component: MovieLookupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
