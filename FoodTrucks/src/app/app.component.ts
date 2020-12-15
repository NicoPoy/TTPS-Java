import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from './modelos/usuario/usuario';
import { AuthenticationService } from './servicios/authentication.service';
import { HomeComponent } from 'src/app/home/home.component'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'FoodTrucks';
  estaLogueado;
  esFoodTrucker = true;

  public currentUser: Usuario;

  constructor( private router: Router, private authenticationService: AuthenticationService) {
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }

  ngOnInit(): void { 
    if( localStorage.getItem("token") != "null" ){
      this.estaLogueado = true;
    } else { this.estaLogueado = false }
    
    if( localStorage.getItem("userType") == "foodtrucker" ){
      this.esFoodTrucker = true
    } else { this.esFoodTrucker = false }
  }
  
  logout(){
    this.authenticationService.logout();
    this.ngOnInit();
    this.router.navigate(['/login']);
  }

  

}
