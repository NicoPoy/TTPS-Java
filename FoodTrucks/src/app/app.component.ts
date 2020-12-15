import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from './modelos/usuario/usuario';
import { AuthenticationService } from './servicios/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'FoodTrucks';
  estaLogueado = false;
  esFoodTrucker = true;

  public currentUser: Usuario;

  constructor( private router: Router, private authenticationService: AuthenticationService) {
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
}
  
  logout(){
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

}
