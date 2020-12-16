import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { RegistroComponent } from './registro/registro.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FoodtruckThumbComponent } from './foodtruck-thumb/foodtruck-thumb.component';
import { NewFoodtruckComponent } from './new-foodtruck/new-foodtruck.component';
import { FoodtruckFullComponent } from './foodtruck-full/foodtruck-full.component';
import { MisFoodtrucksComponent } from './mis-foodtrucks/mis-foodtrucks.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'login', component: LoginComponent},
  {path: 'altafoodtruck', component: NewFoodtruckComponent},
  {path: 'foodtruck/:id', component: FoodtruckFullComponent},
  {path: 'misFoodtrucks', component: MisFoodtrucksComponent},
  {path: '**', component: HomeComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    RegistroComponent,
    LoginComponent,
    HomeComponent,
    FoodtruckThumbComponent,
    NewFoodtruckComponent,
    FoodtruckFullComponent,
    MisFoodtrucksComponent,
  ],
  imports: [
    RouterModule.forRoot( appRoutes ),
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
    
  ],
  exports: [ RouterModule ],
  providers: [],
  bootstrap: [AppComponent]

})
export class AppModule { }

