import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RandomPokeComponent } from './random-poke/random-poke.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { PokeServiceService } from './poke-service.service';
import { FormsModule} from '@angular/forms';
import { SearchPokeComponent } from './search-poke/search-poke.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    RandomPokeComponent,
    SearchPokeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'welcome',component: WelcomeComponent},
      {path: 'random-poke',component: RandomPokeComponent},
      {path: 'search-poke',component: SearchPokeComponent}
      
    ])
  ],
  providers: [PokeServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
