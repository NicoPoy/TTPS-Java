import { Component, OnInit, Input } from '@angular/core';
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { TipoDeServicio } from '../modelos/tipoDeServicio/tipo-de-servicio';

@Component({
  selector: 'app-foodtruck-thumb',
  templateUrl: './foodtruck-thumb.component.html',
  styleUrls: ['./foodtruck-thumb.component.css']
})
export class FoodtruckThumbComponent implements OnInit {

  @Input() ft: Foodtruck; 

  direccion: string;
  servicios: string;
  arrayServicios: Array<TipoDeServicio> = [];

  constructor() { 
  }

  ngOnInit(): void {    
    this.direccion = "/foodtruck/" + this.ft.id;
    
    for (let tipo of this.ft.tipos) {
      this.arrayServicios.push(tipo.nombre);
    }
    
    this.servicios = this.arrayServicios.join(", ") + ".";
  }

}
