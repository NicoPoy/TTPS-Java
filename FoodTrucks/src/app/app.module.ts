import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { RegistroComponent } from './registro/registro.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FoodtruckThumbComponent } from './foodtruck-thumb/foodtruck-thumb.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'login', component: LoginComponent},
  {path: '**', component: HomeComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    RegistroComponent,
    LoginComponent,
    HomeComponent,
    FoodtruckThumbComponent
  ],
  imports: [
    RouterModule.forRoot( appRoutes ),
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [ RouterModule ],
  providers: [],
  bootstrap: [AppComponent]

})
export class AppModule { }

