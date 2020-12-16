import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { ApiService } from 'src/app/servicios/api.service';

@Component({
  selector: 'app-foodtruck-full',
  templateUrl: './foodtruck-full.component.html',
  styleUrls: ['./foodtruck-full.component.css']
})
export class FoodtruckFullComponent implements OnInit {

  idFoodTruck: number;
  ft: Foodtruck;
  servicios: string;
  miFoodTruck: boolean;
  idUsuario: number;
  direccionAct: string;
  direccionDel: string;

  constructor(private route: ActivatedRoute, private api:ApiService) { }

  ngOnInit(): void {
    this.idFoodTruck = +this.route.snapshot.paramMap.get("id");
    this.ft = this.api.getFoodTruck(this.idFoodTruck);
    this.servicios = this.ft.servicios.join(", ") + ".";
    this.idUsuario = +localStorage.getItem("userID");
    if(this.api.esMiFoodTruck(this.idFoodTruck,this.idUsuario)){
      this.miFoodTruck = true;
      this.direccionAct = ""; //HACER
      this.direccionDel = ""; //HACER
    }
    else{
      this.miFoodTruck = false;
    }
  }

}
