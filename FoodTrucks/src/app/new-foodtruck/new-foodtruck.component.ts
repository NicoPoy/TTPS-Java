import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Foodtruck } from 'src/app/modelos/foodtruck/foodtruck.model'
import { TipoDeServicio } from 'src/app/modelos/tipoDeServicio/tipo-de-servicio'
import { ApiService } from 'src/app/servicios/api.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-foodtruck',
  templateUrl: './new-foodtruck.component.html',
  styleUrls: ['./new-foodtruck.component.css']
})

export class NewFoodtruckComponent implements OnInit {
  
  listaServicios: TipoDeServicio[];
  
  nuevoFoodtruckForm = new FormGroup({
    nombre: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    url: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    whatsapp: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    twitter: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    instagram: new FormControl('', [Validators.required, Validators.minLength(3)] ),
    descripcion: new FormControl('', [Validators.required, Validators.minLength(3)] ),
  })

  constructor( private api:ApiService, private router:Router ) { }

  ngOnInit(): void {

    this.api.getTiposDeServicio().subscribe(data => {
      
      this.listaServicios = data;

      console.log( this.listaServicios );
    
      this.listaServicios.map( elem =>  this.nuevoFoodtruckForm.addControl(elem.nombre, new FormControl('')) );

      /* for (let servicio of this.servicios) { 
        this.nuevoFoodtruckForm.addControl(servicio.nombre, new FormControl(''));
      }; */

      

    });
  

    

    //this.servicios.forEach( serv => this.nuevoFoodtruckForm.addControl( 'new', ('') ) )

  }

  postFoodtruckForm( form: Foodtruck ){
  
  }

}
