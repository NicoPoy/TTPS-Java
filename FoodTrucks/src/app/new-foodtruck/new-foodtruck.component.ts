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

  constructor( private api:ApiService, private router:Router ) {
    if( localStorage.getItem("token") == null || localStorage.getItem("token") == "null" ){
      this.router.navigate(['/login']);
    }

    this.api.getTiposDeServicio().subscribe(data => {
      this.listaServicios = data;
      console.log( this.listaServicios );
      this.listaServicios.map( elem =>  this.nuevoFoodtruckForm.addControl(elem.nombre, new FormControl('')) );
    });
    
  }

  ngOnInit(): void {
  }

  async postFoodtruckForm( form: Foodtruck ){
    let selectServicios: Array<TipoDeServicio> = [];
    this.listaServicios.map( elem => {
      if ( this.nuevoFoodtruckForm.controls[elem.nombre].value ) {
        selectServicios.push(elem);
      };
    });

    console.log(selectServicios);

    let ft = new Foodtruck (null,form.nombre, form.descripcion, form.instagram, form.twitter, form.whatsapp, form.url, selectServicios);
    
    this.api.crearFoodTruck(ft).subscribe( data => console.log(data) );
    
    await this.sleep(500);
    this.router.navigate(['/misFoodtrucks']);

  }

  sleep(ms) {
    return new Promise((resolve) => {
      setTimeout(resolve, ms);
    });
  }

}
