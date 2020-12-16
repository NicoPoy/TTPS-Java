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

  id: number;
  ft: Foodtruck;
  servicios: string;

  constructor(private route: ActivatedRoute, private api:ApiService) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get("id");
    this.ft = this.api.getFoodTruck(this.id);
    this.servicios = this.ft.servicios.join(", ") + ".";
  }

}
