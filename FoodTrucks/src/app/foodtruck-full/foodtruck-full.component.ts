import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { ApiService } from 'src/app/servicios/api.service';
import { TipoDeServicio } from '../modelos/tipoDeServicio/tipo-de-servicio';

@Component({
  selector: 'app-foodtruck-full',
  templateUrl: './foodtruck-full.component.html',
  styleUrls: ['./foodtruck-full.component.css']
})
export class FoodtruckFullComponent implements OnInit {

  idFoodTruck: string;
  ft: Foodtruck;
  servicios: string;
  miFoodTruck: boolean;
  idUsuario: string;
  direccionAct: string;
  direccionDel: string;
  
  arrayServicios: Array<TipoDeServicio> = [];
  
  constructor(private route: ActivatedRoute, private api:ApiService) { }

  ngOnInit(): void {
    this.idFoodTruck = this.route.snapshot.paramMap.get("id");
    
    this.api.getFoodTruck(this.idFoodTruck).subscribe(data => {
      this.ft = data; 
      for (let tipo of this.ft.tipos) {
        this.arrayServicios.push(tipo.nombre);
      }    
      this.servicios = this.arrayServicios.join(", ") + ".";
      this.direccionAct = "/actFoodtruck/" + this.ft.id;
      this.direccionDel = "/delFoodtruck/" + this.ft.id;
      console.log(this.direccionAct);
    });

    this.idUsuario = localStorage.getItem("userID");

    this.api.esMiFoodTruck(this.idFoodTruck,this.idUsuario).subscribe( data => { 
        if (data.status == "ok") {
          console.log("LLEGO UN OK");
          this.miFoodTruck = true;
        } else{
          this.miFoodTruck = false;
        }
    } );

  }

}
