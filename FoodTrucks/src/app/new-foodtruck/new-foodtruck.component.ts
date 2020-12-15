import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Foodtruck } from 'src/app/modelos/foodtruck/foodtruck.model'
import { ApiService } from 'src/app/servicios/api.service'
import { AuthenticationService } from 'src/app/servicios/authentication.service'
import { Router } from '@angular/router';
import { ResponseI } from 'src/app/modelos/response/response-i'


@Component({
  selector: 'app-new-foodtruck',
  templateUrl: './new-foodtruck.component.html',
  styleUrls: ['./new-foodtruck.component.css']
})

export class NewFoodtruckComponent implements OnInit {

  nuevoFoodtruckForm = new FormGroup({
   
  })

  constructor() { }

  ngOnInit(): void {
  }

  postFoodtruckForm( form: Foodtruck ){

  }

}
