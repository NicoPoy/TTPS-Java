import { Component, OnInit } from '@angular/core';
import { Foodtruck } from '../modelos/foodtruck/foodtruck.model';
import { ApiService } from 'src/app/servicios/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  mejoresft: Foodtruck[];

  constructor(private api:ApiService) {
    this.mejoresft = api.mejoresFoodTrucks();

  }

  ngOnInit(): void {
  }

}
