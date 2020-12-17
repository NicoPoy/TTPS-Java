import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { ApiService } from '../servicios/api.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-del-foodtruck',
  templateUrl: './del-foodtruck.component.html',
  styleUrls: ['./del-foodtruck.component.css']
})
export class DelFoodtruckComponent implements OnInit {

  nombreFT: string;
  idFoodTruck: string;
  mift: Foodtruck;
  esmift: boolean;

  constructor(private route: ActivatedRoute, private api:ApiService, private router: Router,) {
    this.idFoodTruck = this.route.snapshot.paramMap.get("id");
    this.api.getFoodTruck(this.idFoodTruck).subscribe( data => {
      this.mift = data;
      this.nombreFT = data.nombre
    })
  }

  ngOnInit(): void {
    this.api.esMiFoodTruck(this.idFoodTruck,localStorage.getItem("userID")).subscribe( data => { 
      if (data.status == "ok") {
        //console.log("ES MIO");
        this.esmift = true;
      }else{
        //console.log("ES DE OTRO");
        this.esmift = false;
      }
      if(this.esmift){
      }
      else{
        this.router.navigate(['/home']);
      }
  } );

    
  }

  async borrarFoodtruck(id: string){
    this.api.borrarFoodtruck(id).subscribe( data => console.log(data) );
    await this.sleep(500);
    this.router.navigate(['/misFoodtrucks']);
  }

  sleep(ms) {
    return new Promise((resolve) => {
      setTimeout(resolve, ms);
    });

  }

}
