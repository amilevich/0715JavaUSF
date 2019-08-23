import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { RandomJokeComponent } from './random-joke/random-joke.component';
import { SearchJokeComponent } from './search-joke/search-joke.component';
import { SecretComponent } from './secret/secret.component';
import { JokeService } from './joke.service';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    RandomJokeComponent,
    SearchJokeComponent,
    SecretComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'welcome', component: WelcomeComponent},
      {path: 'joke', component: RandomJokeComponent},
      {path: 'search', component: SearchJokeComponent},
      {path: 'secret', component: SecretComponent}
    ])
  ],
  providers: [JokeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
