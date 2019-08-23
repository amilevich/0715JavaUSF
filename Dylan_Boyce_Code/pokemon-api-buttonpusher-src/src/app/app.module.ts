import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RandomPokemanComponent } from './random-pokeman/random-pokeman.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { RouterModule } from '@angular/router';
import { PokeServService } from './poke-serv.service';
import { SearchPokemonComponent } from './search-pokemon/search-pokemon.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    RandomPokemanComponent,
    SearchPokemonComponent
    
  ],
  imports: [
    BrowserModule,
   
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'welcome', component: WelcomeComponent},
      {path: 'pokemon', component: RandomPokemanComponent},
      {path: 'search', component: SearchPokemonComponent}

    ])
  ],
  providers: [PokeServService],
  bootstrap: [AppComponent]
})
export class AppModule { }
