import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { AddComponent } from './add/add.component';
import { FoodServiceService } from './food-service.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProfileComponent,
    AddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'Home', component:HomeComponent},
      {path: 'Add', component:AddComponent},
      {path: 'Profile', component:ProfileComponent}
    ])
  ],
  providers: [FoodServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
