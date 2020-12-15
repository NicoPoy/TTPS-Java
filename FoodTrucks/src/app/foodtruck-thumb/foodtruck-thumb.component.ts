import { Component, OnInit, Input } from '@angular/core';
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';

@Component({
  selector: 'app-foodtruck-thumb',
  templateUrl: './foodtruck-thumb.component.html',
  styleUrls: ['./foodtruck-thumb.component.css']
})
export class FoodtruckThumbComponent implements OnInit {

  @Input() ft: Foodtruck; 

  direccion: string;
  servicios: string;

  constructor() { 
  }

  ngOnInit(): void {
    this.direccion = "/foodtruck/" + this.ft.id;
    this.servicios = this.ft.servicios.join(", ") + ".";
  }

}
