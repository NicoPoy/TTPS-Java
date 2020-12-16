import { Component, OnInit } from '@angular/core';
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { ApiService } from 'src/app/servicios/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mis-foodtrucks',
  templateUrl: './mis-foodtrucks.component.html',
  styleUrls: ['./mis-foodtrucks.component.css']
})
export class MisFoodtrucksComponent implements OnInit {

  miId: string;
  misFt: Foodtruck[];

  constructor(private api:ApiService, private router:Router) { 
    if( localStorage.getItem("token") == null || localStorage.getItem("token") == "null" ){
      this.router.navigate(['/login']);
    }
    this.miId = localStorage.getItem("userID");
    
    api.FoodTrucksDeUsuario(this.miId).subscribe( data => {
      this.misFt = data;
    });
    
  }

  ngOnInit(): void {
  }

}
