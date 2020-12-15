import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-foodtruck-thumb',
  templateUrl: './foodtruck-thumb.component.html',
  styleUrls: ['./foodtruck-thumb.component.css']
})
export class FoodtruckThumbComponent implements OnInit {

  constructor() { }

  nombrefoodtruck = "Camioncito"

  tiposservicio = 'Servicio1, servicio2, servicio3';

  direccionft = "/foodtruck/12345";

  ngOnInit(): void {
  }

}
